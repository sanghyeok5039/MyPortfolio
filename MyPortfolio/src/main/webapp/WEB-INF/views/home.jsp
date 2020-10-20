<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">

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

<title>Home</title>
</head>
<body id="page-top">
<!-- header -->
<jsp:include page="/WEB-INF/views/include/header.jsp"/>

  <header class="bg-primary text-white">
    <div class="container text-center">
      <h1>Welcome to My Bulletin Board</h1>
    </div>
  </header>

  <section id="about">
    <div class="container">
      <div class="row">
        <div class="col-lg-8 mx-auto">
          <h2>Features of this project...</h2>
          <ul></ul>
          <ul>
            <li>회원가입(회원가입시에 필요한 입력요소들의 유효성검사), 로그인, 아이디 찾기, 비밀번호 찾기</li>
          </ul>
          <ul>
            <li>게시판(게시글 쓰기,보기,수정,삭제), 게시판 페이징, 댓글 달기, 조회수, 댓글 수</li>
          </ul>
          <ul>
            <li> 마이페이지( 기본정보 변경, 비밀번호 변경, 회원탈퇴 )</li>
          </ul>
        </div>
      </div>
    </div>
  </section>
  
<!-- footer -->
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>

</body>
</html>