let blog = {}

blog.logout = function(){
	$.post("../blogLogout.mem", function(data, state) {
		history.go(-2);
	});
}

blog.mainContent = function () { //블로그 메인
	$("#c_blogContent").load("../blogMain.bg");
}

blog.manage = function () { //블로그 관리 메인
	$("#c_top_frm").attr("action", "?inc=../blogManageMain.bg").submit();
}

blog.mainTag = function (keyword) { //주제 누르면 뜨는 블로그 메인
	jQuery.ajaxSettings.traditional = true; //배열 값을 넘기기 위해 세팅값 바꾸기
	let tag = [];
	if (keyword == "life") { //라이프
		tag = ["일상", "데일리"];
	} else if (keyword == "travel") { //여행, 맛집
		tag = ["여행", "여행에 미치다"];
	} else if (keyword == "it") { //it
		tag = ["IT", "it", "자바", "java", "css", "ajax"];
	}
	$.post("../blogMain.bg", {"tag" : tag}, function (data, state) { 
		$("#c_blogContent").html(data);
	});
}

blog.myblog = function () { //내 블로그
	$("#c_top_frm").attr("action", "?inc=../myblogMain.bg").submit();
}

blog.otherBlog = function () { //다른 사람 블로그
	$("#c_blog_frm").attr("action", "?inc=../myblogMain.bg").submit();
}

blog.category = function (name) { //해당 카테고리 정보 페이지
	$("#c_cName").val(name);
	$("#c_blog_frm").attr("action", "?inc=../myblogMain.bg").submit();
}

blog.brdView = function (mId, brdNo) { //게시물 페이지
	$("#c_mId").val(mId);
	$("#c_brdNo").val(brdNo);
	$("#c_blog_frm").attr("action", "?inc=../blogBrd.bg").submit();
}

blog.brdModify = function () { //게시물 수정
	$("#c_blog_frm").attr("action", "?inc=../brdModify.bg").submit();
}

blog.brdDelete = function () { //게시물 삭제
	let param = $("#c_blog_frm").serialize();
	$.post("../brdDelete.bg", param, function(data, state) {
		history.go(-2);
		/*$("#c_blogMain").html(data);*/
	});
}

blog.brdInsert = function (mId) { //글 쓰기
	$("#c_mId").val(mId);
	$("#c_blog_frm").attr("action", "?inc=../brdInsert.bg").submit();

}

/*blog.func = function(){
	$(".c_subject").click(function(){
		if ($(".c_subject").hasClass("on")) {
			$(".c_subject").removeClass("on");				
		} 
		$(this).addClass("on");
	});
}*/

blog.myblog_func = function () {	
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
	
	/*$("#c_btnBrdLike").click(function () { //공감버튼
		let mId = session.getSession("mId");
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
	});*/
	
	$("#c_btnRepl").click(function () {
		$(".modal-title").text("답글 입력");
	});
	
	/* 블로그 게시물 입력 */
	$("#c_btnBrdInsert_Con").click(function () {
		basicSetAdd();
		$("#c_blog_frm").attr("action", "?inc=../brdInsertR.bg").submit();
	});
	
	/* 블로그 게시물 수정 */
	$("#c_btnBrdModify_Con").click(function () {
		basicSetAdd();
		$("#c_blog_frm").attr("action", "?inc=../brdModifyR.bg").submit();
	});
	
	//라디오 체크된 값 input태그에 넣기
	function basicSetAdd() {
		let basicSet = document.getElementsByName("c_basicSet");
		for (let i=0; i<basicSet.length; i++){
			if (basicSet[i].checked == true){ 
				$("#c_basicSetVal").val(basicSet[i].value);
			}
		}
	}
}


blog.brdLike = function (mId) { //공감버튼 값 변경
	let brdLike = $("#c_btnBrdLike");

	if (brdLike.hasClass("glyphicon-heart-empty")) {//공감 버튼 처음 눌렀을 때
		brdLike.removeClass("glyphicon-heart-empty");
		brdLike.addClass("glyphicon-heart");
		if (brdLike.text() == "공감") {
			brdLike.text(1);
		} else {
			brdLike.text(Number(brdLike.text()) + 1);		
		}
		$("#c_likeFlag").val("i");
	} else { //공감 해제할 때
		brdLike.removeClass("glyphicon-heart");
		brdLike.addClass("glyphicon-heart-empty");
		$("#c_likeFlag").val("d");
		let like = Number(brdLike.text()) - 1;
		if (like == 0) { //공감 수가 0이면
			brdLike.text("공감");				
		} else {
			brdLike.text(like);
		}
	}
	$("#c_mId").val(mId);
	let param = $("#c_brd_frm").serialize(); 
	$.post("../blogbrdLike.bg", param, function(data, state) {
	});
}

