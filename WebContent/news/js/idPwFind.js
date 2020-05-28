/**
 * http://usejsdoc.org/
 */

$('.eMail').blur(function(){
	if(!/^[a-z0-9]{4,20}$/.test($('#mId').val())){
		$('#checkId').text("아이디는 영 소문자, 숫자 4~20자리로 입력해주세요.");
		$('#sm').attr("disabled", true);
	}else{
		var param = $('#pwdFind_s').serialize();
		$.ajax({
			url : "eMailCk.mem",
			type : "POST",
			dataType : false,
			data : param,
			success : function(data){
				if(data == 1){
					$('#emailCk_s').text("")
				}else{
					$('#emailCk_s').text("이메일이 존재하지 않습니다.");
				}
			}
		})
	}
})
