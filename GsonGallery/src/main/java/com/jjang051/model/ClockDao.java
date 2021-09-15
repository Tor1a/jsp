package com.jjang051.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClockDao {
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "TEST_USER";
	String password = "1234";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; 
	
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
	
	//insert
	public int insertClock(ClockDto clockDto) {
		int result = 0;
		try {
			getConnection();
			String sql = "INSERT INTO CLOCK VALUES (SEQ_CLOCK.NEXTVAL,?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,clockDto.getCategory());
			pstmt.setString(2,clockDto.getTitle());
			pstmt.setInt(3,clockDto.getDepth());
			pstmt.setInt(4,clockDto.getPrice());
			pstmt.setString(5,clockDto.getLink());
			pstmt.setString(6,clockDto.getClockImg());
			pstmt.setString(7,clockDto.getRealClockImg());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt,conn);
		return result;
	}
	//select
	public ArrayList<ClockDto> showAllClock() {
		ArrayList<ClockDto> clockList = new ArrayList<ClockDto>();
		try {
			getConnection();
			String sql = "SELECT * FROM CLOCK";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ClockDto clockDto = new ClockDto();
				clockDto.setNo(rs.getInt("no"));
				clockDto.setCategory(rs.getString("category"));
				clockDto.setTitle(rs.getString("title"));
				clockDto.setDepth(rs.getInt("depth"));
				clockDto.setPrice(rs.getInt("price"));
				clockDto.setLink(rs.getString("link"));
				clockDto.setClockImg(rs.getString("clockImg"));
				clockDto.setRealClockImg(rs.getString("realClockImg"));
				clockList.add(clockDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clockList;
	}
}






























