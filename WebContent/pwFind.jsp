<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<link rel="stylesheet" href="./sb_music/sb_lib/css/jquery-ui.css">
<link rel="stylesheet" href="./sb_music/sb_lib/css/bootstrap.min.css">
<link rel="stylesheet" href="./sb_music/sb_lib/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="./news/css/idPwFind.css">
<script src="./sb_music/sb_lib/js/jquery-3.4.1.js"></script>
<script src="./sb_music/sb_lib/js/jquery-ui.js"></script>
</head>
<body>
	<div class="container">
		<br><br><br><br>
		<div class="row">	
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<form id="pwdFind_s" method="post">
					<div class="pw_find_tt" style="text-align: center;">
						<span class="pw_find_top">비밀번호 찾기</span><br/>
					</div>
					<div class="pwFind">
						<span>이메일</span><br/>
						<input type="text" class="eMail" placeholder="가입시 입력한 이메일"/><br/>
						<div id="emailCk_s" ></div>
						<button type="button" class="btn btn-secondary eCk">인증하기</button><br/>
						<span>인증번호</span><br/>
						<input type="text"  placeholder="인증번호 입력"/><br/>
						<span>새 비밀번호</span><br/>
						<input type="text" class="pwd" placeholder="비밀번호"/><br/>
						<span>새 비밀번호 확인</span><br/>
						<input type="text" class="newPwd" placeholder="비밀번호 확인"/><br/>
					</div>
				</form>
			</div>
			<div class="col-sm-4"></div>
		</div>
	</div>




<script src="./news/js/idPwFind.js"></script>
</body>
</html>