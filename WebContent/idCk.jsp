<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
						<span>아이디</span><br/>
						<input type="text" class="mId" name="mId" placeholder="가입시 입력한 아이디"/><br/>
						<div id="idCk_s" ></div>
						<button type="button" class="btn btn-secondary eCk" onclick="idCk()" disabled>코드발급</button><br/>
					</div>
				</form>
			</div>
			<div class="col-sm-4"></div>
		</div>
	</div>




<script src="./news/js/idPwFind.js"></script>
</body>
</html>