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
  	<h3>글 쓰기</h3>
  	<hr>
	<form method="post" action="writeArticle">
		<table class="write-table">
			<tr>
				<td class="common">제목</td>
				<td class="info">
					<textarea id="title" name="title" class="txt_input" style="height:40px;"
						placeholder="제목을 입력하세요"></textarea>
				</td>
			</tr>
			<tr>
				<td class="common">작성자</td>
				<td class="info">${sessionScope.userId}</td>
			</tr>							
			<tr>
				<td class="content">내용</td>
				<td class="info">
					<textarea id="content" name="content" class="txt_input"  style="height:300px;"
						placeholder="내용을 입력하세요"></textarea>
				</td>
			</tr>
		</table>
		<br> 
		<div>
			<input type="hidden" id="writer" name="writer" value="${sessionScope.userId}">
			<input type="submit" id="write" value="글쓰기"> 
			<input type="reset"  value="다시작성">
		</div>
	</form>
  </section>
  
<!-- footer -->
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>

</body>
</html>