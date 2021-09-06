<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>jsp request 방식</h1>
	<%
		int num01 =(Integer) request.getAttribute("num01");
		int num02 =(Integer) request.getAttribute("num02");
	%>
	<p><%=num01 %>+ <%=num02 %>= <%= num01+num02 %></p>
	
	<p>${num01 }+${num02 } = ${sum }</p>
</body>
</html>