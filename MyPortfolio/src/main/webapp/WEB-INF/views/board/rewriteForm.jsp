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
<script src="js/boardWrite.js"></script>

<title>Insert title here</title>
</head>
<body>
<!-- header -->
<jsp:include page="/WEB-INF/views/include/header.jsp"/>
  <section class="write-container">
  	<h3>글 수정</h3>
  	<hr>
	<form method="post" action="rewriteArticle">
		<table class="write-table">
			<tr>
				<td class="common">제목</td>
				<td class="info">
					<textarea id="title" name="title" class="txt_input" style="height:40px;">${boardDto.title}</textarea>
				</td>
			</tr>
			<tr>
				<td class="common">작성자</td>
				<td class="info">${sessionScope.userId}</td>
			</tr>							
			<tr>
				<td class="content">내용</td>
				<td class="info">
					<textarea id="content" name="content" class="txt_input"  style="height:300px;">${boardDto.content}</textarea>
				</td>
			</tr>
		</table>
		<input type="hidden" value="${boardDto.board_num}" name="board_num">
		<input type="hidden" id="writer" name="writer" value="${sessionScope.userId}">
		<br> 
		<div>
			<input type="submit" id="rewrite" value="수정완료"> 
			<input type="reset"  value="다시작성">
		</div>
	</form>
  </section>
<!-- footer -->
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>

</body>
</html>