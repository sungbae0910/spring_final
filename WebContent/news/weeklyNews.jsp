<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>
    <!--   Weekly2-News start -->
	<div class="weekly2-news-area  weekly2-pading gray-bg">
        <div class="container">
            <div class="weekly2-wrapper">
                <!-- section Tittle -->
                <div class="row">
                    <div class="col-lg-12 autoplay">
                        <div class="section-tittle mb-30">
                            <h3>많이 본 뉴스</h3>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <div class="weekly2-news-active dot-style d-flex dot-style">
                        	<c:forEach var="i" items="${vo3}" varStatus="ii">
                        	<fmt:formatDate value="${i.nDate}" var="dateFmt" pattern="yyyy-MM-dd"/>
                        	<input type="hidden" value="${i.nSerial}" class="serial${ii.index}">
	                            <div class="weekly2-single">
	                                <div class="weekly2-img">
	                                	<c:forEach var="pho" items="${i.photos}">
	                                    	<img src="./img/newsImages/${pho.pName}" alt="">
	                                    </c:forEach>
	                                </div>
	                                <div class="weekly2-caption">
	                                    <span class="color1">${i.nCategory}</span>
	                                    <p>${dateFmt}</p>
	                                    <h4><a href="#" onclick="news_detail(${ii.index})">${i.nTitle}</a></h4>
	                                </div>
	                            </div>
                            </c:forEach> 
                        </div>
                    </div>
                </div>
            </div>
        </div>
	</div>        
    <!-- End Weekly-News -->
<!-- JS here -->
<!-- All JS Custom Plugins Link Here here -->

   <!-- Jquery Mobile Menu -->
      <script src="./js/jquery.slicknav.min.js"></script>

<!-- Jquery Plugins, main Jquery -->	
      <script src="./js/main.js"></script>  
</body>
</html>