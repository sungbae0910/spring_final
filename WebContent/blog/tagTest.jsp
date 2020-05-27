<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="./js/jquery-3.4.1.js"></script>
<style>
/* #c_tagBox {
	width: 830px;
    min-height: 115px;
    margin: 0 auto;
    box-sizing: border-box;
} */

#c_tagBox #c_tagList {
	display: inline-flex;
}
#c_tagBox #c_tagList>span {margin: 0 10px 0 0;}
#c_tagBox #c_tagList .c_tag .tagDelBtn{cursor: pointer;}
#c_tagBox .c_inpTag {
	color: #909090;
    letter-spacing: -3px;
}

#c_tagBox .c_inpTag .c_tag{
	display: inline-block;
    outline: none;
    border: none;
    letter-spacing: -2px;
}


</style>
</head>
<body>
<div id="c_tagBox">
	<div id="c_tagList"></div>
	<span class="c_inpTag">
		<span>#</span>
			<input type="text" class="c_tag" id="c_tag" placeholder="태그입력"/>
	</span>
</div>
<script>
btnFunc();
$("#c_tag").focus(function(){
	
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
                    $("#c_tagList").append("<span class='c_txtTag'><span class='c_tagItem' onclick='btnFunc()'>"+'#'+tagValue+"</span><span class='tagDelBtn' idx='"+counter+"'>x</span></span>");
                    addTag(tagValue);
                    $(this).val("");
                } else {
                    alert("태그값이 중복됩니다.");
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
    
  	//태그 수정
	 /* $(document).on("click", ".c_tagItem", function () {
	       var v = $(this).text();
	       let tagChange = "<span class='c_inpTag1'><span>#</span><input type='text' class='c_tag' value='"+v+"'/></span>";
	       $(this).parent().replaceWith(tagChange); //객체 바꾸기
	       $(".c_inpTag1>.c_tag").focus();
	    }); */
  	
	 /* $(document).on("blur", ".c_inpTag1>.c_tag", function () { 
	       var v = $(this).val();
	       let tagChange = "<span class='c_txtTag'><span class='c_tagItem'>"+v+"</span><span class='tagDelBtn' idx='"+counter+"'>x</span></span>";
	       $(this).parent().replaceWith(tagChange); //객체 바꾸기
	    }); */
});



btnFunc = function() {
	$(".c_tagItem").click(function () {
   		var v = $(this).text();
	    let tagChange = "<span class='c_inpTag1'><span>#</span><input type='text' class='c_tag' value='"+v+"'/></span>";
	    $(this).parent().replaceWith(tagChange); //객체 바꾸기
	    $(".c_inpTag1>.c_tag").focus();
 });

$(".c_inpTag1>.c_tag").blur(function () { 
    var v = $(this).val();
    let tagChange = "<span class='c_txtTag'><span class='c_tagItem'>"+v+"</span><span class='tagDelBtn' idx='"+counter+"'>x</span></span>";
    $(this).parent().replaceWith(tagChange); //객체 바꾸기
 });
}
</script>
</body>
</html>