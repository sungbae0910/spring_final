/**
 * 
 */

let food = {}

food.foodj = function(type) {
 $.post("../select.food",{"type" : type},function(data,state){
	 alert(data);
	 $('.w_tab_container').html(data)
 })
	
}