<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="shop_itemView">
	<form name="shop_frm" id="shop_frm" method="post">
		<div class="container-fluid">
		    <div class="row">
				<div class="col-xs-12">
					<div class="row">
						<div class="col-xs-6 itemView_photo">
							<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
							  <!-- Indicators -->
							  <ol class="carousel-indicators">
							    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
							    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
							    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
							  </ol>					
							  <!-- Wrapper for slides -->
							  <div class="carousel-inner" role="listbox">
							    <div class="item active">
							      <img src="./image/1.jpg" alt="..." id="itemView_photo_content">
							      <div class="carousel-caption">
							      </div>
							    </div>
							    <div class="item">
							      <img src="./image/poo.jpg" alt="..." id="itemView_photo_content">
							      <div class="carousel-caption">
							      </div>
							    </div>
								<div class="item">
							      <img src="./image/pooh_10.jpg" alt="..." id="itemView_photo_content">
							      <div class="carousel-caption">
							      </div>
							    </div>
							  </div>					
							  <!-- Controls -->
							  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
							    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
							    <span class="sr-only">Previous</span>
							  </a>
							  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
							    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
							    <span class="sr-only">Next</span>
							  </a>
							</div>
						</div>
						<div class="col-xs-6 itemView_information">
							<div class="col-xs-12">
								<div class="row itemView_name_frm">
									<div class="col-xs-4 itemView_name">
										<span id="itemView_name_title">이름</span>
									</div>
									<div class="col-xs-8 itemView_name_text">
										<span id="itemView_name_contnet">가나다</span>
									</div>
								</div>
								<div class="row itemView_price_frm">
									<div class="col-xs-4 itemView_price">
										<span id="itemView_price_title">가격</span>
									</div>
									<div class="col-xs-8 itemView_price_text">
										<span id="itemView_price_content">10000원</span>
									</div>
								</div>
								<div class="row itemView_option_frm">
									<div class="col-xs-4 itemView_option">
										<span id="itemView_option_title">옵션</span>
									</div>
									<div class="col-xs-8 itemView_option_text">
										<!-- Single button -->
										<div class="btn-group">
										  <button type="button" class="btn btn-default dropdown-toggle btn_itemView_option" data-toggle="dropdown" aria-expanded="false">
										    필수 옵션 <span class="caret"></span>
										  </button>
										  <ul class="dropdown-menu" id="btn_itemView_option_menu" role="menu">
										    <li><span>필수 옵션</span></li>
										    <li class="divider"></li>
										    <li><a href="#">실버</a></li>
										    <li><a href="#">골드</a></li>
										    <li><a href="#">로즈골드</a></li>
										  </ul>
										</div>
									</div>
								</div>
								<div class="row itemView_num_frm">
									<div class="col-xs-4 itemView_num">
										<span id="itemView_num_title">수량</span>
									</div>
									<div class="col-xs-8 itemView_num_text">
										<div class="row">
											<div class="col-xs-6 col-xs-offset-3 itemView_num_text_frm">
												<div class="row">
													<div class="input-group itemView_num_content">
													  <span class="input-group-addon btn glyphicon glyphicon-menu-up btn_itemView_num_up"></span>
													  <input type="number" class="form-control itemView_num_middle_content" aria-label="Amount (to the nearest dollar)">
													  <span class="input-group-addon btn glyphicon glyphicon-menu-down btn_itemView_num_down"></span>
													</div>
													<!-- <div class="col-xs-4 itemView_num_up">
														<button type="button" class="btn btn-default btn-lg btn_itemView_num_up">
														  <span class="glyphicon glyphicon-menu-up" aria-hidden="true"></span>
														</button>
													</div>
													<div class="col-xs-4 itemView_num_middle">
														<input class="form-control" id="itemView_num_middle_content" type="text" placeholder="">
													</div>
													<div class="col-xs-4 itemView_num_down">
														<button type="button" class="btn btn-default btn-lg btn_itemView_num_down">
														  <span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span>
														</button>
													</div> -->
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="row itemView_btn_frm">
									<div class="col-xs-4 itemView_btn_payment">
										<button type="button" class="btn btn-default btn-lg btn_itemView_payment">
											<span class="glyphicon glyphicon-credit-card btn_itemView_payment_click" aria-hidden="true">결제하기</span>
										</button>
									</div>
									<div class="col-xs-4 itemView_btn_basket">
										<button type="button" class="btn btn-default btn-lg btn_itemView_basket">
											<span class="glyphicon glyphicon-shopping-cart btn_itemView_basket_click" aria-hidden="true">장바구니</span>
										</button>
									</div>
									<div class="col-xs-4 itemView_btn_like">
										<button type="button" class="btn btn-default btn-lg btn_itemView_like" >
											<span class="glyphicon glyphicon-heart-empty" id="btn_itemView_like_click" aria-hidden="true">찜하기</span>
										</button>
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