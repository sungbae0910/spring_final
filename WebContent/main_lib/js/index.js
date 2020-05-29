/**
 * http://usejsdoc.org/
 */
$(document).ready(function() {
	
	let param = $('#index_frm').serialize();
	$.ajax({
		url : 'IndexInfo.mem',
		data : param,
		type : 'POST',
		dataType : 'json',
		success : function(data){
			
			$('#email').text(data.email);
			
			
			
		}
	})
});