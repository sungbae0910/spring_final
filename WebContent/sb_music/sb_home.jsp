<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

	<div class="container" id="news">
		<header>
			<form>
				<div class="input-group">
					<input type="text" id="search" class="form-control" placeholder="곡 검색">
					<span class="input-group-addon"><img src="../lib/images/wm.png" id="search-left"></span>
				</div>
			</form>
		</header>
		
		
		<!-- 뉴스 -->
		<img src="../lib/images/news.png" width="130px">
		<div id="myCarousel" class="carousel slide">
			<div class="carousel-inner">
				<div class="item active">
					<div class="col-sm-4" onclick="window.open('https://www.hankookilbo.com/News/Read/202004241622343323?NClass=HF04')">
						<img src="../lib/images/rain.jpg">
						<br>
						<span>비 "정지훈"의 데뷔 19년 소감</span>
					</div>
					
					<div class="col-sm-4" onclick="window.open('https://www.sedaily.com/NewsView/1Z1K6ZIB21')">
						<img src="../lib/images/펭수.jpg" >
						<br>
						<span>세계 팽귄의 날을 기념하는 펭수의 첫 디지털 싱글</span>
					</div>
					
					<div class="col-sm-4" onclick="window.open('http://hiphople.com/news_world/16950017')">
						<img src="../lib/images/말론.jpg">
						<br>
						<span>포스트 말론의 'Circle' 빌보드 최장시간 Top10 기록!</span>
					</div>
				</div>
				
				<div class="item">
					<div class="col-sm-4" onclick="window.open('https://www.hankookilbo.com/News/Read/202004221084741333?NClass=HF04')">
						<img src="../lib/images/있지.jpg">
						<br>
						<span>ITZY의 'WANNABE' 뮤직비디오 1억뷰 달성!</span>
					</div>
					
					<div class="col-sm-4" onclick="window.open('https://www.ytn.co.kr/_sn/0117_202004241546155261')">
						<img src="../lib/images/b1a4.jpg" >
						<br>
						<span>B1A4, 데뷔 9주년 랜선 팬미팅 진행</span>
					</div>
					
					<div class="col-sm-4" onclick="window.open('http://www.kukinews.com/news/article.html?no=776295')">
						<img src="../lib/images/ㄷㄷㄷㅈ.jpg" width="310px" height="182px">
						<br>
						<span>머쉬베놈 '두둥등장'</span>
					</div>
				</div>
				<a class="left carousel-control" href="#myCarousel" data-slide="prev">‹</a>
                <a class="right carousel-control" href="#myCarousel" data-slide="next">›</a>
			</div>
		</div>
		
	</div>
	
	<hr>
	
	<div class="container" id="recommend">
		<img src="../lib/images/main_Text1.png" width="250px">
		<div align="center">
			<div class="col-sm-3">
				<img src="../lib/album/오마이걸-nonstop.PNG" width="200px;">
				<br>
				<span>NONSTOP-오마이걸</span>
			</div>
			<div class="col-sm-3">
				<img src="../lib/album/조정석-아로하.PNG" width="200px;">
				<br>
				<span>아로하-조정석</span>
			</div>
			<div class="col-sm-3">
				<img src="../lib/album/방탄-on.PNG" width="200px;">
				<br>
				<span>Map Of The Soul-방탄소년단</span>
			</div>
			<div class="col-sm-3">
				<img src="../lib/album/처음처럼.PNG" width="200px;">
				<br>
				<span>CEREMONIA-M.C The MAX</span>
			</div>
		</div>
	</div>

	<hr>
	
	<!-- top10 -->
	<div class="container" id="top10">
		<img src="../lib/images/top10.png">
		<div id="top10_list">
			<div class="col-sm-2">
				순위
			</div>
			<div class="col-sm-3">
				곡정보
			</div>
			<div class="col-sm-3">
				앨범정보
			</div>
			<div class="col-sm-2">
				듣기
			</div>
			<div class="col-sm-2">
				다운
			</div>
		</div>
		<c:forEach var="v" begin="1" end="10">
			<div id="top10_select">
				<div class="col-sm-2">
					<span>${v}</span> 
				</div>
				<div class="col-sm-3">
					<span>곡 이름${v }</span>
				</div>
				<div class="col-sm-3">
					<span>앨범이름${v }</span>
				</div>
				<div class="col-sm-2">
					<span>듣기</span>
				</div>
				<div class="col-sm-2">
					<span>다운</span>
				</div>
				<hr>
			</div>
			
		</c:forEach>
	
	</div>

</body>
</html>