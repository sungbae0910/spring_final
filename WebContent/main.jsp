<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<form id="c_blog_frm" name="c_blog_frm" method="post">
	<input type="hidden" id="c_mId" name="c_mId">
	<input type="hidden" id="c_brdNo" name="c_brdNo">
</form>
<form id="h_shop_frm" name="h_shop_frm" method="post">
	<input type="hidden" id="h_item_id" name="h_item_id">
	<input type="hidden" name="h_item_category" id="h_item_category"/>
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
			<div class="col-xs-12" id="main_shop_frm">
				<div id="shop">
					<h3>shop</h3>
					<div class="row" id="shop_earringList">
						<div class="page-header">
					  		<h4>귀걸이<small><button type="button" onclick="shop.category(0)" class="btn btn-default btn_more">더보기</button></small></h4>
						</div>
						<c:forEach var="i" items="${earringList}" begin="0" end="1">
							<div id="main_shop_earringList" onclick="main.shopView('${i.item_id}')">
								<div class="col-xs-6">
									<div>
										<img src="${pageContext.request.contextPath}/shop/image/${i.item_main_photo}" class="img-rounded" id="shop_earring_img">
									</div>
									<div id="shop_earring_information">
										<div class="earring_name">${i.item_name}</div>
										<div class="earring_price">${i.item_price}</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="row" id="shop_necklaceList">
						<div class="page-header">
					  		<h4>목걸이<small><button type="button" onclick="shop.category(1)" class="btn btn-default btn_more">더보기</button></small></h4>
						</div>
						<c:forEach var="i" items="${necklaceList}" begin="0" end="1">
							<div id="shop_necklaceList" onclick="main.shopView('${i.item_id}')">
								<div class="col-xs-6">
									<div>
										<img src="${pageContext.request.contextPath}/shop/image/${i.item_main_photo}" class="img-rounded" id="shop_necklace_img">
									</div>
									<div id="shop_necklace_information">
										<div class="necklace_name">${i.item_name}</div>
										<div class="necklace_price">${i.item_price}</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="row" id="shop_ringList">
						<div class="page-header">
					  		<h4>반지<small><button type="button" onclick="shop.category(2)" class="btn btn-default btn_more">더보기</button></small></h4>
						</div>
						<c:forEach var="i" items="${ringList}" begin="0" end="1">
							<div id="shop_ringList" onclick="main.shopView('${i.item_id}')">
								<div class="col-xs-6">
									<div>
										<img src="${pageContext.request.contextPath}/shop/image/${i.item_main_photo}" class="img-rounded" id="shop_ring_img">
									</div>
									<div id="shop_ring_information">
										<div class="ring_name">${i.item_name}</div>
										<div class="ring_price">${i.item_price}</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
					<div class="row" id="shop_braceletList">
						<div class="page-header">
					  		<h4>팔찌<small><button type="button" onclick="shop.category(3)" class="btn btn-default btn_more">더보기</button></small></h4>
						</div>
						<c:forEach var="i" items="${braceletList}" begin="0" end="1">
							<div id="shop_braceletList" onclick="main.shopView('${i.item_id}')">
								<div class="col-xs-6">
									<div>
										<img src="${pageContext.request.contextPath}/shop/image/${i.item_main_photo}" class="img-rounded" id="shop_bracelet_img">
									</div>
									<div id="shop_bracelet_information">
										<div class="bracelet_name">${i.item_name}</div>
										<div class="bracelet_price">${i.item_price}</div>
									</div>
								</div>
							</div>
						</c:forEach>
					</div>
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