<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8"); // 읽을때 한글 깨지지 않게 읽기...
	response.setContentType("text/html; charset=utf-8;");  // 출력할때 한글 깨지지 않게 내보내기...
	
	int no =  Integer.parseInt( request.getParameter("no") );
	String userPw = request.getParameter("userPw"); 
	
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "test_user";
	String password = "1234";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	try {
		Class.forName(driver); // 행복하자 아부지 말고... 
		conn = DriverManager.getConnection(url,id,password);
		String sql = "DELETE FROM BOARD WHERE NO = ? AND PASSWORD = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,no);
		pstmt.setString(2, userPw);
		int result = pstmt.executeUpdate();
		if(result > 0) {
%>	
			<script>
				alert("삭제되었습니다.");
				location.href="list.jsp";
			</script>
<%
		} else {
%>			
			<script>
				alert("비밀번호를 확인해주세요.");  //이게 방탄 유리야//// 우리 아직 45 발 남았어요...
				history.back();
			</script>
<%
		}
	} catch(Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch(Exception e2) {
			e2.printStackTrace();
		}
	}

%>







