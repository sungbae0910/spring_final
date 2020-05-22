<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>창업문의</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<!--[if lte IE 8]><script src="css/ie/html5shiv.js"></script><![endif]-->
<script src="./js/jquery.min.js"></script>
<script src="./js/jquery.dropotron.min.js"></script>
<script src="./js/w_brand.js"></script>


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
										<li><a href="w_main.jsp">전 메뉴</a></li>						
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
			<div id="main" class="wrapper style1">
				<div class="container">
						<!-- Content -->
						<div id="content" class="8u skel-cell-important">
					<c:choose>
        <c:when test="${empty sessionScope.w_mid}">
            <!-- 로그인이 안되어 있으면 -->
            <form id="frm_food" name="frm_food" action="w_LoginCheck.fd">
                <table>
                    <tr>
                        <td>아이디</td>
                        <td><input type="text" name="w_mid" id="w_mid" placeholder="10글자" maxlength="10"></td>
                    </tr>
                    <tr>
                        <td>패스워드</td>
                        <td><input type="password" name="w_pwd" id="w_pwd" maxlength="20"></td>
                    </tr>
                    <c:if test="${msg == '실패'}">
                        <tr>
                            <td colspan=2>
                                아이디 또는 패스워드가 틀렸습니다.
                            </td>
                        </tr>
                    </c:if>
                    <tr>
                        <td colspan=2>
                            <input type="button" id="w_btnLogin1" value="로그인" />
                        </td>
                    </tr>
                </table>
            </form>
        </c:when>
        <c:otherwise>
            <h3>${sessionScope.w_mid}님 환영합니다.</h3>
            <a href="w_Logout.fd">로그아웃</a>
        </c:otherwise>
    </c:choose>
				          </div>
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
			<script type="text/javascript">
		    $(document).ready(function(e) {
		        $('#w_btnLogin1').click(function() {

		            // 입력 값 체크
		            if ($.trim($('#w_mid').val()) == '') {
		                alert("아이디를 입력해 주세요.");
		                $('#w_mid').focus();
		                return;
		            } else if ($.trim($('#w_pwd').val()) == '') {
		                alert("패스워드를 입력해 주세요.");
		                $('#w_pwd').focus();
		                return;
		            }

		            //전송
		            $('#frm_food').submit();
		        });

		    });
		</script>
	</body>
</html>