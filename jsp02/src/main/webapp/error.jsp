<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ERROR</title>
</head>
<body>
	<h1>아래와 같은 ERROR가 발생했습니다.</h1>
	<h2><%= exception.getMessage() %></h2>
</body>
</html>