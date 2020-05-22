<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- <form id="c_frmMain" name="c_frmMain" method="post" action="../blogMain.bg">
	<input type="hidden" name="test" value="test"/>
</form> -->
<!-- 슬라이드 사진 -->
<div id="c_mainBlog">
	<div class="container-fluid" id="c_mainHeader">
	    <div class="row">
	        <div class="col-xs-12">
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
				  <div class="carousel-inner">
				    <div class="item active">
				      <img src="./blog_image/blog_mainHeader.PNG">
				    </div>
				    <div class="item">
				      <img src="./blog_image/life.jpg">
				    </div>
				    <div class="item">
				      <img src="./blog_image/night.jpg">
				    </div>
				  </div>
				  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
				    <span class="glyphicon glyphicon-chevron-left"></span>
				  </a>
				  <a class="right carousel-control" href="#myCarousel" data-slide="next">
				    <span class="glyphicon glyphicon-chevron-right"></span>
				  </a>
				</div>
	        </div>
	    </div>
	</div>
	<!-- 주제 메뉴 -->
	<div class="container">
	    <div class="row">
	        <div class="col-md-6" id="c_subject">
	        	<span class="c_subject" onclick="blog.mainTag('life')"><span>라이프</span></span>
	        	<span class="c_subject" onclick="blog.mainTag('travel')"><span>여행.맛집</span></span>
	        	<span class="c_subject"onclick="blog.mainTag('it')"><span>IT</span></span>
	        </div>
	    </div>
	</div>
</div>
<%-- <% 
String inc2 = "../blogMain.bg";
	if (request.getParameter("inc2") != null) {
		inc2 = request.getParameter("inc2");
	}
%> --%>
<div id="c_blogContent">
	<%-- <jsp:include page="&inc2=<%=inc2 %>"/> --%>
</div> 
<script>blog.mainContent();</script>