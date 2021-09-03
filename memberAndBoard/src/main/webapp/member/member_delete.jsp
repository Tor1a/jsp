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
		<h2 class="contentsTitle">회원탈퇴</h2>
		<form method="POST" action="delete_member_action.jsp" class="form">
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
						<tr>
							<th>password</th>
							<td><input type="password" placeholder="패스워드를 입력하시오." name="userPw"></td>
						</tr>
				</tbody>
			</table>
			<div class="btns center">
				<input type="submit" value="회원탈퇴">
				<a href="member_delete.jsp">취소</a>
			</div>
		</form>
	</div>
	<!-- contents end -->
</main>
<%@ include file="../include/footer.jsp"%>





