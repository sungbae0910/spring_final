<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="shop_myPage">
	<form name="shop_frm" id="shop_frm" method="post">
		<div class="container-fluid">
		    <div class="row">
		    	<div class="col-xs-12">
			        <div class="col-md-3 member">
			        	<div class="row">
						  <div class="col-sm-6 col-md-4 member_frm">
						    <div class="thumbnail member_thumbnail">
						      <img src="./image/1.jpg" alt="...">
						      <div class="caption">
						        <h3 id="member_id_frm">회원 아이디</h3>
						        <p><a data-toggle="modal" data-target="#myModal" class="btn btn-default btn_modify" role="button">회원 정보 수정</a></p>
						      </div>
						    </div>
						  </div>
						</div>
						<!-- Modal -->
						<div id="myModal" class="modal fade" role="dialog">
						  <div class="modal-dialog">
						
						    <!-- Modal content-->
						    <div class="modal-content">
						      <div class="modal-header">
						        <button type="button" class="close" data-dismiss="modal">&times;</button>
						        <h4 class="modal-title">회원 정보 수정</h4>
						      </div>
						      <div class="modal-body">
						      	<div class="container-fluid">
		    						<div class="row">
							        	<div class="col-xs-12 a">
							        		<div class="row">	
							        			<div class="col-xs-8 modal_member_photo_frm">						        			
										       		<img src="./image/1.jpg" alt="..." class="img-circle modal_member_photo">
							        			</div>					
							        			<div class="col-xs-4 modal_member_photo_modify">
										        	<button class="btn btn-default btn_photo_modify" type="submit">프로필 사진 변경</button>
										        	<button class="btn btn-default btn_photo_remove" type="submit">프로필 사진 삭제</button>				        			
							        			</div>	        			
								       		</div>
								        </div>
							        </div>
							        <div class="row">
							        	<div class="col-xs-2 modal_member_information_title">
							        		<div id="member_id_frm">						        		
							        			<span id="member_id">아이디</span><br/>
							        		</div>
							        		<div id="member_name_frm">
							        			<span id="member_name">이름</span><br/>
							        		</div>
							        		<div id="member_phone_frm">
							        			<span id="member_phone">연락처</span>
							        		</div>
								        	<div id="member_address_frm">
								        		<span id="member_address">주소</span><br/>
								        	</div>
							        	</div>
							        	<div class="col-xs-10 modal_member_information_modify">
							        		<input class="form-control" id="member_id_text" type="text" placeholder="">
							        		<input class="form-control" id="member_name_text" type="text" placeholder="">
							        		<input class="form-control" id="member_phone_text" type="text" placeholder="">
								        	<input class="form-control" id="member_address_text" type="text" placeholder="">
							        	</div>
							        </div>
							 	</div>
						      </div>
						      <div class="modal-footer">
						      	<button data-toggle="modal" data-target="#myModal" type="button" class="btn btn-default btn_member_save">저장</button>
						      	<button data-toggle="modal" data-target="#myModal" type="button" class="btn btn-default btn_member_delete">탈퇴</button>
						        <button type="button" class="btn btn-default btn_member_back" data-dismiss="modal">취소</button>
						      </div>
						    </div>
						
						  </div>
						</div>
			        </div>
			        <div class="col-md-9 myPage_buy">
			        	<div class="row">
			        		<div class="col-xs-3 buy_list">
			        			<div class="page-header">
								  	<h2 id="delivery_header">배송 조회<small><button class="btn btn-default btn_buy_more" type="submit">더보기</button></small></h2>
								</div>
			        		</div>
			        	</div>
			        	<div class="col-xs-12 buy">
			        		<div class="row buy_list_title">
			        			 <div class="col-xs-4 col-xs-offset-2 buy_list_name_title">
			        			 	<span id="item_name_title">상품 명</span>
			        			 </div>
							     <div class="col-xs-4 buy_list_price_title">
							     	<span id="item_price_title">상품 가격</span>
							     </div>
							     <div class="col-xs-2 buy_list_status_title">
							     	<span id="item_status_title">배송 상태</span>
							     </div>
			        		</div>
			        		<div class="row buy_list_item">
			        			<div class="col-xs-2 buy_list_photo">
			        				<img src="./image/1.jpg" alt="..." class="img-circle buy_photo">
			        			</div>
			        			<div class="buy_information">
				        			<div class="col-xs-4 buy_list_name">
				        				<span id="buy_name">가나다</span>
				        			</div>
				        			<div class="col-xs-4 buy_list_price">
				        				<span id="buy_price">10000원</span>
				        			</div>
				        			<div class="col-xs-2 buy_list_status">
				        				<span id="buy_status">배송중</span>
				        			</div>
			        			</div>
			        		</div>
			        	</div>
			        </div>
			        <div class="col-md-9 myPage_like">
			        	<div class="row">
			        		<div class="col-xs-3 like_list">
			        			<div class="page-header">
							  		<h2 id="like_header">찜한 목록<small><button class="btn btn-default btn_like_more" type="submit">더보기</button></small></h2>
								</div>
			        		</div>
			        		<div class="col-xs-12">
			        			<div class="row like_item_list">
			        				<div class="col-xs-3 like_item">
			        					<div class="row">
										  <div class="col-sm-6 col-md-4">
										    <div class="thumbnail like_thumbnail" id="like_item_first">
										      <img src="./image/1.jpg" alt="...">
										      <div class="caption">
										        <h3>아이템1</h3>
										        <p>아이템 정보</p>
										        <p><a href="#" class="btn btn-default btn_like_detail" role="button">상세보기</a><a href="#" class="btn btn-default glyphicon glyphicon-remove btn_like_remove" role="button"></a></p>
										      </div>
										    </div>
										  </div>
										</div>
			        				</div>
			        				<div class="col-xs-3 like_item">
			        					<div class="row">
										  <div class="col-sm-6 col-md-4">
										    <div class="thumbnail like_thumbnail" id="like_item_second">
										      <img src="./image/1.jpg" alt="...">
										      <div class="caption">
										        <h3>아이템2</h3>
										        <p>아이템 정보</p>
										        <p><a href="#" class="btn btn-default btn_like_detail" role="button">상세보기</a><a href="#" class="btn btn-default glyphicon glyphicon-remove btn_like_remove" role="button"></a></p>
										      </div>
										    </div>
										  </div>
										</div>
			        				</div>
			        				<div class="col-xs-3 like_item">
			        					<div class="row">
										  <div class="col-sm-6 col-md-4">
										    <div class="thumbnail like_thumbnail" id="like_item_third">
										      <img src="./image/1.jpg" alt="...">
										      <div class="caption">
										        <h3>아이템3</h3>
										        <p>아이템 정보</p>
										        <p><a href="#" class="btn btn-default btn_like_detail" role="button">상세보기</a><a href="#" class="btn btn-default glyphicon glyphicon-remove btn_like_remove" role="button"></a></p>
										      </div>
										    </div>
										  </div>
										</div>
			        				</div>
			        				<div class="col-xs-3 like_item">
			        					<div class="row">
										  <div class="col-sm-6 col-md-4">
										    <div class="thumbnail like_thumbnail" id="like_item_forth">
										      <img src="./image/1.jpg" alt="...">
										      <div class="caption">
										        <h3>아이템4</h3>
										        <p>아이템 정보</p>
										        <p><a href="#" class="btn btn-default btn_like_detail" role="button">상세보기</a><a href="#" class="btn btn-default glyphicon glyphicon-remove btn_like_remove" role="button"></a></p>
										      </div>
										    </div>
										  </div>
										</div>
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