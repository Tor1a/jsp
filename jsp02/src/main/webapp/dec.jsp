<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 변수 또는 메서드 선언 declation   -->
	<%!
		String str = "안녕하세요.";
		int num01 = -10;
		int num02 = 20;
		public int abs(int num) {
			if(num < 0) {
				return num = -num;
			}
			return num;
		}
	%>
	<%	
		out.print(str+"<br>");
		out.print("<p>"+str+"</p>");
		out.print(num01+"의 절대값은 " + abs(num01)+"<br>");
		out.print(num02+"의 절대값은 " + abs(num02)+"<br>");
	%>
</body>
</html>






