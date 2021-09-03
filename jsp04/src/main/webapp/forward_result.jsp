<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//form 에 들어있던 값은 String
	//request.setAttribute로 세팅해서 보낸값은 Object
	String age = request.getParameter("age");
	String name = (String)request.getAttribute("name");
	String bloodType = (String)request.getAttribute("bloodType");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>forward로 바뀌 페이지....(서버가 바꾼 페이지라 위쪽 주소는 바뀌지 않음 즉 내용만 바뀜...)</h1>
	<h2>name : <%=name %></h2>
	<h2>age : <%=age %></h2>
	<h2>bloodType : <%=bloodType %></h2>
</body>
</html>