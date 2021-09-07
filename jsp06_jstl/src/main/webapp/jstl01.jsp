<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	pageContext.setAttribute("test", "test에 저장된 변수값입니다.");  // request, session, application
%>
<body>
	<c:out value="Hello World"></c:out>
	<c:set var = "msg" scope="request" vaule="hello m sg 나는 c:set으로 만들어진 변수"></c:set>
	<c:set var=  "add" value="${10+5 }"></c:set>
	<p>${test }</p>
	<p>${msg }</p>
	<p>${add }</p>
</body>
</html>