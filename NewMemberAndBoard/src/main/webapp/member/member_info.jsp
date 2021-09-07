<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

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
					<tr>
						<th>ID</th>
						<td>${loggedMember.id }</td>
					</tr>
					<tr>
						<th>Name</th>
						<td>${loggedMember.name }</td>
					</tr>
					<tr>
						<th>Email</th>
						<td>${loggedMember.email }</td>
					</tr>
					<tr>
						<th>H.P</th>
						<td>${loggedMember.hp }</td>
					</tr>
					<tr>
						<th>Address</th>
						<td>${loggedMember.address }</td>
					</tr>
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





