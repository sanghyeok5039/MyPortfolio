<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
  <div class="container">
    <a class="navbar-brand js-scroll-trigger" href="/MyPortfolio/">Home</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarResponsive">
      <ul class="navbar-nav">
         <li class="nav-item">
          <a class="nav-menu js-scroll-trigger" href="viewAllArticles">게시판</a>
        </li>
      </ul>
      <hr class="hr-gold">
      <ul class="navbar-nav ml-auto">
        <c:choose>
    		<c:when test="${sessionScope.loginCheck eq true}"> 
       		 	<li class="nav-item">
       		 		<a class="nav-link js-scroll-trigger" href="logout" style="pointer-events: none;">
       		 			<span style="color:#FFF136">
       		 				${sessionScope.userId}님 환영합니다!
       		 			</span>
       		 		</a>      			
        		</li>
        		<li class="nav-item">
          			<a class="nav-link js-scroll-trigger" href="myPage">마이페이지</a>
        		</li>
        		<li class="nav-item">
          			<a class="nav-link js-scroll-trigger" href="logout">로그아웃</a>
        		</li>
    		</c:when>
    		<c:otherwise>
        		<li class="nav-item">
          			<a class="nav-link js-scroll-trigger" href="loginForm">로그인</a>
        		</li>
        		<li class="nav-item">
          			<a class="nav-link js-scroll-trigger" href="signUpForm">회원가입</a>
        		</li>
    		</c:otherwise>
		</c:choose>
      </ul>
    </div>
  </div>
</nav>
