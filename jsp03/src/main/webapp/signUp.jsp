<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp" %>
<%
	request.setCharacterEncoding("utf-8");
	String userId =  request.getParameter("userId");
	String userPw =  request.getParameter("userPw");
	String hint =  request.getParameter("hint");
	String hintAnswer =  request.getParameter("hintAnswer");
	String userName =  request.getParameter("userName");
	
	String zipcode =  request.getParameter("address01");
	String address02 =  request.getParameter("address02");
	String address03 =  request.getParameter("address03");
	String address = address02+address03; 
	
	String userEmail =  request.getParameter("userEmail");

%>
<main>

	<div id="contents">
		<h2 class="contentsTitle">회원정보</h2>
		<div id="memberInfo" class="form">
			<table>
				<tbody>
					<tr>
						<th>ID</th>
						<td><%=userId%></td>
					</tr>
					<tr>
						<th>PASSWORD</th>
						<td><%=userPw%></td>
					</tr>
					<tr>
						<th>비밀번호 확인 질문</th>
						<td><%=hint%></td>
					</tr>
					<tr>
						<th>비밀번호 확인 질문 답변</th>
						<td><%=userId%></td>
					</tr>
					<tr>
						<th>우편번호</th>
						<td><%=zipcode%></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><%=address%></td>
					</tr>
					<tr>
						<th>비밀번호 확인 질문 답변</th>
						<td><%=userId%></td>
					</tr>
					
					<tr>
						<th>EMAIL</th>
						<td><%=userEmail%></td>
					</tr>
					
				</tbody>
				
			</table>			
		</div>
	</div> 
</main>
<%@ include file="./include/footer.jsp" %>



