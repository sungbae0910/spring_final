<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main_page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- <link rel="stylesheet" href="./sb_music/sb_lib/css/bootstrap.min.css"> -->
<link rel="stylesheet" href="./sb_music/sb_lib/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="./main_lib/css/main_page.css">
<script src="./main_lib/js/main_page.js"></script>
<script src="./main_lib/js/jquery-3.4.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-timeago/1.6.5/jquery.timeago.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-timeago/1.6.5/locales/jquery.timeago.ko.js"></script>
</head>
<body>

<%
	String mId = "";
	if(session.getAttribute("mId") != null){
 		mId = (String)session.getAttribute("mId");	
	}
	
<div class="container">
	<!-- 헤더 -->
	
	<!-- 로고, 검색창 -->
	<div class="row">
		<div id='header_top'>
			 <div class="col-xs-4 col-sm-3 col-md-2">
				<img id="logo" src="./main_lib/images/root.png">        
			 </div>
			 <div class="col-xs-8 col-sm-9 col-md-10">
				<span>
				
					<input type="text" id='searchBar'/>
				</span>
			</div>
    	</div>
	</div>
</div>
	<hr>
	<div class="container-fluid" id="header_bot">
		<div class="row" align="center" >
			<div class="col-xs-2">
				<a href="./news/newsMainT.jsp" style="color:black;">뉴스</a>
			</div>
			<div class="col-xs-2">
				<a href="./blog/blog_Index.jsp" style="color:black;">블로그</a>
			<div class="col-sm-3" id="loginDiv">
			
					<c:if test="${empty mId}">
						<span id="logintop">여태까지 아무도 뚫지못한 철통보안</span><br><br>
						<a href="${pageContext.request.contextPath}/sb_music/login.jsp" style="color:black;"><button id="loginBtn">로그인</button></a>
					</c:if>
					<c:if test="${!empty mId}">
						
							
						<span><%=mId %>님</span> | <span>내 정보  </span> 
						<button id="logout">로그아웃</button>
						<br>
						<span id="email"></span><br>

						<div class="col-sm-2"><span>알림</span></div>	
						<div class="col-sm-2"><span>구독</span></div>	
						<div class="col-sm-2"><span>쇼핑</span></div>	
						<div class="col-sm-2"><span>블로그</span></div>	
						<div class="col-sm-2"><span>음악</span></div>	
					</c:if>
					
					
			
			</div>
			<div class="col-xs-2">
				<a href="./shop/shop_index.jsp" style="color:black;">쇼핑</a>
			</div>
			<div class="col-xs-2">
				<p>SNS</p>
			</div>
			<div class="col-xs-2">
				<a href="./sb_music/sb_main.jsp" style="color:black;">음악</a>
			</div>
			<div class="col-xs-2">
				<p>더보기</p>
			</div>
		</div>
	</div>
	<hr id='hr'>

<!-- 메인 -->
<div id="main">
</div>
	
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<!-- <script src="./lib/js/bootstrap.min.js"></script> -->
<script>main.view();</script>
</body>
</html>