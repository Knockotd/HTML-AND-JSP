<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>페이지 이동-HTML에서 요청</title>
</head>
<body>
<!-- 입력이 없으면 a 태그를 사용해서 url속에 직접 파라미터를 포함해서 전달 -->
<a href="process.jsp?email=aisdugo@gmail.com&pw=1234&name=크림히어로">process로 이동</a><br/>

<form action="process.jsp" id="myform" method="post">
<!-- method="post"로 전송하게 되면 한글은 깨집니다.
method="post"를 안 쓰면 한글이 안 깨지지만 주소창에 입력한 데이터가 보이므로 보안적으로 좋지 않습니다. -->
이메일<input type="email" name="email"/><br/>
비민번호<input type="password" name="pw"/><br/>
이름<input type="text" name="name"/><br/>
<input type="submit" value="전송"/><br/>

<input type="button" value="location 이용" id="btn1" />
<input type="button" value="window 이용" id="btn2" />
<input type="button" value="뒤로" id="back" />
<input type="button" value="새로고침" id="reload" />
<input type="button" value="폼 데이터 전송" id="formsubmit" />
<input type="button" value="ajax" id="ajax" />

</form>

</body>
<script>

var btn1 = document.getElementById("btn1")
var btn2 = document.getElementById("btn2")
var back = document.getElementById("back")
var reload = document.getElementById("reload")
var formsubmit = document.getElementById("formsubmit")
var ajax = document.getElementById("ajax")

btn1.addEventListener("click", function(e){
	//process.jsp를 요청
	location.href="process.jsp?email=aisdugo&pw=123444&name=크림히어로즈";
});
btn2.addEventListener("click", function(e){
	window.location="process.jsp?email=knock_otd999&pw=ㄴㅇㅁㅎㅇㅎ&name=크림히어로즈";
});
back.addEventListener("click", function(e){
	//이전 url을 요청
	history.back();
});
reload.addEventListener("click", function(e){
	//새로고침 - 현재 url을 다시 요청
	location.reload();
});
formsubmit.addEventListener("click", function(e){
	document.getElementById("myform").submit();
});
ajax.addEventListener("click", function(e){
	//ajax 요청 객체 생성
	var request1 = new XMLHttpRequest();
	//요청을 생성하고 요청
	/*
	GET 방식으로 파라미터 전
	request1.open('GET', 'process.jsp?email=aisdugo@naver.com&pw=9283940&name=크림크림루')
	*/
	//ajax에서 POST 방식으로 파라미터 전송
	request1.open('POST', 'process.jsp')
	//전송 방식을 form으로 설정해서 post 	방식으로 전송합니다.
request1.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	request1.send('email=aisdugo@naver.comㄴㅇㄹ');
	//ajax 요청에 성공하면 호출하는 콜백 메소드 등록
	request1.onreadystatechange = function(){
		if(request1.readyState == 4){
			if(request1.status >= 200 && request1.status <300){
	alert("요청 성공")
}
			}
		}
	
});

</script>
</html>