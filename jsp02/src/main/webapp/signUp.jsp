<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp" %>
<%
	String userId =  request.getParameter("userId");	
%>
<main>

	<div id="contents">
		<h2 class="contentsTitle">회원정보</h2>
		<div id="memberInfo" class="form">
			<table>
				<tbody>
					<th>ID</th>
					<td><%=userId%></td>
				</tbody>
			</table>			
		</div>
	</div> 
</main>
<%@ include file="./include/footer.jsp" %>



