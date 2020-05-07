<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse navbar-fixed-top" id="c_blogNavbar">
  <div class="container-fluid">
    <div class="navbar-header">
    	<a class="navbar-brand" href="#"><img src="">LOGO</a>
    </div>
    <ul class="nav navbar-nav navbar-right">
		<li><a href="#"><span class="glyphicon glyphicon-user"></span> 로그인 하기</a></li>
      	<li class="dropdown">
      		<span class="dropdown-toggle" data-toggle="dropdown">
      			<img src="../blog_image/cat.jpg" class="img-circle" alt="">
      		</span>
	        <ul class="dropdown-menu">
	          <li><a href="#" id="c_menuUserNname">사용자 닉네임</a></li>
      		  <li class="dropdown-header" id="c_menuUsermId">gus927@naver.com</li>
      		  <li class="dropdown-header" id="c_menuManage">계정 관리</li>
      		  <li class="divider"></li>
      		  <li class="dropdown-header">운영중인 블로그</li>
      		  <li><a href="#" id="c_menuMyBlog">내 블로그</a></li>
      		  <li class="divider"></li>
      		  <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> 로그아웃 하기</a></li>
	        </ul>
      	</li>
  	</ul>
  </div>
</nav>