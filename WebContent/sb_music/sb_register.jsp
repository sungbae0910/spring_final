<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../sb_music/sb_lib/css/jquery-ui.css">
<link rel="stylesheet" href="../sb_music/sb_lib/css/bootstrap.min.css">
<link rel="stylesheet" href="../sb_music/sb_lib/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../sb_music/sb_lib/css/sb_register.css">
<script src="../sb_music/sb_lib/js/jquery-3.4.1.js"></script>
<script src="../sb_music/sb_lib/js/jquery-ui.js"></script>
</head>
<body>
	
	
	<br><br><br><br>
	<div align="center">
		<h1>로고</h1>
		<br><br>
		<div class="container">	
			<form id="frm_register" name="frm_register">
				
				<span>아이디</span><br> 
				<input type="text" id="mId" name="mId"><div id="checkId" ></div><br>
				<span>비밀번호</span> <br> 
				<input type="text" id="pwd" name="pwd"><br>
				<span>성명</span> <br> 
				<input type="text" id="mName" name="mName"><br>
				<span>생년월일</span> <br> 
				<input type="date" id="birth" name="birth"><br>
				<span>전화번호</span> <br> 
				<input type="tel" id="phone" name="phone"><br>
				<span>이메일주소</span> <br> 
				<input type="email" id="email" name="email"><br>
				<span>집주소</span> <br> 	
				<input type="text" id="address" name="address"><br><br>
				<span>성별</span><br>
				<select id="gender" name="gender">
					<option value="1">남성</option>
					<option value="2">여성</option>
					<option value="3">애매함</option>
				</select>
				<br><br>
				
				<button id="sm" type="submit">회원가입</button>
			
			</form>
		</div>
	</div>


<script src="../sb_music/sb_lib/js/sb_register.js"></script>
</body>
</html>