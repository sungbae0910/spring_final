<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>News HTML-5 Template</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" type="image/x-icon" href="./img/favicon.ico">

<!-- CSS here -->
<link rel="stylesheet" href="./css/bootstrap.min.css">
<link rel="stylesheet" href="./css/owl.carousel.min.css">
<link rel="stylesheet" href="./css/ticker-style.css">
<link rel="stylesheet" href="./css/flaticon.css">
<link rel="stylesheet" href="./css/slicknav.css">
<link rel="stylesheet" href="./css/animate.min.css">
<link rel="stylesheet" href="./css/magnific-popup.css">
<link rel="stylesheet" href="./css/fontawesome-all.min.css">
<link rel="stylesheet" href="./css/themify-icons.css">
<link rel="stylesheet" href="./css/slick.css">
<link rel="stylesheet" href="./css/nice-select.css">
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/responsive.css">
<link rel="stylesheet" href="./css/newsTemp.css">

<!-- js -->
<script src="./js/jquery-3.4.1.js"></script>
<script src="./js/news.js"></script>
</head>
<body>
<form id="tes_s" method="post">
	<input type="hidden" name="nCategory" class="nCategory"/>
	<input type="hidden" name="nSerial" class="nSerial" value="${vo.nSerial }"/>
	<input type="hidden" name="mName" value="${sessionScope.mName}"/>
	<input type="hidden" name="cSerial" class="cSerial"/>
	<input type="hidden" name="indent" class="cIndent"/>
	<input type="hidden" name="cGroup" class="cGroup"/>
	<input type="hidden" name="reContent" class="reContent"/>
	<input type="hidden" name="nowPage" value="${p.nowPage}" class="nowPage"/>
	<!-- Preloader Start -->
	<div id="preloader-active">
		<div
			class="preloader d-flex align-items-center justify-content-center">
			<div class="preloader-inner position-relative">
				<div class="preloader-circle"></div>
				<div class="preloader-img pere-text">
					<img src="./img/logo/logo.png" alt="">
				</div>
			</div>
		</div>
	</div>
	<!-- Preloader Start -->

	<header>
		<!-- Header Start -->
		<div class="header-area">
			<div class="main-header ">
				<div class="header-top black-bg d-none d-md-block">
					<div class="container">
						<div class="col-xl-12">
							<div
								class="row d-flex justify-content-between align-items-center">
								<div class="header-info-left">
									<ul>
										<li><img src="./img/icon/header_icon1.png" alt="">34ºc,Sunny</li>
										<li><img src="./img/icon/header_icon1.png" alt="">Tuesday,18th June, 2019</li>
									</ul>
								</div>
                                <div class="header-info-right">
                                    <ul class="header-social">    
                                        <li><a href="#"><img src="./img/icon/insta_s.png" style="width:25px; height:25px;"></a></li>
                                        <li><a href="#"><img src="./img/icon/blog_s.png" style="width:25px; height:25px;"></a></li>
                                    </ul>
                                </div>								
							</div>
						</div>
					</div>
				</div>
				<div class="header-mid d-none d-md-block">
					<div class="container">
						<div class="row d-flex align-items-center">
							<!-- Logo -->
							<div class="col-xl-3 col-lg-3 col-md-3">
								<div class="logo">
									<a href="newsMainT.jsp"><!-- <img src="./img/logo/logo.png"alt=""> --></a>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="header-bottom header-sticky">
					<div class="container">
						<div class="row align-items-center">
							<div class="col-xl-10 col-lg-10 col-md-12 header-flex">
								<!-- sticky -->
								<div class="sticky-logo">
									<a href="newsMainT.jsp"><!-- <img src="./img/logo/logo.png"alt=""> --></a>
								</div>
								<!-- Main-menu -->
								<div class="main-menu d-none d-md-block">
									<nav>
										<ul id="navigation">
											<li><a href="newsMainT.jsp">홈</a></li>
											<li><a href="categori.html">사회</a></li>
											<li><a href="about.html">정치</a></li>
											<li><a href="latest_news.html">경제</a></li>
											<li><a href="contact.html">국제</a></li>
											<li><a href="contact.html">문화</a></li>
											<li><a href="#">IT</a></li>
										</ul>
									</nav>
								</div>
							</div>
							<!-- Mobile Menu -->
							<div class="col-12">
								<div class="mobile_menu d-block d-md-none"></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Header End -->
	</header>

	<main> <!-- About US Start -->
	<div class="container" style="padding-top: 15px;">
		<div class="row">
			<div class="col-sm">
				<div id="cSub" class="hcg_media_pc_cSub">
					<div class="head_view">
						<div class="info_cp">${vo.nCompany}</div>
						<h3 class="tit_view">${vo.nTitle }</h3>	
						<span class="info_view">
							<span class="txt_info">${vo.nRepoter}</span>
							<fmt:formatDate value="${vo.nDate}" pattern="yyyy-MM-dd" var="fmtDate"/>
							<span class="txt_info">${fmtDate}</span>
							<button type="button" id="alexCounter" class="emph_g2 link_cmt">
								댓글						
							</button>
						</span>				
					</div>
				</div>				
			</div>
		<!-- row -->
		</div>
	<!-- container -->
	<hr/>
	</div>	
	<div class="about-area">
		<div class="container">
			<!-- Hot Aimated News Tittle-->
			<div class="row">
				<div class="col-lg-8">
					<!-- Trending Tittle -->
					<div class="about-right mb-90">
						<figure class="figure">
							<img src="./img/newsImages/${vo.photos[0].pName}"
								class="figure-img img-fluid rounded" alt="...">
							<figcaption class="figure-caption">${vo.photos[0].pContent }</figcaption>
						</figure>
						<div class="about-prea">
							<p class="about-pera1 mb-25">${vo.nContent }</p>
						</div>
					</div>
					<!-- From -->
					<!-- 댓글 입력창 -->
					<div id="news_comment_s">
						<div class="count_comment_s">
							<h5>${cnt}개</h5>
						</div>
						<div class="input-group mb-3">
							<input type="text" name="content" id="cC_s" class="form-control cContent" placeholder="댓글을 입력해주세요"/>
							<div class="input-group-append">
								<button class="btn btn-outline-secondary" type="button"
									id="button-addon2" onclick="news_comment()">입력</button>
							</div>
						</div>
						<div class="cmt_box">
							<ul class="list_category">
								<li>추천순</li>
								<li>등록순</li>
							</ul>
						</div>
						<div id="commnet_s">
							<div class="comments-area">
							<c:forEach var="i" items="${comment}" varStatus="ii">
							<fmt:formatDate value="${i.cDate}" var="fmtDate" pattern="yyyy-MM-dd"/>
							<c:set var="indent" value="${i.cIndent }"/>
							<c:set var="index" value="${ii.index }"/>
							<c:set var="group" value="${i.cGroup}"/>
								<c:if test="${indent eq 0}">
								<input type="hidden" value="${i.cSerial}" class="serial${ii.index}">
								<input type="hidden" value="${i.cIndent}" class="indent${ii.index}">
								<input type="hidden" value="${i.cGroup}" class="cg${ii.index}"/>
								<div class="comment-list">
									<div class="single-comment justify-content-between d-flex">
										<div class="user justify-content-between d-flex">
											<div class="desc">
												<div class="d-flex justify-content-between">
													<div class="d-flex align-items-center">
														<h5>
															<a href="#">${i.mName}</a>
														</h5>
														<p class="date">${fmtDate}</p>
													</div>
												</div>
												<p class="comment">${i.cContent}</p>
												<div class="d-flex justify-content-between">
														<div class="reply-btn reply_count${ii.index}" onclick='hide_come(${ii.index})'>
																	답글
														</div>
												</div>
											</div>
										</div>
										<div class="test_s">
											<div class="dropdown img_cmt2">
												<a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
													<img src="./img/icon/vertical-dots.png" > 
												</a>
												<div class="dropdown-menu" style="min-width: 5rem" aria-labelledby="dropdownMenuLink">
													<a class="dropdown-item" href="#" onclick="news_comment_delete('${ii.index}','${i.cGroup}')">삭제</a>
												</div>
											</div>									
											<div>
												<br />
												<br />
											</div>
											<div>
												<span class="comment_recomm" style="float: right;">
													<c:choose>
														<c:when test="${not empty sessionScope.mName}">
															<button type="button" class="btn_g btn_recomm" onclick="like_func_s(${ii.index})" style="border: none; cursor: pointer;">
																<span class="img_cmt ico_recomm bounce"><img class="recomm${ii.index}" src="./img/news/unlike.png" style="width: 18px; height: 18px;"></span>
																<span class="num_txt num_txtr${ii.index}">
																	${i.cLike}
																</span>
															</button>
														</c:when>
														<c:otherwise>
															<button type="button" class="btn_g btn_recomm" onclick="login_s()" style="border: none; cursor: pointer;">
																<span class="img_cmt ico_recomm bounce"><img src="./img/news/unlike.png" style="width: 18px; height: 18px;"></span> 
																<span class="num_txt">
																	${i.cLike}
																</span>
															</button>
														</c:otherwise>
													</c:choose>
													<c:choose>
														<c:when test="${not empty sessionScope.mName}">
															<button type="button" class="btn_g btn_oppose" onclick="diLike_func_s(${ii.index})" style="border: none; cursor: pointer;">
																<span class="img_cmt ico_oppose bounce"><img class="oppose${ii.index}" src="./img/news/like.png" style="width: 18px; height: 18px;"></span> 
																<span class="num_txt num_txto${ii.index}">
																	${i.cDiLike}
																</span>
															</button>
														</c:when>
														<c:otherwise>
															<button type="button" class="btn_g btn_oppose" onclick="login_s()" style="border: none; cursor: pointer;">
																<span class="img_cmt ico_oppose bounce"><img src="./img/news/like.png" style="width: 18px; height: 18px;"></span> 
																<span class="num_txt">
																	${i.cDiLike}
																</span>
															</button>
														</c:otherwise>
													</c:choose>
												</span>
											</div>
										</div>
									</div>
								</div>
								<!-- 대댓글 시작-->
								</c:if>
								<div class="hide_comment${index} hide_come">
									<div class="comment-list2">
										<div class="input-group mb-3" style="padding-top: 5px;">
											<input type="text" id="cC_s2" class="form-control reC${ii.index}" placeholder="댓글을 입력해주세요" aria-label="Recipient's username" aria-describedby="button-addon2">
											<div class="input-group-append">
												<button class="btn btn-outline-secondary" type="button" id="button-addon2" onclick="news_re_comment(${ii.index})">입력</button>
											</div>
										</div>
										<c:forEach items="${reComment}" var="re" varStatus="ri">
										<fmt:formatDate value="${re.cDate}" var="reDate" pattern="yyyy-MM-dd"/>
										<c:set var="reGroup" value="${re.cGroup }"/>
										<c:if test="${reGroup eq group }">
										<input type="hidden" value="${re.cSerial}" class="sserial${ri.index}">
										<input type="hidden" value="${re.cIndent}" class="iindent${ri.index}">
										<div class="single-comment justify-content-between d-flex">
											<div class="user justify-content-between d-flex">
												<div class="desc">
													<div class="d-flex justify-content-between">
														<svg class="bi bi-arrow-return-right" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
													<path fill-rule="evenodd" d="M10.146 5.646a.5.5 0 01.708 0l3 3a.5.5 0 010 .708l-3 3a.5.5 0 01-.708-.708L12.793 9l-2.647-2.646a.5.5 0 010-.708z" clip-rule="evenodd" />
													<path fill-rule="evenodd" d="M3 2.5a.5.5 0 00-.5.5v4A2.5 2.5 0 005 9.5h8.5a.5.5 0 000-1H5A1.5 1.5 0 013.5 7V3a.5.5 0 00-.5-.5z"clip-rule="evenodd" />
												</svg>
														<div class="d-flex align-items-center">
															<h5>
																<a href="#">${re.mName}</a>
															</h5>
															<p class="date">${reDate}</p>
														</div>
													</div>
													<p class="comment">${re.cContent }</p>
												</div>
											</div>
											<!-- 삭제버튼 -->
											<div class="dropdown img_cmt2">
												<a class="" href="#" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
													<img src="./img/icon/vertical-dots.png" > 
												</a>
												<div class="dropdown-menu" style="min-width: 5rem" aria-labelledby="dropdownMenuLink">
													<a class="dropdown-item" href="#" onclick="news_comment_deletes('${ri.index}')">삭제</a>
												</div>
											</div>
											<!-- 삭제버튼  끝-->
										</div>
										<hr class="hr_s" />
										</c:if>
										</c:forEach>
									</div>
								</div>
								<!-- 대댓글 끝-->
							</c:forEach>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4">
					<!-- New Poster -->
					<!-- Detial Side 영역 -->
					<div id="detail_side_s">
						<aside class="single_sidebar_widget post_category_widget d-none d-lg-block">
							<div class="top_view_s">
								<h3 class="widget_title">많이 본 뉴스</h3>
								<div class="view_sub_s">
									<span onclick="news_detail_side('경제')">경제</span>
									<span onclick="news_detail_side('정치')">정치</span>
									<span onclick="news_detail_side('IT')">IT</span>
								</div>
							</div>
							<div class="">
								<ol class="ordered-list">
									<c:forEach var="i" items="${list}" varStatus="ii">
										<li onclick="news_detail('${ii.index}')">
											<span>${i.nTitle}</span>
											<input type="hidden" value="${i.nSerial}" class="serial${ii.index}"/>
										</li>
									</c:forEach>
								</ol>
							</div>
						</aside>						
					</div>
					<!-- Detail Side 영역 -->					
					<div class="news-poster d-none d-lg-block">
						<img src="./img/news/news_card.jpg" alt="">
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- About US End --> 
	<!--Start pagination -->
	<div class="pagination-area pb-45 text-center">
		<div class="container">
			<div class="row">
				<div class="col-xl-8">
					<div class="single-wrap d-flex justify-content-center">
						<nav aria-label="Page navigation example">
							<ul class="pagination justify-content-start">
								<c:if test="${p.startPage>p.blockSize }">
									<li class="page-item"><a class="page-link" href="#" onclick="comment_go(${p.startPage-1})"><img src="./img/news/previous.png" alt=""></a></li>
								</c:if>
								
								<c:forEach var="i" begin="${p.startPage}" end="${p.endPage}" varStatus="ii">
									<li class="page-item ${(i==1)?'active':''}"><a class="page-link" href="#" onclick="comment_go(${i},${ii.index})">${i}</a></li>
								</c:forEach>
								
								<c:if test="${p.endPage<p.totPage}">
									<li class="page-item"><a class="page-link" href="#" onclick="comment_go(${p.endPage+1})"><img src="./img/news/next.png" alt=""></a></li>
								</c:if>
							</ul>
						</nav>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- End pagination  --> 
	</main>

	<footer>
		<!-- Footer Start-->
		<!-- footer-bottom aera -->
		<div class="footer-bottom-area">
			<div class="container">
				<div class="footer-border">
					<div class="row d-flex align-items-center justify-content-between">
						<div class="col-lg-6">
							<div class="footer-copy-right">
								<p>
									<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
									Copyright &copy;
									<script>document.write(new Date().getFullYear());</script>
									All rights reserved | This template is made with <i
										class="ti-heart" aria-hidden="true"></i> by <a
										href="https://colorlib.com" target="_blank">Colorlib</a>
									<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
								</p>
							</div>
						</div>
						<div class="col-lg-6">
							<div class="footer-menu f-right">
								<ul>
									<li><a href="#">Terms of use</a></li>
									<li><a href="#">Privacy Policy</a></li>
									<li><a href="#">Contact</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Footer End-->
	</footer>
