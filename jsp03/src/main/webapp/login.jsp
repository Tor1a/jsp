<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp"%>
<main>
	<div id="contents">
		<h2 class="contentsTitle">로그인</h2>
		<form method="POST" action="loginㅅㄷㄴㅅ.jsp" id="join" class="form"
			name="signUp">
			<table border="1">
				<cols>
				<col style="width: 200px">
				<col style="width: 600px">
				</cols>
				<tbody>
					<tr>
						<th>아이디 <span>*</span></th>
						<td><input type="text" name="userId" placeholder="아이디">
						</td>
					</tr>
					<tr>
						<th>비밀번호 <span>*</span></th>
						<td><input type="password" name="userPw" placeholder="패스워드"  id="userPw">
						</td>
					</tr>
					
				</tbody>
			</table>
			<div class="btns center">
				<input type="submit" value="로그인" >
			</div>
		</form>
	</div>>