<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8"); 
	response.setContentType("text/html; charset=utf-8");
	//로그인 체크..넘어온 id와 pw가 같으면 체크..
	String userId = request.getParameter("userId");
	String userPw = request.getParameter("userPw");
	// db연결..
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "test_user";
	String password = "1234";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; // select는 result set이 있어야함
	
	String sql = "SELECT * FROM MEMBER WHERE ID=? AND PASSWORD=?";
	try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url,id,password);
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, userId);
		pstmt.setString(2, userPw);
		
		rs = pstmt.executeQuery();
		if(rs.next()){
			// 로그인 성공
			//out.print(rs.getString("name"));
			// 로그인이 되면, 뽑아놓은 이름으로 대체하기(scope 사용...) page, request, session 등
			session.setAttribute("name", rs.getString("name")); // session에 저장을하면 session을 종료하기 전까지는 계속 값을 유지한다.
			session.setAttribute("id", rs.getString("id")); 
			response.sendRedirect("../board/list.jsp"); // 이쪽으로 보내라..
		} else {
			// 로그인 실패
%>
			<script>
				alert("아이디, 비밀번호를 확인하세요");
				history.back();
			</script>
<%
		}
	} catch(Exception e){
		e.printStackTrace();
	}
		
%>



