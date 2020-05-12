<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<div id="c_dimmedSidebar"></div>
<aside id="c_sidebar">
	<div id="c_innerSidebar">
		<button type="button" class="btn btn-default btn-lg x" id="c_sidebar_close">
  			<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
		</button>
		<button type="button" class="btn btn-default btn-lg home">
  			<span class="glyphicon glyphicon-home" aria-hidden="true"></span> 지현이의 블로그
		</button>
		<div id="c_myblog_Cate">
			<div class="c_CateItem">카테고리1 <span>(3)</span></div>
			<div class="c_CateItem">카테고리2 <span>(10)</span></div>
			<div class="c_CateItem">카테고리3 <span>(1)</span></div>
		</div>
		<hr/>
		<div id="c_myblog_manageTool">
			<button type="button">글쓰기</button>
			<button type="button">블로그 관리</button>
		</div>
	</div>
</aside>
<div id="c_myBlog_header">
	<div class="container-fluid">
	    <div class="row">
	        <div class="col-xs-12">
	        	<img id="c_myBlog_headerImg" src="./blog_image/night.jpg">
	        	<img id="c_sidebar_open" src="./blog_image/menu2.png">
	        	<div id="c_myblogTitle">지현이의 블로그</div>
	        	<div id="c_brdItem">
		        	<div id="c_brd_Subject">글 제목!</div>
		        	<div id="c_brd_Date">2020.05.06</div>
	        	</div>
	        </div>
	    </div>
	</div>
</div>
<div id="c_brd">
	<div class="container">
	    <div class="row">
	    	<div class="col-md-2"></div>
	        <div class="col-md-8">
		        <div id="c_brd_Cont">
	        		블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용
	        		블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용
					블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용
					블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용	        				
	        	</div>
	        	<div id="c_brd_btn_group">
  					<span id="c_brd_like" class="glyphicon glyphicon-heart-empty" aria-hidden="true">공감</span>
  					<div class="dropdown" id="c_brd_manage">
      					<span class="dropdown-toggle" data-toggle="dropdown">
  							<span class="glyphicon glyphicon-option-horizontal" aria-hidden="true"></span>
      					</span>
	        			<ul class="dropdown-menu">
	        			  <li><a href="#" id="c_brd_modify">수정</a></li>
			      		  <li><a href="#" id="c_brd_modify">삭제</a></li>
			      		  <li><a href="#" id="c_brd_public"> 공개로 전환</a></li>
	        			</ul>
      				</div>
	        	</div>
		        <div id="c_cmt">
		        	<span id="c_cmt_title">댓글 10</span>
		        	<hr/>
			        <div class="c_cmt">
		        		<img src="./blog_image/cat.jpg" class="img-circle" alt="">
		        		<div class="dropdown" id="c_cmt_manage">
	      					<span class="dropdown-toggle" data-toggle="dropdown">
	  							<span class="glyphicon glyphicon-option-vertical" aria-hidden="true"></span>
	      					</span>
		        			<ul class="dropdown-menu">
		        			  <li><a href="#" id="c_cmt_modify">수정</a></li>
				      		  <li><a href="#" id="c_cmt_modify">삭제</a></li>
		        			</ul>
      					</div>
		        		<div class="c_cmtMid">댓글 단 사람</div>
		        		<div class="c_cmtDate">2020.05.07 23:53</div>
		        		<div class="c_cmtBlame">신고</div>
		        		<div class="c_cmtContent">안녕하세요 나는 댓글이에요</div>
		        		<div class='c_btnRepl'>답글</div>
		        	</div>
		        	<div class="c_repl">
		        		<img src="./blog_image/landscape.jpg" class="img-circle" alt="">
		        		<div class="dropdown" id="c_cmt_manage">
	      					<span class="dropdown-toggle" data-toggle="dropdown">
	  							<span class="glyphicon glyphicon-option-vertical" aria-hidden="true"></span>
	      					</span>
		        			<ul class="dropdown-menu">
		        			  <li><a href="#" id="c_repl_modify">수정</a></li>
				      		  <li><a href="#" id="c_repl_modify">삭제</a></li>
		        			</ul>
      					</div>
		        		<div class="c_cmtMid">답글 단 사람</div>
		        		<div class="c_cmtDate">2020.05.07 23:53</div>
		        		<div class="c_cmtBlame">신고</div>
		        		<div class="c_cmtContent">안녕하세요 나는 답글!!안녕하세요 나는 답글!!안녕하세요 나는 답글!!안녕하세요 나는 답글!!안녕하세요 나는 답글!!안녕하세요 나는 답글!!안녕하세요 나는 답글!!안녕하세요 나는 답글!!</div>
		        	</div>
		        	<textarea placeholder="댓글을 입력해주세요."></textarea>
		        	<label><input type="checkbox" name="c_cmtSecret"/> 비밀글</label>
		        	<input type="button" id="c_cmtInsert" value="등록"/>
		        </div>
	        </div>
	        <div class="col-md-2"></div>
	    </div>
	</div>
</div>

<script>blog.myblog_func();</script>