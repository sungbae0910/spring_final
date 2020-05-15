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
<link rel="stylesheet" href="../sb_music/sb_lib/css/sb_login.css">
<script src="../sb_music/sb_lib/js/jquery-3.4.1.js"></script>
<script src="../sb_music/sb_lib/js/jquery-ui.js"></script>
</head>
<body>
	
	
	
	<div align="center">
		<div class="container">
			<form id="frm_register" name="frm_register">
				<span>아이디</span><br> 
				<input type="text" ><br>
				<span>비밀번호</span> <br> 
				<input type="text"><br>
				<span>성명</span> <br> 
				<input type="text"><br>
				<span>생년월일</span> <br> 
				<input type="date"><br>
				<span>전화번호</span> <br> 
				<input type="tel"><br>
				<span>이메일주소</span> <br> 
				<input type="email"><br>
				<span>집주소</span> <br> 
				<input type="text"><br><br>
				<span>성별</span><br>
				<select>
					<option>남성</option>
					<option>여성</option>
					<option>애매함</option>
				</select>
				<br><br>
				
				<button type="submit">회원가입</button>
			
			</form>
		</div>
	</div>


<script src="../sb_music/sb_lib/js/sb_login.js"></script>
</body>
</html>