<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core"  prefix="c" %>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${param.color ==1 }">
	<div style="width:100px; height:100%; border-radius:100%; background:#f00"></div>
</c:if>
<c:if test="${param.color ==2 }">
	<div style="width:100px; height:100%; border-radius:100%; background:#0f0"></div>
</c:if>
<c:if test="${param.color ==3 }">
	<div style="width:100px; height:100%; border-radius:100%; background:#00f"></div>
</c:if>

</body>
</html>