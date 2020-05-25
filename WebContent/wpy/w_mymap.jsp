<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>창업문의</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
<script src="./js/jquery-3.4.1.js"></script>
<script src="./js/jquery.dropotron.min.js"></script>

<link rel="stylesheet" href="./css/skel.css" />
<link rel="stylesheet" href="./css/style.css" />
		<!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
	</head>
	<body class="left-sidebar">

		<!-- Header -->
			<div id="header">
				<div class="container">
						
					<!-- Logo -->
						<img src="./w_images/w_mainimage1.png">
					
					<!-- Nav -->
						<nav id="nav">
							<ul>
								<li><a href="w_index.jsp">Home</a></li>
								<li>
									<a href="">브랜드 소개</a>
									<ul>
										<li><a href="w_menu.jsp">전 메뉴</a></li>						
									</ul>
								</li>
								<li><a href="w_founded.jsp">창업문의</a></li>
								<li><a href="w_customersupport.jsp">고객문의</a></li>
								<li><a href="w_mymap.jsp">매장안내</a></li>
							</ul>
						</nav>


				</div>
			</div>

		<!-- Main -->
			<div id="main_w" class="wrapper style1">
				<div class="container">
						<!-- Content -->
						<div id="content" class="8u skel-cell-important">		
			              <div class="w_wrap">
							<div class="w_t_tab">
							  <a href="#"class="on">매장위치</a>
							</div>
						</div>
						   <h4 class="w_tab_sub">매장위치</h4>
						   <article id="w_v" style="width: 100%">
						   	<header>
						     <h1 id="w_title">
						       상봉점
						     </h1>
						   	</header>
						   	<section class="w_v_info"></section>
						   <div class="w_info">
						    <div class="w_imp1">
						     <div id="w_v_image">
						     </div>
						    </div>
						   	<div class="w_imp2">
						   	 <h2 class="w_view_sjw">상봉점</h2>
						   	 <table>
						   	  <tbody>
						   	   <tr>
						   	    <th>
						   	    <img src="./w_images/w_icon_check.png" alt width="32" style="position: relative; top: 9px;">
						   	      오시는길
						   	    </th>
						   	    <td>
						   	     서울 중랑구 면목로 454 1층
						   	    </td>
						   	    </tr>
						   	   <tr>
						   	    <th>
						   	    <img src="./w_images/w_icon_check.png" alt width="32" style="position: relative; top: 9px;">
						   	     전화번호
						   	    </th>
						   	    <td>
						   	     010-9413-5834
						   	    </td>
						   	    </tr>
						   	    <tr>
						   	    <th>
						   	    <img src="./w_images/w_icon_check.png" alt width="32" style="position: relative; top: 9px;">
						   	      매장서비스
						   	    </th>
						   	    <td class="w_ser">
						         <span><img src="./w_images/w_shop_icon1_on.png" alt width="19">예약가능</span>
						         <span><img src="./w_images/w_shop_icon2_on.png" alt width="19">포장가능</span>
						         <span><img src="./w_images/w_shop_icon3_on.png" alt width="19">주차가능</span>
						         <span><img src="./w_images/w_shop_icon4.png" alt width="19">24시간영업불가능</span>   
						   	    </td>
						   	    </tr>
						   	  </tbody>
						   	 </table>
						   	</div>
						   </div>
						   <h2 class="w_view_wpy">찾아 오시는길</h2>
						  
						    <p style="margin-top:-12px">
							    <em class="link">
							        <a href="javascript:void(0);" onclick="window.open('http://fiy.daum.net/fiy/map/CsGeneral.daum', '_blank', 'width=981, height=650')">

							        </a>
							    </em>
							</p>
						  
						  
						  <div id="map" style="width:500px;height:400px;"></div> 
						   
						   </article>
						</div>
					</div>
				</div>

		<!-- Footer -->
			<div id="footer">
				<div class="container">

					<!-- Lists -->
						<div class="row">
							<div class="8u">
								
							</div>
							<div class="4u">
								
							</div>
						</div>

					<!-- Copyright -->
						<div class="copyright">
							  <span>주식회사 :꼬치예전</span>
						      <span>대표자 :원필연 </span>
						      <span>전화번호 :010-9413-5834</span>
						      <br/>		 
						      <span>이메일 :wkymonk@gmail.com</span>
						      <span>사업자 등록번호 :217-18-15486</span>
						      <span>서울 중랑구 면목로 454 1층(서울 중랑구 면목동 91-65)</span>	
						</div>

				</div>
			</div>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=6e9fd82593e11cb5e15222429393e508"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=LIBRARY"></script>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=APIKEY&libraries=services,clusterer,drawing"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch('제주특별자치도 제주시 첨단로 242', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">우리회사</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    
</script>
</body> 
</html>