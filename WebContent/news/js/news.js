/**
 * http://usejsdoc.org/
 */


let news = function(){
	
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