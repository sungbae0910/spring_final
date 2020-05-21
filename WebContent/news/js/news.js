/**
 * http://usejsdoc.org/
 */

let news = function(){
	
	$('#alexCounter').click(function(){
		var offset = $('#news_comment_s').offset();
		
		$('html').animate({scrollTop : offset.top}, 400);
	})
	
	$('.btn_test_s').click(function(){
		$('#test_s').attr('action', '../news/test.news').submit();
	})
	
	$('.trend-top-cap a').click(function(){
		alert('asdad');
		$('#tes_s').attr('action', '../newsDetailT.news').submit();
	})
	
	$('.pagination li').click(function(){
		$('li').removeClass('active');
		$(this).addClass('active');
	})
	
}

let comment_go = function(nowPage, index){
	$('.nowPage').val(nowPage);
	let asd = $('.nowPage').val();
	let param = $('#tes_s').serialize();
	
	$.post("commentPage.news", param, function(data, status){
		$('#news_comment_s').html(data);
	})
	
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
	if(nSerial!=""){
		$('.nSerial').val(nSerial);
	}
	$('#tes_s').attr('action', 'newsDetail.news').submit();
}

let news_detail_side = function(category){
	$('.nCategory').val(category);
	
	let param = $('#tes_s').serialize();
	$.post("newsDetailSide.news", param, function(data, status){
		$('#detail_side_s').html(data);
	})
}

let weekly = function(){
	let param = $('#tess_s').serialize();
	$.post("weekly.news", param, function(data, status){
		$('#weekly_s').html(data);
		$('#slick-slide-control00').trigger("click");
	})
}

let news_comment = function(){
	let param = $('#tes_s').serialize();
	$.post("comment.news", param, function(data, status){
		$('#news_comment_s').html(data);
		$('#cC_s').val('');
	})
}

let news_re_comment = function(serial){
	let cg = $('.cg'+serial).val();
	let reCon = $('.reC'+serial).val();
	$('.cGroup').val(cg);
	$('.reContent').val(reCon);
	
	let param = $('#tes_s').serialize();
	$.post("reComment.news", param, function(data, status){
		$('#news_comment_s').html(data);
		$('#cC_s2').val('');
		$('.reply_count'+serial).trigger("click");
	})
}

let news_comment_delete = function(cSerial, cGroup){
	let asd = $('.serial'+cSerial).val();
	let asd2 = $('.indent'+cSerial).val();
	$('.cSerial').val(asd);
	$('.cIndent').val(asd2);
	$('.cGroup').val(cGroup);
	
	let param = $('#tes_s').serialize();
	$.post("commentDelete.news", param, function(data, status){
		$('#news_comment_s').html(data);
	})
}

let news_comment_deletes = function(cSerial){
	let asb = $('.sserial'+cSerial).val();
	let asb2 = $('.iindent'+cSerial).val();
	$('.cSerial').val(asb);
	$('.cIndent').val(asb2);
	
	let param = $('#tes_s').serialize();
	$.post("commentDelete.news", param, function(data, status){
		$('#news_comment_s').html(data);
	})
}
/*let weekly = function(){
	$('#tes_s').attr('action', 'weekly.news').submit();
}*/

let login_s = function(){
	alert("로그인 먼저해주세요!!");
}

let diLike_func_s = function(serial){
	let cSerial = $('.serial'+serial).val();
	$('.cSerial').val(cSerial);
	let param = $('#tes_s').serialize();
	$.ajax({
		url : "unLikeA.news",
		type : "POST",
		cache : false,
		dataType : "json",
		data : param,
		success : function(data){
			
			if(data.unlike_check==0){
				$('.num_txto'+serial).html(data.unLikeA);
				$('.oppose'+serial).attr('src', './img/news/unlikeA.png');
			}else if(data.unlike_check==1){
				$('.num_txto'+serial).html(data.unLikeA);
				$('.oppose'+serial).attr('src', './img/news/like.png');
			}else{
				alert(data.unLikeA);
			}
		},
		error : function(request, status, error){
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error)
		}
	});
}

let like_func_s = function(serial){
	let cSerial = $('.serial'+serial).val();
	$('.cSerial').val(cSerial);
	let param = $('#tes_s').serialize();
	
	$.ajax({
		url : "likeA.news",
		type : "POST",
		cache : false,
		dataType: "json",
		data : param,
		success : function(data){
			var like_img = '';
			
			if(data.like_check == 0){
				like_img = './img/news/likeA.png';
				$('.num_txtr'+serial).html(data.likeA);
				$('.recomm'+serial).attr('src', like_img);
			}else if(data.like_check == 1){
				like_img = './img/news/unlike.png';
				$('.num_txtr'+serial).html(data.likeA);
				$('.recomm'+serial).attr('src', like_img);
			}else{
				alert(data.likeA);
			}
		},
		error : function(request, status, error){
			alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error)
		}
	});
}

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

