<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:choose>
		<c:when test="${param.fruit ==1 }">
			<p>자두</p>
		</c:when>
		<c:when test="${param.fruit ==2 }">
			<p>복숭아</p>
		</c:when>
		<c:when test="${param.fruit ==3 }">
			<p>사과</p>
		</c:when>
		<c:otherwise>
			<p>당근</p>
		</c:otherwise>
	</c:choose>
</body>
</html>