<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../lib/css/bootstrap.min.css">
<link rel="stylesheet" href="../lib/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../lib/css/sb_main.css">
<script src="../lib/js/jquery-3.4.1.js"></script>
</head>
<body>
 <!-- <img src="../lib/images/music.png" height="100px" width="300px"> -->
 
 <div class="container-fluid">
 
  <nav class="col-sm-3 sidenav">
  
  	<img src="../lib/images/logo.png" id="logo"> <!-- 로고 -->
  	
  	<br><br><br><br>
   	<ul class="nav nav-pills nav-stacked">
	    <li><a href="#" id="sideA">닉네임</a></li>
	    <li><a href="#" id="sideA">TOP 100</a></li>
	    <li><a href="#" id="sideA">최신 앨범</a></li>
    </ul>
    	<hr style="background-color: #969B97;">
    	
    <img src="../lib/images/service.png">
   	<ul class="nav nav-pills nav-stacked">
   		<li><a href="#" id="sideA">서비스 소개</a></li>
	    <li><a href="#" id="sideA">멤버쉽 가입</a></li>
	    
    </ul>	
    
  </nav>
  	  
  	  
  
  
  
	  <div class="col-sm-9 page">
	  
	  		<jsp:include page="./sb_home.jsp"/>
	  	
	  	<br><br><br><br><br>
	  	
	  	
	  	
	  	
	  	
	  	<footer>
			<div class="container-fluid">
				<div class="row">
					<div class="col-sm-8">
						Logo WaterMelon Music Platform
					</div>
					<div class="col-sm-2">
						이용약관
					</div>
					<div class="col-sm-2">
						고객센터
					</div>
					<hr>
					<div class="col-sm-12">
						WaterMelon Musicⓒ
					</div>
					<div class="col-sm-12">
						워터멜론(주) 대표이사 장성빈
					</div>
					<div class="col-sm-3">
						사업자 등록번호 - 123-123-1234
					</div>
					<div class="col-sm-3">
						주소 - 서울특별시 부자동 리치구 flex
					</div>
					<div class="col-sm-3">
						대표전화 - 010-7728-7862
					</div>
					<div class="col-sm-3">
						이메일 - tommy631@naver.com
					</div>
				</div>
				
				
				
			</div>

		</footer>
	  </div>
  
  
  
  
  
 </div>
 
 
<!-- footer -->



	<!-- 뮤직 실행바 -->
 <nav class="navbar nav-default navbar-fixed-bottom" role="navigation" id="nav">
 		
 			<div class="wrapper">
 			<div class="audio-player__container">
				        <div class="audio-player__container__progress">
				          <input id="progress-bar" type="range" value="0" step="0.00011" class="slider">
				       </div>
			</div>
				   
				   
		   </div>
			
			<!-- 앨범 -->
 			<div class="col-sm-2">
				 <img src="../lib/album/meteor.jpg" id="album">
			</div>
			
			<!-- 이름 / 플레이 버튼 -->
				  <div class="col-sm-8">
				  	 <div align="center">
				       <br>	
				       <span style="color: white;">노래이름-가수</span>
				       <br>
				        <div class="audio-player__container__actions">
				         <button id="prevBtn"><img src="../lib/images/prevBtn.png" width="50px;"></button>
				          <button id="play-button"><img src="../lib/images/playBtn.png" width="50px;"></button>
				          <button id="nextBtn"><img src="../lib/images/nextBtn.png" width="50px;"></button>
				        </div>
				     </div>
			      </div>
				    
	       
				  
				  <div class="col-sm-2">
				   <button onclick="changeVolume(-0.2)">볼륨-</button>
				   <button onclick="changeVolume(+0.2)">볼륨+</button>
				  </div>
				  
		
 </nav>
 
<script src="../lib/js/sb_main.js"></script>
<script src="../lib/js/bootstrap.min.js"></script>
</body>
</html>