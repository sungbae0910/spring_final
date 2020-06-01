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

var news_detail = function(serial){
	let nSerial = $('.serial'+serial).val();
	if(nSerial!=""){
		$('.s_nserial').val(nSerial);
	}
	$('#s_news_frm').attr('action', 'newsDetail.mem').submit();
}
