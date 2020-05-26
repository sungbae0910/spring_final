<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>News HTML-5 Template </title>
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
<link rel="stylesheet" href="./css/newsTemp.css">

<!-- js -->
<script src="./js/jquery-3.4.1.js"></script>
<script src="./js/news.js"></script>

</head>

<body>
<form id="news_s" method="post">
	<input type="hidden" value="${sessionScope.mName}" name="mName"/>
</form>
    <header>
        <!-- Header Start -->
       <div class="header-area">
            <div class="main-header ">
                <div class="header-top black-bg d-none d-md-block">
                   <div class="container">
                       <div class="col-xl-12">
                            <div class="row d-flex justify-content-between align-items-center">
                                <div class="header-info-left">
                                    <ul>     
                                        <li><img src="./img/icon/header_icon1.png" alt="">34ºc </li>
                                        <li><img src="./img/icon/header_icon1.png" alt=""><script>document.write(new Date().getFullYear());</script></li>
                                    </ul>
                                </div>
                                <div class="header-info-right">
                                    <ul class="header-social">    
                                        <li><a href="#" class="ins_s" onclick="weekly()"><img src="./img/icon/insta_s.png" style="width:25px; height:25px;"></a></li>
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
                                    <a href="newsMainT.jsp"><!-- <img src="./img/logo/logo.png" alt=""> -->logo</a>
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
                                        <a href="newsMainT.jsp"><!-- <img src="./img/logo/logo.png" alt=""> --></a>
                                    </div>
                                <!-- Main-menu -->
                                <div class="main-menu d-none d-md-block">
                                    <nav>                  
                                        <ul id="navigation">    
                                            <li><a href="#" onclick="go_all()">홈</a></li>
                                            <li><a href="categori.html">사회</a></li>
                                            <li><a href="about.html">정치</a></li>
                                            <li><a href="latest_news.html">경제</a></li>
                                            <li><a href="contact.html">국제</a></li>
                                            <li><a href="contact.html">문화</a></li>
                                            <li><a href="contact.html">IT</a></li>
                                        </ul>
                                    </nav>
                                </div>
                            </div>             
                            <div class="col-xl-2 col-lg-2 col-md-4">
                                <div class="header-right-btn f-right d-none d-lg-block">
                                    <i class="fas fa-search special-tag"></i>
                                    <img src="./img/icon/search_icon.png" onclick="news_search()" style="width:23px; height: 25px;">
                                    <div class="search-box">
                                        <form method="post" id="frm_news_search">
                                            <input type="text" name="searchText" class="searchText" placeholder="Search" value="${p.findStr}">
                                        </form>
                                    </div>
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

    <main>
    <form id="tess_s" method="post">
    
    </form>

    <!-- top 뉴스 시작 -->
	<div id="top_news_s">
	
	</div>
	<!-- top 뉴스 끝 -->
	
	<!-- 카테고리별 뉴스 시작 -->
	<div id="category_s">
		
	</div>
	<!-- 카테고리별 뉴스 끝 -->
	
	<!-- 많이 본 뉴스 시작 -->
	<div id="weekly_s">
	
	</div>
	<!-- 많이 본 뉴스 끝 -->

    </main>
    
   <footer>
       <!-- footer-bottom aera -->
       <div class="footer-bottom-area">
           <div class="container">
               <div class="footer-border">
                    <div class="row d-flex align-items-center justify-content-between">
                        <div class="col-lg-6">
                            <div class="footer-copy-right">
                                <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="ti-heart" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
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
      <script src="./js/wow.min.js"></script>
	<script src="./js/animated.headline.js"></script>
      <script src="./js/jquery.magnific-popup.js"></script>

      <!-- Breaking New Pluging -->
      <script src="./js/jquery.ticker.js"></script>
      <script src="./js/site.js"></script>

<!-- Scrollup, nice-select, sticky -->
      <script src="./js/jquery.scrollUp.min.js"></script>
      <script src="./js/jquery.nice-select.min.js"></script>
	<script src="././js/jquery.sticky.js"></script>
      
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
	go_all();
	news()
</script>        
</body>
</html>