<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<div id="movie">
	<p id="movie_top">���� ����</p>

	<iframe width="1161" height="653" src="${movie.music_video}" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
	
	<p id="movie_title">[MV] ${movie.music_name }</p>

</div>


</body>
</html>