<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!-- page 지시자.... -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<!-- jsp를 하고 있으니 오늘 날짜를 java통해서 가져오고 싶다. -->
	<%@ include file ="header.jsp" %>
	<%
		Calendar date = Calendar.getInstance();
		SimpleDateFormat today = new SimpleDateFormat("yyyy-MM-dd");
	%>
	<p>오늘은 <%=today.format(date.getTime()) %>  </p>
	<p><a href="sub.jsp">서브페이지 바로가기</a></p>
	<%@ include file ="footer.jsp" %>
</body>
</html>