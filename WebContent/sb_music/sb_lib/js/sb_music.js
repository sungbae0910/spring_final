var home = function(){
	$('#changePage').load('sb_home.mu');
}


var movie = function (serial){
	frm_top.m_serial.value = serial;
	let param = $('#frm_top').serialize();
	$('#changePage').load('sb_movie.mu', param, function(data){
		console.log('굳');
	} );
}

var info = function(serial){
	frm_top.m_serial.value = serial;
	let param = $('#frm_top').serialize();
	$('#changePage').load('sb_info.mu', param, function(data){
		
	});
	
}
