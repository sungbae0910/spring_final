/**
 * 
 */

let fd = {}

fd.foodj = function(type) {
	
 $.post("../w_select.fd",{"type" : type},function(data,state){
	 $('.w_tab_container').html(data)
 })
	
}