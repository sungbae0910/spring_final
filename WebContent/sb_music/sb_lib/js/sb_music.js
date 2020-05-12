let mu = {}


mu.func = function(){
	
	
	
}



mu.home = function(){
	$('#changePage').load('../sb_home.mu');
}


mu.movie = function(serial){
	frm_top.m_serial.value = serial;
	let param = $('#frm_top').serialize();
	$('.page').load('../sb_movie.mu', param, function(data){
		console.log('굳');
	} );
}

