<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main_page</title>

<link rel="stylesheet" href="./sb_music/sb_lib/css/bootstrap.min.css">
<link rel="stylesheet" href="./sb_music/sb_lib/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="./main_lib/css/main_page.css">
<script src="./sb_music/sb_lib/js/jquery-3.4.1.js"></script>
</head>
<body>
	
	<div class="container-fluid">
		<!-- 헤더 -->
		
		<!-- 로고, 검색창 -->
		<div align="center" id='header_top'>
			<img id="logo" src="./main_lib/images/root.png">
		
			<span>
				<input type="text" id='searchBar'/>
			</span>
		</div>
		
		<hr>
		<div class="container" id="header_bot">
			<div class="row">
				<div class="col-sm-1">
					<a href="./news/newsMainT.jsp" style="color:black;">뉴스</a>
				</div>
				<div class="col-sm-1">
					<a href="./blog/blog_Index.jsp" style="color:black;">블로그</a>
				</div>
				<div class="col-sm-1">
					<a href="./shop/shop_index.jsp" style="color:black;">쇼핑</a>
				</div>
				<div class="col-sm-1">
					<p>SNS</p>
				</div>
				<div class="col-sm-1">
					<a href="./sb_music/sb_main.jsp" style="color:black;">음악</a>
				</div>
				<div class="col-sm-1">
					<p>더보기</p>
				</div>
			</div>
		</div>
		<hr id='hr'>
		
		<!-- 메인 -->
		<div class="container">
			<div class="col-sm-8" style="border:2px solid black;">
				조필연씨 배너
			</div>
			<div class="col-sm-3" id="loginDiv">
				<div align="center">
					<span id="logintop">여태까지 아무도 뚫지못한 철통보안</span><br><br>
					<button id="loginBtn">로그인</button>			
				</div>
			</div>
			
			<div class="col-sm-12">
				
			</div>
			
		</div>
	</div>




<script src="./lib/js/bootstrap.min.js"></script>
</body>
</html>