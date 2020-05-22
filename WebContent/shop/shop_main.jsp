<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="shop_main">
	<div class="container-fluid">
	    <div class="row">
	        <div class="col-xs-12 shop_main_form">
	        	<div class="col-xs-10 col-xs-offset-1 shop_main_item1" >
	        		<div>
	        			<div class="row">
							<div class="col-sm-6 col-md-4">
						  		<div class="page-header">
				  					<h2>귀걸이<small><button type="button" class="btn btn-default btn_more" type="submit">더보기</button></small></h2>
								</div>
						    	<div id="item_thumbnail">
						    		<c:forEach var="i" items="${earringList}">
									    <div class="thumbnail" id="first_item">
									      	<img src="./image/${i.item_main_photo}" alt="...">  	
									      	<div class="caption" id="item_information">
									        	<h3>${i.item_name}</h3>
									        	<p>${i.item_price}</p>
									        	<p><a href="#" class="btn btn-default btn_detail" role="button">상세보기</a></p>
									      	</div>
									    </div>
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
									<c:forEach var="i" items="${necklaceList}" begin="0" end="4">
									    <div class="thumbnail" id="first_item">
									      	<img src="./image/1.jpg" alt="...">
									      	<div class="caption" id="item_information">
									        	<h3>${i.item_name}</h3>
									        	<p>${i.item_price}</p>
									        	<p><a href="#" class="btn btn-default btn_detail" role="button">상세보기</a></p>
									      	</div>
									    </div>
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
						  	  		<c:forEach var="i" items="${ringList}" begin="0" end="4">
										<div class="thumbnail" id="first_item">
										    <img src="./image/1.jpg" alt="...">
										    <div class="caption" id="item_information">
										        <h3>${i.item_name}</h3>
										        <p>${i.item_price}</p>
										        <p><a href="#" class="btn btn-default btn_detail" role="button">상세보기</a></p>
										    </div>
										</div>
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
						  			<c:forEach var="i" items="${braceletList}" begin="0" end="4">
									    <div class="thumbnail" id="first_item">
									      	<img src="./image/1.jpg" alt="...">
									      	<div class="caption" id="item_information">
									        	<h3>${i.item_name}</h3>
									        	<p>${i.item_price}</p>
									        	<p><a href="#" class="btn btn-default btn_detail" role="button">상세보기</a></p>
									      	</div>
									    </div>
									</c:forEach>
							  	</div>
						   	</div>
						</div>
	        		</div>
	        	</div>
	        </div>
	    </div>
	</div>
</div>