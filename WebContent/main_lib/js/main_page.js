/*
 * 포털 메인페이지
 */

let main = {}

main.view = function(){
	$("#main").load("main.mem");
}

/* 블로그 게시물상세보기 */
main.brdView = function(mId, brdNo) {
	$("#c_mId").val(mId);
	$("#c_brdNo").val(brdNo);
	$("#c_blog_frm").attr("action", "./blog/blog_Index.jsp?inc=../blogBrd.bg").submit();
}

/*main.shopView = function(item_id){
	$("#h_item_id").val(item_id);
	$("#h_shop_frm").attr("action", "./shop/shop_index.jsp?inc=../view.shop").submit();
}*/