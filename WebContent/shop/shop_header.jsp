<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="shop_header">
	<form name="shop_frm" id="shop_frm" method="post">
		<div class="container-fluid">
	    	<div class="row">
	        	<div class="col-xs-12">
					<div class="row">
						<div class="col-xs-4">
							<img id="logo" src="../main_lib/images/root.png">
						</div>
						<div class="col-xs-4 col-xs-offset-8" id="btn">
							<div class="row">
								<div class="col-xs-4 login_frm">
									<button type="button" class="btn btn-default btn-lg btn_login">
							  			<span class="glyphicon glyphicon-off" aria-hidden="true"></span> 로그인
									</button>
								</div>
								<div class="col-xs-4 basket_frm">
									<button type="button" class="btn btn-default btn-lg btn_basket">
							  			<span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span> 장바구니
									</button>
								</div>
								<div class="col-xs-4 my_frm">
									<button type="button" class="btn btn-default btn-lg btn_my">
							  			<span class="glyphicon glyphicon-user" aria-hidden="true"></span> 마이페이지
									</button>
								</div>
							</div>
						</div>
						<div class="col-xs-12">
							<div class="row">
								<div class="col-lg-6">
							    	<div class="input-group shop_search">
							      		<input type="text" class="form-control" placeholder="Search for...">
							      		<span class="input-group-btn">
							        		<button class="btn btn-default" type="button">Go!</button>
							      		</span>
							    	</div><!-- /input-group -->
							  	</div><!-- /.col-lg-6 -->
							</div>
						</div>
						<div class="col-xs-3 item1">
						    <a href="#" id="item1_category" onclick="shop.category(0)"><span>귀걸이</span></a>
						</div>
						<div class="col-xs-3 item2">
						    <a href="#" id="item2_category" onclick="shop.category(1)"><span>목걸이</span></a>
						</div>
						<div class="col-xs-3 item3">
							<a href="#" id="item3_category" onclick="shop.category(2)"><span>반 지</span></a>	
						</div>
						<div class="col-xs-3 item4">
							<a href="#" id="item3_category" onclick="shop.category(3)"><span>팔 찌</span></a>	
						</div>
						    <input type="hidden" name="item_category" id="item_category"/>
					</div><!-- /.row -->
				</div>
			</div>
		</div>
	</form>
	<script>shop.func()</script>
</div>