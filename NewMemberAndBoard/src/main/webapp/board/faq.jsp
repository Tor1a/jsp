<%@page import="java.sql.DriverManager"%>
<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.PreparedStatement"%>
<%@ page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "test_user";
	String password = "1234";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
%>

<div id="contents">
	<h2 class="contentsTitle">목록</h2>
	<div class="form">
	
		//db   no   subject   contents        date
		       1    fjdksfl    fklds;kf       2021/09/03
		       2    fjdksfl    fklds;kf       2021/09/03
		       3    fjdksfl    fklds;kf       2021/09/03
		<ul>
			<li>
				<div class="subject">비밀번호를 잃어버렸엉,,,  2021/09/03 </div>
				<div>
					비빌번호 잃어 버린걸 나더러 어떡하라고... <br>
					비빌번호 잃어 버린걸 나더러 어떡하라고... <br>
					비빌번호 잃어 버린걸 나더러 어떡하라고... <br>
					비빌번호 잃어 버린걸 나더러 어떡하라고... <br>
					비빌번호 잃어 버린걸 나더러 어떡하라고... <br>
				</div>
			</li>
			<li>
				<div class="subject">비밀번호를 잃어버렸엉,,,  2021/09/03</div>
				<div>
					비빌번호 잃어 버린걸 나더러 어떡하라고... <br>
					비빌번호 잃어 버린걸 나더러 어떡하라고... <br>
					비빌번호 잃어 버린걸 나더러 어떡하라고... <br>
					비빌번호 잃어 버린걸 나더러 어떡하라고... <br>
					비빌번호 잃어 버린걸 나더러 어떡하라고... <br>
				</div>
			</li>
			<li>
				<div class="subject">비밀번호를 잃어버렸엉,,,  2021/09/03</div>
				<div>
					비빌번호 잃어 버린걸 나더러 어떡하라고... <br>
					비빌번호 잃어 버린걸 나더러 어떡하라고... <br>
					비빌번호 잃어 버린걸 나더러 어떡하라고... <br>
					비빌번호 잃어 버린걸 나더러 어떡하라고... <br>
					비빌번호 잃어 버린걸 나더러 어떡하라고... <br>
				</div>
			</li>
			
		</ul>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>



