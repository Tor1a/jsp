<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div id="contents">
	<h2 class="contentsTitle">VIEW</h2>
	<div class="form">
		<table class="tdLeft">
			<cols>
				<col style="width: 150px;">
				<col style="width:350px">
				<col style="width: 150px;">
				<col style="width:350px">
			</cols>
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
					<th>subject</th>
					<td colspan="3">${replyDto.subject }</td>
				</tr>
				<tr>
					<th>contents</th>
					<td class="txtContents" colspan="3">${replyDto.contents }</td>
				</tr>
			</tbody>
		</table>
		
		<div class="prevAndNext">
			<div class="item">
				<span class="inner">PREV <span class="material-icons">expand_less</span></span>
				<a href="BoardView.do?no=${prevReplyDto.no}&num=${prevReplyDto.num}">${prevReplyDto.subject }</a>
			</div>
			<div class="item"><span class="inner">NEXT <span class="material-icons">expand_more</span></span>
				<a href="BoardView.do?no=${nextReplyDto.no}&num=${nextReplyDto.num}">${nextReplyDto.subject }</a>
			</div>
		</div>
		<div class="btns center">
			<a href="BoardReplyForm.do?no=${replyDto.no }&reGroup=${replyDto.reGroup}&reStep=${replyDto.reStep}&reLevel=${replyDto.reLevel}">답글달기</a>
			<a href="">삭제</a>
			<a href="">수정</a>
			<a href="BoardList.do?clickedPage=1">목록</a>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>



