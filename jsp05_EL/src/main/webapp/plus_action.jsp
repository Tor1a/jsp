<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>결과 값</h1>
	더하기 출력하기.. request로  빋이사 형변환  해서  더하기
	<%
		int num01 = Integer.parseInt(request.getParameter("num01"));
		int num02 = Integer.parseInt(request.getParameter("num02"));
	%>
	<p><%= num01 %>+<%= num02 %> = <%= num01+num02 %></p>
	<p>${param.num01} + ${param.num02 } = ${param.num01+param.num02 } </p>
</body>
</html>