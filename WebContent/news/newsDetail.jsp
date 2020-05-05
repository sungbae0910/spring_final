<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<!-- css -->
<link href="../css/all.min.css" rel="stylesheet">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="../css/news.css">
<!-- js -->
<script src="../js/jquery-3.4.1.js"></script>
</head>
<body>
<div id="news_s">
	<div class="container" style="border:1px solid black;">
		<div class="row justify-content-md-center">
			<div class="col" id="hlog">
				<div class="logo_s">
					예제입니당
				</div>
				<a href="#">예제입니당</a>
				<a href="#">예제입니당</a>
				<a href="#">예제입니당</a>
			</div>
		<!-- row -->
		</div>
	<!-- container -->
	</div>
	
	<div class="container" style="border:1px solid black;">
		<div class="row">
			<div class="col-sm">
				<div class="head_s">
					<a href="#"><h2>뉴스</h2></a>
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
	
	<div class="container" style="border:1px solid black;">
		<div class="row">
			<div class="col-sm">
				<nav class="navbar navbar-expand navbar-light">
					<div class="collapse navbar-collapse" id="navbarNav">
						<ul class="navbar-nav">
							<li class="nav-item active">
								<a class="nav-link" href="#">홈</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="#">사회</a>
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

	<div class="container" style="border:1px solid black;">
		<div class="row">
			<div class="col-sm">
				<div id="cSub" class="hcg_media_pc_cSub">
					<div class="head_view">
						<div class="info_cp">아시아경제</div>
						<h3 class="tit_view">박수현, 임종석 불출마 '뒷이야기' 공개...</h3>	
						<span class="info_view">
							<span class="txt_info">강나훔</span>
							<span class="txt_info">입력 2020.05.05. 12:33</span>
							<button id="alexCounter" class="emph_g2 link_cmt">
								댓글<span class="alex-count-area">5</span>개						
							</button>
						</span>				
					</div>
				</div>				
			</div>
		<!-- row -->
		</div>
	<!-- container -->
	</div>
	
	<div class="container" style="border:1px solid black;">
		<div class="row">
			<div class="col-sm-8">
				<div class="news_view">
					<figure class="figure">
						<img src="../image/landscape.jpg" class="figure-img img-fluid rounded" alt="...">
						<figcaption class="figure-caption">A caption for the above image.</figcaption>
					</figure>
					<p>
						(서울=연합뉴스) 강애란 기자 = 정부는 감염병 위기경보 단계를 현재의 '심각'에서 '경계'로 낮추더라도 마스크 5부제 등 신종 
						코로나바이러스 감염증(코로나19) 관련 개별 정책에는 큰 변화가 없을 것이라고 밝혔다.
					</p>	
				</div>
			</div>
			<div class="col-sm-4">
				<div class="hc_news_pc_mAside_popular_news">
					<div class="aside_g aside_popular">
						<div class="top_new_s">
							<h3 class="txt_newsview">많이 본 뉴스</h3>
							<a href="#" class="link_tab link_tab2">뉴스</a>
							<a href="#" class="link_tab link_tab3">연애</a>
							<a href="#" class="link_tab link_tab4">스포츠</a>
						</div>
						<p/>
						<ul class="tab_aside tab_media">
							<li class="on">
								<div class="cont_aside">
									<ol class="list_ranking">
										<c:forEach begin="1" end="10" var="i" varStatus="ii">
											<li>
												<em class="num_newsview num${ii.index}">1</em>
												<strong class="tit_g">
													<a href="#" class="link_txt @${ii.index}">아쩌구저쩌ㅜ구구구국asdasdasasdasdads</a>
												</strong>
											</li>
										</c:forEach>																				
									</ol>
								</div>
							</li>													
						</ul>
					</div>
				</div>
			</div>
		<!-- row -->
		</div>
	<!-- container -->
	</div>


	<div class="container" style="border:1px solid black;">
		<div class="row">
			<div class="col-sm-8">
				<div class="count_comment_s">댓글 48개</div>
				<div class="input-group mb-3">
					<input type="text" class="form-control" placeholder="댓글을 입력해주세요" aria-label="Recipient's username" aria-describedby="button-addon2">
					<div class="input-group-append">
					 	<button class="btn btn-outline-secondary" type="button" id="button-addon2">입력</button>
					</div>
				</div>
				<div class="cmt_box">
					<ul class="list_category">
						<li>추천순</li>
						<li>등록순</li>
					</ul>
				</div>
				<div class="com_to_s">
					<div class="com_body_s">
						<span class="txt_id">강나훔</span>
						<span class="txt_date">2020.05.05. 12:33</span>
						<p class="com_cont_s">asdasdas</p> 
					</div>
					<div class="box_reply">
						<span class="box_inner">
							<button class="reply_count">
								<span>
									<span>답글</span>
									<span class="num_txt">3</span>
								</span>
							</button>
						</span>
						<span class="comment_recomm">
							<button class="btn_g btn_recomm"  style="border: none;">
								<span class="img_cmt ico_recomm bounce">찬성</span>
								<span class="num_txt">200</span>
							</button>
							<button class="btn_g btn_oppose"  style="border: none;">
								<span class="img_cmt ico_oppose bounce">비추천</span>
								<span class="num_txt">5</span>
							</button>
						</span>
					</div>
				</div>
				<div class="com_to_s">
					<div class="com_body_s">
						<span class="txt_id">강나훔</span>
						<span class="txt_date">2020.05.05. 12:33</span>
						<p class="com_cont_s">asdasdas</p> 
					</div>
					<div class="box_reply">
						<span class="box_inner">
							<button class="reply_count">
								<span>
									<span>답글</span>
									<span class="num_txt">3</span>
								</span>
							</button>
						</span>
						<span class="comment_recomm">
							<button class="btn_g btn_recomm"  style="border: none;">
								<span class="img_cmt ico_recomm bounce">찬성</span>
								<span class="num_txt">200</span>
							</button>
							<button class="btn_g btn_oppose"  style="border: none;">
								<span class="img_cmt ico_oppose bounce">비추천</span>
								<span class="num_txt">5</span>
							</button>
						</span>
					</div>
				</div>				
			</div>
		<!-- row -->
		</div>
	<!-- container -->
	</div>



<!-- news_s -->
</div>






<script src="../js/bootstrap.bundle.min.js"></script>
</body>
</html>