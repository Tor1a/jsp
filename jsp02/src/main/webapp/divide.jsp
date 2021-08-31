<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage = "error.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<p>어떤 숫자를 0으로 나누는건 불가능 합니다.</p>
	<!-- run on server 단축기 ctrl+f11 -->
	<%=2/0 %>
</body>
</html>