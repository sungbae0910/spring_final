<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main_page</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/sb_music/sb_lib/css/bootstrap.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/sb_music/sb_lib/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/main_lib/css/main_page.css">
<script src="${pageContext.request.contextPath}/sb_music/sb_lib/js/jquery-3.4.1.js"></script>
</head>
<body>

<%
	String mId = "";
	if(session.getAttribute("mId") != null){
 		mId = (String)session.getAttribute("mId");	
	}
	
	
%>

	<form id="index_frm" name="index_frm">
		<input type="hidden" id="mId" name="mId" value="<%=mId%>">
	</form>
	
	<div class="container-fluid">
		<!-- 헤더 -->
		
		<!-- 로고, 검색창 -->
		<div align="center" id='header_top'>
			<img id="logo" src="${pageContext.request.contextPath}/main_lib/images/root.png">
		
			<span>
				<input type="text" id='searchBar'/>
			</span>
		</div>
		
		<hr>
		<div class="container" id="header_bot">
			<div class="row">
				<div class="col-sm-1">
					<a href="${pageContext.request.contextPath}/news/newsMainT.jsp" style="color:black;">뉴스</a>
				</div>
				<div class="col-sm-1">
					<a href="${pageContext.request.contextPath}/blog/blog_Index.jsp" style="color:black;">블로그</a>
				</div>
				<div class="col-sm-1">
					<a href="${pageContext.request.contextPath}/shop/shop_index.jsp" style="color:black;">쇼핑</a>
				</div>
				<div class="col-sm-1">
					<a href="${pageContext.request.contextPath}/sb_music/sb_main.jsp" style="color:black;">음악</a>
				</div>
				<div class="col-sm-1">
					<p>더보기</p>
				</div>
			</div>
		</div>
		<hr id='hr'>
		
		<!-- 메인 -->
		<div class="container">
			<div class="col-sm-8"  >
				
			</div>
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
			
			<div class="col-sm-12">
				
			</div>
			
		</div>
	</div>

<script src="${pageContext.request.contextPath}/main_lib/js/index.js"></script>

</body>
</html>