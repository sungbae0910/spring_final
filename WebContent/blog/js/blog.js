let blog = {}

blog.main = function() { //로고 클릭 시 블로그 메인
	location.href = "blog_Index.jsp";
}

blog.mainContent = function() { //블로그 메인
	$("#c_blogContent").load("../blogMain.bg");
}

/*blog.Main = function() { //블로그 메인
	let tag = ["일상", "데일리"];
	let form = $("#c_frmMain");
	for (let i=0; i<tag.length; i++) {
		let input = document.createElement("input");
		 $(input).attr("type", "hidden");
		 $(input).attr("name", "tag");
		 $(input).attr("value", tag[i]);
		 $(form).append(input);
	} 
	$("#c_frmMain").submit();
	 
	jQuery.ajaxSettings.traditional = true; //배열 값을 넘기기 위해 세팅값 바꾸기	
	$.post("../blogMain.bg", {"tag" : tag}, function(data, state) { 
		$("#c_blogContent").html(data);
	});
}*/

blog.mainTag = function(keyword) { //주제 누르면 뜨는 블로그 메인
	jQuery.ajaxSettings.traditional = true; //배열 값을 넘기기 위해 세팅값 바꾸기
	let tag = [];
	if (keyword == "life") { //라이프
		tag = ["일상", "데일리"];
	} else if (keyword == "travel") { //여행, 맛집
		tag = ["여행", "여행에 미치다"];
	} else if (keyword == "it") { //it
		tag = ["IT", "it", "자바", "java", "css", "ajax"];
	}
	$.post("../blogMain.bg", {"tag" : tag}, function(data, state) { 
		$("#c_blogContent").html(data);
	});
}

blog.myblog = function() { //내 블로그
	if($("#c_mId") == null) {
		let mId = sessionStorage.getItem("LoginId");		
		$("#c_mId").val(mId);
	}
	$("#c_blog_frm").attr("action", "?inc=../myblogMain.bg").submit();
	/*let param = $("#c_blog_frm").serialize(); 
	$.post("../myblogMain.bg", param, function(data, state) { 
		$("#c_blogContent").html(data);
	});*/
}
 
blog.brdView = function(mId, brdNo) { //게시글 페이지
	$("#c_mId").val(mId);
	$("#c_brdNo").val(brdNo);
	$("#c_blog_frm").attr("action", "?inc=../blogBrd.bg").submit();
	
	/*let param = $("#c_blog_frm").serialize();*/
	/*$.post("../blogBrd.bg", {"bNo" : bNo, "brdNo" : brdNo}, function(data, state) { 
		$("#c_blogContent").html(data);
	});*/
}

/*blog.category = function(name) { //해당 카테고리 정보 페이지
	$("#c_cName").val(name);
	$("#c_blog_frm").attr("action", "?inc=../myblogMain.bg").submit();
}*/

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

/*blog.func = function(){
	$(".c_subject").click(function(){
		if ($(".c_subject").hasClass("on")) {
			$(".c_subject").removeClass("on");				
		} 
		$(this).addClass("on");
	});
}*/

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
	
	$("#c_btnBrdLike").click(function() { //공감버튼
		let mId = sessionStorage.getItem("LoginId");
		let brdLike = $("#c_brdLike");
		
		if ($(this).hasClass("glyphicon-heart-empty")) {
			$(this).removeClass("glyphicon-heart-empty");
			$(this).addClass("glyphicon-heart");
			brdLike.val(Number(brdLike.val()) + 1);
			$(this).text(brdLike.val());
		} else {
			$(this).removeClass("glyphicon-heart");
			$(this).addClass("glyphicon-heart-empty");
			brdLike.val(Number(brdLike.val()) - 1);
			if (brdLike.val() == 0) {
				$(this).text("공감");				
			} else {
				$(this).text(brdLike.val());
			}
		}
		$("#c_mId").val(mId);
		blog.brdLikeUpdate();
	});
	
	$("#c_btnRepl").click(function() {
		$(".modal-title").text("답글 입력");
	});
}

blog.brdLikeUpdate = function() { //공감버튼 값 변경
	let param = $("#c_brd_frm").serialize(); 
	$.post("../blogBrd.bg", param, function(data, state) {
	});
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











