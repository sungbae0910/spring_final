let blog = {}

blog.Main = function() { //블로그 메인
	$.post("../blogMain.bg", {"kind":"life"}, function(data, state) { 
		$("#c_blogContent").html(data);
	});
}

blog.myblog = function() { //내 블로그	
	let param = $("#c_blog_frm").serialize(); 
	$.post("../myblogMain.bg", param, function(data, state) { 
		$("#c_blogContent").html(data);
	});
}

blog.brdView = function() { //게시글 페이지
	let param = $("#c_blog_frm").serialize(); 
	$.post("../blogBrd.bg", param, function(data, state) { 
		$("#c_blogContent").html(data);
	});
}

blog.category = function(name) { //해당 카테고리 정보 페이지
	let cName = name;
	$.post("../myblogMain.bg", {"cName" : cName}, function(data, state) { 
		$("#c_blogContent").html(data);
	});
}

blog.brdInsert = function() { //글 쓰기
	let param = $("#c_blog_frm").serialize(); 
	$.post("../brdInsert.bg", param, function(data, state) { 
		$("#c_blogContent").html(data);
	});

}

blog.brdModify = function() { //글 수정
		let param = $("#c_blog_frm").serialize(); 
		$.post("../brdModify.bg", param, function(data, state) { 
			$("#c_blogContent").html(data);
		});
}

blog.manageMain = function() { //블로그 관리
	let param = $("#c_blog_frm").serialize(); 
	$.post("../blogManage.bg", param, function(data, state) { 
		$("#c_blogContent").html(data);
	});
}

blog.myblog_func = function() {	
		$("#c_sidebar_open").click(function() {
			$("#c_sidebar").animate({right : 0}, 500);
			$("body").css("overflow", "hidden"); //스크롤X.
			$("#c_dimmedSidebar").css("position", "absolute");
		});		
		
		$("#c_sidebar_close, #c_dimmedSidebar").click(function() {
			$("#c_sidebar").animate({right : -360}, 500);
			$("body").css("overflow", "scroll");
			$("#c_dimmedSidebar").css("position", "");
		});
	
	$("#c_brd_like").click(function() { //공감버튼
		if ($(this).hasClass("glyphicon-heart-empty")) {
			$(this).removeClass("glyphicon-heart-empty");
			$(this).addClass("glyphicon-heart");
			$(this).text("1");
		} else {
			$(this).removeClass("glyphicon-heart");
			$(this).addClass("glyphicon-heart-empty");
			$(this).text("공감");
		}
	});
	
	$("#c_btnRepl").click(function() {
		$(".modal-title").text("답글 입력");
	});
	
/*	$("c_btnLife").click(function() { //블로그 메인 라이프버튼
		
	});*/
}

blog.note = function() {
	/* blog_brdInsert */
	$("#c_summernote").summernote({
		height : 420,
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
	
	$("#c_myblog_headerImg_add").click(function() {
		$("#c_btn_bHeaderImg").trigger('click');
	});
	
	$("#c_myblog_headerImg_rem").click(function() {
		$("#c_btn_bHeaderImg").val("");
		$("#c_bHeaderImg").removeAttr("src");
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
}











