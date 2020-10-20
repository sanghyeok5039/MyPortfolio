<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Popup</title>

<!-- Bootstrap core CSS -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/custom.css" rel="stylesheet">

<!-- Bootstrap core JavaScript -->
<script src="jquery/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Custom JavaScript for this theme -->
<script src="js/login.js"></script>

</head>
<body>
	<br><br>
    <section class="loginPop-container">
    	<h3 align="center">로그인</h3>
	   <div class="form-group">
	       <input class="loginPop-content" type="text" id="userId" name="userId" placeholder="아이디"/>
		</div>
		<div class="form-group">
			<input class="loginPop-content" type="password" id="password" name="password" placeholder="비밀번호"/>                
	   		 <span style="text-align:left" id="msg"></span>
	    </div>
	    <div class="fomr-group">
	    	<input type="submit" class="btn btn-loginPop btn-inline" value="로그인" id="popSignIn">
			<input type="button" class="btn btn-loginPop btn-inline" value="닫기" 
				onclick="window.close()" id="popCancel">
	    </div>
	</section>

</body>
</html>