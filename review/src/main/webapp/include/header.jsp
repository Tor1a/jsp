<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JJANG'S MEDIA</title>
<link rel="stylesheet" href="css/layout.css">
<script src="js/jquery-3.6.0.min.js"></script>
<script	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
</head>
<body>
	<header id="header">
		<div class="container">
			<h1 id="logo">JJANG'S MEDIA</h1>
			<nav id="gnb">
				<c:choose>
					<c:when test="${loggedMemberInfo != null}">
						<ul>
							<li><a href="MemberInfo.do">${loggedMemberInfo.name}</a></li>
							<li><a href="MemberLogOut.do">로그아웃</a></li>
							<li><a href="ReplyList.do">게시판</a></li>
						</ul>
					</c:when>
					<c:otherwise>
						<ul>
							<li><a href="MemberJoin.do">회원가입</a></li>
							<li><a href="MemberLogin.do">로그인</a></li>
							<li><a href="ReplyList.do">게시판</a></li>
						</ul>						
					</c:otherwise>
				</c:choose>
			</nav>
		</div>
		<!-- M V C -->
	</header>