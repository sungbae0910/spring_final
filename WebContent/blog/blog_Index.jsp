<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>블로그</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.16/dist/summernote.min.css" rel="stylesheet">
<link rel="stylesheet" href="./css/blog.css">
<link rel="stylesheet" href="./css/blog_manage.css">
<script src="./js/blog.js"></script>
<script src="./js/blog_manage.js"></script>
<script src="./js/jquery-3.4.1.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.16/dist/summernote.min.js"></script>
<script src="./js/summernote-ko-KR.js"></script>
</head>
<body>
<script>
	blog.Main();
</script>

<div id="c_blogMain">
	<%@ include file="blog_top.jsp"%>

	<div id="c_blogContent">
	</div>   		
	                                            
	<%@ include file="blog_footer.jsp"%>

</div>
</body>
</html>