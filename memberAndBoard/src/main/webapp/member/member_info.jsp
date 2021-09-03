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
		<h2 class="contentsTitle">회원정보</h2>
		<div class="form">
			<table border="1" class="tdLeft">
				<cols>
				<col style="width: 150px">
				<col style="width: 550px">
				</cols>
				<tbody>
						<%
							//session.setAttribute("name","value"); // bean, vo, dto
							//String userId = request.getParameter("userId");
							String userId = (String)session.getAttribute("id");
							String sql = "SELECT * FROM MEMBER WHERE ID = ?";
							try{
								Class.forName(driver);
								conn = DriverManager.getConnection(url,id,password);
								pstmt = conn.prepareStatement(sql);
								pstmt.setString(1, userId);
								rs = pstmt.executeQuery();
								while(rs.next()) {
									out.print("<tr>");
										out.print("<th>ID</th>");
										out.print("<td>"+rs.getString("id")+"</a></td>");
									out.print("</tr>");
									out.print("<tr>");
										out.print("<th>이름</th>");
										out.print("<td>"+rs.getString("name")+"</td>");
									out.print("</tr>");
									out.print("<tr>");
										out.print("<th>우편번호</th>");
										out.print("<td>"+rs.getInt("zipcode")+"</td>");
									out.print("</tr>");
									out.print("<tr>");
										out.print("<th>주소</th>");
										out.print("<td>"+rs.getString("address")+"</td>");
									out.print("</tr>");
									out.print("<tr>");
										out.print("<th>HP</th>");
										out.print("<td>"+rs.getString("hp")+"</td>");
									out.print("</tr>");
									out.print("<tr>");
										out.print("<th>E-MAIL</th>");
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
			<div class="btns center">
				<a href="member_modify.jsp">회원정보 수정</a>
				<a href="member_delete.jsp">회원탈퇴</a>
			</div>
		</div>
	</div>
	<!-- contents end -->
</main>
<%@ include file="../include/footer.jsp"%>





