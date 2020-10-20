$(document).ready(function() {	
	//로그인
	$("#signIn").click(function() {
			
		var id = $("#userId").val();
		var pw = $("#password").val();
		if (id == "" || pw == "") {
			alert("아이디 또는 비밀번호를 입력하세요.");
			return false;
		}
			
		var obj={"userId":id,"password":pw}
		
		$.ajax({
			async : true,
			url: 'login',
			type: 'POST',
			dataType: 'json',
			contentType : 'application/json; charset=utf-8;',
			data: JSON.stringify(obj),

			success: function(data){
				//로그인 성공
			    if(data.result){
			    	alert(data.msg);
			    	window.location.replace("/MyPortfolio/");
			    }
			    //로그인 실패
			    else{
			    	$("#msg").html("<span style='color:red'>"+data.msg+"</span>");
			    }
			   },
			error: function (){        
			                      
			}
		});
			
	});
	
	//로그인 팝업창에서 로그인
	$("#popSignIn").click(function() {
		
		var id = $("#userId").val();
		var pw = $("#password").val();
		if (id == "" || pw == "") {
			$("#msg").html("<span style='color:red'>아이디 또는 비밀번호를 입력하세요.</span>");
			return false;
		}
			
		var obj={"userId":id,"password":pw}
		
		$.ajax({
			async : true,
			url: 'login',
			type: 'POST',
			dataType: 'json',
			contentType : 'application/json; charset=utf-8;',
			data: JSON.stringify(obj),

			success: function(data){
				//로그인 성공
			    if(data.result){
			    	window.location.replace("/MyPortfolio/loginSuccess");
			    }
			    //로그인 실패
			    else{
			    	$("#msg").html("<span style='color:red'>"+data.msg+"</span>");
			    }
			   },
			error: function (){        
			                      
			}
		});
			
	});
	
	//아이디 찾기
	$("#findIdBtn").click(function() {
		
		var name = $("#name").val();
		var mbTlNum = $("#mbTlNum1").val();
		if (name == "" || mbTlNum == "") {
			alert("이름과 전화번호를 입력하세요");
			return false;
		}
			
		var obj={"name":name,"mbTlNum":mbTlNum}
		
		$.ajax({
			async : true,
			url: 'findId',
			type: 'POST',
			dataType: 'json',
			contentType : 'application/json; charset=utf-8;',
			data: JSON.stringify(obj),
	
			success: function(data){
				alert(data.msg);
				window.location.replace("/MyPortfolio/findAccount");
			   },
			error: function (){        
			                      
			}
		});
			
	});

	//비밀번호 찾기
	$("#findPwBtn").click(function() {
		
		var id = $("#userId").val();
		var mbTlNum = $("#mbTlNum2").val();
		if (id == "" || mbTlNum == "") {
			alert("아이디와 전화번호를 입력하세요");
			return false;
		}
			
		var obj={"userId":id,"mbTlNum":mbTlNum}
		
		$.ajax({
			async : true,
			url: 'findPw',
			type: 'POST',
			dataType: 'json',
			contentType : 'application/json; charset=utf-8;',
			data: JSON.stringify(obj),
	
			success: function(data){
				if(data.result){
					alert(data.msg);
					window.location.replace("/MyPortfolio/findPwChangeForm");
				}
				else{
					alert(data.msg);
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
			    	window.location.replace("/MyPortfolio/");
			    }
	
			    else{
			    	alert("오류가 발생했습니다.");
			    }
			   },
			error: function (){        
			                      
			}
		});
			
	});

});

	

/* 로그인 팝업창 띄우기 */
function popup(){
	
	var url = "/MyPortfolio/loginPopForm";
	var name = "loginPopup";
	var option = "width = 700, height = 500, top = 100, left = 200, location = no"
	window.open(url, name, option);
	
}

