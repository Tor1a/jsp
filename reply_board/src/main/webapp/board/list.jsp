<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div id="contents">
	<h2 class="contentsTitle">목록</h2>
	<form method="POST" action="insert_board_action.jsp" class="form">
		<table>
			<cols>
				<col style="width: 30px;">
				<col>
				<col style="width: 150px;">
				<col style="width: 200px;">
				<col style="width: 30px;">
			</cols>
			<thead>
				<tr>
					<th>No</th>
					<th class="left">Subject</th>
					<th>Name</th>
					<th>Date</th>
					<th>Hit</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="replyDto" items="${replyList }" >
					<tr>
						<td>${replyDto.no }</td>
						<td class="left space${replyDto.reStep }">
							<c:if test="${replyDto.reStep > 1 }">
								<span class="material-icons">subdirectory_arrow_right</span>
							</c:if>
							<a href="BoardView.do?no=${replyDto.no }">${replyDto.subject }</a>
						</td>
						<td>${replyDto.name }</td>
						<td>${replyDto.regDate }</td>
						<td>${replyDto.readCount }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<div class="btns center">
			<a href="BoardWriteForm.do">글쓰기</a>
		</div>
		
	</form>
</div>
<%@ include file="../include/footer.jsp"%>



