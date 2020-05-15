/**
 * http://usejsdoc.org/
 */


let news = function(){
	
	$('.btn_test_s').click(function(){
		$('#test_s').attr('action', '../news/test.news').submit();
	})
	
	$('.trend-top-cap a').click(function(){
		alert('asdad');
		$('#tes_s').attr('action', '../newsDetailT.news').submit();
	})
	
/*	//카테고리(사회)
	$('#nav-profile-tab').click(function(){
		$('.cate_name').val('사회');
		let ee = $('.cate_name').val();
		alert('asd');
	})
	
	//카테고리(경제)
	$('#nav-contact-tab').click(function(){
		alert('asd');
	})	
	
	//카테고리(스포츠)
	$('#nav-last-tab').click(function(){
		alert('asd');
	})	
	
	//카테고리(IT)
	$('#nav-Sports').click(function(){
		alert('asd');
	})	
	
	//카테고리(문화)
	$('#nav-technology').click(function(){
		alert('asd');
	})	*/
}

let hide_come = function(replyCount){
	if($('.reply_count'+replyCount).hasClass('reply_count'+replyCount)){
		$('.reply_count'+replyCount).addClass('reply_close'+replyCount).removeClass('reply_count'+replyCount);
		$('.hide_comment'+replyCount).css('display', 'block');
	}else if($('.reply_close'+replyCount).hasClass('reply_close'+replyCount)){
		$('.reply_close'+replyCount).addClass('reply_count'+replyCount).removeClass('reply_close'+replyCount);
		$('.hide_comment'+replyCount).css('display', 'none');
	}
		
	
}

let go_all = function(){
	go_home();
	cate_all();
	weekly();
}

let go_home = function(){
	/*$('#news_s').attr('action', 'newsMain.news').submit();*/
	let param = $('#tess_s').serialize();
	$.post("newsMain.news", param, function(data, status){
		$('#top_news_s').html(data);
	})
}


let cate_all = function(){
	// 	카테고리(모두)
	let param = $('#tes_s').serialize();
	$.post("cateAll.news", param, function(data, status){	
		$('#category_s').html(data);
	});
}

let cate_detail = function(detail, n){
	$('.cate_name').val(detail);
	let param = $('#tes_s').serialize();
	$.post("cateDe.news", param, function(data, status){	
		$('#category_s').html(data);
		cate_ui(n);
	});
}

let news_detail = function(serial){
	let nSerial = $('.serial'+serial).val();
	$('.nSerial').val(nSerial);
	$('#tes_s').attr('action', 'newsDetail.news').submit();
}

let weekly = function(){
	let param = $('#tess_s').serialize();
	$.post("weekly.news", param, function(data, status){
		$('#weekly_s').html(data);
		$('#slick-slide-control00').trigger("click");
	})
}

/*let weekly = function(){
	$('#tes_s').attr('action', 'weekly.news').submit();
}*/

let cate_ui = function(n){
	if(n=='n2'){
		$('a').removeClass('active');
		$('div.tab-pane').removeClass('show active');
		$('.n2').addClass('active');
		$('.nh2').addClass('show active');
	}else if(n=='n3'){
		$('a').removeClass('active');
		$('div.tab-pane').removeClass('show active');
		$('.n3').addClass('active');
		$('.nh3').addClass('show active');
	}else if(n=='n4'){
		$('a').removeClass('active');
		$('div.tab-pane').removeClass('show active');
		$('.n4').addClass('active');
		$('.nh4').addClass('show active');
	}else if(n=='n5'){
		$('a').removeClass('active');
		$('div.tab-pane').removeClass('show active');
		$('.n5').addClass('active');
		$('.nh5').addClass('show active');
	}else if(n=='n6'){
		$('a').removeClass('active');
		$('div.tab-pane').removeClass('show active');
		$('.n6').addClass('active');
		$('.nh6').addClass('show active');
	}
}

