/**
 * http://usejsdoc.org/
 */
let shop = {}

shop.mainFunc = function(){
	let param = $("#shop_frm").serialize();
	$.post("../main.shop", param, function(data, state){
		$("#main").html(data);
	})
}

shop.func = function(){
	
	$(".btn_more").click(function(){
		alert("아이템 더보기");
		let param = $("#shop_frm").serialize();
		$.post("../more.shop", param, function(data, state){
			$("#main").html(data);
		})
	})
	
	$(".btn_detail").click(function(){
		alert(1);
		let param = $("#shop_frm").serialize();
		$.post("../view.shop", param, function(data, state){
			$("#main").html(data);
		})
	})
	
	$(".btn_basket").click(function(){
		let param = $("#shop_frm").serialize();
		$.post("../basket.shop", param, function(data, state){
			$("#main").html(data);
		})
	})
	
	$(".btn_my").click(function(){
		let param = $("#shop_frm").serialize();
		$.post("../myPage.shop", param, function(data, state){
			$("#main").html(data);
		})
	})
	
	$("#item1_category").click(function(){
		let param = $("#shop_frm").serialize();
		$.post("../more.shop", param, function(data, state){
			$("#main").html(data);
		})
	})
	
	$("#item2_category").click(function(){
		let param = $("#shop_frm").serialize();
		$.post("../more.shop", param, function(data, state){
			$("#main").html(data);
		})
	})
	
	$("#item3_category").click(function(){
		let param = $("#shop_frm").serialize();
		$.post("../more.shop", param, function(data, state){
			$("#main").html(data);
		})
	})
	
	$(".btn_itemView_payment").click(function(){
		alert("결제하시겠습니까?")
		let param = $("#shop_frm").serialize();
		$.post("../payment.shop", param, function(data, state){
			$("#main").html(data);
		})
	})
	
	$(".btn_itemView_basket").click(function(){
		alert("장바구니로 이동하시겠습니까?")
		let param = $("#shop_frm").serialize();
		$.post("../basket.shop", param, function(data, state){
			$("#main").html(data);
		})
	})
	
	$(".btn_itemView_like").click(function(){
		if($("#btn_itemView_like_click").hasClass("glyphicon-heart-empty")){
			alert("찜 목록에 추가되었습니다.")
			$("#btn_itemView_like_click").removeClass("glyphicon-heart-empty")
			$("#btn_itemView_like_click").hasClass("glyphicon-heart")
		}else{
			alert("찜 목록에서 삭제되었습니다.")
			$("#btn_itemView_like_click").removeClass("glyphicon-heart")
			$("#btn_itemView_like_click").hasClass("glyphicon-heart-empty")
		}
	})
	
	$(".basket_payment").click(function(){
		alert("결제창으로 이동합니다.")
		let param = $("#shop_frm").serialize();
		$.post("../payment.shop", param, function(data, state){
			$("#main").html(data);
		})
	})
	
	$(".basket_cancel").click(function(){
		alert("마이페이지로 이동합니다.")
		let param = $("#shop_frm").serialize();
		$.post("../myPage.shop", param, function(data, state){
			$("#main").html(data);
		})
	})
	
	$(".payment").click(function(){
		alert("결제가 완료되었습니다.")
		let param = $("#shop_frm").serialize();
		$.post("../myPage.shop", param, function(data, state){
			$("#main").html(data);
		})
	})
	
	$(".cancel").click(function(){
		alert("장바구니로 돌아갑니다.")
		let param = $("#shop_frm").serialize();
		$.post("../basket.shop", param, function(data, state){
			$("#main").html(data);
		})
	})
	
	$(".btn_like_more").click(function(){
		let param = $("#shop_frm").serialize();
		$.post("../more.shop", param, function(data, state){
			$("#main").html(data);
		})
	})
	
	$(".btn_like_detail").click(function(){
		let param = $("#shop_frm").serialize();
		$.post("../view.shop", param, function(data, state){
			$("#main").html(data);
		})
	})
	
	$(".btn_member_save").click(function(){
		alert("회원 정보가 정상적으로 수정되었습니다.")
	})
	
	$(".btn_member_delete").click(function(){
		alert("정상적으로 탈퇴되었습니다.")
	})
}