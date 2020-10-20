$(document).ready(function() {
	
	//이메일 유효성검사 조건
	var emailCondition=RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
	//휴대전화 유효성검사 조건
	var telCondition=RegExp(/^01[0179][0-9]{7,8}$/);
	
	var chkEmail = true;
	var chkMbTlNum = true;
	
	//이메일 유효성검사 
	$('#email').blur(function() {
		var email = $("#email").val();
		
		if(email==""){
			alert("이메일을 입력해주세요.");
			chkEmail = false;
		}
		
		else if(!emailCondition.test(email)){
			alert("이메일 형식에 맞게 입력해주세요.");
			chkEmail = false;
		}
		
		else{
			chkEmail = true;
		}
	});
	
	//휴대전화 유효성검사 
	$('#mbTlNum').blur(function() {
		var mbTlNum = $("#mbTlNum").val();
		
		if(mbTlNum==""){
			alert("휴대전화번호를 입력해주세요.");
			chkMbTlNum = false;
		}
		
		else if(!telCondition.test(mbTlNum)){
			alert("휴대전화번호 형식에 맞게 입력해주세요.");
			chkMbTlNum = false;
		}
		
		else{
			chkMbTlNum = true;
		}
	});
	
	//개인 정보 수정은 이메일과 휴대전화만 수정가능한데
	//각각 입력했는지 확인.
	$("#upInfo").click(function(){

		if(chkEmail==false){
			alert("이메일을 확인하세요.");
			$("#email").focus();
			return false;
		}
		
		if(chkMbTlNum==false){
			alert("휴대전화번호를 확인하세요.");
			$("#mbTlNum").focus();
			return false;
		}
	});
	
	//비밀번호 변경전 확인
	$("#pwConfirm").click(function() {
		
		var id = $("#userId").val();
		var pw = $("#password").val();
		
		if (pw == "") {
			alert("비밀번호를 입력하세요.");
			return false;
		}
			
		var obj={"userId":id,"password":pw}
		
		$.ajax({
			async : true,
			url: 'pwConfirm',
			type: 'POST',
			dataType: 'json',
			contentType : 'application/json; charset=utf-8;',
			data: JSON.stringify(obj),

			success: function(data){
				//비밀번호 일치
			    if(data.result){
			    	window.location.replace("/MyPortfolio/pwChangeForm");
			    }
			    //비밀번호 불일치
			    else{
			    	alert("비밀번호가 일치하지 않습니다.");
			    }
			   },
			error: function (){        
			                      
			}
		});
			
	});
	
	//비밀번호 변경
	$("#pwChange").click(function() {
		
		//비밀번호 유효성검사 조건
		var passCondition=RegExp(/^(?=.*[a-z])(?=.*[0-9]).{8,16}$/);
	
		var id = $("#userId").val();
		var pw = $("#password").val();
		var pwConfirm = $("#passwordConfirm").val();
		
		if (pw == "") {
			alert("비밀번호를 입력하세요.");
			return false;
		}
		
		if(!passCondition.test(pw)){
			alert("8~16자의 영 소문자와 숫자의 조합으로 입력해주세요.");
			return false;
		}
		
		if (pw != pwConfirm) {
			alert("비밀번호가 일치하지 않습니다.");
			return false;
		}
			
		var obj={"userId":id,"password":pw}
		
		$.ajax({
			async : true,
			url: 'pwChange',
			type: 'POST',
			dataType: 'json',
			contentType : 'application/json; charset=utf-8;',
			data: JSON.stringify(obj),

			success: function(data){

			    if(data.result){
			    	alert("비밀번호가 변경되었습니다.");
			    	window.location.replace("/MyPortfolio/myPage");
			    }

			    else{
			    	alert("오류가 발생했습니다.");
			    }
			   },
			error: function (){        
			                      
			}
		});
			
	});

	//회원 탈퇴 본인인증절차
	$("#selfCrtfc").click(function() {
		
	var id = $("#userId").val();
	var pw = $("#password").val();
	
	if (pw == "") {
		alert("비밀번호를 입력하세요.");
		return false;
	}
		
	var obj={"userId":id,"password":pw}
	
	$.ajax({
		async : true,
		url: 'memberSecsn',
		type: 'POST',
		dataType: 'json',
		contentType : 'application/json; charset=utf-8;',
		data: JSON.stringify(obj),

		success: function(data){
			//비밀번호 일치
		    if(data.result){
		    	alert(data.msg);
		    	window.location.replace("/MyPortfolio/");
		    }
		    //비밀번호 불일치 or 오류발생
		    else{
		    	alert(data.msg);
		    }
		   },
		error: function (){        
		                      
		}
	});
		
});


	
});