</form>
	<!-- JS here -->

	<!-- All JS Custom Plugins Link Here here -->
	<script src="./js/vendor/modernizr-3.5.0.min.js"></script>

	<!-- Jquery, Popper, Bootstrap -->
	<script src="./js/vendor/jquery-1.12.4.min.js"></script>
	<script src="./js/popper.min.js"></script>
	<script src="./js/bootstrap.min.js"></script>
	<!-- Jquery Mobile Menu -->
	<script src="./js/jquery.slicknav.min.js"></script>

	<!-- Jquery Slick , Owl-Carousel Plugins -->
	<script src="./js/owl.carousel.min.js"></script>
	<script src="./js/slick.min.js"></script>
	<!-- Date Picker -->
	<script src="./js/gijgo.min.js"></script>
	<!-- One Page, Animated-HeadLin -->
	<script src="././js/wow.min.js"></script>
	<script src="./js/animated.headline.js"></script>
	<script src="./js/jquery.magnific-popup.js"></script>

	<!-- Breaking New Pluging -->
	<script src="./js/jquery.ticker.js"></script>
	<script src="./js/site.js"></script>

	<!-- Scrollup, nice-select, sticky -->
	<script src="./js/jquery.scrollUp.min.js"></script>
	<script src="./js/jquery.nice-select.min.js"></script>
	<script src="./js/jquery.sticky.js"></script>

	<!-- contact js -->
	<script src="./js/contact.js"></script>
	<script src="./js/jquery.form.js"></script>
	<script src="./js/jquery.validate.min.js"></script>
	<script src="./js/mail-script.js"></script>
	<script src="./js/jquery.ajaxchimp.min.js"></script>

	<!-- Jquery Plugins, main Jquery -->
	<script src="./js/plugins.js"></script>
	<script src="./js/main.js"></script>
	<script>
	news()
</script>

</body>
</html>