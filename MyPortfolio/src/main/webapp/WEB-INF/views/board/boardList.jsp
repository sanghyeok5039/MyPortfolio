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

<title>게시판 목록</title>
</head>
<body>
<!-- header -->
<jsp:include page="/WEB-INF/views/include/header.jsp"/>

  <section class="board-container">
  	<h3>자유 게시판</h3>
  	<hr>
	<table class="board-table table-striped text-center">
		<thead>
			<tr>
			  <th width="10%">번호</th>
			  <th width="40%">제목</th>
			  <th width="10%">작성자</th>
			  <th width="20%">작성 날짜</th>
			  <th width="10%">조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${cnt==0}">
				<tr>
			  		<td colspan="5"><b>등록된 글이 없습니다.</b></td>
				</tr>
		  	</c:if>
		  	<c:forEach var="list" items="${list}">
				<tr>
			  		<td style="font-weight:bold">${list.board_num}</td>
			 		<td class="title text-left">
			 			<a href="viewArticle?num=${list.board_num}&pageNum=${pageNum}">${list.title}</a>
			 			<c:if test="${list.replyCount > 0 }">
			 				<span style="color:red;font-weight:bold;">[ ${list.replyCount} ]</span>
			 			</c:if>			
			 		</td>
			 		<td>${list.writer}</td>
			  		<td><fmt:formatDate value="${list.regDate}" pattern="yyyy-MM-dd HH:mm" /></td>
			  		<td>${list.readCount}</td>
				</tr>
		 	 </c:forEach>
		</tbody>
	</table>
	
	<c:if test="${sessionScope.loginCheck eq true}">
		<div align="right">
			<input type="button" value="글쓰기" onClick="location='writeForm'">
		</div>
	</c:if>
	
	<div class="pageNumber text-center">
		<c:if test="${pre}">
			<a class="pageNumber" href="viewAllArticles?pageNum=${startPage-10}">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${startPage}" end="${endPage}" step="1">
			<c:choose>
				<c:when test="${i==pageNum}">
					<span style="color: black; font-size: larger"><b>${i}</b></span>&nbsp;
				</c:when>
				<c:otherwise>
					<a class="pageNumber" href="viewAllArticles?pageNum=${i}">${i}&nbsp;</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<c:if test="${next}">
			<a class="pageNumber" href="viewAllArticles?pageNum=${startPage+10}">[다음]</a>
		</c:if>
	</div>
	
  </section>
<!-- footer -->
<jsp:include page="/WEB-INF/views/include/footer.jsp"/>

</body>
</html>