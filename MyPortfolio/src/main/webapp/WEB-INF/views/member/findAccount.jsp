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

<title>계정 찾기</title>
</head>
<body>
<!-- header -->
<jsp:include page="/WEB-INF/views/include/header.jsp"/>

	<section class="find-wrap">
		<div class="find-id">
			<h3>아이디 찾기</h3>
			<input type="text" id="name" class="find-input" placeholder="이름을 입력하세요.">
			<input type="text" id="mbTlNum1" class="find-input" placeholder="휴대전화 번호를 입력하세요.">
			<input type="button" class="btn btn-find" value="아이디 찾기" id="findIdBtn">
		</div>
		<div class="find-pw">
			<h3>비밀번호 찾기</h3>
			<input type="text" id="userId" class="find-input" placeholder="아이디를 입력하세요.">
			<input type="text" id="mbTlNum2" class="find-input" placeholder="휴대전화 번호를 입력하세요.">
			<input type="button" class="btn btn-find" value="비밀번호 찾기" id="findPwBtn">
		</div>
	</section>

<!-- footer -->
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>

</body>
</html>