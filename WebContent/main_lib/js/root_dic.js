/**
 * http://usejsdoc.org/
 */
var root = {}

root.rt = function(){
	$("#w_btnSearch").click(function(){
	 let param = new FormData($('#frm_dic')[0]);
	   $.ajax({
		 url : 'dictionary.mem',
		 type : 'post',
		 data : param,
		 contentType : false,
		 processData : false,
		 error : function(status,error){
			  console.log(error);
		 },
		 success : function(data,status){
			 $("#w_border1").html(data)
		 }
		   
	   })	

	})
	
}
