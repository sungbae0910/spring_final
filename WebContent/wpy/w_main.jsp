<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../lib/jquery-3.4.1.js"></script>
<script src="../js/bootstrap.bundle.min.js"></script>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/w_wpy.css" rel="stylesheet">
</head>
<body>

<form>
  <input type="button" id="w_login"  class="btn btn-primary" style="position: relative; top: 20px; left: 500px;" value="로그인" />
  <input type="button" id="w_logout" class="btn btn-primary" style="position: relative; top: 20px; left: 500px;" value="로그아웃" />
</form>

<div id='w_header'>
  <jsp:include page="w_header.jsp"></jsp:include>

</div>

<div id="w_BrandName">
	<button class="btn btn-link" type="button" id="w_btnStory" >
	  <span class="text-danger" style="font-size:20px;">브랜드 소개</span>
	</button>
	
	<button class="btn btn-link" type="button" id="w_btnMap" >
	  <span class="text-danger" style="font-size:20px;">매장안내</span>
	</button>
	
	<button class="btn btn-link" type="button" id="w_btnCustomer" >
	  <span class="text-danger" style="font-size:20px;">고객지원</span>
	</button>
</div>

<div id="w_Brandform">
	  <div id="w_view1">
		 <a href="../wpy/w_brandform.jsp">꼬치예전</a>
	 </div>
</div>

<div id="footer">


</div>
<script>w_btnFunc()</script>
</body>
</html>