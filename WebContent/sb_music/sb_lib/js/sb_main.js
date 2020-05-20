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

play = function(serial){ // 듣기 눌렀을 때
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
		
		player();
		$('#play-button').click();
		
	});
}

kimchi = function(serial){ // 담기 눌렀을 때
	frm_top.m_serial.value = serial;
	let param = $('#frm_top').serialize();
	
	$.post('sb_kimchi.mu', param, function(data){
		console.log(data);
		alert(data);
	});
	
	$('#alert').show();
}

var topP = function(){
	$('#changePage').load('sb_top.mu');
}

function nice(){ // 나중에 지우자궁
	alert(audio.src);
}

function audioBtn(num){ // 전노래 다음노래 버튼
	frm_top.m_serial.value = serial;
	let param = $('#frm_top').serialize();
	
	if(num == 1){
		$.ajax({
			url : 'sb_prevMusic.mu',
			data : param,
			type: 'POST',
			dataType: "json",
			success : function(data){
				
				
				
				
			}
		});		
		
	}else if(num == 2){
		$.ajax({
			url : 'sb_nextMusic.mu',
			data : param,
			type: 'POST',
			dataType: "json",
			success : function(data){
				
				
				
				
				
			}
		});		
		
		
		
	}
}

function getTime(t){
	var m=~~(t/60), s=~~(t % 60);
	return (m<10?"0"+m:m)+':'+(s<10?"0"+s:s);
	
}

var time = $('#start-time');

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
	        
	        time.text(getTime(audio.currentTime));
	        
	  });
	  audio.addEventListener("ended",(e)=>{
	    progressBar.value = 0;
	    
		$('#btn_play').attr("src","../sb_music/sb_lib/images/play.png");
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
	playList();
}


var cnt = 0;
var str;

function playList(){
	let param = $('#frm_top').serialize();
	str = '';
	$.ajax({
		url : 'sb_playList.mu',
		data : param,
		type: 'POST',
		dataType: "json",
		success : function(data){
			var tbody = $('#pl_tbody');
			cnt = 0;
			$('#list_val').empty();
			
			$('#pl_tbody').empty();
			
			
			$.each( data,function(index , val){
				tbody.append(
						"<tr id='changing' onmouseup='ChDrag()'>" +
						"<td> <span>" + index + "</span> </td>" +
						"<td> <img src='../sb_music/sb_lib/album/" + val.album_photo + ".PNG' width='55px' id='tplay'>" +
						" <img src='../sb_music/sb_lib/images/start.png' id='hiddenStart" + index + "' class='hiddenStart' onclick='play("+ val.music_serial +")'> " + 
						"</td>" +
						"<td> <span>" + val.music_name + "</span>" +
						"<br>" +
						"<span>" + val.artist_name + "</span> </td>" +
						"<td> <span id='tb_delete' onclick='delList(" + val.music_serial + ")'>X</span>" +
						"</td>" +
						"</tr>"
						
				)
				
				str += val.music_serial + ',';
				cnt++;
				
			})
			
			$('#listV').val(str);
			
			console.log($('#listV').val());
			
			
		},
		error : function(request, status, error){
			alert(request.status + "\n에러메시지:" + error);
		}
		
	})
}


function delList(serial){
	frm_top.m_serial.value = serial;
	let param = $('#frm_top').serialize();
	str = '';
	
	$.ajax({
		url : 'sb_delList.mu',
		data: param,
		type: 'POST',
		dataType: "json",
		success : function(data){
			cnt = 0;
			var tbody = $('#pl_tbody');
			cnt = 0;
			$('#list_val').empty();
			
			$('#pl_tbody').empty();
			
			
			$.each( data,function(index , val){
				
				tbody.append(
						"<tr id='changing' onmouseup='ChDrag()'>" +
						"<td> <span>" + index + "</span> </td>" +
						"<td> <img src='../sb_music/sb_lib/album/" + val.album_photo + ".PNG' width='55px' id='tplay'>" +
						" <img src='../sb_music/sb_lib/images/start.png' id='hiddenStart" + index + "' class='hiddenStart' onclick='play("+ val.music_serial +")'> " + 
						"</td>" +
						"<td> <span>" + val.music_name + "</span>" +
						"<br>" +
						"<span>" + val.artist_name + "</span> </td>" +
						"<td> <span id='tb_delete' onclick='delList(" + val.music_serial + ")'>X</span>" +
						"</td>" +
						"</tr>"
						
				)
				
				str += val.music_serial + ',';
				cnt++;
			})
			
			$('#listV').val(str);
			
			console.log(tbody.html);
			console.log($('#listV').val());
		},
		
		error: function(request, status, error){
			alert(request.status + "\n에러메시지:" + error);
		}
		
		
	})
}



function ChDrag(){
	console.log("chdrag");
	let param = $('#frm_top').serialize();
	str = '';
	
	$.post('sb_ChDrag.mu', param, function(data){
		
		console.log("변경 된거같지?")
		
	});
	
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
	
	$('#list_val').hide();
	
	
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










