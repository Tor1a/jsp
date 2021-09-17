<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
<div id="contents">
	<div class="container">
		<h2 class="contentsTitle">VIEW</h2>
		<form class="form" method="POST" action="BoardDelete.do">
			<table>
				<colgroup>
					<col style="width:150px">
					<col style="width:450px">
					<col style="width:150px">
					<col style="width:450px">
				</colgroup>
				<tbody>
					<tr>
						<th>name</th>
						<td>${replyDto.name }</td>
						<th>hit</th>
						<td>${replyDto.readCount }</td>
					</tr>
					<tr>
						<th>email</th>
						<td>${replyDto.email }</td>
						<th>date</th>
						<td>${replyDto.regDate }</td>
					</tr>
					<tr>
						<th>contents</th>
						<td colspan="3" style="height:300px; text-align:left; vertical-align:top">${replyDto.contents }</td>
					</tr>
					<tr>
						<th>password</th>
						<td colspan="3">
							<input type="password" name="password" placeholder="비밀번호를 입력하시오">
							<input type="hidden" name="no" value="${param.no }">
						</td>
					</tr>
				</tbody>
			</table>
			<div class="btns">
				<a href="ReplyList.do">목록</a>
				<input type="submit" value="확인">
			</div>
		</form>
	</div>
</div>	
<%@ include file="../include/footer.jsp" %>




