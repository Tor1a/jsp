<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Requset 내장객체를 통해 받기</h1>
<p>ID: <%= request.getParameter("userId") %></p>
<p>PW: <%= request.getParameter("userPw") %></p>
<h2> ==를 이용한 로그인 처리</h2>
<p>
	<%= request.getParameter("userId").equals("tis") %>
</p>

<h1>EL에 있는 param통해서 받기</h1>
<p>ID:${param.userId}  </p>
<p>PW: ${param.userPw}></p>
<p>${param.userId+param.userPw }</p>

<h2> EL을 이용한 로그인 처리</h2>
<p> ${param.userId =="tis"} }</p>
<!-- bean, vo, dto, / memberVo, memberDto, memberBean el jst1 -->
<!-- param으로 값을 받으면 자동 형변환된다.-->
</body>
</html>