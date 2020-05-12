let blog = {}

blog.myblog_func = function(){
	$("#c_sidebar_open").click(function(){
		$("#c_sidebar").animate({right:0}, 500);
		$("body").css("overflow", "hidden"); //스크롤X.
		$("#c_dimmedSidebar").css("position", "absolute");
	});
	
	$("#c_sidebar_close, #c_dimmedSidebar").click(function(){
		$("#c_sidebar").animate({right:-360}, 500);
		$("body").css("overflow", "");
		$("#c_dimmedSidebar").css("position", "");
	});
	
	$("#c_brd_like").click(function(){ //공감버튼
		if ($(this).hasClass("glyphicon-heart-empty")){
			$(this).removeClass("glyphicon-heart-empty");
			$(this).addClass("glyphicon-heart");
			$(this).text("1");
		} else {
			$(this).removeClass("glyphicon-heart");
			$(this).addClass("glyphicon-heart-empty");
			$(this).text("공감");
		}
		
	});
}

blog.note = function(){
	$("#c_summernote").summernote({
		height : 550,
		lang : "ko-KR",
		toolbar : [
			['style', ['style']],
			["style", ["bold", "italic", "underline", "strikethrough"]],
			["fontname", ["fontname"]],
			["color", ["color"]],
			['fontsize', ['fontsize']],
			["para", ["ul", "ol", "paragraph"]],
			["table", ["table"]],
			["insert", ["link", "picture", "video"]],
			['view', ['fullscreen']]
		]
	});
}

blog.myblog_manage = function(){
	$("#c_myblog_headerImg_add").click(function(){
		$("#c_btn_bHeaderImg").trigger('click');
	});
	
	$("#c_btn_bHeaderImg").change(function(e) {
		let url = e.target.files[0];
		
		let reader = new FileReader();
		reader.readAsDataURL(url);
		
		reader.onload = function(ev) {
			let img = new Image();
			img.src = ev.target.result;
			$("#c_bHeaderImg").attr("src", img.src);
		}
	});
	
	$("#c_myblog_headerImg_rem").click(function(){
		$("#c_btn_bHeaderImg").val("");
		$("#c_bHeaderImg").removeAttr("src");
	});
}








