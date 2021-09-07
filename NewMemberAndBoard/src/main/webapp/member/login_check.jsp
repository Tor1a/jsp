<%@page import="com.jjang051.model.MemberDto"%>
<%@page import="com.jjang051.model.MemberDao"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String userId =  request.getParameter("userId");
	String userPw =  request.getParameter("userPw");
	
	MemberDao memberDao = new MemberDao();
	MemberDto memberDto = new MemberDto();
	memberDto.setId(userId);
	memberDto.setPassword(userPw);
	MemberDto loggedMember =  memberDao.getLoggedMember(memberDto);
	if(loggedMember!=null) {
		session.setAttribute("loggedMember", loggedMember);
%>
		<script>
			location.href="../board/list.jsp";
		</script>
<%
	} else {
%>
		<script>
			alert("id/password를 확인해 주세요");
			history.back();
		</script>
<%
	}
%>
	









