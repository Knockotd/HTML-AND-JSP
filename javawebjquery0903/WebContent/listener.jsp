<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jQuery 연습</title>
</head>
<body>
<%
	session.setAttribute("dataa","sksksk");
%>
	프로젝트 이름까지의 경로
	${pageContext.request.contextPath}
	<input type="button" value="클릭" id="btn"/>
	
</body>

<script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>

<script>

$('#btn').bind('click', function(){
	
	console.log("로그를 출력합니다.")
	
});

//스크립트에 $로 시작하면 제이쿼리를 사용하는 것입니다.
//문서의 내용을 전부 읽자 마자 라는 뜻입니다(아래)
$(function(){
	alert("나어라")
})
</script>
</html>