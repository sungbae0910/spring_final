<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<div id="c_dimmedSidebar"></div>
<form id="c_blog_frm" name="c_blog_frm" method="post">
	<aside id="c_sidebar">
		<div id="c_innerSidebar">
			<button type="button" id="c_sidebar_close" class="btn btn-default btn-lg x">
	  			<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
			</button>
			<button type="button" class="btn btn-default btn-lg home" onclick="blog.myblog()">
	  			<span class="glyphicon glyphicon-home" aria-hidden="true"></span> 지현이의 블로그
			</button>
			<div id="c_myblog_Cate">
				<div class="c_CateItem" onclick="blog.category('카테고리1')">카테고리1 <span>(3)</span></div>
				<div class="c_CateItem" onclick="blog.category('카테고리2')">카테고리2 <span>(10)</span></div>
				<div class="c_CateItem" onclick="blog.category('카테고리3')">카테고리3 <span>(1)</span></div>
			</div>
			<hr/>
			<div id="c_myblog_manageTool">
				<button type="button" onclick="blog.brdInsert()">글쓰기</button>
				<button type="button" onclick="blog.manageMain()">블로그 관리</button>
			</div>
		</div>
	</aside>
	
	<div id="c_myBlog_header">
		<div class="container-fluid">
		    <div class="row">
		        <div class="col-xs-12">
		        	<img id="c_myBlog_headerImg" src="./blog_image/boy.jpg">
		        	<img id="c_sidebar_open" src="./blog_image/menu2.png">
		        	<div id="c_myblogTitle" onclick="blog.myblog()">지현이의 블로그</div>
		        </div>
		    </div>
		</div>
	</div>
	<div id="c_myBlog_content">
		<div class="container">
		    <div class="row">
		        <div class="col-xs-12">
		        	<c:choose>
		        		<c:when test="${cName == null || cName == ''}">
				        	<span id="c_myBlog_allBrd">전체 글 <span class="badge">10</span></span>
		        		</c:when>
		        		<c:when test="${cName != null || cName != ''}">
				        	<span id="c_myBlog_allBrd">${cName} <span class="badge">10</span></span>
		        		</c:when>
		        	</c:choose>
		        	<div id="c_myBlog_list">
		        		<div class="c_myBlog_brd_item" onclick="blog.brdView()">
		        			<img src="./blog_image/jeju.jpg" class="img-rounded" alt="">
		        			<div class="c_brd_Subject">글 제목!</div>
		        			<div class="c_brd_Cont">
		        					블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용
		        					블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용
									블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용
									블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용	        				
		        			</div>
		        			<div class="c_brd_Date">2020.05.06</div>
		        		</div>
		        		
		        		<div class="c_myBlog_brd_item" onclick="blog.brdView()">
		        			<img src="./blog_image/landscape.jpg" class="img-rounded" alt="">
		        			<div class="c_brd_Subject">언제 끝날까 퍼블리싱은~~~~~~~</div>
		        			<div class="c_brd_Cont">
		        					블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용
		        					블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용
									블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용
									블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용	        				
		        			</div>
		        			<div class="c_brd_Date">2020.05.06</div>
		        		</div>
		        		
		        		<div class="c_myBlog_brd_item" onclick="blog.brdView()">
		        			<img src="./blog_image/night.jpg" class="img-rounded" alt="">
		        			<div class="c_brd_Subject">나는 나는 나는 제목!</div>
		        			<div class="c_brd_Cont">
		        					블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용
		        					블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용
									블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용
									블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용	        				
		        			</div>
		        			<div class="c_brd_Date">12:21:03</div>
		        		</div>
		        	</div>
		        	<div id="c_blog_paging">
						<ul class="pager">
						    <li>
						      <a href="#" aria-label="Previous">
						        <span aria-hidden="true"> < </span>
						      </a>
						    </li>
						    <li><a href="#">1</a></li>
						    <li><a href="#">2</a></li>
						    <li><a href="#">3</a></li>
						    <li><a href="#">4</a></li>
						    <li><a href="#">5</a></li>
						    <li>
						      <a href="#" aria-label="Next">
						        <span aria-hidden="true"> > </span>
						      </a>
						    </li>
						</ul>
		        	</div>				
		        </div>
		    </div>
		</div>
	</div>
</form>
<script>blog.myblog_func();</script>
