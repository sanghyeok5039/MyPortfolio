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
<script src="js/myPage.js"></script>

<title>Insert title here</title>
</head>
<body>

<!-- header -->
<jsp:include page="/WEB-INF/views/include/header.jsp"/>

<section class="myPage-wrap">
	<div class="myPage-menu">
		<div class="menu-content">
			<hr class="hr-gold">
			<div class="content">
				<a href="myPage">개인 정보 변경</a>
			</div>
			<hr class="hr-gold">
			<div class="content">
				<a href="pwConfirmForm">비밀번호 변경</a>
			</div>
			<hr class="hr-gold">
			<div class="content">
				<a href="memberSecsnForm">회원탈퇴</a>
			</div>
			<hr class="hr-gold">
		</div>
	</div>
	<div class="myPage-content">
		<div class="form-group">
			<h3>본인 인증 절차</h3>
		</div>
		<table class="myPage-table">
			<tr>
				<td class="common">아이디</td>
				<td class="info">${sessionScope.userId}</td>
			</tr>
			<tr>
				<td class="common">비밀번호</td>
				<td class="info"><input type="password" id="password" name="password"></td>
			</tr>
		</table>
		<div class="form-group">
			<span style="color:red;font-weight:bold">
				*비밀 번호를 입력하시고 본인인증이 완료되면 회원 탈퇴가 완료됩니다.
			</span>
		</div>
		<input type="hidden" id="userId" name="userId" value="${sessionScope.userId}">
		<div class="text-center">
			<input type="button" id="selfCrtfc" value="본인 인증" class="myPage-btn">
		</div>
	</div>
</section>

<!-- footer -->
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>

</body>
</html>