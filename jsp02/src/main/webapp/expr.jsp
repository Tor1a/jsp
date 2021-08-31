<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 변수 또는 메서드 선언 declation 전역 변수   -->
<%!
	String str = "안녕하세요.";
	int num01 = -10;
	int num02 = 20;
	int globalNum = 1;
	public int abs(int num) {
		if(num < 0) {
			return num = -num;
		}
		return num;
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>num01의 절대값은 <%=num01%></p>  <!-- expression 표현식 -->
	<p>str의 값은 "<%=str%>"</p>
	<p>num01의 값은 <%=num01 %>이고 절대값은 <%=abs(num01) %>이다.</p>
	<%
		out.print("<p>num01의 절대값은 "+num01+"</p>");
		int localNum = 1;
		out.print("localNum : ");
		out.print(++localNum+"<br>");
		out.print("globalNum : ");
		out.print(++globalNum);
		//
		/*
			
		*/
		
		
	%>
</body>
</html>