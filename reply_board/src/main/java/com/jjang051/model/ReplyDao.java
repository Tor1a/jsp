package com.jjang051.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReplyDao {
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "TEST_USER";
	String password = "1234";
	
	Connection  conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,id,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void close(PreparedStatement pstmt, Connection conn) {
		try {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//insert  (새글 썼을때....)
	public int insertBoard(ReplyDto replyDto) {
		int result = 0;
		try {
			getConnection();
			
			int reGroup = 0;
			int reStep =  1;   
			int reLevel = 1;
			
			//reGroup변수는 reGroup컬럼에 제일 큰 값얻어오기....
			String reGroupSql =  "SELECT MAX(REGROUP) AS REGROUPMAX FROM REPLYBOARD";
			//String reGroupSql =  "SELECT MAX(REGROUP) FROM REPLYBOARD";
			
			pstmt = conn.prepareStatement(reGroupSql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				reGroup = rs.getInt("REGROUPMAX") + 1;
				//reGroup = rs.getInt(1) + 1;
			}
			String sql = "INSERT INTO REPLYBOARD VALUES (SEQ_REPLYBOARD.NEXTVAL,?,?,?,?,SYSDATE,?,?,?,0,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,replyDto.getName());
			pstmt.setString(2, replyDto.getEmail());
			pstmt.setString(3, replyDto.getSubject());
			pstmt.setString(4, replyDto.getPassword());
			pstmt.setInt(5, reGroup);
			pstmt.setInt(6, reStep);
			pstmt.setInt(7, reLevel);
			pstmt.setString(8, replyDto.getContents());		
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		close(rs,pstmt,conn);
		return result;
	}
	
	
	//답글쓰기....
	public int insertReplyBoard(ReplyDto replyDto) {
		int result = 0;
		try {
			getConnection();
			
			int reGroup = replyDto.getReGroup();
			int reStep =  replyDto.getReStep();   
			int reLevel = replyDto.getReLevel();
			
			//level증가
			String levelSql = "UPDATE REPLYBOARD SET RELEVEL = RELEVEL + 1 WHERE REGROUP = ? AND RELEVEL > ?"; 
			pstmt = conn.prepareStatement(levelSql);
			pstmt.setInt(1, reGroup);
			pstmt.setInt(2, reLevel);
			pstmt.executeUpdate();
			
			//insert
			String sql = "INSERT INTO REPLYBOARD VALUES (SEQ_REPLYBOARD.NEXTVAL,?,?,?,?,SYSDATE,?,?,?,0,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, replyDto.getName());
			pstmt.setString(2, replyDto.getEmail());
			pstmt.setString(3, replyDto.getSubject());
			pstmt.setString(4, replyDto.getPassword());
			pstmt.setInt(5, reGroup);  //5  5
			pstmt.setInt(6, reStep + 1); 
			pstmt.setInt(7, reLevel + 1);  
			pstmt.setString(8, replyDto.getContents());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		close(rs,pstmt,conn);
		return result;
	}
	
	public ArrayList<ReplyDto> getAllList(int start, int end) {
		ArrayList<ReplyDto> replyList = new ArrayList<ReplyDto>();
		
		try {
			getConnection();
			//String sql = "SELECT * FROM REPLYBOARD ORDER BY REGROUP DESC, RELEVEL ASC";
			//갯수를 제한해서 뽑아오기.... 조건 걸어서 몇번부터 몇번까지 뽑아오기.....
			String sql = "SELECT * FROM "
					+ "    (SELECT B.*,ROWNUM AS NUM FROM "
					+ "        ( SELECT * FROM REPLYBOARD ORDER BY REGROUP DESC, RELEVEL ASC ) B"
					+ "    ) "
					+ "    WHERE NUM >= ? AND NUM < ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,start);
			pstmt.setInt(2,end);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ReplyDto replyDto = new ReplyDto();
				replyDto.setNo(rs.getInt("no"));
				replyDto.setName(rs.getString("name"));
				replyDto.setEmail(rs.getString("email"));
				replyDto.setSubject(rs.getString("subject"));
				replyDto.setPassword(rs.getString("password"));
				replyDto.setRegDate(rs.getDate("regDate"));
				replyDto.setReGroup(rs.getInt("reGroup"));
				replyDto.setReStep(rs.getInt("reStep"));
				replyDto.setReLevel(rs.getInt("reLevel"));
				replyDto.setReadCount(rs.getInt("readCount"));
				replyDto.setContents(rs.getString("contents"));
				replyList.add(replyDto);
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return replyList;
	}
	
	public ReplyDto getSelectOne(int no) {
		ReplyDto replyDto = new ReplyDto();
		
		try {
			getConnection();
			
			//조회수 증가
			String readSql = "UPDATE REPLYBOARD SET READCOUNT = READCOUNT + 1 WHERE NO = ?";
			pstmt = conn.prepareStatement(readSql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			
			
			//값을 뽑아오기...
			String sql = "SELECT * FROM REPLYBOARD WHERE NO = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				replyDto.setNo(rs.getInt("no"));
				replyDto.setName(rs.getString("name"));
				replyDto.setEmail(rs.getString("email"));
				replyDto.setSubject(rs.getString("subject"));
				replyDto.setPassword(rs.getString("password"));
				replyDto.setRegDate(rs.getDate("regDate"));
				replyDto.setReGroup(rs.getInt("reGroup"));
				replyDto.setReStep(rs.getInt("reStep"));
				replyDto.setReLevel(rs.getInt("reLevel"));
				replyDto.setReadCount(rs.getInt("readCount"));
				replyDto.setContents(rs.getString("contents"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs,pstmt,conn);
		
		return replyDto;
	}
	
	// 전체 글 갯수 가져오기
	public int getTotal() {
		int total = 0;
		try {
			getConnection();
			String sql = "SELECT COUNT(*) AS TOTAL FROM REPLYBOARD";
			pstmt =conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				total = rs.getInt("total");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return total;
	}
}

































