var fd = {}

fd.foodj = function(type) {
	
 $.post("../w_select.fd",{"type" : type},function(data,state){
	 $('.w_tab_container').html(data)
 })
}

fd.foodv = function(foodCode){
	frm_food.foodCode.value = foodCode;
	
	let param = $('#frm_food').serialize();
	$.post("../w_view.fd", param, function(data, state) {
    $('.w_tab_container').html(data)
	})
}


/*fd.foodv = function(foodCode){
	$.post("../w_view.fd",{"foodCode" : foodCode}, function(data,state){
		$(".w_tab_container").html(data)
	})
	
}*/

fd.func = function(){
	
	$("#w_btninsert").click(function(){
		$("#content").load("w_image_insert.jsp");
	});
	
	
	
   $('#w_btnRegister').click(function(){
		let food = new FormData($('#frm_food')[0]);
		$('#frm_food').attr('action',"../w_insertR.fd");
		$('#frm_food').submit();
		
	});
	
}

