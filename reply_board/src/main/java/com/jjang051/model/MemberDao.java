package com.jjang051.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.mindrot.bcrypt.BCrypt;

public class MemberDao {

	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "TEST_USER";
	String password = "1234";

	Connection conn = null;
	PreparedStatement pstmt = null;

	ResultSet rs = null; // select

	// method를 연결 객체 //insert / update

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

	// 멤버테이블에 멤버 집어넣기....
	public int insertMember(MemberDto memberDto) {
		int result = 0;

		getConnection(); // 연결....
		String sql = "INSERT INTO MEMBER VALUES	(SEQ_MEMBER.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getId());
			//pstmt.setString(2, memberDto.getPassword());
			pstmt.setString(2, BCrypt.hashpw(memberDto.getPassword(),BCrypt.gensalt(10)) );
			pstmt.setString(3, memberDto.getName());
			pstmt.setInt(4, memberDto.getZipcode());
			pstmt.setString(5, memberDto.getAddress());
			pstmt.setString(6, memberDto.getHp());
			pstmt.setString(7, memberDto.getEmail());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt, conn);
		return result;
	}

	// 멤버 테이블에 있는 멤버 가져오기....
	// ArrayList
	public ArrayList<MemberDto> showAllMember() {
		ArrayList<MemberDto> memberList = new ArrayList<MemberDto>();
		getConnection();
		String sql = "SELECT * FROM MEMBER";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MemberDto memberDto = new MemberDto();
				memberDto.setNo(rs.getInt("no"));
				memberDto.setId(rs.getString("id"));
				memberDto.setPassword(rs.getString("password"));
				memberDto.setName(rs.getString("name"));
				memberDto.setZipcode(rs.getInt("zipcode"));
				memberDto.setAddress(rs.getString("address"));
				memberDto.setHp(rs.getString("hp"));
				memberDto.setEmail(rs.getString("email"));
				memberList.add(memberDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs, pstmt, conn);
		return memberList;
	}

	// 한명의 데이터 가져오기....
	public MemberDto getSelectOne(String userId) {
		MemberDto memberDto = new MemberDto();
		getConnection();
		String sql = "SELECT * FROM MEMBER WHERE ID = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberDto.setNo(rs.getInt("no"));
				memberDto.setId(rs.getString("id"));
				memberDto.setPassword(rs.getString("password"));
				memberDto.setName(rs.getString("name"));
				memberDto.setZipcode(rs.getInt("zipcode"));
				memberDto.setAddress(rs.getString("address"));
				memberDto.setHp(rs.getString("hp"));
				memberDto.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs, pstmt, conn);
		return memberDto;
	}

	public MemberDto getLoggedMember(MemberDto memberDto) {
		MemberDto loggedMember = null;
		try {
			getConnection();
			String idSql = "SELECT * FROM MEMBER WHERE ID = ?";
			pstmt = conn.prepareStatement(idSql);
			pstmt.setString(1, memberDto.getId());
			rs = pstmt.executeQuery();
			if (rs.next()) {
if(BCrypt.checkpw(memberDto.getPassword(), rs.getString("password"))) {
					loggedMember = new MemberDto();
					loggedMember.setNo(rs.getInt("no"));
					loggedMember.setId(rs.getString("id"));
					loggedMember.setName(rs.getString("name"));
					//loggedMember.setPassword(rs.getString("password"));
					loggedMember.setEmail(rs.getString("email"));
					loggedMember.setHp(rs.getString("hp"));
					loggedMember.setAddress(rs.getString("address"));
					loggedMember.setZipcode(rs.getInt("zipcode"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loggedMember;
	}

	public int updateMember(MemberDto memberDto) {
		int result = 0;
		getConnection();
		String sql = "UPDATE  MEMBER SET NAME=?,ZIPCODE=?,ADDRESS=?,HP=?,EMAIL=? WHERE ID = ? AND PASSWORD = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getName());
			pstmt.setInt(2, memberDto.getZipcode());
			pstmt.setString(3, memberDto.getAddress());
			pstmt.setString(4, memberDto.getHp());
			pstmt.setString(5, memberDto.getEmail());
			pstmt.setString(6, memberDto.getId());
			pstmt.setString(7, memberDto.getPassword());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(pstmt, conn);
		return result;
	}

	public int deleteMember(MemberDto memberDto) {
		int result = 0;
		getConnection();
		String sql = "DELETE FROM MEMBER WHERE ID = ? AND PASSWORD = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getId());
			pstmt.setString(2, memberDto.getPassword());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		close(pstmt, conn);
		return result;
	}

	public int idCheck(String id) {
		int result = 0;
		try {
			getConnection();
			String sql = "SELECT COUNT(*) AS COUNT FROM MEMBER WHERE ID = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(rs,pstmt,conn);
		return result;
		
	}
}
