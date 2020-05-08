<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../lib/css/jquery-ui.css">
<link rel="stylesheet" href="../lib/css/bootstrap.min.css">
<link rel="stylesheet" href="../lib/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../lib/css/sb_main.css">
<script src="../lib/js/jquery-3.4.1.js"></script>
<script src="../lib/js/jquery-ui.js"></script>
</head>
<body>
 <%
 	String p = "./sb_home.jsp";
 	if(request.getParameter("p") != null){
 		p = request.getParameter("p");
 	}
 %>
 
 
 <div class="container-fluid">
 
  <nav class="col-sm-3 sidenav">
  
  	<img src="../lib/images/logo.png" id="logo" onclick="location.href='sb_main.jsp?p=./sb_home.jsp'"> <!-- 로고 -->
  	
  	<br><br><br><br>
   	<ul class="nav nav-pills nav-stacked">
	    <li><a href="sb_main.jsp?p=./sb_myPage.jsp" id="sideA">닉네임</a></li>
	    <li><a href="sb_main.jsp?p=./sb_top.jsp" id="sideA">TOP 100</a></li>
	    <li><a href="sb_main.jsp?p=./sb_new.jsp" id="sideA">최신 앨범</a></li>
    </ul>
    	<hr style="background-color: #969B97;">
    	
    <img src="../lib/images/service.png">
   	<ul class="nav nav-pills nav-stacked">
   		<li><a href="sb_main.jsp?p=./sb_service.jsp" id="sideA">서비스 소개</a></li>
	    <li><a href="sb_main.jsp?p=./sb_membership.jsp" id="sideA">멤버쉽 가입</a></li>
	    
    </ul>	
    
  </nav>
  	  
  
	  <div class="col-sm-9 page">
	  
	  		<jsp:include page="<%=p %>"/>
	  	
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
				    
	       
				  
				  <div class="col-sm-1">
			   		 <br>
			  		 <div class="input-group">
			  		 	 <span class="input-group-addon" id="speaker">
			  		 		 <img id="sound" src="../lib/images/vol1.png" width="18px">
			  		 	 </span>
				  		 <input type="range" id='volume-bar' min="0" max='100'  value="100" oninput="showVolume(this.value)">
					   	 <span><font size=2 id="now-vol" style="color: white; text-shadow: 0 0 1px black">100</font></span>
				   	 </div>
				   	
				  </div>
				  
				  <div class="col-sm-1">
				  	<img src="../lib/images/list.png" id="m_list" width="90px" onclick="nav_list()">
				  </div>
				  
		<br><br><br><br><br><br>
			<!-- 숨겨진 목록 -->
		<div class="container-fluid">
			<div class="col-sm-6">
				<div align="center" id="playerImg">
					<img src="../lib/images/player.png" width="500px;" >
					<img src="../lib/album/meteor.jpg" id="player-top">
				</div>
			</div>
		
			<div id="show_list" class="col-sm-6">
				<div align="center" id="nav_scroll">
					<table id = "music_tb">
						<caption id="cap">플레이 리스트</caption>
						<colgroup>
							<col width="10%">
							<col width="20%">
							<col width="60%">
							<col width="10%">
						</colgroup>
						<thead>
						<tr>
							<th scope="col">NO</th>
							<th scope="col">앨범</th>
							<th scope="col">음악 정보</th>
							<th scope="col">음악 삭제</th>
						</tr>
						</thead>
						<c:forEach var="v" begin="1" end="20">
								<tr>
									<td>
										<span>${v }</span>
									</td>
									<td>
										<img src="../lib/album/방탄-on.PNG" width="55px">
									</td>
									<td>
										<span>곡 이름 ${v }</span>
										<br>
										<span>가수명 ${v } ♬플레이타임</span></td>
									<td>
										<span id="tb_delete">X</span>
									</td>
								</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			
		</div>
 </nav>
 
<script src="../lib/js/sb_main.js"></script>
<script src="../lib/js/bootstrap.min.js"></script>
</body>
</html>