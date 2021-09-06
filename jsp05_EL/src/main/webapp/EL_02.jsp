<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>정수: ${10}</li>
		<li>실수: ${4.8}</li>
		<li>문자열: ${"김민준"}</li>
		<li>boolean: ${true }</li>
		<li>실수: ${4.8}</li>
		<li>null: ${null}</li>

	</ul>
	<h2>EL 연산</h2>
	<ul>
		<li>${10+10}</li>
		<li>${100-10}</li>
		<li>${10*10}</li>
		<li>${10/10}</li>
	</ul>
	<%
		String input = null;
	%>
	
	<!-- null 인지 아닌지... 값이 넘어오지 않을 경우 문제가 생긴다. -->
</body>	
</html>