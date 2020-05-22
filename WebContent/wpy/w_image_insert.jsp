<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>창업문의</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
<script src="js/jquery.min.js"></script>
<script src="./w_js/jquery.dropotron.min.js"></script>
<script src="./w_js/skel.min.js"></script>
<script src="./w_js/skel-layers.min.js"></script>
<script src="./w_js/init.js"></script>
<link rel="stylesheet" href="./w_css/skel.css" />
<link rel="stylesheet" href="./w_css/style.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
	</head>
	<body class="left-sidebar">

		<!-- Header -->
			<div id="header">
				<div class="container">
						
					<!-- Logo -->
						<img src="./w_images/w_mainimage1.png">
					
					<!-- Nav -->
						<nav id="nav">
							<ul>
								<li><a href="w_index.jsp">Home</a></li>
								<li>
									<a href="">브랜드 소개</a>
									<ul>
										<li><a href="w_main.jsp">전 메뉴</a></li>						
									</ul>
								</li>
								<li><a href="w_founded.jsp">창업문의</a></li>
								<li><a href="w_customersupport.jsp">고객문의</a></li>
								<li><a href="w_mymap.jsp">매장안내</a></li>
							</ul>
						</nav>


				</div>
			</div>

		<!-- Main -->
			<div id="main" class="wrapper style1">
				<div class="container">
						<!-- Content -->
						<div id="content" class="8u skel-cell-important">
						<form name='frm_food' id='frm_food' method='post' enctype='multipart/form-data'>
						    <label>가격</label>
						    <input type="text" name="w_price"><br/>
						    <label>음식이름</label>
						    <input type="text" name="w_foodName"><br/>
						    
							<span class="w_photo"><img id="w_photo1" src="./w_images/w_modeumjeon.jpg" alt width="340"></span>	
							<input type="file" id="w_btnPhoto" name="w_photo">
							<div id="w_button">
				             <input type="button" id="w_btnRegister" value="저장"/>
				             <input type="button" id="w_btnfind" value="취소"/>
				          </div>
				         </form>
						</div>
					</div>
				</div>

		<!-- Footer -->
			<div id="footer">
				<div class="container">
                
					<!-- Lists -->
						<div class="row">
							<div class="8u">
								
							</div>
							<div class="4u">
								
							</div>
						</div>

					<!-- Copyright -->
						<div class="copyright">
							  <span>주식회사 :꼬치예전</span>
						      <span>대표자 :원필연 </span>
						      <span>전화번호 :010-9413-5834</span>
						      <br/>		 
						      <span>이메일 :wkymonk@gmail.com</span>
						      <span>사업자 등록번호 :217-18-15486</span>
						      <span>서울 중랑구 면목로 454 1층(서울 중랑구 면목동 91-65)</span>	
						</div>

				</div>
			</div>
<script>w_btnFunc()</script>
	</body>
</html>