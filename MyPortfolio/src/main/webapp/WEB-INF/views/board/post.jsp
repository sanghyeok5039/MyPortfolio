	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
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
<script src="js/boardWrite.js"></script>
<script src="js/login.js"></script>

<title>Insert title here</title>
</head>
<body>
<!-- header -->
<jsp:include page="/WEB-INF/views/include/header.jsp"/>
  <section class="board-container">
	<form method="post" action="rewriteForm" id="board-form">
		<table class="article-table">
			<tr>
				<td></td>
				<td></td>
				<td class="common">조회수</td>
				<td class="small">${boardDto.readCount}</td>
			</tr>
			<tr>
				<td class="common" rowspan="2">제목</td>
				<td class="title" rowspan="2">${boardDto.title}</td>	
				<td class="common">작성자</td>
				<td class="small">${boardDto.writer}</td>
			</tr>
			<tr>
				<td class="common">작성일</td>
				<td class="small">
					<fmt:formatDate value="${boardDto.regDate}" pattern="yyyy-MM-dd HH:mm" />
				</td>
			</tr>
			<tr>
				<td class="common">내용</td>
				<td class="content" colspan="3">
					<textarea id="content" name="content" class="txt_input" 
						style="border:none;height:300px;" readonly>${boardDto.content}</textarea>
				</td>
			</tr>
		</table>
		<input type="hidden" value="${boardDto.board_num}" name="board_num">
		<input type="hidden" value="${boardDto.title}" name="title">
		<div>
			<input type="button" value="목록" onClick="location='viewAllArticles?pageNum=${pageNum}'">
			<input type="button" value="TOP" onClick="location='#'">
			<c:if test="${sessionScope.userId eq boardDto.writer}">
				<input type="submit" value="글 수정">
				<input type="button" value="글 삭제" onClick="location='deleteArticle?num=${boardDto.board_num}'">
			</c:if>
		</div>
	</form>
	
	<br><br><br>
	<h4>댓글</h4>
	<hr>
	
	
	
	<c:forEach var="list" items="${replyList}">
		<form action="updateReply">
			<div style="margin-left:2rem">
				<div>
					<span style="font-weight:bold;font-size:1.2rem">${list.writer}</span>
				</div>
				<c:choose>
					<c:when test="${sessionScope.userId == list.writer}">
						<div>
							<textarea id="comments" name="comments" rows="3" cols="110" 
								style="ime-mode: active;">${list.comments}</textarea>
						</div>
					</c:when>
					<c:otherwise>
						<div>${list.comments}</div>
					</c:otherwise>
				</c:choose>
				<div>
					<span style="font-size:0.6rem; color:gray">
						<fmt:formatDate value="${list.regDate}" pattern="yyyy-MM-dd HH:mm" />	
					</span>
				</div>
				<div>
					<c:if test="${sessionScope.userId == list.writer}">
						<input type="hidden" value="${list.reply_num}" name="reply_num">
						<input type="hidden" value="${boardDto.board_num}" name="board_num">
						<input type="submit" id="upReply" value="수정하기">
						<input type="button" id="delReply"value="삭제하기" 
							onClick="location='deleteReply?num=${list.reply_num}&board_num=${boardDto.board_num}'">
					</c:if>
				</div>
			</div>
		</form>
		<hr>
	</c:forEach>
	<!-- 로그인해야 댓글쓰기 가능 -->
	<c:choose>
		<c:when test="${sessionScope.loginCheck eq true}"> 
			<form action="writeReply">
				<div class="write-reply">
					<div class="text-left">
						<span style="font-weight:bold;font-size:1.2rem">${sessionScope.userId}</span>
					</div>
					<div>
						<textarea id="comments" name="comments" rows="3" cols="110" style="ime-mode: active;"
							placeholder="댓글을 입력하세요."></textarea>
					</div>
					<input type="hidden" value="${boardDto.board_num}" name="board_num">
					<input type="hidden" value="${sessionScope.userId}" name="writer">
					<div align=right>
						<input type="submit" id="submitReply"value="댓글 쓰기">
					</div>
				</div>
			</form>
		</c:when>
		<c:otherwise>
			<div class="write-reply">
				<div></div>
				<div>
					<textarea id="comments" name="comments" rows="3" cols="110" style="ime-mode: active;"
						placeholder="로그인이 필요합니다." class="disabled"></textarea>
				</div>
				<div align=right>
					<input type="button" value="로그인 하러가기" onClick="javascript:popup()">
				</div>
			</div>
		</c:otherwise>
	</c:choose>
	
	
  </section>

<!-- footer -->
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>

</body>
</html>