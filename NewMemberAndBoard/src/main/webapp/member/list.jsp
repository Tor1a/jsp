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
	
	Connection  conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
%>
<main>
	<div id="contents">
		<h2 class="contentsTitle">MEMBER LIST</h2>
		<div class="form wide">
			<table border="1">
				<cols>
					<col style="width: 50px">
					<col style="width: 100px">
					<col style="width: 100px">
					<col style="width: 100px">
					<col>
					<col style="width: 150px">
					<col style="width: 200px">
				</cols>
				<thead>
					<tr>
						<th>NO</th>
						<th>ID</th>
						<th>이름</th>
						<th>우편번호</th>
						<th>주소</th>
						<th>H.P</th>
						<th>E-MAIL</th>
					</tr>
				</thead>
				<tbody>
					<%
						String sql = "SELECT * FROM MEMBER";
						try{
							Class.forName(driver);
							conn = DriverManager.getConnection(url,id,password);
							pstmt = conn.prepareStatement(sql);
							rs = pstmt.executeQuery();
							while(rs.next()) {
								out.print("<tr>");
								out.print("<td>"+rs.getString("no")+"</td>");
								out.print("<td><a href='member_info.jsp?userId="+rs.getString("id")+"'>"+rs.getString("id")+"</a></td>");
								out.print("<td>"+rs.getString("name")+"</td>");
								out.print("<td>"+rs.getInt("zipcode")+"</td>");
								out.print("<td class='left'>"+rs.getString("address")+"</td>");
								out.print("<td>"+rs.getString("hp")+"</td>");
								out.print("<td>"+rs.getString("email")+"</td>");
								out.print("</tr>");
							}
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							try {
								if(rs!=null) rs.close();
								if(pstmt!=null) pstmt.close();
								if(conn!=null) conn.close();
							} catch(Exception e2) {
								e2.printStackTrace();
							}
						}
					%>
				</tbody>
			</table>
		</div>
	</div>
</main>
<%@ include file="../include/footer.jsp"%>





