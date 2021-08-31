<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./include/header.jsp"%>
<main>
	<div id="contents">
		<h2 class="contentsTitle">회원가입</h2>
		<form method="POST" action="signUp.jsp" id="join" class="form"
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
					<tr>
						<th>비밀번호확인 <span>*</span></th>
						<td>
							<input type="password" name="userPw02" placeholder="패스워드" id="userPw02">
							<span class="txtPass red"></span>
						</td>
					</tr>
					<tr>
						<th>비밀번호 확인 질문 <span>*</span></th>
						<td><select id="hint" name="hint">
								<option value="hint_01">기억에 남는 추억의 장소는?</option>
								<option value="hint_02">자신의 인생 좌우명은?</option>
								<option value="hint_03">자신의 보물 제1호는?</option>
								<option value="hint_04">가장 기억에 남는 선생님 성함은?</option>
								<option value="hint_05">타인이 모르는 자신만의 신체비밀이 있다면?</option>
								<option value="hint_06">추억하고 싶은 날짜가 있다면?</option>
								<option value="hint_07">받았던 선물 중 기억에 남는 독특한 선물은?</option>
								<option value="hint_08">유년시절 가장 생각나는 친구 이름은?</option>
								<option value="hint_09">인상 깊게 읽은 책 이름은?</option>
								<option value="hint_10">읽은 책 중에서 좋아하는 구절이 있다면?</option>
								<option value="hint_11">자신이 두번째로 존경하는 인물은?</option>
								<option value="hint_12">친구들에게 공개하지 않은 어릴 적 별명이 있다면?</option>
								<option value="hint_13">초등학교 때 기억에 남는 짝꿍 이름은?</option>
								<option value="hint_14">다시 태어나면 되고 싶은 것은?</option>
								<option value="hint_15">내가 좋아하는 캐릭터는?</option>
						</select></td>
					</tr>
					<tr>
						<th>비밀번호 확인 답변 <span>*</span></th>
						<td><input type="text" name="hintAnswer"
							placeholder="비밀번호 확인 답변"></td>
					</tr>
					<tr>
						<th>이름*</th>
						<td><input type="text" name="userName"></td>
					</tr>
					<tr>
						<th>주소</th>
						<td>
							<div>
								<!-- 정규표현식.... -->
								<input type="number" name="address01" class="short" id="zipcode"> 
								<input type="button" name="addressBtn" value="우편번호" id="btnZip">
							</div>
							<div>
								<input type="text" name="address02" id="address02"><span>기본주소</span>
							</div>
							<div>
								<input type="text" name="address03" id="address03"><span>나머지주소</span>
							</div>
						</td>
					</tr>
					<tr>
						<th>일반전화</th>
						<td><select name="homeNumber" class="short">
								<option value="02">02</option>
								<option value="031">031</option>
								<option value="032">032</option>
								<option value="033">033</option>
						</select> - <input type="number" name="homeMidleNumber" class="short">
							- <input type="number" name="homeLastNumber" class="short">
						</td>
					</tr>
					<tr>
						<th>휴대전화</th>
						<td><select name="phoneNumber" class="short">
								<option value="02">010</option>
								<option value="031">011</option>
								<option value="032">017</option>
						</select> - <input type="number" name="phoneMidleNumber" class="short">
							- <input type="number" name="phoneLastNumber" class="short"></td>
					</tr>
					<tr>
						<th>SMS수신여부*</th>
						<td><input type="checkbox" name="SMSCheck" value="true">동의함
							<br>
							<p>
								쇼핑몰에서 제공하는 유익한 이벤트 소식을 SMS로 받으실 수 있습니다.<br>(※ 선택하지 않을 시 수신
								미동의로 가입됩니다.)
							</p></td>
					</tr>
					<tr>
						<th>이메일<span>*</span></th>
						<td><input type="text" name="userEmail"></td>
					</tr>
					<tr>
						<th>이메일 수신여부</th>
						<td><input type="checkbox" name="EmailCheck" value="true">동의함
							<br>
							<p>
								쇼핑몰에서 제공하는 유익한 이벤트 소식을 이메일로 받으실 수 있습니다.<br>(※ 선택하지 않을 시 수신
								미동의로 가입됩니다.)
							</p></td>
					</tr>
				</tbody>
			</table>
			<div class="btns center">
				<input type="submit" value="회원가입" onClick="return signCheck();">
			</div>
		</form>
	</div>
	<!-- contents end -->
	<script>
		function signCheck() {
			if (document.signUp.userId.value == "") {
				alert("아이디를 입력하시오.");
				document.signUp.userId.focus();
				return false;
			} else if (document.signUp.userPw.value == "") {
				alert("패스워드를 입력하시오.");
				document.signUp.userPw.focus();
				return false;
			} else if (document.signUp.userPw02.value == "") {
				alert("패스워드확인를 입력하시오.");
				document.signUp.userPw02.focus();
				return false;
			} else {
				return true;
			}
		}
	</script>
	
	<script>
		$("#btnZip").on("click",function(){
			new daum.Postcode({
		        oncomplete: function(data) {
		            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
		            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
		            //console.log(data.zonecode);
		            //console.log(data.address);
		        	$("#zipcode").val(data.zonecode);
		        	$("#address02").val(data.address);
		            
		        }
		    }).open();
			return false;
		});
		$("#userPw02").on("keyup",function(e){
			if($("#userPw").val() !== $("#userPw02").val()){
				//console.log("틀리다");
				$(".txtPass").text("비밀번호가 맞지 않습니다.");
				$(".txtPass").addClass("red");
			} else {
				//console.log("같다");
				$(".txtPass").text("비밀번호가 맞습니다.");
				$(".txtPass").removeClass("red");
			}
		});
	</script>
</main>
<%@ include file="./include/footer.jsp"%>



