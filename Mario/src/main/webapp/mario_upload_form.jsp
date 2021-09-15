<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/layout.css" rel="stylesheet">
</head>
<body>
	<div id="contents">
		<form action="MarioUpload.do" class="form" method="POST" enctype="multipart/form-data">
			<table class="tdLeft">
				<cols>
					<col style="width:150px">
					<col>
				</cols>
				<tbody>
					<tr>
						<th>TITLE</th>
						<td><input type="text" name="title" placeholder="제목을 쓰세요."></td>
					</tr>
					<tr>
						<th>BACKGROUND</th>
						<td>
							<label><span>RED</span><input type="radio"    name="background" value="#ff0000"></label>
							<label><span>GREEN</span><input type="radio"  name="background" value="#00ff00"></label>
							<label><span>BLUE</span><input type="radio"   name="background" value="#0000ff"></label>
							<label><span>YELLOW</span><input type="radio" name="background" value="#33cc99"></label>
							<label><span>PURPLE</span><input type="radio" name="background" value="#ff3366"></label>
						</td>
					</tr>
					<tr>
						<th>LINK</th>
						<td><input type="text" name="link" placeholder="LINK"></td>
					</tr>
					<tr>
						<th>CONTENTS</th>
						<td><textarea name="contents" placeholder="내용을 입력하시오."></textarea></td>
					</tr>
					<tr>
						<th>MARIO IMG</th>
						<td><input type="file" name="file" placeholder="SELECT MARIO"></td>
					</tr>
				</tbody>
			</table>
			<div class="btns center"><input type="submit" value="확인 "><input type="reset" value="취소 "></div>
		</form>
	</div>
</body>
</html>