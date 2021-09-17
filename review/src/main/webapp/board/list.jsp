<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>
	<div id="contents">
		<h2 class="contentsTitle">목록</h2>
		<div class="form">
			<table>
				<colgroup>
					<col style="width: 30px;">
					<col>
					<col style="width: 150px;">
					<col style="width: 200px;">
					<col style="width: 30px;">
				</colgroup>
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
					<c:forEach var="replyDto" items="${replyList }" begin="0" end="${replyList.size() }" step="1" varStatus="status">
					<tr>
						<td>${replyDto.no }</td>
						<td><a href="ReplyView.do?no=${replyDto.no }">${replyDto.subject }</a></td>
						<td>${replyDto.name }</td>
						<td>${replyDto.regDate }</td>
						<td>${replyDto.readCount }</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<c:if test="${loggedMemberInfo != null }">
			<div class="btns center">
				<a href="ReplyForm.do">글쓰기</a>
			</div>
			</c:if>
		</div>
	</div>
<%@ include file="../include/footer.jsp"   %>








