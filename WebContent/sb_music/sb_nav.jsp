<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body id="navBody">

<!-- footer -->

	<!-- 뮤직 실행바 -->
 <nav class="navbar nav-default navbar-fixed-bottom" role="navigation" id="nav">
 			
 			<input type="hidden" id="audioH" value="${play.album_photo }">
 			
 			
 			<div class="wrapper">
 			<div class="audio-player__container">
				        <div class="audio-player__container__progress">
				          <input id="progress-bar" type="range" value="0" step="0.00011" class="slider">
				       </div>
			</div>
				   
				   
		   </div>
			<div id="music_play">
				<!-- 앨범 -->
	 			<div class="col-sm-2">
	 				 <img src="../sb_music/sb_lib/images/cd.png" id="albumD" >
	 				 <img src="../sb_music/sb_lib/album/${play.album_photo}.PNG" id="album" >
				</div>
				
				<!-- 이름 / 플레이 버튼 -->
					  <div class="col-sm-8">
					  	 <div align="center">
					       <br>	
					       		<span style="color: white;" id="playBarD">노래를 선택해주세요</span>
					       		<span style="color: white;" id="playBar">${play.music_name} - ${play.artist_name }</span>
					       <br>
					       		<span style="color: white;" id="timer"></span>
					       <br>
					        <div class="audio-player__container__actions">
					         <button id="prevBtn"><img src="../sb_music/sb_lib/images/prev.png" width="50px;"></button>
					          <button id="play-button" onclick="player()"><img src="../sb_music/sb_lib/images/play.png" id="btn_play" width="50px;"></button>
					          <button id="nextBtn"><img src="../sb_music/sb_lib/images/next.png" width="50px;"></button>
					        </div>
					     </div>
				      </div>
				    
	       </div>
				  
				  <div class="col-sm-1">
			   		 <br>
			  		 <div class="input-group">
			  		 	 <span class="input-group-addon" id="speaker">
			  		 		 <img id="sound" src="../sb_music/sb_lib/images/vol1.png" width="18px">
			  		 	 </span>
				  		 <input type="range" id='volume-bar' min="0" max='100'  value="100" oninput="showVolume(this.value)">
					   	 <span><font size=2 id="now-vol" style="color: white; text-shadow: 0 0 1px black">100</font></span>
				   	 </div>
				   	
				  </div>
				  
				  <div class="col-sm-1">
				  	<img src="../sb_music/sb_lib/images/list.png" id="m_list" width="90px" onclick="nav_list()">
				  </div>
				  
		<br><br><br><br><br><br>
			<!-- 숨겨진 목록 -->
		<div class="container-fluid">
			<div class="col-sm-6">
				<div align="center" id="playerImg">
					<img src="../sb_music/sb_lib/images/player.png" width="500px;" >
					<img src="../sb_music/sb_lib/album/${play.album_photo}.PNG" id="player-top">
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
										<img src="../sb_music/sb_lib/album/방탄-on.PNG" width="55px">
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




</body>
</html>