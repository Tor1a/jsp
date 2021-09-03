<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int age = Integer.parseInt(request.getParameter("age"));
	if(age<=19) {
%>
	<script>
		alert("19세 미만이므로 입장 불가....");
		history.back();
		//history.go(-1);
	</script>
<%
	} else {
		// forward
		request.setAttribute("name","jjang051");  //값을 세팅....
		request.setAttribute("bloodType","A");  //값을 세팅....
		RequestDispatcher dispatcher = request.getRequestDispatcher("forward_result.jsp");
		dispatcher.forward(request,response);
	}
%>