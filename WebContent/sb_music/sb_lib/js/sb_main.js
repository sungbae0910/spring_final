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
var audio = new Audio();   


$('#playBar').hide();
$('#album').hide();

play = function(serial){
	frm_top.m_serial.value = serial;
	let param = $('#frm_top').serialize();
	$.post('sb_play.mu', param, function(data){
		
		
		$('#navBody').empty();
		$('#navBody').append(data);
		
		$('#playBar').show();
		$('#album').show();
		
		$('#playBarD').hide();
		$('#albumD').hide();
		
		$("#show_list").hide();
		$("#playerImg").hide();
		

		audio.src =("../sb_music/sb_lib/music/" + $('#audioH').val() + ".MP3");
		
		
		
	});
}

var topP = function(){
	$('#changePage').load('sb_top.mu');
}

function nice(){
	alert(audio.src);
}



function player(){
	  audio.pause(); // 시작할때 다른 음악 끄기
	  var playBtn = document.getElementById("play-button");
	  var progressBar = document.getElementById("progress-bar");
	  
	  
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
		$('#btn_play').attr("src","../sb_music/sb_lib/images/pause.png");
		playing=true;
	  });
	  audio.addEventListener("pause",(e)=>{    
		$('#btn_play').attr("src","../sb_music/sb_lib/images/play.png");
	   
	    playing=false;
	  });
	  audio.addEventListener("canplay",()=>{
	    duration = audio.duration;
	    progressBar.min =0;
	    progressBar.max= duration;    
	  });
	  
	  
	 /* $('#play-button').click(function(){
		if(playing){
			  audio.play();
		}
		
		  
	  })*/
	  
	  
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


function showVolume(vol){
	var view = document.getElementById("now-vol");
	view.innerHTML = vol;
	
	var now = audio.volume = vol/100;
	
	if(now > 0){
		$("#sound").attr("src","../sb_music/sb_lib/images/vol1.png");
	}else{
		$("#sound").attr("src","../sb_music/sb_lib/images/vol2.png");
	}
}



var nav_flag = 0;
$("#show_list").hide();
$("#playerImg").hide();
function nav_list(){
	if(nav_flag == 0){
		$("#show_list").hide(1000);
		$("#playerImg").hide(1000);
		nav_flag = 1;
	}else{
		$("#show_list").show(1000);
		$("#playerImg").show(1000);
		nav_flag = 0;
	}
	
}




$(document).ready(function() {
	
	$("#music_tb tbody").sortable({
		update: function(event, ui){
			$(this).children().each(function(index){
				$(this).find('td').first().html(index + 1);
				$(this).find('td').first().css("color", "white");
				$(this).find('td').first().css("font-weight", "bold");
				$(this).find('td').first().css("font-size", "16px");
				$(this).find('td').first().css("text-shadow", "0 0 2px #F7819F");
			})
		}
	})
	

	
	
	$('#myCarousel').carousel({
	interval: 10000
	})
    
    $('#myCarousel').on('slid.bs.carousel', function() {
    	//alert("slid");
	});
});










/*$('input[type=range]').on('input', function(){
    var val = $(this).val();
    $(this).css('background', 'linear-gradient(to right, dodgerblue 0%, dodgerblue '+ val +'%, #d5d4d3 ' + val + '%, #d5d4d3 100%)');
});
*/










