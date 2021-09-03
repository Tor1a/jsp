<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "test_user";
	String password = "1234";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	//String sql = "SELECT * FROM BOARD WHERE NO = 5";
	
	int no = Integer.parseInt( request.getParameter("no") );  //"5"===> 5
	//out.print("list에서 a 태그에 query string 형태로 넘긴 값 no==="+no);
	
%>
<div id="contents">
	<h2 class="contentsTitle">VIEW</h2>
	<div class="form">
		<table class="tdLeft">
			<cols>
				<col style="width: 150px;">
				<col>
			</cols>
			<tbody>
				<%
					try {
						Class.forName(driver);
						conn = DriverManager.getConnection(url,id,password);
						String sql = "SELECT * FROM BOARD WHERE NO = ?";
						pstmt = conn.prepareStatement(sql);
						pstmt.setInt(1,no);
						rs = pstmt.executeQuery();// ResultSet
						while(rs.next()) {
				%>
						<!-- html -->
						<tr>
							<th>name</th>
							<td><%=rs.getString("name") %></td>
						</tr>
						<tr>
							<th>email</th>
							<td><%=rs.getString("email") %></td>
						</tr>
						<tr>
							<th>subject</th>
							<td><%=rs.getString("subject") %></td>
						</tr>
						<tr>
							<th>contents</th>
							<td class="txtContents"><%=rs.getString("contents") %></td>
						</tr>
				<%
						}
						
					} catch(Exception e) {
						e.printStackTrace();// 예외가 발생하면 서버특 콘솔에 출력
					}
				%>
				
			</tbody>
		</table>
		<div class="btns center">
			<a href="delete.jsp?no=<%=no%>">삭제</a>
			<a href="modify.jsp">수정</a>
		</div>
	</div>
</div>
<script>
	$(".txtContents").html($(".txtContents"));
</script>
<%@ include file="../include/footer.jsp"%>



