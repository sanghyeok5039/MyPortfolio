$(document).ready(function() {
	//아이디 유효성검사 조건
	var idCondition=RegExp(/^[a-z]{1}[a-z0-9]{4,19}$/);
	//비밀번호 유효성검사 조건
	var passCondition=RegExp(/^(?=.*[a-z])(?=.*[0-9]).{8,16}$/);
	//성명 유효성검사 조건
	var nameCondition=RegExp(/^[가-힣]{2,6}$/);
	//생년월일 유효성검사 조건
	var brthdyCondition=RegExp(/^(19|20)[0-9]{2}(0[1-9]|1[1-2])(0[1-9]|[1-2][0-9]|3[0-1])$/);
	//이메일 유효성검사 조건
	var emailCondition=RegExp(/^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/);
	//휴대전화 유효성검사 조건
	var telCondition=RegExp(/^01[0179][0-9]{7,8}$/);
	
	
	//유효성 검사가 완료되는 항목은 true
	//전체 항목이 true가 되어야 회원가입이 가능합니다.
	var chkId = false;
	var chkPw = false;
	var chkPwConfirm = false;
	var chkBrthdy = false;
	var chkBrthdy = false;
	var chkEmail = false;
	var chkMbTlNum = false;
	
	//아이디 유효성 검사 및 중복 검사
	$('#userId').blur(function() {
		var userId = $("#userId").val();
		
		//아이디 유효성검사 
		if(userId==""){
			$("#idCheck").html("<span style='color:red'>아이디를 입력하세요</span>");
			chkId = false;
		}
		
		else if(!idCondition.test(userId)){
			$("#idCheck").html("<span style='color:red'>영소문자로 시작해서 5~20자의 영소문자 또는 숫자로 입력해주세요.</span>");
			chkId = false;
		}
		
		else{
			$.ajax({
				async : true,
			    url: 'idDplctcheck',
			    type: 'POST',
			    dataType: 'json',
			    contentType : 'application/json; charset=utf-8;',
			    data: userId ,

			    success: function(data){
			         if(data.result){
			       		$("#idCheck").html("<span style='color:green'>사용하실 수 있는 아이디입니다.</span>");
			       		chkId = true;
			         }else{
			         	$("#idCheck").html("<span style='color:red'>중복된 아이디가 존재합니다.</span>");
			         }
			    },
			    error: function (){        
			                      
			    }
			  });
		}
		
	});
	
	//비밀번호 유효성검사 
	$('#password').blur(function() {
		var password = $("#password").val();
		
		if(password==""){
			$("#passCheck").html("<span style='color:red'>비밀번호를 입력해주세요.</span>");
			chkPw = false;
		}
				
		else if(!passCondition.test(password)){
			$("#passCheck").html("<span style='color:red'>8~16자의 영 소문자와 숫자의 조합으로 입력해주세요.</span>");
			chkPw = false;
		}
		
		else{
			$("#passCheck").html("<span style='color:green'>사용 가능한 비밀번호입니다.</span>");
			chkPw = true;
		}
		
	});
	
	//비밀번호 재확인
	$('#pwConfirm').blur(function() {
		var pass1 = $("#password").val();
		var pass2 = $("#pwConfirm").val();

		if (pass1 == pass2) {
			$("#passEqual").html("<span style='color:green'>비밀번호가 일치합니다.</span>");
			chkPwConfirm = true;
		} else {
			$("#passEqual").html("<span style='color:red'>비밀번호가 일치하지 않습니다.</span>");
			chkPwConfirm = false;
		}
	});
	
	//성명 유효성검사 
	$('#name').blur(function() {
		var name = $("#name").val();
		
		if(name==""){
			$("#nameCheck").html("<span style='color:red'>성명을 입력해주세요.</span>");
			chkName = false;
		}
		
		else if(!nameCondition.test(name)){
			$("#nameCheck").html("<span style='color:red'>성명은 한글로 2~6자로 입력해주세요.</span>");
			chkName = false;
		}
		
		else{
			$("#nameCheck").html("<span style='color:green'>멋진 이름이네요!</span>");
			chkName = true;
		}
	});

	//생년월일 유효성검사 
	$('#brthdy').blur(function() {
		var brthdy = $("#brthdy").val();
		
		if(brthdy==""){
			$("#brthdyCheck").html("<span style='color:red'>생년월일을 입력해주세요.</span>");
			chkBrthdy = false;
		}
		
		else if(!brthdyCondition.test(brthdy)){
			$("#brthdyCheck").html("<span style='color:red'>yyyymmdd 형식에 맞게 입력해주세요.</span>");
			chkBrthdy = false;
		}
		
		else{
			$("#brthdyCheck").html("<span style='color:green'></span>");
			chkBrthdy = true;
		}
	});
	
	//이메일 유효성검사 
	$('#email').blur(function() {
		var email = $("#email").val();
		
		if(email==""){
			$("#emailCheck").html("<span style='color:red'>이메일을 입력해주세요.</span>");
			chkEmail = false;
		}
		
		else if(!emailCondition.test(email)){
			$("#emailCheck").html("<span style='color:red'>이메일 형식에 맞게 입력해주세요.</span>");
			chkEmail = false;
		}
		
		else{
			$("#emailCheck").html("<span style='color:green'></span>");
			chkEmail = true;
		}
	});
	
	//휴대전화 유효성검사 
	$('#mbTlNum').blur(function() {
		var mbTlNum = $("#mbTlNum").val();
		
		if(mbTlNum==""){
			$("#mbTlNumCheck").html("<span style='color:red'>휴대전화번호를 입력해주세요.</span>");
			chkMbTlNum = false;
		}
		
		else if(!telCondition.test(mbTlNum)){
			$("#mbTlNumCheck").html("<span style='color:red'>휴대전화번호 형식에 맞게 입력해주세요.</span>");
			chkMbTlNum = false;
		}
		
		else{
			$("#mbTlNumCheck").html("<span style='color:green'></span>");
			chkMbTlNum = true;
		}
	});
	
	$("#submit").click(function(){
		if(chkId==false){
			alert("아이디를 확인하세요.");
			$("#userId").focus();
			return false;
		}
		
		if(chkPw==false){
			alert("비밀번호를 확인하세요.");
			$("#password").focus();
			return false;
		}
		
		if(chkPwConfirm==false){
			alert("비밀번호가 다릅니다.");
			$("#pwConfirm").focus();
			return false;
		}
		
		if(chkName==false){
			alert("성명을 확인하세요.");
			$("#name").focus();
			return false;
		}
		
		if(chkBrthdy==false){
			alert("생년월일을 확인하세요.");
			$("#brthdy").focus();
			return false;
		}
		
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
});