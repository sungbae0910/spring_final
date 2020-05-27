$(document).ready(function(){
	alert("워터멜론으로 음악을 감상하실수 있습니다.");
	
	

})

widow.onload = function(){
	let param = $('#frm_resultPay').serialize();
	$.post('sb_payMembership.mem', param);
}
