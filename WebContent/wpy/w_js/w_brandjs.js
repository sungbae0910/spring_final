/**
 * 
 */

let w_btnFunc = function(){
	
	$('#btnFind').click(function() {
		frm_brd.enctype='';
		let param = $('#frm_food').serialize();
		$.post("w_menu.", param, function(data, state) {
			$('#main').html(data)
		})
	});
	
	
	
}