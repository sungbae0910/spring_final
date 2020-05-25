var fd = {}

fd.foodj = function(type) {
	
 $.post("../w_select.fd",{"type" : type},function(data,state){
	 $('.w_tab_container').html(data)
 })
}

fd.func = function(){
	
	$("#w_btninsert").click(function(){
		$("#content").load("w_image_insert.jsp");
	});
	
	$('#w_btnMenu').click(function() {
		$("#content").load("w_menu.jsp");
	});
	
	
   $('#w_btnRegister').click(function(){
		let food = new FormData($('#frm_food')[0]);
		$('#frm_food').attr('action',"../w_insertR.fd");
		$('#frm_food').submit();
		
	});
	
}

