<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String)session.getAttribute("name");
%>
<!-- 1. alert창 띄우기 2. 세션종료시키기 3. list.jsp로 보내기 -->

<script>
	alert("<%=name%> 빠이요");
</script>
<% 
	session.invalidate(); // 세션 종료
%>
<script>
	location.href="../board/list.jsp";
</script>