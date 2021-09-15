<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=utf-8;");
	
	String userId = request.getParameter("userId");
	String userPw = request.getParameter("userPw");
	String userName = request.getParameter("userName");
	int zipcode = Integer.parseInt(request.getParameter("zipcode"));
	String address = request.getParameter("address01") + request.getParameter("address02");
	String phone = request.getParameter("phoneNumber") + request.getParameter("phoneMiddleNumber")
			+ request.getParameter("phoneLastNumber");
	String email = request.getParameter("userEmail");
	
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "TEST_USER";
	String password = "1234";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	

try {
	Class.forName(driver);
	conn = DriverManager.getConnection(url, id, password);
	String sql = "UPDATE MEMBER SET NAME = ?, ZIPCODE = ?, ADDRESS = ?, HP = ?, EMAIL = ? WHERE ID = ? AND PASSWORD = ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, userName);
	pstmt.setInt(2, zipcode);
	pstmt.setString(3, address);
	pstmt.setString(4, phone);
	pstmt.setString(5, email);
	pstmt.setString(6, userId);
	pstmt.setString(7, userPw);
	int result = pstmt.executeUpdate();
		if (result > 0) {
			session.setAttribute("name", userName);
			%>
			<script>
				alert("수정되었습니다.");
				location.href = "../member/list.jsp";
			</script>
			<%
		} else {
			%>
				<script>
					alert("비밀번호를 확인 하세요.");
					history.back();
				</script>
			<%
		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
%>