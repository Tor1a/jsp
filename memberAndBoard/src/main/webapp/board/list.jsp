<%@page import="java.sql.DriverManager"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.Connection"%>
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
	
%>

<div id="contents">
	<h2 class="contentsTitle">목록</h2>
	<form method="POST" action="insert_board_action.jsp" class="form">
		<table>
			<cols>
				<col style="width: 50px;">
				<col>
				<col style="width: 150px;">
			</cols>
			<thead>
				<tr>
					<th>No</th>
					<th>subject</th>
					<th>name</th>
				</tr>
			</thead>
			<tbody>
				
				<%
					try {
						Class.forName(driver);
						conn = DriverManager.getConnection(url,id,password);
						String sql = "SELECT * FROM BOARD ORDER BY NO DESC";
						pstmt = conn.prepareStatement(sql);
						rs = pstmt.executeQuery();
						while(rs.next()) {  // rs.next()를 통해서 row읽어 내려간다.
							out.print("<tr>");
							out.print("<td>"+rs.getString("no")+"</td>");
							//a  를 통해서 페이지 링크를 걸때 데이터를 넘기는 방법은  GET 방식 (Query string)
							out.print("<td class='left'><a href='view.jsp?no="+rs.getString("no")+"'>"+rs.getString("subject")+"</a></td>");
							out.print("<td>"+rs.getString("name")+"</td>");
							out.print("<tr>");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				%>
				<!-- 
				<tr>
					<td class="no">1</td>
					<td class="left">제목을 표시합니다.</td>
					<td>정형돈</td>
				</tr>
				<tr>
					<td>1</td>
					<td>제목을 표시합니다.</td>
					<td>정형돈</td>
				</tr>
				<tr>
					<td>1</td>
					<td>제목을 표시합니다.</td>
					<td>정형돈</td>
				</tr>
				<tr>
					<td>1</td>
					<td>제목을 표시합니다.</td>
					<td>정형돈</td>
				</tr>
				<tr>
					<td>1</td>
					<td>제목을 표시합니다.</td>
					<td>정형돈</td>
				</tr>
				<tr>
					<td>1</td>
					<td>제목을 표시합니다.</td>
					<td>정형돈</td>
				</tr>
				<tr>
					<td>1</td>
					<td>제목을 표시합니다.</td>
					<td>정형돈</td>
				</tr>
				-->
				
			</tbody>
		</table>
		<%
			//String name = (String)session.getAttribute("name");
			if(loggedMember!=null){
		%>
				<div class="btns center">
					<a href="write.jsp">글쓰기</a>
				</div>
		<%
			}
		%>
	</form>
</div>
<%@ include file="../include/footer.jsp"%>



