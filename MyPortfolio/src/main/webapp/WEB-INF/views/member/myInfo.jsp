<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
			<h3>개인 정보 수정</h3>
		</div>
		<form action="updateInfo" method="post">
			<table class="myPage-table">
				<tr>
					<td class="common">아이디</td>
					<td class="info">${memberDto.userId}</td>
				</tr>
				<tr>
					<td class="common">이름</td>
					<td class="info">${memberDto.name}</td>
				</tr>
				<tr>
					<td class="common">생년월일</td>
					<td class="info">
						${memberDto.brthdy}
					</td>
				</tr>
				<tr>
					<td class="common">이메일</td>
					<td class="info">
						<input type="text" id="email" name="email" value="${memberDto.email}" size="30">
					</td>
				</tr>
				<tr>
					<td class="common">휴대폰 번호</td>
					<td class="info">
						<input type="text" id="mbTlNum" name="mbTlNum" value="${memberDto.mbTlNum}" size="13">
					</td>
				</tr>
			</table>
			<input type="hidden" name="userId" value="${memberDto.userId}">
			<div class="text-center">
				<input type="submit" id="upInfo" value="변경" class="myPage-btn">
			</div>
		</form>
	</div>
</section>

<!-- footer -->
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>
</body>
</html>