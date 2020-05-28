<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
<link rel="stylesheet" href="../sb_music/sb_lib/css/sb_myPage.css">
</head>
<body>

<%
	String mId = "guest";
	if(session.getAttribute("mId") != null){
 	mId = (String)session.getAttribute("mId");	
 	
	}
%>

	<div id="myPageBody">
		<h2>
			내 정보
		</h2>
		<hr>
		<h3>		
			아이디 : <%=mId%>
		</h3>
		<h3>
			성명 : ${vo.mName }
		</h3>
		<h3>
			휴대폰 번호 : ${vo.phone }
		</h3>
		<h3>
			이메일 : ${vo.email }
		</h3>				
	</div>



	
</body>
</html>