<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>블로그</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="./css/blog.css">
<script src="./js/blog.js"></script>
<script src="./js/jquery-3.4.1.js"></script>
</head>
<body>
	<%@ include file="blog_top.jsp"%>

  	<%@ include file="mainBlog_content.jsp"%>
	<%-- <%@ include file="myBlog_main.jsp"%> --%>
	<%-- <%@ include file="myBlog_brd.jsp"%> --%>
	                                            
	<%@ include file="blog_footer.jsp"%>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</body>
</html>