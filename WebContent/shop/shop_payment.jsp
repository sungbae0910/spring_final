<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="shop_payment">
	<div class="container-fluid">
	    <div class="row">
	    	<div class="col-xs-12">
	    		<div class="row">
			    	<div class="col-xs-10 col-xs-offset-1 shop_payment_frm">
			    		<div class="page-header">
						  <h2>결제</h2>
						</div>
			    		<div class="col-xs-12" id="item_payment">
			    			<div class="row">
				    			<div class="col-xs-9 col-xs-offset-3 item_title">
				    				<div class="row">
				    					<div class="col-xs-4">
								    		<span id="item_name_title">상품 명</span>
								    	</div>
								    	<div class="col-xs-4">
								    		<span id="item_price_title">상품 가격</span>
								    	</div>
								    	<div class="col-xs-4">	
								    		<span id="item_num_title">상품 수량</span>	    
								    	</div>		
								    </div>	
				    			</div>
				    			<div class="col-xs-12">
					    			<div class="row" id="item">
					    				<div class="col-xs-3">
					    					<img src="./image/1.jpg" alt="..." class="img-circle item_photo">
					    				</div>	
					    				<div class="item_information">
					    					<div class="col-xs-3 item_name_frm">
								    			<span id="item_name">가나다</span>
								    		</div>
								    		<div class="col-xs-3 item_price_frm">
								    				<span id="item_price">10000원</span>
								    		</div>
								    		<div class="col-xs-3 item_num_frm">
								    				<span id="item_num">10</span>
								    		</div>
					    				</div>
					    			</div>
				    			</div>			    			
			    			</div>
			    		</div>
			    	</div>
			    	<div class="col-xs-10 col-xs-offset-1 shop_payment_tot">
						<div class="col-xs-8 shop_payment_information">
							<div class="row">
							    <div class="col-xs-4 col-xs-offset-4 order_information_frm">
							    	<span id="order_information">주문 정보</span>
							    </div>
							    <div class="col-xs-12">
							    	<div class="row">
							    		<div class="col-xs-2 orderer_frm">
							    			<span id="orderer">주문인</span>
							    		</div>
							    		<div class="col-xs-3">
							    			<input class="form-control" id="orderer_text" type="text" placeholder="">
							    		</div>
							    		<div class="col-xs-3 ordererPhone_frm">
							    			<span id="ordererPhone">주문인 연락처</span>
							    		</div>
							    		<div class="col-xs-4">
							    			<input class="form-control" id="ordererPhone_text" type="text" placeholder="">
							    		</div>
							    	</div>
							    	<div class="row">
							    		<div class="col-xs-2 orderAdress_frm">
							    			<span id="orderAddress">주소</span>
							    		</div>
							    		<div class="col-xs-10">
							    			<input class="form-control" id="orderAddress_text" type="text" placeholder="">
							    		</div>
							    	</div>
							    	<div class="row">
							    		<div class="col-xs-2  reciever_frm">
							    			<span id="reciever">수취인</span>
							    		</div>
							    		<div class="col-xs-3">
							    			<input class="form-control" id="reciever_text" type="text" placeholder="">
							    		</div>
							    		<div class="col-xs-3 recieverPhone_frm">
							    			<span id="recieverPhone">수취인 연락처</span>
							    		</div>
							    		<div class="col-xs-4">
							    			<input class="form-control" id="recieverPhone_text" type="text" placeholder="">
							    		</div>
							    	</div>
							    </div>
							</div>
						</div>
						<div class="col-xs-4 shop_payment_mathod">
							<div class="row">
							    <div class="col-xs-6 col-xs-offset-3 mathod_frm">
							    	<span id="mathod">결제 수단</span>
							    </div>
							    <div class="col-xs-12">
							    	<div class="row">
							    		<div class="col-xs-8 mathod_card_frm">
							    			<span id="card">신용카드</span>
							    		</div>
							    		<div class="col-xs-4">
							    			<button type="button" class="btn btn-default btn-lg  btnCard">
												<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
											</button>
							    		</div>
							    	</div>
							    	<div class="row">
							    		<div class="col-xs-8 mathod_transfer_frm">
							    			<span id="transfer">계좌이체</span>
							    		</div>
							    		<div class="col-xs-3">
							    			<button type="button" class="btn btn-default btn-lg  btnTransfer">
												<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
											</button>
							    		</div>
							  		</div>
							    	<div class="row">
							    		<div class="col-xs-6">
									    	<div id="payment">
												<span id="amount_payment">결제금액</span>
									    	</div>							    					
							    		</div>
							  			<div class="col-xs-6">
							    			<div id="money">
							    				<span id="payment_money">10000원</span>
							    			</div>
							    		</div>
							    	</div>
							    </div>
							</div>
						</div>
						<div class="col-xs-4 col-xs-offset-4 shop_payment_final">
					        <div class="col-xs-12">
					        	<div class="row">
					        		<div class="col-xs-6">
					        			<button type="button" class="btn btn-default btn-lg payment">
											<span class="glyphicon glyphicon-credit-card" aria-hidden="true"></span> 결제
										</button>
					        		</div>
					   	        	<div class="col-xs-6">
										<button type="button" class="btn btn-default btn-lg cancel">
											<span class="glyphicon glyphicon-remove" aria-hidden="true"></span> 취소
										</button>
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