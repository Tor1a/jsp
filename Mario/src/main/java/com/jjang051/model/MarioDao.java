package com.jjang051.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MarioDao {
	//db연결할떄 써야할 driver, id, password
	//getConnection
	//close
	//insertMario  메서드 만들기.....  
	
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "TEST_USER";
	String password = "1234";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; // select
	
	public void getConnection() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close(PreparedStatement pstmt, Connection conn) {
		try {
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// insert  
	public int insertMario(MarioDto marioDto) {
		int result = 0;
		try {
			getConnection();
			String sql = "INSERT INTO MARIO02 VALUES (SEQ_MARIO.NEXTVAL,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,marioDto.getTitle());
			pstmt.setString(2,marioDto.getContents());
			pstmt.setString(3,marioDto.getBg());
			pstmt.setString(4,marioDto.getLink());
			pstmt.setString(5,marioDto.getMarioImg());
			pstmt.setString(6,marioDto.getMarioRealImg());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt,conn);
		return result;
	}
	public ArrayList<MarioDto> selectAllMario() {
		//new 
		ArrayList<MarioDto> marioList = new ArrayList<MarioDto>();
		try {
			getConnection();
			String sql = "SELECT * FROM MARIO02";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MarioDto marioDto = new MarioDto();
				marioDto.setNo(rs.getInt("no"));
				marioDto.setTitle(rs.getString("title"));
				marioDto.setContents(rs.getString("contents"));
				marioDto.setBg(rs.getString("bg"));
				marioDto.setLink(rs.getString("link"));
				marioDto.setMarioImg(rs.getString("marioImg"));
				marioDto.setMarioRealImg(rs.getString("marioRealImg"));
				marioList.add(marioDto);
			}
			// 고인 물
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return marioList;
	}
}











