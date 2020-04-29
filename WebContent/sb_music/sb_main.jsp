<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../lib/css/bootstrap.min.css">
<link rel="stylesheet" href="../lib/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../lib/css/sb_main.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/14.0.2/nouislider.css">
</head>
<body>
	<img src="../lib/images/music.png" height="100px" width="300px">



	<nav class="navbar nav-default navbar-fixed-bottom" role="navigation" id="nav">
		<div align="center">
			
			
			<div class="wrapper">
 				<div class="audio-player__container">
   					<div class="audio-player__container__progress"> 
     					<input id="progress-bar" type="range" value="0" step="0.00011" class="slider">
  					</div>
    				<div class="audio-player__container__actions"> 
     					<button id="play-button">▶</button>
   					</div>
				</div>
			</div>
			
			
			<!-- <button onclick="doPlay()" title="">Play</button>
			<button onclick="doPause()" title="">Pause</button>
			<button onclick="doStop()" title="">Stop</button>
			<button onclick="changeVolume(+0.2)">볼륨+</button>
			<button onclick="changeVolume(-0.2)">볼륨_</button> -->
			
		</div>
		
	</nav>
	

<script src="../lib/js/sb_main.js"></script>
<script src="../lib/js/jquery-3.4.1.js"></script>
<script src="../lib/js/bootstrap.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/noUiSlider/14.0.2/nouislider.js"></script>
</body>
</html>