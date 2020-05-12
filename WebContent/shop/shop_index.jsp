<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<link href="" rel="stylesheet">
<link href="/lib/css/bootstrap.min.css" rel="stylesheet">
<link href="../lib/css/shop_index.css" rel="stylesheet">
<link href="../lib/css/shop_main.css" rel="stylesheet">
<link href="../lib/css/shop_itemMore.css" rel="stylesheet">
<link href="../lib/css/shop_basket.css" rel="stylesheet">
<link href="../lib/css/shop_payment.css" rel="stylesheet">
<link href="../lib/css/shop_myPage.css" rel="stylesheet">
<script src='../lib/script/jquery-3.4.1.js'></script>
<script src="../lib/script/bootstrap.min.js"></script>
</head>
<body>
<div id="shop_body">
	<div class="container-fluid">
		<div class="row">
			<div class="col-xs-12">
				<%@include file="shop_header.jsp" %>
			</div>
			<div class="col-xs-12" id="main">
				<%-- <%@include file="shop_main.jsp" %> --%>
				<%-- <%@include file="shop_itemMore.jsp" %> --%>
				<%-- <%@include file="shop_basket.jsp" %> --%>
				<%@include file="shop_payment.jsp" %>
				<%-- <%@include file="shop_myPage.jsp" %> --%>
			</div>
			<div class="col-xs-12">
				<%@include file="shop_footer.jsp" %>
			</div>
		</div>
	</div>
</div>
</body>
</html>