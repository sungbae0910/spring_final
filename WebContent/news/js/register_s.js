/**
 * http://usejsdoc.org/
 */

// 다음주소 api사용
var daumAdd = function(){
	new daum.Postcode({
		oncomplete:function(data){
			$('#zipCode').val(data.zonecode);
			$('#address').val(data.address);
		}
	}).open();
}

	// 로그인 버튼 눌렀을때
	$('#login_s').click(function(){
		$('#frm_login_s').attr('action', 'login.mem').submit();
	})

	// 회원가입 버튼 눌렀을때
	$('#sm').click(function(){
		$('#frm_register').attr('action', 'Register.mem').submit();
	})

	
	// 아이디 체크
	$('#mId').blur(function(){
		if(!/^[a-z0-9]{4,20}$/.test($('#mId').val())){
			$('#checkId').text("아이디는 영 소문자, 숫자 4~20자리로 입력해주세요.");
			$('#sm').attr("disabled", true);
		}else{
			var param = $('#frm_register').serialize();
			$.ajax({
				url : "mIdCk.mem",
				type : "POST",
				cache : false,
				dataType : "json",
				data : param,
				success : function(data){
					if(data == 1){
						$('#checkId').text("이미 사용중인 아이디입니다.");
						$('#sm').attr("disabled", true);
					}else{
						$('#checkId').text("사용 가능한 아이디입니다.");
						$('#sm').attr("disabled", false);
					}
				},
				error : function(request, status, error){
					alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error)
				}
			})
		}
		
	})
	
	// 비밀번호 재확인
	$('#pwdCk').blur(function(){
		var pass = $('#pwd').val();
		var passCk = $('#pwdCk').val();
		
		if(pass != passCk){
			$('#checkPass').text("비밀번호가 다릅니다.");
		}else{
			$('#checkPass').text("");
		}
	})
	
	//이메일 정규식 확인
	$('#email').blur(function(){
		var reg_email = /^([0-9a-zA-Z_\.-]+)@([0-9a-zA-Z_-]+)(\.[0-9a-zA-Z_-]+){1,2}$/;
		var email = $('#email').val();
		
		if(!reg_email.test(email)){
			$('#checkEmail').text("이메일 양식이 맞지 않습니다.");
		}else{
			$('#checkEmail').text("");
		}
		
	})
	
	// 로그인시 아이디 확인
	$('#lId').blur(function(){
		if(!/^[a-z0-9]{4,20}$/.test($('#lId').val())){
			$('#checkId').text("아이디는 영 소문자, 숫자 4~20자리로 입력해주세요.");
			return false;
		}else{
			$('#checkId').text("");
		}
	})
	
	
var loginCk = function(){
		
}	
	
	
