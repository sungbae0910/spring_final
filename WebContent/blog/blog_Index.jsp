<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-timeago/1.6.5/jquery.timeago.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-timeago/1.6.5/locales/jquery.timeago.ko.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.16/dist/summernote.min.js"></script>
<script src="./js/summernote-ko-KR.js"></script>
</head>
<body>
<script>
/* let tag = ["일상", "데일리"];
$.setJSON('../blogMain.bg', {"tag" : tag}, function() {
		$("#c_blogContent").html(data);
	}); */
	/* blog.Main(); */
	/* sessionStorage.setItem("LoginId", "id");
	let tag = ["일상", "데일리"];
	let form = $("#c_frmMain");
	for (let i=0; i<tag.length; i++) {
		/*$("<input> <input/>").attr({type : "hidden", name : "tag", value : tag[i]}).appendTo(form);
		let input = document.createElement("input");
		 $(input).attr("type", "hidden");
		 $(input).attr("name", "tag");
		 $(input).attr("value", tag[i]);
		 $(form).append(input);
	}
	alert(1);
	$("#c_frmMain").submit();
	alert(2); 
	
let tag = ["일상", "데일리"]		
	let el;
	for (let i=0; i<tag.length; i++) {
		el = document.createElement("input");
		el.type = "hidden";
		el.name = "tag";
		el.value = tag[i];
		document.form.appendChild(el);    
	} */
</script>
<%
	String inc = "./blog_header.jsp";
	if (request.getParameter("inc") != null) {
		inc = request.getParameter("inc");
	}
%>

<div id="c_blogMain">
	<%@ include file="blog_top.jsp"%>

	<div id="c_blogMain">
		<jsp:include page="<%=inc%>"/>
	</div>  		
	                                       
	<%@ include file="blog_footer.jsp"%>

</div>
</body>
</html>