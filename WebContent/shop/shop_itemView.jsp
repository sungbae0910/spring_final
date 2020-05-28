<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="shop_itemView">
	<form name="shop_frm" id="shop_frm" method="post">
		<div class="container-fluid">
		    <div class="row">
				<div class="col-xs-12">
				<input type="hidden" name="item_id" value="${vo.item_id}" />
					<div class="row">
						<div class="col-xs-6 itemView_photo">
							<div id="carousel-example-generic" class="carousel slide" data-ride="carousel">		
							  	<!-- Wrapper for slides -->
							  	<div class="carousel-inner" role="listbox">
							  		<c:forEach var="i" items="${photo}" begin="0" end="0">
							    		<div class="item active">
							      			<img src="./image/${i.item_main_photo}" alt="..." id="itemView_photo_content">
							    		</div>
							  		</c:forEach>
							    	<c:forEach var="i" items="${photo}" begin="1">
								    	<div class="item">
								     		<img src="./image/${i.item_photo}" alt="..." id="itemView_photo_content">
								    	</div>
									</c:forEach>
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
										<span id="itemView_name_contnet">${vo.item_name}</span>
									</div>
								</div>
								<div class="row itemView_price_frm">
									<div class="col-xs-4 itemView_price">
										<span id="itemView_price_title">가격</span>
									</div>
									<div class="col-xs-8 itemView_price_text">
										<span id="itemView_price_content">${vo.item_price}</span>
									</div>
								</div>
								<div class="row itemView_option_frm">
										<div class="col-xs-4 itemView_typeOption">
											<span id="itemView_option_title">option</span>
										</div>
									<div class="col-xs-8 itemView_option_text">
											<!-- Single button -->
										<div class="btn-group">
											<c:forEach var="i" items="${typeOption}">
												<button type="button" class="btn btn-default dropdown-toggle btn_itemView_typeOption" data-toggle="dropdown" aria-expanded="false">
													${i.option_name_values}<span class="caret"></span>
												</button>
											</c:forEach>	
												<ul class="dropdown-menu" id="btn_itemView_typeOption_menu" role="menu">
													<li><span>필수 옵션</span></li>
													<li class="divider"></li>
													<c:forEach var="i" items="${typeValue}">
														<li><a href="#">${i.option_value}</a></li>
													</c:forEach>
												</ul>
											</div>
											<div class="btn-group">
												<c:forEach var="i" items="${colorOption}">
												<button type="button" class="btn btn-default dropdown-toggle btn_itemView_colorOption" data-toggle="dropdown" aria-expanded="false">
													${i.option_name_values}<span class="caret"></span>
												</button>
											</c:forEach>
											<ul class="dropdown-menu" id="btn_itemView_colorOption_menu" role="menu">
												<li><span>필수 옵션</span></li>
												<li class="divider"></li>
												<c:forEach var="i" items="${colorValue}">
													<li><a href="#">${i.option_value}</a></li>
												</c:forEach>
											</ul>
										</div>
										<div class="btn-group">
											<c:forEach var="i" items="${sizeOption}">
												<button type="button" class="btn btn-default dropdown-toggle btn_itemView_sizeOption" data-toggle="dropdown" aria-expanded="false">
													${i.option_name_values}<span class="caret"></span>
												</button>
											</c:forEach>
											<ul class="dropdown-menu" id="btn_itemView_sizeOption_menu" role="menu">
												<li><span>필수 옵션</span></li>
												<li class="divider"></li>
												<c:forEach var="i" items="${sizeValue}">
													<li><a href="#">${i.option_value}</a></li>
												</c:forEach>
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
													  	<button type="button" class="btn btn-default btn-lg btn_count_up" onclick="shop.changeUp()">
														 	<span class="glyphicon glyphicon-menu-up" aria-hidden="true"></span>
														</button>
													  <input type="text" class="itemView_num_count" name="count" value="0" />
													  	<button type="button" class="btn btn-default btn-lg btn_count_down" onclick="shop.changeDown()">
														 	<span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span>
													  	</button>
													</div>
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