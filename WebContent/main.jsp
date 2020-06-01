<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="c_blog_frm" name="c_blog_frm" method="post">
	<input type="hidden" id="c_mId" name="c_mId">
	<input type="hidden" id="c_brdNo" name="c_brdNo">
</form>
<div class="container" id="mainContent">
    <div class="row">
    
	    <div class="col-sm-12 col-md-4" id="main_s">
			<div class="col-xs-12" id="loginDiv">
				<div align="center">
					레반에 로그인하세요<br/>
					<a href="${pageContext.request.contextPath}/login.jsp" style="color:black;"><button type="button">ROOT 로그인</button></a>			
				</div>
			</div>
			
			<div class="col-xs-12" style="border: 2px solid black;">
				<div align="center" id="shop">
					쇼핑
				</div>
			</div>					
		</div>
		
        <div class="col-sm-12 col-md-8" id="main_c">
        
        	<div class="col-xs-12" id="promotion">
				 <a href="${pageContext.request.contextPath}/wpy/w_index.jsp"><img  src="${pageContext.request.contextPath}/wpy/w_images/foodB.jpg"></a> 
			</div>
			
			<div class="col-xs-12 " style="border: 2px solid black;">
				<div id="news" class="list">
	        		<div class="listItem">
	        			<div class="row">
	        				<div class="col-xs-4 col-md-3">
	        					<img class="img-rounded">
	        				</div>
	        				<div class="col-xs-8 col-md-9 con">
		        				<div class="subject"></div>
		        				<div class="content"></div>
	        				</div>
	        			</div>
	        		</div>
        		</div>
			</div>
			
			<div class="col-xs-12 blog">
				<div id="blog" class="list">
	        		<c:forEach  var="bList" items="${blogList}">
		        		<div class="listItem" onclick="main.brdView('${bList.mId}', ${bList.brdNo})">
		        			<div class="row">
	        				<div class="col-xs-4 col-md-3">
	        					<img src="${pageContext.request.contextPath}/blog/blog_image/${bList.brdHeader}" class="img-rounded">
	        				</div>
       						<div class="col-xs-8 col-md-9">
			        			<div class="subject">${bList.subject}</div>
			        			<div class="content">${bList.content}</div>
			        			<time class="date" datetime="${bList.brdDate}"></time>
       						</div>
       						</div>
		        		</div>
	        		</c:forEach>
        		</div>
			</div>
		</div>
	</div>
</div>
<script>
	//블로그 게시물 시간
	$(document).ready(function(){
		$("time.date").timeago();
	});
</script>