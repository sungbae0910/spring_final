<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="shop_myPage">
	<form name="shop_frm" id="shop_frm" method="post">
		<div class="container-fluid">
		    <div class="row">
		    	<div class="col-xs-12">
			        <div class="col-md-3 a">
			        	<div class="row">
						  <div class="col-sm-6 col-md-4">
						    <div class="thumbnail">
						      <img src="./image/1.jpg" alt="...">
						      <div class="caption">
						        <h3>회원 아이디</h3>
						        <p><a href="#" class="btn btn-default btn_modify" role="button">회원 정보 수정</a></p>
						      </div>
						    </div>
						  </div>
						</div>
			        </div>
			        <div class="col-md-9 b">
			        	<div id="c">
			        		<div class="page-header">
						  		<h2 id="delivery_header">배송조회<small><button class="btn btn-default btn_delivery_more" type="submit">더보기</button></small></h2>
							</div>
			        		<div class="delivery_title">
					    		<span id="item_name_title">상품 명</span>
					    		<span id="item_price_title">상품 가격</span>
					    		<span id="item_status_title">배송 상태</span>
					    	</div>
			    			<div id="delivery">
			    				<img src="./image/1.jpg" alt="..." class="img-circle item_photo">
			    				<div class="delivery_information">
				    				<span id="item_name">가나다</span>
				    				<span id="item_price">10000원</span>
				    				<span id="item_status">배송중</span>
								</div>
			    			</div>
			        	</div>
			        	<div id="d">
			        		<div class="page-header">
						  		<h2 id="wishList_header">찜한 목록<small><button class="btn btn-default btn_wishList_more" type="submit">더보기</button></small></h2>
							</div>
			        		<div class="wishList_title">
					    		<span id="item_name_title">상품 명</span>
					    		<span id="item_price_title">상품 가격</span>
					    		<span id="item_remove_title">배송 상태</span>
					    	</div>
			    			<div id="wishList">
			    				<img src="./image/1.jpg" alt="..." class="img-circle item_photo">
			    				<div class="wishList_information">
				    				<span id="item_name">가나다</span>
				    				<span id="item_price">10000원</span>
				    				<button type="button" class="btn btn-default btn-lg btn_remove">
									  <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
									</button>
								</div>
			    			</div>
			        	</div>
			        </div>
				</div>
		    </div>
		</div>
	</form>	
</div>