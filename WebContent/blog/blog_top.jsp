<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse navbar-fixed-top" id="c_blogNavbar">
	<div class="container-fluid">
		<div class="navbar-header">
    		<div id="c_logo" class="navbar-brand" onclick="blog.Main()"><img src="">LOGO</div>
  		</div>
    <form id="c_blog_frm" name="c_blog_frm" method="post">
   		<ul class="nav navbar-nav navbar-right">
			<li><a href="#"><span class="glyphicon glyphicon-user"></span> 로그인 하기</a></li>
	      		<li class="dropdown">
	      			<span class="dropdown-toggle" data-toggle="dropdown">
	      				<img src="./blog_image/cat.jpg" class="img-circle" alt="">
	      			</span>
			        <ul class="dropdown-menu">
			          <li><span id="c_menuUserNname">사용자 닉네임</span></li>
		      		  <li class="dropdown-header" id="c_menuUsermId">gus927@naver.com</li>
		      		  <li class="dropdown-header" id="c_menuManage">계정 관리</li>
		      		  <li class="divider"></li>
		      		  <li class="dropdown-header blog">운영중인 블로그</li>
		      		  <li onclick="blog.myblog()"><span id="c_btnMenuMyBlog">내 블로그</span></li>
		      		  <li onclick="blog.manageMain()"><span class="glyphicon glyphicon-cog" aria-hidden="true"></span></li>
		      		  <li class="divider"></li>
		      		  <li><span class="glyphicon glyphicon-log-in"></span> 로그아웃 하기</li>
			        </ul>
	      		</li>
  			</ul>
		</form>
	</div>
</nav>
<script>blog.myblog_func();</script>