package com.mins.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//  DB 연결하고 DTO 받아서 데이터 처리하고 결과 돌려주기
public class ReplyDao {
	//연결
	//각종 메서드
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
	//insert sql db table 실질적인 영향을 미치는 것들.. insert, delete, update
	public int insertBoard(ReplyDto replyDto) {
		int result =0;
		
		try {
		getConnection();
		String sql = "INSERT INTO REPLYBOARD2 VALUSE (SEQ_REPLYBOARD2.NEXTVAL,?,?,?,?,TO_CHAR(SYSDATE,'YYYY'-MM-DD HH:MI'),1,1,1,0,?)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, replyDto.getName());
		pstmt.setString(2, replyDto.getSubject());
		pstmt.setString(3, replyDto.getEmail());
		pstmt.setString(4, replyDto.getPassword());
		pstmt.setString(5, replyDto.getContents());
		result = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
		close(pstmt,conn);
		
		return result;
	}
	// 데이터 가져오기
	public  ArrayList<ReplyDto> getAllList() {
		 ArrayList<ReplyDto> replyList = new ArrayList<ReplyDto>();
		 
		 try {
			 getConnection();
			 String sql = "SELECT  * FROM REPLYBOARD2";
			 pstmt = conn.prepareStatement(sql);
			 rs = pstmt.executeQuery();
			 while(rs.next()) {
				 ReplyDto replyDto = new ReplyDto();
				 replyDto.setNo(rs.getInt("no"));
				 replyDto.setName(rs.getString("name"));
				 replyDto.setEmail(rs.getString("emali"));
				 replyDto.setSubject(rs.getString("subject"));
				 replyDto.setPassword(rs.getString("password"));
				 replyDto.setRegDate(rs.getString("regdate"));
				 replyDto.setReGroup(rs.getInt("regroup"));
			 }
		 }catch (SQLException e) {
			 e.printStackTrace();
		 }
		return replyList;
	}
}
