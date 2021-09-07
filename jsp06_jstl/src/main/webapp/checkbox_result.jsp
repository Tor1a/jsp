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
	<%
		String languages[] = request.getParameterValues("language");
		for(int i=0;i<languages.length;i++){
			out.print(languages[i]);
		}
	%>
	<h1>당신이 할 수 있는 프로그래밍 언어는?</h1>
	<c:forEach var="language" items="${paramValues.language }" varStatus="status">
		${language }  <c:if test="${!status.last }">,</c:if>
	</c:forEach>
</body>
</html>