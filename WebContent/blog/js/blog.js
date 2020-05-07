let blog = {}

blog.myblog_func = function(){
	$("#c_sidebar_open").click(function(){
		$("#c_sidebar").animate({right:0}, 500);
		$("body").css("overflow", "hidden"); //스크롤X.
		$("#c_dimmedSidebar").css("position", "absolute");
	});
	
	$("#c_sidebar_close, #c_dimmedSidebar").click(function(){
		$("#c_sidebar").animate({right:-360}, 500);
		$("body").css("overflow", "");
		$("#c_dimmedSidebar").css("position", "");
	});
}