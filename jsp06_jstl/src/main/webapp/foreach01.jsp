<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String movieList[] = {"스파이더맨","닥터 스트레인지","아이언맨","토르"};
		request.setAttribute("movieList", movieList);
	%>
	<ul>
	<p>
		varStatus = status
	</p>
		<c:forEach var="movieName" items="${movieList }" varStatus="status">
		<c:choose>
			<c:when test="${status.index ==0 }">
				<li><a href=""><span>${status.index +1}</span>${movieName }</a></li>
			</c:when>
		</c:choose>
		</c:forEach>
		
		<c:forEach var="movieName" items="${movieList }" varStatus="status">
		<c:choose>
			<c:when test="${status.last }">
				<li><a href=""><span>${status.index +1}</span>${movieName }</a></li>
			</c:when>
		</c:choose>
		</c:forEach>
		<hr>
		<table border="1">
			<tr>
				<td>2 x  1 = 2</td>
				<td>2 x  1 = 2</td>
				<td>2 x  1 = 2</td>
				<td>2 x  1 = 2</td>
				<td>2 x  1 = 2</td>
				<td>2 x  1 = 2</td>
				<td>2 x  1 = 2</td>
				<td>2 x  1 = 2</td>
				<td>2 x  1 = 2</td>
			</tr>
		</table>
		<ul>
			<c:forEach var="cnt" begin="1" end="10" step="1">
				<li>3 x ${cnt } = ${cnt*3 }</li>
			</c:forEach>
		</ul>
		
		<table border="1">
			<h1>구구단</h1>
   <table border="1">
      <c:forEach var="trCount" begin="1" end="9" step="1">
         <tr>
            <c:forEach var="tdCount" begin="2" end="9" step="1">
               <td>${tdCount} x ${trCount} = ${tdCount*trCount }</td>
            </c:forEach>
         </tr>
      </c:forEach>
   </table>
			
		</table>
	<!-- 
		<li><a href="">스파이더맨</a></li>
		<li><a href=""></a></li>
		<li><a href=""></a></li>
		<li><a href=""></a></li>
	 -->
	</ul>
</body>
</html>