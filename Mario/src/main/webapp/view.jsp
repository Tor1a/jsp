<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Source+Sans+Pro:wght@200;300;400;600;700;900&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="css/reset.css">
<link rel="stylesheet" href="css/swiper.css">
<link rel="stylesheet" href="css/mario_layout.css">
<script src="js/jquery-3.6.0.min.js"></script>
<script src="js/swiper.min.js"></script>
<script src="js/gsap/gsap.min.js"></script>
<script src="js/main.js" defer></script>
</head>

<body>
	<header id="header" class="header">
		<h1 id="logo">
			<a href=""><img src="images/logo.png" alt=""></a>
		</h1>
		<nav id="gnb">
			<ul>
				<li><a href="">supermario</a></li>
				<li><a href="">monster</a></li>
			</ul>
		</nav>
	</header>
	<nav id="menu">
		<ul>
			<li>타이틀 뿌리기...</li>
		</ul>
	</nav>
	<main id="main">
		<ul class="swiper-wrapper" id="marioList">
			<c:forEach var = "marioDto" items="${marioList }">
				<li class="swiper-slide">
					<div class="item">
						<div class="img">
							<img src="upload_mario/${marioDto.marioRealImg }" alt="">
						</div>
						<div class="infoBox" style="background-color:${marioDto.bg}">
							<h2>${marioDto.title }</h2>
							<p>${marioDto.contents }</p>
							<a href="${marioDto.link }" target="_blank">more</a>
						</div>
					</div>
				</li>
			</c:forEach>
		</ul>
	</main>
	<footer id="footer">
		<p>ALL COPYRIGHT RESERved by jjang051's media lab</p>
	</footer>

</body>

</html>