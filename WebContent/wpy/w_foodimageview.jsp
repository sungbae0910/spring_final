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
   <c:forEach var="i" items="${list }">
	<div  class="tab_content" style="display: block;">
		<ul>
			<li><img src="./w_images/${i.sysFile }" alt width="340" class="w_menu_image">
			<h3 class="w_h1">
			  ${i.foodname } <img src="./w_images/w_best.jpg" alt="인기" width="32" class="w_best">
		     </h3>
			<p>
			<span>${i.foodprice }</span>
		  	</p>
		  </li>
		</ul>
	</div>
	</c:forEach>
</body>
</html>