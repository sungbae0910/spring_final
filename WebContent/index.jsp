<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main_page</title>

<link rel="stylesheet" href="./lib/css/bootstrap.min.css">
<link rel="stylesheet" href="./lib/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="./lib/css/main_page.css">
<script src="./lib/js/jquery-3.4.1.js"></script>
</head>
<body>
	
	<div class="container-fluid">
		<!-- 헤더 -->
		
		<!-- 로고, 검색창 -->
		<div align="center" id='header_top'>
			<img id="logo" src="./lib/images/logo.png">
		
			<span>
				<input type="text" id='searchBar'/>
			</span>
		</div>
		
		<hr>
		<div class="container" id="header_bot">
			<div class="row">
				<div class="col-sm-2">
					<p>뉴스</p>
				</div>
				<div class="col-sm-2">
					<p>블로그</p>
				</div>
				<div class="col-sm-2">
					<p>쇼핑</p>
				</div>
				<div class="col-sm-2">
					<p>sns</p>
				</div>
				<div class="col-sm-2">
					<p>음악</p>
				</div>
				<div class="col-sm-2">
					<p>웹툰</p>
				</div>
			</div>
		</div>
		<hr id='hr'>
		
		<!-- 메인 -->
		<div class="container">
			<img src="./lib/images/ex.png" style="width:1000px; height: 500px;">
		</div>
	</div>




<script src="./lib/js/bootstrap.min.js"></script>
</body>
</html>