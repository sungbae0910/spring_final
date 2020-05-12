<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 슬라이드 사진 -->
<div id="c_mainBlog">
	<div class="container-fluid" id="c_mainHeader">
	    <div class="row">
	        <div class="col-xs-12">
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
				  <div class="carousel-inner">
				    <div class="item active">
				      <img src="../blog_image/blog_mainHeader.PNG">
				    </div>
				
				    <div class="item">
				      <img src="../blog_image/life.jpg">
				    </div>
				
				    <div class="item">
				      <img src="../blog_image/night.jpg">
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
		        	<a href="" id="c_btnLife" class="c_subject"><span>라이프</span></a>
		        	<a href="" id="c_btntravel" class="c_subject"><span>여행.맛집</span></a>
		        	<a href="" id="c_btnIt" class="c_subject"><span>IT</span></a>
	        </div>
	    </div>
	</div>
	<!-- 주제별 베스트 글 -->
	<div id="c_bestContent">
		<div class="container">
		    <div class="row">
		    	<div class="col-sm-4">
		 			<div class="thumbnail" id="c_content1">
		     			<a href="">
		     			   <img src="../blog_image/food.jpg" alt="">
								<div class="caption" id="c_con1">
		          					<div class="c_bestSubject">너무너무너무너무너무너무너무너무 맛있는 제주도 페페로니 피자!</div>
		          					<p/>
		          					<div>
		          						<span>개인블로그 title</span><br/>
		          						<span class="c_bestMid">by 유저 아이디</span>
		          					</div>
		        				</div>
		    			</a>
		    		</div>
		    	</div>
		    	<div class="col-sm-4">
		    		 <div class="thumbnail" id="c_content2">
		     			<a href="">
		     			   <img src="../blog_image/life.jpg" alt="">
								<div class="caption">
		          					<div class="c_bestSubject">너무너무너무너무너무너무너무너무 맛있는 제주도 페페로니 피자!</div>
		        					<p/>
		          					<div>
		          						<span>개인블로그 title</span><br/>
		          						<span class="c_bestMid">by 유저 아이디</span>
		          					</div>
		        				</div>
		    			</a>
		    		</div>
		    	</div>
		    	<div class="col-sm-4">
		    		 <div class="thumbnail" id="c_content3">
		     			<a href="">
		     			   <img src="../blog_image/night.jpg" alt="">
								<div class="caption">
		          					<div class="c_bestSubject">너무너무너무너무너무너무너무너무 맛있는 제주도 페페로니 피자!</div>
		        					<p/>
		          					<div>
		          						<span>개인블로그 title</span><br/>
		          						<span class="c_bestMid">by 유저 아이디</span>
		          					</div>
		        				</div>
		    			</a>
		    		</div>
	 			 </div>
		    </div>
		</div>
	</div>
	<!-- 블로그 글 리스트 -->
   <div id="c_blogList">
		<div class="container">
	    	<div class="row">
	        	<div class="col-sm-12">
	        		<div class="c_blogList">
		        		<a href="">
		        			<span class="c_listBrdImg">
		        				<img src="../blog_image/boy.jpg" class="img-rounded" alt="">
		        			</span>
		        			<div class="c_listCont">
		        				<div class="c_listData">
		        					<span class="c_listCate">카테고리</span>
		        					<br><br>
		        					<span>게시된 시간</span><br>
		        					<span>공감 <span class="badge">5</span></span><br>
		        				</div>
		        				<div class="c_listSubject">블로그 글 제목!</div>
		        				<div class="c_listInnerCont">
		        					블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용
		        					블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용
									블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용블로그 글 내용	        				
		        				</div>
		        			</div>
		        			<div class="c_listInfo">
		        				<span class="c_listUserImg">
		        					<img src="../blog_image/cat.jpg" class="img-circle" alt="">
		        				</span>
		        				<span>개인블로그 title</span>
		        				<span class="c_listMid">by 유저 아이디</span>
		        			</div>
		        		</a>
	        		</div>
	        	</div>
	        	<hr/>
    		</div>
    	</div>
	</div>
</div>
