<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
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
				<c:forEach var="replyDto" items="${replyList }" begin="0" end="${replyList.size()}" step="1" varStatus="status" >
					<tr>
						<!-- <td>${replyDto.no }</td> -->
						<td>${total - (currentPage-1)*listPerCount - status.index }</td>
						<td class="left space${replyDto.reStep }">
							<c:if test="${replyDto.reStep > 1 }">
								<span class="material-icons">subdirectory_arrow_right</span>
							</c:if>
							<a href="BoardView.do?no=${replyDto.no }&clickedPage=${currentPage}">${replyDto.subject }</a>
						</td>
						<td>${replyDto.name }</td>
						<td>
							<fmt:formatDate pattern="yy-MM-dd hh:mm:ss" value="${replyDto.regDate }" />
							<p>${replyDto.regDate}</p>
						</td>
						<td>${replyDto.readCount }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div class="paginationBox">
			<ul>
				<c:if test="${startPage!=1 }">
					<li>
						<a href="BoardSearchList.do?clickedPage=${startPage - pageGroupCount }&searchSelect=${param.searchSelect }&searchWord=${param.searchWord }">
							<span class="material-icons">chevron_left</span>
						</a>
					</li>
				</c:if>
				<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1" varStatus="status">
					<li class="${currentPage == i ? 'active':'' }">
						<a href="BoardSearchList.do?clickedPage=${i }&searchSelect=${param.searchSelect }&searchWord=${param.searchWord }">
							${i }
						</a>
					</li>
				</c:forEach>
				<c:if test="${endPage != lastPage}">
					<li>
						<a href="BoardSearchList.do?clickedPage=${startPage + pageGroupCount }&searchSelect=${param.searchSelect }&searchWord=${param.searchWord }">
							<span class="material-icons">chevron_right</span>
						</a>
					</li>
				</c:if>
			</ul>
		</div>
		<form class="searchForm" method="GET" action="BoardSearchList.do">
			<select name="searchSelect" class="searchSelect">
				<option value="name"     ${param.searchSelect=="name"?"selected":"" }  >작성자</option>
				<option value="contents" ${param.searchSelect=="contents"?"selected":"" }>내용</option>
				<option value="subject"  ${param.searchSelect=="subject"?"selected":""}>제목</option>
			</select>
			<input type="text" name="searchWord" value="${param.searchWord }" placeholder="검색어를 입력하세요.">
			<input type="submit" class="btn"  value="검색">
		</form>
		<div class="btns center">
			<a href="BoardWriteForm.do">글쓰기</a>
		</div>
		
	</div>
</div>
<%@ include file="../include/footer.jsp"%>
<!-- 
 글 갯수 58                   
 글 리스트 한번에 보여지는 갯수 10  
 pagination이 보여지는 갯수 4   
 1/2/3/4   >     5/6     
 
 전체글의 갯수  SQL ,  보여지는 리스트의 갯수 10 (내가 결정)
 pagination이 보여지는 갯수 4  (내가 결정)
  -->









