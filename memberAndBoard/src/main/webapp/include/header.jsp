<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String loggedMember = (String)session.getAttribute("name");
	String loggedMemberId = (String)session.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>INCLUDE 연습</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR:wght@100;200;300;400;500;600;700&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="../css/layout.css">
<script src="../js/jquery-3.6.0.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<header id="header">
		<div class="container">
			<h1 id="logo">
				<a href="">JJANG051'S MEDIA</a>
			</h1>
			<nav id="gnb">
				<%
					if(loggedMember==null) {
				%>
						<ul>
							<li><a href='../member/login.jsp'>로그인</a></li>
							<li><a href="../member/join.jsp">회원가입</a></li>
							<li><a href="../board/list.jsp">게시판</a></li>
						</ul>
				<%
					} else {
				%>
						<ul>
							<!-- <li><a href='../member/member_info.jsp?userId=<%=loggedMemberId%>'><%=loggedMember%></a></li> -->
							<li><a href='../member/member_info.jsp'><%=loggedMember%></a></li>
							<li><a href="../member/logout.jsp">로그아웃</a></li>
							<li><a href="../board/list.jsp">게시판</a></li>
						</ul>
				<%
					}
				%>
				
			</nav>
		</div>
	</header>
	<!-- 내용은 여기에 들어감... -->