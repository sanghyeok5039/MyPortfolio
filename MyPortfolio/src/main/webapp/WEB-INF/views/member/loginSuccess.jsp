<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
    setTimeout(function() {
   	 	opener.location.reload(); //부모창 리프레쉬
    	self.close(); //현재창 닫기
    }, 1000); // 2초후 실행 1000당 1초
</script>

</head>
<body onload="setTimeout()">

</body>
</html>