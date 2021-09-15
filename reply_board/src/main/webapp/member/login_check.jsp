<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//로그인 체크 id
	String userId =  request.getParameter("userId");
	String userPw =  request.getParameter("userPw");
	//db 연결....
	//code 주세요....
	//SELECT 해서 이름 출력하기...
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "test_user";
	String password = "1234";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String sql = "SELECT * FROM MEMBER WHERE ID = ? AND PASSWORD= ?";
	try {
		Class.forName(driver);
	    conn = DriverManager.getConnection(url,id,password);
	    pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1,userId);
	    pstmt.setString(2,userPw);
	    
	    rs = pstmt.executeQuery();
		if(rs.next()) {
			//로그인 성공
			//out.print(rs.getString("name"));  // 실어야 한다... scopepage
			session.setAttribute("name", rs.getString("name")); //session에 저장을 하면 session을 종료하기전까지는 계속 값을 유지
			session.setAttribute("id", rs.getString("id"));
			response.sendRedirect("../board/list.jsp");
		} else {
			//로그인 실패
%>
			<script>
				alert("아이디 비밀번호를 학인해 주세요.");
				history.back();
			</script>
<%
		}
	} catch (Exception e) {
		e.printStackTrace();
	}

%>












