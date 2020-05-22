<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../sb_music/sb_lib/css/jquery-ui.css">
<link rel="stylesheet" href="../sb_music/sb_lib/css/bootstrap.min.css">
<link rel="stylesheet" href="../sb_music/sb_lib/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="../sb_music/sb_lib/css/sb_main.css">
<script src="../sb_music/sb_lib/js/jquery-3.4.1.js"></script>
<script src="../sb_music/sb_lib/js/jquery-ui.js"></script>

</head>
<body>
 <%
 	String p = "sb_home.mu";
 	if(request.getParameter("p") != null){
 		p = request.getParameter("p");
 	}
 %>
 
 
 <div class="container-fluid">
 
  <nav class="col-sm-3 sidenav">
  
  	<img src="../sb_music/sb_lib/images/logo.png" id="logo" onclick="home()"> <!-- 로고 -->
  	<img src="../sb_music/sb_lib/images/wtm.gif" width="70px">
  	
  	<br><br><br><br>
   	<ul class="nav nav-pills nav-stacked">
   		<li><a href="./sb_login.jsp" id="sideA">로그인</a></li>
	    <li><a href="sb_main.jsp?p=./sb_myPage.jsp" id="sideA">닉네임</a>
	    	<ul>
	    		<li>마이페이지</li>
	    		<li>로그아웃</li>
	    	</ul>
	    </li>
	    <li><a href="#" id="sideA" onclick="topP()">TOP 100</a></li>
	    <li><a href="sb_main.jsp?p=./sb_new.jsp" id="sideA">최신 앨범</a></li>
    </ul>
    	<hr style="background-color: #969B97;">
    	
    <img src="../sb_music/sb_lib/images/service.png">
   	<ul class="nav nav-pills nav-stacked">
   		<li><a href="sb_service.jsp" id="sideA">서비스 소개</a></li>
	    <li><a href="sb_membership.jsp" id="sideA">멤버쉽 가입</a></li>
	    
    </ul>	
    
  </nav>
  
  	  <form action="frm_top" id="frm_top" method="post">
				<input type="hidden" name="m_serial" id="m_serial">
				<input type="hidden" name="m_music" id="m_music">
				<input type="hidden" name="m_artist" id="m_artist">
				<input type="hidden" name="m_photo" id="m_photo">
				<input type="hidden" name="mId" id="mId" value="id">
				<input type="hidden" name="as" id="as" value="">
				<input type="hidden" name="listV" id="listV">
		</form>
  
	  <div class="col-sm-9 page">
	  	<div id="changePage">
	  		<jsp:include page="<%=p %>"/>
	  	</div>
	  	<br><br><br><br><br>
	  	
	  	<footer>
			<div class="container-fluid">
				<div class="row">
					<div class="col-sm-8">
						Logo WaterMelon Music Platform
					</div>
					<div class="col-sm-2" onclick="nice()">
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
 


<jsp:include page="./sb_nav.jsp"/>
<script src="../sb_music/sb_lib/js/sb_music.js"></script>
<script src="../sb_music/sb_lib/js/sb_main.js"></script>
<script src="../sb_music/sb_lib/js/bootstrap.min.js"></script>
</body>
</html>