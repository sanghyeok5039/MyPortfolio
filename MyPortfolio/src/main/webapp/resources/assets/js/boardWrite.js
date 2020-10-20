$(document).ready(function() {
	//게시글 쓰기 버튼 눌렀을 때 게시글과 내용을 입력했는지 안했는지 검사
	//게시글과 내용 글자 수 검사하는것도 구현해보자.
	$("#write").click(function() {
		var title = $("#title").val();
		var content = $("#content").val();
		
		if (title == "") {
			alert("제목을 입력하세요.");
			$("#title").focus();
			return false;
		}
		
		if (content == "") {
			alert("내용을 입력하세요");
			$("#content").focus();
			return false;
		}
	});
		
	//게시글의 댓글 쓰기전에 내용을 입력했는지 검사
	$("#submitReply").click(function() {
		var comments = $("#comments").val();
		
		if (comments == "") {
			alert("댓글 내용을 입력하세요");
			$("#comments").focus();
			return false;
		}
		
	});
});