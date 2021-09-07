<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div id="contents">
	<h2 class="contentsTitle">FAQ</h2>
	<form method="POST" action="insert_faq_action.jsp" class="form">
		<table class="tdLeft">
			<cols>
			<col style="width: 150px;">
			<col>
			</cols>
			<tbody>
				<tr>
					<th>제목</th>
					<td><input type="text" name="subject" placeholder="제목을 쓰세요"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td>
						<textarea rows="" cols="" name="contents"
							placeholder="내용을 쓰세요"></textarea>
					</td>
				</tr>
			</tbody>
		</table>
		<div class="btns center">
			<input type="submit" value="확인"> <input type="button"
				value="취소">
		</div>
	</form>
</div>
<%@ include file="../include/footer.jsp"%>



