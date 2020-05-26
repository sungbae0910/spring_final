<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>꼬치예전</title>
<script src="./w_js/jquery.min.js"></script>
		<script src="./js/jquery.dropotron.min.js"></script>
		<script src="./js/skel.min.js"></script>
		<script src="./js/skel-layers.min.js"></script>
		<script src="./js/init.js"></script>
<link rel="stylesheet" href="./css/skel.css" />
<link rel="stylesheet" href="./css/style.css" />
</head>

<body>

  <form name='frm_food' id='frm_food' method='post'>
		<!-- UI  -->
		<c:forEach var='v' items="${vo }">
		<label>메뉴 가격</label>
		<input type='text' readonly name='foodPrice' value='${v.foodPrice }'/><br/>
		
		<label>메뉴 이름</label>
		<input type='text' name='foodName' size='90' value='${v.foodName }'/><br/>
		
		<label>메뉴 종류</label>
		<input type='text' name='foodType' size='90' value='${v.foodType }'/><br/>

		<fieldset><legend>[ 첨부된 파일 ]</legend>
				<div>
					<span>첨부된 파일${v.sysFile }</span>
				</div>
		</fieldset>
        </c:forEach>


	    
		<input type='button' id='btnModify' value='수정'/>
		<input type='button' id='btnDelete' value='삭제'/>
		<input type='button' id='btnFind' onclick="location.href='w_menu.jsp'" value='목록으로'/>
		

	</form>

</body>
</html>