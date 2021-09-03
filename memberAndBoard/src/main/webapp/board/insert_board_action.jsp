<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8"); // 읽을때 한글 깨지지 않게 읽기...
	response.setContentType("text/html; charset=utf-8;");  // 출력할때 한글 깨지지 않게 내보내기...
	String userName = request.getParameter("userName");
	String email = request.getParameter("email");
	String subject = request.getParameter("subject");
	String userPw = request.getParameter("password");
	String contents = request.getParameter("contents");
	
	
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "test_user";
	String password = "1234";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	String sql = "INSERT INTO BOARD VALUES (SEQ_BOARD.NEXTVAL,?,?,?,?,?)";
	
	try {
		Class.forName(driver);
		conn = DriverManager.getConnection(url,id,password);
		pstmt = conn.prepareStatement(sql);// oracle로 가서 쿼리 실행하기 위해 준비
		pstmt.setString(1,userName);
		pstmt.setString(2, email);
		pstmt.setString(3, subject);
		pstmt.setString(4, userPw);
		pstmt.setString(5, contents);
		//select   vs   insert, delete, update
		int result = pstmt.executeUpdate();  // result는 몇개의 열에 영향을 미쳤는지 그 갯수를 리턴 
		if(result > 0) {
			//제대로 입력되었을때 해야할일....
%>
			<script>
				alert("글이 입력되었습니다.");
				location.href="list.jsp";
			</script>
<%
		}
	} catch (Exception e) {
		e.printStackTrace();//오류 메세지를 서버쪽 로그에 남겨달라...
	} finally {
		try {
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		} catch(Exception e2) {
			e2.printStackTrace();
		}
	}
	
	
	
	//out.print(userName+"<br>");
	//out.print(email+"<br>");
	//out.print(subject+"<br>");
	//out.print(password+"<br>");
	//out.print(contents+"<br>");
	// java ===driver===  db(oracle)

%>


