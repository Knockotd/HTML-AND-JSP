<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
#registermsg{color:red}
</style>
</head>
<body>
<h1>회원가입</h1>
<img src="${pageContext.request.contextPath }/image/루루1.gif"/>
<form action="insert" method="post" id="registerform">
<div id="registermsg">${registermsg }</div>
	<label for="email">아이디</label>
	<input type="email" name="email" id="email" required="required" />
	<span id="emailmsg"></span><br/>
	<label for="password">비밀번호</label>
	<input type="password" name="password" id="password" required="required" /><br/>
	<label for="name">이름</label>
	<input type="text" name="name" id="name" required="required" /><br/>
		<label for="mphone">핸드폰 번호</label>
	<input type="text" name="mphone" id="mphone" required="required" /><br/>
		<label for="addr">주소</label>
	<input type="text" name="addr" id="addr" width="100" /><br/>
			<label for="recoveremail">임시 이메일</label>
	<input type="email" name="recoveremail" id="recoveremail" /><br/>
	<input type="submit" value="회원가입" />
	<input type="button" value="메인으로"  onclick="location.href='../'"/>
</form>
</body>
<script src="${pageContext.request.contextPath}/resource/js/jquery.js"></script>
<script>
var email = document.getElementById("email")
var emailmsg = document.getElementById("emailmsg")
//중복검사 여부를 저장할 변수
var emailcheck = false;

email.addEventListener("blur", function(){
	emailcheck=false;
	//이메일에 입력된 값 가져오기
	var value = email.value
	
	$.ajax({
		url:'emailcheck',
		data:{'email':value},
		dataType:'json',
		success:function(data){
			if(data.result == true){
				emailmsg.innerHTML = '사용 불가능한 아이디입니다.'
				emailmsg.style.color = "red"
				emailcheck=false;
			}else{
				emailmsg.innerHTML = '사용 가능한 아이디입니다.'
					emailmsg.style.color = "blue"
					emailcheck=true;
			}
		}
		
	})
	
})
//폼의 데이터를 전송할 때
document.getElementById("registerform").addEventListener("submit", function(e){
	var event = e || window.event
	if(emailcheck == false){
		alert("이메일 중복체크를 안하셨습니다.")
		emailmsg.innerHTML="이메일 중복 체크를 다시 하세요."
		
		//이벤트 발생시 기본적으로 수행하는 내용하지 않기
		//이 경우에는 폼의 데이터가 전송되지 않습니다.
		event.preventDefault();
		//그리고 포커스가 email로 이동합니다.
		email.focus()
	}
})
</script>
</html>