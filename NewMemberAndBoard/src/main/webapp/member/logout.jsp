<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String  name = (String)session.getAttribute("name");
%>
<script>
	alert("<%=name%>님 안녕히 가세요");
</script>
<%
	session.invalidate();
	//response.sendRedirect("../board/list.jsp");
%>
<script>
	location.href="../board/list.jsp";
</script>
<!-- 1.경고창 띄워서 장성호님 안녕히 가세요. -->
<!-- 2.세션종료 -->
<!-- 3.list.jsp -->