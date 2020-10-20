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
<script src="js/signUp.js"></script>

<title>Insert title here</title>
</head>
<body>
<!-- header -->
<jsp:include page="/WEB-INF/views/include/header.jsp"/>

	<section class="form-container">
		<form action="signUp" method="post">
			<div class="form-group">
				<label class="control-label" for="userId">아이디</label>
				<input class="form-control" type="text" id="userId" name="userId"
					placeholder="영 소문자로 시작해서 5~20자의 영소문자 또는 숫자를 사용해주세요."/>
				<span id="idCheck"></span>
			</div>
			<div class="form-group">
				<label class="control-label" for="password">패스워드</label>
				<input class="form-control" type="password" id="password" name="password"
					placeholder="영 소문자와 숫자 각각 하나 이상을 포함하여 8~16자로 입력해주세요."/>
				<span id="passCheck"></span>
			</div>
			<div class="form-group">
				<label class="control-label" for="pwConfirm">패스워드 재확인</label>
				<input class="form-control" type="password" id="pwConfirm" name="pwConfirm"/>
				<span id="passEqual"></span>
			</div>
			<div class="form-group">
				<label class="control-label" for="name">성명</label>
				<input class="form-control" type="text" id="name" name="name"
					placeholder="한글로 2~6자로 입력해주세요."/>
				<span id="nameCheck"></span>
			</div>
			<div class="form-group">
				<label class="control-label" for="brthdy">생년월일</label>
				<input class="form-control" type="text" id="brthdy" name="brthdy"
					placeholder="ex) yyyymmdd"/>
				<span id="brthdyCheck"></span>
			</div>
			<div class="form-group">
				<label class="control-label" for="sexDstn">성별</label>
				<input type="radio" name="sexDstn" id="male" value="m" checked>남자
				&nbsp;&nbsp;
				<input type="radio" name="sexDstn" id="female" value="f">여자
			</div>
			<div class="form-group">
				<label class="control-label" for="email">이메일</label>
				<input class="form-control" type="text" id="email" name="email"
					placeholder="ex) ****@****.***"/>
				<span id="emailCheck"></span>
			</div>
			<div class="form-group">
				<label class="control-label" for="mbTlNum">휴대전화</label>
				<input class="form-control" type="text" id="mbTlNum" name="mbTlNum"
					placeholder="'-'제외하고 입력하세요"/>
				<span id="mbTlNumCheck"></span>
			</div>
			<div class="form-group">
				<input type="submit" id="submit" name="submit" value="회원가입">
				<input type="button" id="cancel" name="cancel" value="취소">
			</div>
		</form>
	</section>
	
<!-- footer -->
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>

</body>
</html>