/*function $(id){
	return document.getElementById(id);
}

var audio = new Audio("../lib/music/001 엠씨더맥스 (M.C the MAX) - 처음처럼.mp3");

function doPlay(){
	
	audio.play();
}

function doPause(){
	audio.pause();
}

function doStop(){
	audio.pause();
	audio.currentTime = 0;
}

function changeVolume(v){
	var new_v = audio.volume+v;
	if(0<=new_v && new_v <= 1.0){
		audio.volume = new_v;
	}
}
*/

window.onload = function(){
	var playBtn = document.getElementById("play-button");
	  var progressBar = document.getElementById("progress-bar");
	  
	  var audio = new Audio("../lib/music/003 방탄소년단 - ON.mp3");   
	  var playing = false;
	  var duration = 0;
	  
	  progressBar.onchange=(e)=>{    
	    audio.currentTime = +progressBar.value;
	  };
	  audio.addEventListener("timeupdate",(e)=>{    
	        progressBar.value = audio.currentTime;
	  });
	  audio.addEventListener("ended",(e)=>{
	    progressBar.value = 0;
	    playBtn.innerText="Play"; 
	    playing=false;
	  });
	  
	  audio.addEventListener("play",(e)=>{    
	    playBtn.innerText="Stop"; 
	    playing=true;
	  });
	  audio.addEventListener("pause",(e)=>{    
	    playBtn.innerText="Play"; 
	    playing=false;
	  });
	  audio.addEventListener("canplay",()=>{
	    duration = audio.duration;
	    progressBar.min =0;
	    progressBar.max= duration;    
	  });
	  
	  playBtn.onclick=()=>{
	    if(playing){
	      audio.pause();            
	    }
	    else{
	      audio.play()      
	    }    
	    return true;
	  };  
	
}
/*$('input[type=range]').on('input', function(){
    var val = $(this).val();
    $(this).css('background', 'linear-gradient(to right, dodgerblue 0%, dodgerblue '+ val +'%, #d5d4d3 ' + val + '%, #d5d4d3 100%)');
});
*/

$(document).ready(function() {
	$('#myCarousel').carousel({
	interval: 10000
	})
    
    $('#myCarousel').on('slid.bs.carousel', function() {
    	//alert("slid");
	});
    
    
});

















