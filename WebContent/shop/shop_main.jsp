<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="shop_main">
	<form name="shop_frm" id="shop_frm" method="post">
		<div class="container-fluid">
		    <div class="row">
		        <div class="col-xs-12 shop_main_form">
		        	<div class="col-xs-10 col-xs-offset-1 shop_main_item1" >
					   <div>
					    	<div class="row">
								<div class="col-sm-6 col-md-4">
									<div class="page-header">	    
								  		<h2>귀걸이<small><button type="button" class="btn btn-default btn_more">더보기</button></small></h2>
									</div>
									<div id="item_thumbnail">
				        				<c:forEach var="i" items="${list}" begin="0" end="4">
				        					<c:if test="${i.category_name eq '귀걸이'}">
													<div class="thumbnail" id="first_item">
														<img src="./image/1.jpg" alt="...">
														<div class="caption" id="item_information">
															<h3>${i.item_name}</h3>
														     <p>${i.item_price}</p>
														     <p><a href="#" class="btn btn-default btn_detail" role="button">상세보기</a></p>
														</div>
													</div>
								        	</c:if>
								        </c:forEach>										  
									</div>
								</div>
							</div>
					    </div>
		        	</div>
	 		        <div class="col-xs-10 col-xs-offset-1 shop_main_item2" >
					        <div>
					        	<div class="row">
									<div class="col-sm-6 col-md-4" id="photo">
										<div class="page-header">
								  			<h2>목걸이<small><button type="button" class="btn btn-default btn_more" type="submit">더보기</button></small></h2>
										</div>
										<div id="item_thumbnail">
								       		<c:forEach var="i" items="${list}" begin="10" end="14" >
												<c:if test="${i.category_name eq '목걸이'}">
													<div class="thumbnail" id="first_item">
														<img src="./image/1.jpg" alt="...">
														<div class="caption" id="item_information">
															<h3>${i.item_name}</h3>
														    <p>${i.item_price}</p>
														    <p><a href="#" class="btn btn-default btn_detail" role="button">상세보기</a></p>
														</div>
													</div>
										    	</c:if>
											</c:forEach>
										</div>
									</div>
								</div>
					        </div>
		        		</div>
					     <div class="col-xs-10 col-xs-offset-1 shop_main_item3" >
							<div>
								<div class="row">
									<div class="col-sm-6 col-md-4" id="photo">
										<div class="page-header">
											<h2>반지<small><button type="button" class="btn btn-default btn_more" type="submit">더보기</button></small></h2>
										</div>
										<div id="item_thumbnail">
											<c:forEach var="i" items="${list}" begin="20" end="24">
												<c:if test="${i.category_name eq '반지'}">
													<div class="thumbnail" id="first_item">
														<img src="./image/1.jpg" alt="...">
														<div class="caption" id="item_information">
															<h3>아이템 3</h3>
															<p>아이템 정보</p>
															<p><a href="#" class="btn btn-default btn_detail" role="button">상세보기</a></p>
														</div>
													</div>
												</c:if>
											</c:forEach>
										</div>
									</div>
								</div>
							</div>
					  	</div>
					        <div class="col-xs-10 col-xs-offset-1 shop_main_item4" >
								<div>
							        <div class="row">
										<div class="col-sm-6 col-md-4" id="photo">
											<div class="page-header">
										  		<h2>팔찌<small><button type="button" class="btn btn-default btn_more" type="submit">더보기</button></small></h2>
											</div>
											<div id="item_thumbnail">
								        		<c:forEach var="i" items="${list}" begin="30" end="34">
										        	<c:if test="${i.category_name eq '팔찌'}">
														<div class="thumbnail" id="first_item">
															<img src="./image/1.jpg" alt="...">
															<div class="caption" id="item_information">
																<h3>아이템 4</h3>
															    <p>아이템 정보</p>
															    <p><a href="#" class="btn btn-default btn_detail" role="button">상세보기</a></p>
															</div>
														</div>
											   		</c:if>
											</c:forEach>
									</div>
								</div>
							</div>
						</div>
					</div> 
		        </div>
		    </div>
		</div>
	</form>
	<script>shop.func()</script>
</div>
