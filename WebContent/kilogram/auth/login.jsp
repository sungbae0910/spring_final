<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Kilogram</title>
  <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
    rel="stylesheet">
    <link rel="shortcut icon" href="../images/favicon.ico">
    <link rel="stylesheet" href="../css/styles.css">
</head>
<body>
  <main id="login">
    <div class="login__column">
      <img src="../images/phoneImage.png" />
    </div>
    <div class="login__column">
      <div class="login__box">
        <img src="../images/loginLogo.png" />
        <form action="/auth/loginProc" method="post" class="login__form">
          <input type="text" name="username" placeholder="사용자 이름" required>
          <input type="password" name="password" placeholder="비밀번호" required>
          <input type="submit" value="로그인">
        </form>
        <span class="login__divider">
          or
        </span>
        <a href="/auth/kakao/login" class="login__fb-link">
        	<img width="100%" src="../images/kakao_account_login_btn_medium_wide.png"/>
        </a>
        <a href="#" class="login__small-link">비밀번호를 잊으셨나요?</a>
      </div>
      <div class="login__box">
        <span class="login__text">
          계정이 없으신가요? <br />
        </span>
        <a class="login__blue-link" href="/auth/join">가입하기</a>
      </div>
      <div class="login__t-box">
        <span class="login__text">
          앱을 다운로드하세요.
        </span>
        <div class="login__appstores">
          <img src="../images/ios.png" class="login__appstore" />
          <img src="../images/android.png" class="login__appstore" />
        </div>
      </div>
    </div>
  </main>
  <%@ include file="../include/footer.jsp" %>
</body>
</html>

