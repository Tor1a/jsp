<%@page import="com.jjang051.model.MemberDto"%>
<%@page import="com.jjang051.model.MemberDao"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="./include/header.jsp"%>

<%
	String userId = request.getParameter("userId");
	MemberDao memberDao = new MemberDao();
	MemberDto memberDto = memberDao.getSelectOne("ABCD");
	request.setAttribute("memberDto", memberDto);
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
					<tr>
						<th>ID</th>
						<th>>${memberDto.id }</th>
					</tr>
					<tr>
						<th>Name</th>
						<th>${memberDto.name }</th>
					</tr>
					<tr>
						<th>우편번호</th>
						<th>${memberDto.zipcode }</th>
					</tr>
					<tr>
						<th>주소</th>
						<!--  <th><%= memberDto.getAddress() %></th>-->
						<th>${memberDto.getAddress}</th>
					</tr>
					<tr>
						<th>H,P</th>
						<th>${memberDto.hp }</th>
					</tr>
					<tr>
						<th>email</th>
						<th>${memberDto.email }</th>
					</tr>
					
						
				</tbody>
			</table>
		</div>
	</div>
	<!-- contents end -->
</main>
<%@ include file="./include/footer.jsp"%>





