<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- css -->
<!-- <link href="../css/all.min.css" rel="stylesheet">
<link href="../css/bootstrap.min.css" rel="stylesheet">-->
<link rel="stylesheet" href="../css/bootstrap.css">
<link rel="stylesheet" href="../css/news.css">
<!-- js -->
<script src="../js/jquery-3.4.1.js"></script>
</head>
<body>
<div id="news_s">
	<div class="flu">
		<div class="container cFlu">
			<div class="row justify-content-md-center">
				<div class="col" id="hlog">
					<div class="logo_s">
						예제입니당
					</div>
					<div id="miniUser">
						<a href="#" class="miniUser_login">로그인</a>
					</div>
					<svg class="bi bi-envelope" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
						<path fill-rule="evenodd" d="M14 3H2a1 1 0 00-1 1v8a1 1 0 001 1h12a1 1 0 001-1V4a1 1 0 00-1-1zM2 2a2 2 0 00-2 2v8a2 2 0 002 2h12a2 2 0 002-2V4a2 2 0 00-2-2H2z" clip-rule="evenodd"/>
						<path fill-rule="evenodd" d="M.071 4.243a.5.5 0 01.686-.172L8 8.417l7.243-4.346a.5.5 0 01.514.858L8 9.583.243 4.93a.5.5 0 01-.172-.686z" clip-rule="evenodd"/>
						<path d="M6.752 8.932l.432-.252-.504-.864-.432.252.504.864zm-6 3.5l6-3.5-.504-.864-6 3.5.504.864zm8.496-3.5l-.432-.252.504-.864.432.252-.504.864zm6 3.5l-6-3.5.504-.864 6 3.5-.504.864z"/>
					</svg>
					<svg class="bi bi-grid" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
						<path fill-rule="evenodd" d="M1 2.5A1.5 1.5 0 012.5 1h3A1.5 1.5 0 017 2.5v3A1.5 1.5 0 015.5 7h-3A1.5 1.5 0 011 5.5v-3zM2.5 2a.5.5 0 00-.5.5v3a.5.5 0 00.5.5h3a.5.5 0 00.5-.5v-3a.5.5 0 00-.5-.5h-3zm6.5.5A1.5 1.5 0 0110.5 1h3A1.5 1.5 0 0115 2.5v3A1.5 1.5 0 0113.5 7h-3A1.5 1.5 0 019 5.5v-3zm1.5-.5a.5.5 0 00-.5.5v3a.5.5 0 00.5.5h3a.5.5 0 00.5-.5v-3a.5.5 0 00-.5-.5h-3zM1 10.5A1.5 1.5 0 012.5 9h3A1.5 1.5 0 017 10.5v3A1.5 1.5 0 015.5 15h-3A1.5 1.5 0 011 13.5v-3zm1.5-.5a.5.5 0 00-.5.5v3a.5.5 0 00.5.5h3a.5.5 0 00.5-.5v-3a.5.5 0 00-.5-.5h-3zm6.5.5A1.5 1.5 0 0110.5 9h3a1.5 1.5 0 011.5 1.5v3a1.5 1.5 0 01-1.5 1.5h-3A1.5 1.5 0 019 13.5v-3zm1.5-.5a.5.5 0 00-.5.5v3a.5.5 0 00.5.5h3a.5.5 0 00.5-.5v-3a.5.5 0 00-.5-.5h-3z" clip-rule="evenodd"/>
					</svg>					
				</div>
			<!-- row -->
			</div>
		<!-- container -->
		</div>
	</div>
	
	<div class="container" style="margin-top: 10px;">
		<div class="row">
			<div class="col-sm">
				<div class="head_s">
					<a href="#"><h2 class="head_ch_s">뉴스</h2></a>
					<a href="#"><h2>연예</h2></a>
					<a href="#"><h2>스포츠</h2></a>
				</div>
				<form class="form-inline" id="nMainSearch_s">
					<input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
				</form>
			</div>
		<!-- row -->
		</div>
	<!-- container -->
	</div>
	<hr/>
	
	<div class="container">
		<div class="row">
			<div class="col-sm">
				<nav class="navbar navbar-expand navbar-light">
					<div class="collapse navbar-collapse" id="navbarNav">
						<ul class="navbar-nav">
							<li class="nav-item active">
								<a class="nav-link" href="#" >홈</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="#" style="color: black;">사회</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="#">정치</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="#">경제</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="#">국제</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="#">문화</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="#">IT</a>
							</li>									
						</ul>
					</div>
				</nav>
			</div>
		<!-- row -->
		</div>
	<!-- container -->
	</div>
	<hr/>

	
	<div class="container">
		<div class="row">
			<div class="col-sm-3">
				<div class="to_img_s">
					<img src="../image/sailboat.jpg" class="card-img-top" alt="...">
						<h5 class="card-title">트럼프 "美 코로나 사망자 10만명 될 것..중국 은폐 끔찍해"</h5>
						<small class="text-muted">Last updated 3 mins ago</small>
						<!-- 관련 뉴스 -->
						<div class="re_new_s" style="padding-top: 10px;">
							<span>트럼프 "美 코로나 사망자 10만명 될 것..중국 은폐 끔찍해"</span>
							<small class="text-muted">머니투데이</small>
						</div>
						<!-- 관련 뉴스 -->
						<div class="re_new_s" style="padding-top: 10px;">
							<span>트럼프 "美 코로나 사망자 10만명 될 것..중국 은폐 끔찍해"</span>
							<small class="text-muted">머니투데이</small>
						</div>						
				</div>
			</div>
			<div class="col-sm-3">
				<div class="to_img_s">
					<img src="../image/sailboat.jpg" class="card-img-top" alt="...">
						<h5 class="card-title">트럼프 "美 코로나 사망자 10만명 될 것..중국 은폐 끔찍해"</h5>
						<small class="text-muted">Last updated 3 mins ago</small>
						<!-- 관련 뉴스 -->
						<div class="re_new_s" style="padding-top: 10px;">
							<span>트럼프 "美 코로나 사망자 10만명 될 것..중국 은폐 끔찍해"</span>
							<small class="text-muted">머니투데이</small>
						</div>
						<!-- 관련 뉴스 -->
						<div class="re_new_s" style="padding-top: 10px;">
							<span>트럼프 "美 코로나 사망자 10만명 될 것..중국 은폐 끔찍해"</span>
							<small class="text-muted">머니투데이</small>
						</div>						
				</div>
			</div>
			<div class="col-sm-3">
				<div class="to_img_s">
					<img src="../image/sailboat.jpg" class="card-img-top" alt="...">
						<h5 class="card-title">트럼프 "美 코로나 사망자 10만명 될 것..중국 은폐 끔찍해"</h5>
						<small class="text-muted">Last updated 3 mins ago</small>
						<!-- 관련 뉴스 -->
						<div class="re_new_s" style="padding-top: 10px;">
							<span>트럼프 "美 코로나 사망자 10만명 될 것..중국 은폐 끔찍해"</span>
							<small class="text-muted">머니투데이</small>
						</div>
						<!-- 관련 뉴스 -->
						<div class="re_new_s" style="padding-top: 10px;">
							<span>트럼프 "美 코로나 사망자 10만명 될 것..중국 은폐 끔찍해"</span>
							<small class="text-muted">머니투데이</small>
						</div>						
				</div>
			</div>
			<div class="col-sm-3">
				<div class="to_img_s">
					<img src="../image/sailboat.jpg" class="card-img-top" alt="...">
						<h5 class="card-title">트럼프 "美 코로나 사망자 10만명 될 것..중국 은폐 끔찍해"</h5>
						<small class="text-muted">Last updated 3 mins ago</small>
						<!-- 관련 뉴스 -->
						<div class="re_new_s" style="padding-top: 10px;">
							<span>트럼프 "美 코로나 사망자 10만명 될 것..중국 은폐 끔찍해"</span>
							<small class="text-muted">머니투데이</small>
						</div>
						<!-- 관련 뉴스 -->
						<div class="re_new_s" style="padding-top: 10px;">
							<span>트럼프 "美 코로나 사망자 10만명 될 것..중국 은폐 끔찍해"</span>
							<small class="text-muted">머니투데이</small>
						</div>						
				</div>
			</div>									
		<!-- row -->
		</div>
	<!-- container -->
	</div>
	<hr/>
	
	
	
	<div class="container">
		<div class="row" id="li_news_s">
			<div class="col-sm-8">
				<nav class="navbar navbar-expand navbar-light">
					<div class="" id="navbarNav">
						<ul class="list_headline">
							<li class="item_main float-right" style="margin-left: 20px;">
								<a href="#" class="link_cont">
									<span class="wrap_thumb">
										<img src="../image/sailboat.jpg" class="img-responsive">
										<strong class="tit_g">
											asdasdasdasdasdasdds
										</strong>
									</span>
								</a>								
							</li>						
							<li>
								<strong class="tit_g">
									<a class="link_txt" href="#">wtaweouitawhtaiuwehtal;wetiha;whtiawtha;wtha;wtata;taet</a><span class="info_news_s"> 머니투데이</span>
								</strong>
							</li>
							<li>
								<strong class="tit_g">
									<a class="link_txt" href="#">홈</a><span class="info_news_s"> 머니투데이</span>
								</strong>
							</li>
							<li>
								<strong class="tit_g">
									<a class="link_txt" href="#">홈</a><span class="info_news_s"> 머니투데이</span>
								</strong>								
							</li>
							<li>
								<strong class="tit_g">
									<a class="link_txt" href="#">홈</a><span class="info_news_s"> 머니투데이</span>
								</strong>								
							</li>
						</ul>
						<hr/>
						<ul class="list_headline">
							<li class="item_main float-right" style="margin-left: 20px;">
								<a href="#" class="link_cont">
									<span class="wrap_thumb">
										<img src="../image/sailboat.jpg" class="img-responsive">
										<strong class="tit_g">
											asdasdasdasdasdasdds
										</strong>
									</span>
								</a>								
							</li>						
							<li>
								<strong class="tit_g">
									<a class="link_txt" href="#">wtaweouitawhtaiuwehtal;wetiha;whtiawtha;wtha;wtata;taet</a><span class="info_news_s"> 머니투데이</span>
								</strong>
							</li>
							<li>
								<strong class="tit_g">
									<a class="link_txt" href="#">홈</a><span class="info_news_s"> 머니투데이</span>
								</strong>
							</li>
							<li>
								<strong class="tit_g">
									<a class="link_txt" href="#">홈</a><span class="info_news_s"> 머니투데이</span>
								</strong>								
							</li>
							<li>
								<strong class="tit_g">
									<a class="link_txt" href="#">홈</a><span class="info_news_s"> 머니투데이</span>
								</strong>								
							</li>
						</ul>
						<hr/>
						<ul class="list_headline">
							<li class="item_main float-right" style="margin-left: 20px;">
								<a href="#" class="link_cont">
									<span class="wrap_thumb">
										<img src="../image/sailboat.jpg" class="img-responsive">
										<strong class="tit_g">
											asdasdasdasdasdasdds
										</strong>
									</span>
								</a>								
							</li>						
							<li>
								<strong class="tit_g">
									<a class="link_txt" href="#">wtaweouitawhtaiuwehtal;wetiha;whtiawtha;wtha;wtata;taet</a><span class="info_news_s"> 머니투데이</span>
								</strong>
							</li>
							<li>
								<strong class="tit_g">
									<a class="link_txt" href="#">홈</a><span class="info_news_s"> 머니투데이</span>
								</strong>
							</li>
							<li>
								<strong class="tit_g">
									<a class="link_txt" href="#">홈</a><span class="info_news_s"> 머니투데이</span>
								</strong>								
							</li>
							<li>
								<strong class="tit_g">
									<a class="link_txt" href="#">홈</a><span class="info_news_s"> 머니투데이</span>
								</strong>								
							</li>
						</ul>
					</div>
				</nav>
			</div>
			<div class="col-sm-4" style="border-left: 1px solid #d2cfcf;">
				<div class="card">
					<img src="../image/sailboat.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Card title</h5>
						<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
					</div>
				</div>
			</div>			
		<!-- row -->
		</div>
		<hr/>
	<!-- container -->
	</div>
	
		
	<div class="container">
		<div class="row">
			<div class="col-sm-2">
				
			</div>
			<div class="col-sm-2">
				<div class="ma_img_s">
					<img src="../image/landscape.jpg">
					<span class="tit_s">asdadasadadadsdasdsd</span>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="ma_img_s">
					<img src="../image/landscape.jpg">
					<span class="tit_s">asdadasadadadsdasdsd</span>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="ma_img_s">
					<img src="../image/landscape.jpg">
					<span class="tit_s">asdadasadadadsdasdsd</span>
				</div>
			</div>
			<div class="col-sm-2">
				<div class="ma_img_s">
					<img src="../image/landscape.jpg">
					<span class="tit_s">asdadasadadadsdasdsd</span>
				</div>
			</div>
			<div class="col-sm-2">
				
			</div>													
		<!-- row -->
		</div>
		<hr/>
	<!-- container -->
	</div>	

	
	<div class="container">
		<div class="row justify-content-md-center">
			<div class="col-sm-8" >
				<div class="pop_news pop_perus" style="margin-top: 20px;">
					<h3 class="tit_news">댓글 많은 뉴스</h3>
					<ol class="list_popcmt">
						<li>
							<a href="#" class="link_txt">
								<span class="num_news num1">1위</span>
								"총선 역대급 패배에도 변화업는 보수 '왕따'될 수도"
							</a>
							<span class="info_news">서울신문</span>
						</li>
						<li>
							<a href="#" class="link_txt">
								<span class="num_news num2">1위</span>
								"총선 역대급 패배에도 변화업는 보수 '왕따'될 수도"
							</a>
							<span class="info_news">서울신문</span>
						</li>
						<li>
							<a href="#" class="link_txt">
								<span class="num_news num3">1위</span>
								"총선 역대급 패배에도 변화업는 보수 '왕따'될 수도"
							</a>
							<span class="info_news">서울신문</span>
						</li>
						<li>
							<a href="#" class="link_txt">
								<span class="num_news num4">1위</span>
								"총선 역대급 패배에도 변화업는 보수 '왕따'될 수도"
							</a>
							<span class="info_news">서울신문</span>
						</li>
						<li>
							<a href="#" class="link_txt">
								<span class="num_news num5">1위</span>
								"총선 역대급 패배에도 변화업는 보수 '왕따'될 수도"
							</a>
							<span class="info_news">서울신문</span>
						</li>																								
					</ol>
				</div>			
				<div class="pop_news pop_cmt">
					<h3 class="tit_news">댓글 많은 뉴스</h3>
					<ol class="list_popcmt">
						<li>
							<a href="#" class="link_txt">
								<span class="num_news num1">1위</span>
								"총선 역대급 패배에도 변화업는 보수 '왕따'될 수도"
							</a>
							<span class="info_news">서울신문</span>
						</li>
						<li>
							<a href="#" class="link_txt">
								<span class="num_news num2">1위</span>
								"총선 역대급 패배에도 변화업는 보수 '왕따'될 수도"
							</a>
							<span class="info_news">서울신문</span>
						</li>
						<li>
							<a href="#" class="link_txt">
								<span class="num_news num3">1위</span>
								"총선 역대급 패배에도 변화업는 보수 '왕따'될 수도"
							</a>
							<span class="info_news">서울신문</span>
						</li>
						<li>
							<a href="#" class="link_txt">
								<span class="num_news num4">1위</span>
								"총선 역대급 패배에도 변화업는 보수 '왕따'될 수도"
							</a>
							<span class="info_news">서울신문</span>
						</li>
						<li>
							<a href="#" class="link_txt">
								<span class="num_news num5">1위</span>
								"총선 역대급 패배에도 변화업는 보수 '왕따'될 수도"
							</a>
							<span class="info_news">서울신문</span>
						</li>																								
					</ol>
				</div>
				<div class="pop_news pop_age">
					<h3 class="tit_news"></h3>
					<div class="agenews_list">
						<span class="txt_news ico_female">여성</span>
						<ul class="list_agenews list_female">
							<li>
								<span class="txt_news ico_age20">20대</span>
								<a href="#" class="link_txt">국뽕코인이 뭐길래 외국어쩌구</a>
							</li>
							<li>
								<span class="txt_news ico_age30">30대</span>
								<a href="#" class="link_txt">국뽕코인이 뭐길래 외국어쩌구</a>
							</li>
							<li>
								<span class="txt_news ico_age40">40대</span>
								<a href="#" class="link_txt">국뽕코인이 뭐길래 외국어쩌구</a>
							</li>
							<li>
								<span class="txt_news ico_age50">50대</span>
								<a href="#" class="link_txt">국뽕코인이 뭐길래 외국어쩌구</a>
							</li>	 																				
						</ul>
					</div>
					<div class="agenews_list">
						<span class="txt_news ico_male">남성</span>
						<ul class="list_agenews list_male">
							<li>
								<a href="#" class="link_txt">국뽕코인이 뭐길래 외국어쩌구</a>
							</li>
							<li>
								<a href="#" class="link_txt">국뽕코인이 뭐길래 외국어쩌구</a>
							</li>
							<li>
								<a href="#" class="link_txt">국뽕코인이 뭐길래 외국어쩌구</a>
							</li>
							<li>
								<a href="#" class="link_txt">국뽕코인이 뭐길래 외국어쩌구</a>
							</li>																					
						</ul>
					</div>	
				</div>
			</div>
			<div class="col-sm-4" style="border-left: 1px solid #d2cfcf;">
				<div class="card">
					<img src="../image/sailboat.jpg" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">Card title</h5>
						<p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
					</div>
				</div>
			</div>
		<!-- row -->
		</div>
	<!-- container -->
	</div>
	
	
	
	
	
<!-- news_s -->
</div>

<script src="../js/bootstrap.bundle.js"></script>
<!-- <script src="../js/bootstrap.bundle.min.js"></script> -->
</body>
</html>