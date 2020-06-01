var fd = {}

fd.foodj = function(type) {
	
 $.post("../w_select.fd",{"type" : type},function(data,state){
	 $('.w_tab_container').html(data)
 })
}

/*fd.foodv = function(foodCode){
	frm_food.foodCode.value = foodCode;
	
	let param = $('#frm_food').serialize();
	$.post("../w_view.fd", param, function(data, state) {
    $('.w_tab_container').html(data)
	})
}
*/

fd.foodv = function(foodCode){
	$.post("../w_view.fd",{"foodCode" : foodCode}, function(data,state){
		$(".w_tab_container").html(data)
	})
	
}

fd.func = function(){
	
	$("#w_btninsert").click(function(){
		$("#content").load("w_image_insert.jsp");
	});
	
   $('#w_btnRegister').click(function(){
	   let param = new FormData($('#frm_food')[0]);
		$.ajax({
	     url : '../w_insertR.fd',
	     type : 'post',
	     data : param, 
	     contentType : false,
	     processData : false,
	     error : function(status, error){
	    	 console.log(error);
	     },
		 success : function(data, status){
			 location.href = "w_menu.jsp"
		 }
		
		})
		
	});
   
   $("#w_btnModify").click(function(){
	   let param = $('#frm_food').serialize();
		$.post("../w_modify.fd", param, function(data, state) {
			$('#content').html(data)
		})
   })
   
  /* $("w_btnUpdate").click(function(){
	   let food = new FormData($('#frm_food')[0]);
	   $("#frm_food").attr("action","../w_modifyR.fd");
	   $("#frm_food").submit();
   })*/
   
   $('#w_btnUpdate').click(function() {

		let param = new FormData($('#frm_food')[0]);
		$.ajax({
	     url : '../w_modifyR.fd',
	     type : 'post',
	     data : param, 
	     contentType : false,
	     processData : false,
	     error : function(status, error){
	    	 console.log(error);
	     },
		 success : function(data, status){
			 location.href = "w_menu.jsp"
		 }
		
		})
	});
   
   $('#w_btnDelete').click(function(){
	   let param = $('#frm_food').serialize();
		$.post("../w_delete.fd", param, function(data, state) {
			location.href = "w_menu.jsp"
		})
   })
   
   
}

