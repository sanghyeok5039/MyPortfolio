<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<!-- Bootstrap core CSS -->
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/scrolling-nav.css" rel="stylesheet">
<link href="css/custom.css" rel="stylesheet">

<!-- Bootstrap core JavaScript -->
<script src="jquery/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.bundle.min.js"></script>

<!-- Plugin JavaScript -->
<script src="jquery-easing/jquery.easing.min.js"></script>

<!-- Custom JavaScript for this theme -->
<script src="js/scrolling-nav.js"></script>
<script src="js/login.js"></script>

<title>비밀번호 재설정</title>
</head>
<body>
<!-- header -->
<jsp:include page="/WEB-INF/views/include/header.jsp"/>

	<section class="form-container">
		<h3 class="text-center">비밀번호 재설정</h3>
		<div class="form-group">
			<input class="form-control" type="password" id="password" name="password"
				placeholder="새 비밀번호"/>
		</div>
		<div class="form-group">
			<input class="form-control" type="password" id="passwordConfirm" name="passwordConfirm"
				placeholder="새 비밀번호 확인"/>
			<span style="text-align:left" id="msg"></span>
		</div>
		<div class="form-group">
			<input type="hidden" id="userId" value="${sessionScope.userId}">
			<input type="submit" class="btn btn-login btn-block" value="비밀번호 변경" id="pwChange">
		</div>
	</section>
	
<!-- footer -->
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>

</body>
</html>