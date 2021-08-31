<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp" %>
<%
   String userId = request.getParameter("userId");
   String userPw = request.getParameter("userPw");
   //out.print(userId+"==="+userPw);
   if(userId.equals("jjang051") && userPw.equals("1234")) {
%>
   <script>
      location.href="loginOk.jsp?name=jjang051";
   </script>
<%
   } else {
%>
   <script>
      alert("아이디 비밀번호 확인해주세요.");
      history.back();
   </script>
<%
   }
%>
<main>
<div id="contents">
	<h2 class="contentsTest">로그인</h2> 
</div>
	
</main>
<%@ include file="./include/footer.jsp" %>