<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../sb_music/sb_lib/css/sb_page.css">
</head>
<body id="info_body">

	
	<div class="col-sm-4" id="info_photo">
		<img src="../sb_music/sb_lib/album/${info.album_photo }.PNG" width="200px">
	</div>
	<div class="col-sm-8" id="info_id">
		<span>${info.music_name }</span>
		<br>
		<span>${info.artist_name }</span>
		<br>
		장르<span>${info.genre }</span>
		<br>
		발매사<span>${info.company }</span>
		<br>
		기획사<span>${info.enter }</span>
		<br>
	</div>
	<div class="col-sm-12" id="info_lylics">
		<h3>가사</h3>
		<span>${info.lylics }</span>
	</div>

</body>
</html>