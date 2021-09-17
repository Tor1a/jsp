package com.jjang051.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.bcrypt.BCrypt;

public class MemberDao {
	// 연결
	// 각종 메서드
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

	public int insertMember(MemberDto memberDto) {
		// TODO Auto-generated method stub
		int result = 0;
		
		try {
			getConnection();
			String sql = "INSERT INTO MEMBER02 VALUES (SEQ_MEMBER02.NEXTVAL,?,?,?,?,?,?,?)";
			pstmt  = conn.prepareStatement(sql);
			pstmt.setString(1,memberDto.getId());
			pstmt.setString(2,BCrypt.hashpw(memberDto.getPassword(),BCrypt.gensalt(10)));
			pstmt.setString(3,memberDto.getName());
			pstmt.setInt(4,memberDto.getZipCode());
			pstmt.setString(5,memberDto.getAddress());
			pstmt.setString(6,memberDto.getHp());
			pstmt.setString(7,memberDto.getEmail());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		close(pstmt,conn);
		return result;
	}

	public MemberDto getLoggedMember(String userId, String userPw) {
		MemberDto loggedMemberInfo = null;
		try {
			getConnection();
			String sql = "SELECT * FROM MEMBER02 WHERE ID = ?";
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String dbPassword = rs.getString("password"); //db에 암호화 되어 있는 패스워드
				if(BCrypt.checkpw(userPw, dbPassword)) {
					loggedMemberInfo = new MemberDto();
					loggedMemberInfo.setId(rs.getString("id"));
					loggedMemberInfo.setName(rs.getString("name"));
					loggedMemberInfo.setNo(rs.getInt("no"));
					loggedMemberInfo.setEmail(rs.getString("email"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs,pstmt,conn);
		return loggedMemberInfo;
	}
}












