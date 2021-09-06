<%@ page import="com.jjang051.model.MemberDto"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.jjang051.model.MemberDao"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.Connection"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp"%>

<%
	MemberDao memberDao = new MemberDao();
	ArrayList<MemberDto> memberList = memberDao.showAllMember();
	request.setAttribute("memberList", memberList);
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
					<!-- 출력하기 jstl  html 자바코드  -->
					<c:forEach var="memberDto" items="${memberList }">
						<tr>
							<td>${memberDto.no }</td>
							<td><a href="member_info.jsp?userId=${memberDto.id }">${memberDto.id }</a></td>
							<td>${memberDto.name }</td>
							<td>${memberDto.zipcode }</td>
							<td>${memberDto.address }</td>
							<td>${memberDto.hp }</td>
							<td>${memberDto.email }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</main>
<%@ include file="./include/footer.jsp"%>





