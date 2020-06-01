<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="c_blog_frm" name="c_blog_frm" method="post">
	<input type="hidden" id="c_mId" name="c_mId">
	<input type="hidden" id="c_brdNo" name="c_brdNo">
</form>
<form id="s_news_frm" method="post">
	<input type="hidden" class="s_nserial" name="s_nserial">
</form>
<%
	String mId = "";
	if(session.getAttribute("mId") != null){
 		mId = (String)session.getAttribute("mId");	
	}
%>
<div class="container" id="mainContent">
    <div class="row">
    
	    <div class="col-sm-12 col-md-4" id="main_s">
	    
			<div class="col-xs-12" id="loginDiv">
					<c:if test="${empty mId}">
						<span id="logintop">여태까지 아무도 뚫지못한 철통보안</span><br><br>
						<a href="${pageContext.request.contextPath}/login.jsp" style="color:black;"><button id="loginBtn">로그인</button></a>
					</c:if>
					<c:if test="${!empty mId}">
						
							
						<span><%=mId %>님</span> | <span>내 정보  </span> 
						<button id="logout">로그아웃</button>
						<br>
						<span id="email"></span><br>

						<div class="col-sm-3"><span>알림</span></div>	
						<div class="col-sm-3"><span>구독</span></div>	
						<div class="col-sm-3"><span>쇼핑</span></div>	
						<div class="col-sm-3"><span>블로그</span></div>	
					</c:if>
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
	        				<c:forEach begin="0" end="3" var="i" items="${newsInfo}" varStatus="ii">
	        				<input type="hidden" value="${i.nSerial}" class="serial${ii.index}"> 
	        				<div class="col-xs-4 col-md-3">
	                            <div class="single-bottom mb-35">
	                                <div class="trend-bottom-img mb-30">
	                                	<c:forEach begin="${ii.index}" end="${ii.index}" var="pho" items="${newsPhoto}">
	                                    	<img src="./news/img/newsImages/${pho.pName}" alt="" style="height:120px;">
                                    	</c:forEach>
	                                </div>
	                                <div class="trend-bottom-cap indexNews_s">
	                                    <span class="color1 indexNewsT">${i.nCompany}</span>
	                                    <h5><a href="#" onclick="news_detail(${ii.index})">${i.nTitle}</a></h5>
	                                </div>
	                            </div>
	        				</div>	
	        				</c:forEach> 	        					        				        				
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
	        					<img src="/blog/blog_image/${bList.brdHeader}" class="img-rounded">
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