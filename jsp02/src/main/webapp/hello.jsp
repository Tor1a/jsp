<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>hello jsp</h1>
	<!-- jsp는 html파일안에 자바 파일 쓰기... -->
	<% 
		int num01 = 20;
		int num02 = 10;
		int sum = num01+num02;
		//servlet에서 썼던 PrintWriter가 내장객체로 들어가 있다. 걔네 이름이  out
		//톰캣 서버가 안에 있는 것은 자바 파일로 인식...
		out.println(sum);  // 이건 화면에 노출된다.
	%>
	<!-- servlet에서는 java 파일에 html 쓰기 -->
	<!-- jsp는 html 파일에 java 쓰기 -->
	
	
</body>
</html>