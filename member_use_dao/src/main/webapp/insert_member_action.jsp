<%@page import="com.jjang051.model.MemberDto"%>
<%@page import="com.jjang051.model.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
String userId = request.getParameter("userId");
String userPw =request.getParameter("userPw");
String userName =request.getParameter("userName");
int zipcode =Integer.parseInt(request.getParameter("zipcode"));
String address =request.getParameter("address01")+request.getParameter("address02");
String hp =request.getParameter("PhoneNumber")+request.getParameter("PhoneMiddelNumber")+request.getParameter("PhoneLastNumber");
String Email =request.getParameter("userEmail");

MemberDto memberDto = new MemberDto();
MemberDao memberDao = new MemberDao();
memberDto.setId(userId);
memberDto.setPassword(userPw);
memberDto.setName(userName);
memberDto.setZipcode(zipcode);
memberDto.setAddress(address);
memberDto.setHp(hp);
memberDto.setEmail(Email);
int result = memberDao.insertMember(memberDto);
out.print(result);

if(result>0){
	%>
	<script>
		alert("회원가입이 완료되었습니다");
		location.href="list.jsp";
	
	</script>
	<% 
}else{
	%>
	<script>
	alert("회원가입이 실패되었습니다");
	history.back();

</script>
<%
}
%>