blog.brdAction = function () {
	/*이미지 헤더 사진*/
	$("#c_myblog_headerImg_add").click(function () { //이미지 추가 버튼
		$("#c_btn_bHeaderImg").trigger('click');
	});
	
	$("#c_myblog_headerImg_rem").click(function () { //이미지 삭제 버튼
		$("#c_btn_bHeaderImg").val("");
		$("#c_bHeaderImg").removeAttr("src");
	});
	
	
	$("#c_btn_bHeaderImg").change(function (e) { //선택한 이미지 헤더영역에 미리보기
		let url = e.target.files[0];
		
		let reader = new FileReader();
		reader.readAsDataURL(url);
		
		reader.onload = function (ev) {
			let img = new Image();
			img.src = ev.target.result;
			$("#c_bHeaderImg").attr("src", img.src);
		}
	});
	
	/* 썸머노트 */
	$("#c_summernote").summernote({
		height : 550,
		lang : "ko-KR",
		toolbar : [
			["style", ["style"]],
			["style", ["bold", "italic", "underline", "strikethrough"]],
			["fontname", ["fontname"]],
			["color", ["color"]],
			["fontsize", ["fontsize"]],
			["para", ["ul", "ol", "paragraph"]],
			["table", ["table"]],
			["insert", ["link", "picture", "video"]],
			["view", ["fullscreen"]]
		],
		callbacks: { //이미지 첨부
			onImageUpload : function(files) {
	            for (var i = files.length - 1; i >= 0; i--) {
	            	sendFile(files[i], this);
	            }
	        }
		}
	});
	
	function sendFile(file, el) { //이미지 파일 업로드
		var form_data = new FormData();
      	form_data.append("file", file);
      	$.ajax({
        	data : form_data,
        	type : "POST",
        	url : "../uploadSummernoteImg.bg",
        	contentType : false,
        	enctype : "multipart/form-data",
        	processData : false,
        	dataType : "json",
        	success : function(data) {
          		$(el).summernote("insertImage", data.url);
        	}
      	});
    }
	
	//태그
	$(".c_tag").focus(function(){
		let tag = {};
		let counter = 0;
		
		//태그 추가
		function addTag (value) {
			tag[counter] = value; //태그를 object 안에 추가
			counter++;
		}
		
		// 최종적으로 서버에 넘길때 tag 안에 있는 값을 array type으로 만들어서 넘김
	    function marginTag () {
	        return Object.values(tag).filter(function (word) {
	            return word !== "";
	        });
	    }
	    
	 	/* // 서버에 넘기기
	    $("#tag-form").on("submit", function (e) {
	        var value = marginTag(); // return array
	        $("#rdTag").val(value); //hidden input에 값 넣기
	        $(this).submit();
	    }); */


	    $(".c_tag").on("keypress", function (e) {
	        // input 에 focus 되있을 때 엔터 및 스페이스바 입력시 구동
	        if (e.key === "Enter" || e.keyCode == 32) {

	            var tagValue = $(this).val();

	            if (tagValue !== "") {// 값이 없으면 동작X

	                // 같은 태그가 있는지 검사, 있다면 해당값이 array 로 return 된다.
	                var result = Object.values(tag).filter(function (word) {
	                    return word === tagValue;
	                })
	            
	                // 태그 중복 검사
	                if (result.length == 0) { 
	                	$("#c_tagList").append("<span class='c_txtTag'><span class='123'>"+'#'+tagValue+"</span><span class='tagDelBtn' idx='"+counter+"'>x</span></span>");          		
	                    addTag(tagValue);
	                    $(this).val("");
	                    
	                    var value = marginTag(); // return array
	        	        $("#c_tagContent").val(value); //hidden input에 값 넣기
	                } else {
	                   $("#c_tag").val(null); //중복되면 값 없애기
	                }
	            }
	            e.preventDefault(); // 스페이스바 시 빈공간이 생기지 않도록 방지
	        }
	    });
	    
	    //태그 삭제
	    $(document).on("click", ".tagDelBtn", function (e) {
	    	var index = $(this).attr("idx");
	    	tag[index] = "";
	    	$(this).parent().remove();
	    });
	});
	
	    
	  	/*//태그 수정
		 $(document).on("click", ".c_tagItem", function () {
		       var v = $(this).text();
		       let tagChange = "<span class='c_inpTag1'><input type='text' class='c_tag' value='"+v+"' onfocus='this.value = this.value;'/></span>";
		       $(this).parent().replaceWith(tagChange); //객체 바꾸기
		       $(".c_inpTag1>.c_tag").focus();
		    });
	  	
		 $(document).on("blur", ".c_inpTag1>.c_tag", function () { 
		       var v = $(this).val();
		       let tagChange = "<span class='c_txtTag'><span class='c_tagItem'>"+v+"</span><span class='tagDelBtn' idx='"+counter+"'>x</span></span>";
		       $(this).parent().replaceWith(tagChange); //객체 바꾸기
		    });*/

}
