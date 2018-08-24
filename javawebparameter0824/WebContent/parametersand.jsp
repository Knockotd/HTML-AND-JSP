<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파라미터 전송</title>
</head>
<body>
<a href="parameterreceive.jsp?name=park&age=26">파라미터 전송</a>

<form action="parameterformreceive.jsp" method="get">
이메일<input type="email" name="email" /><br/>
<fieldset>
	<legend>성별</legend>
	<input type="radio" value="woman" checked="checked" name="gender"/>여자
	<input type="radio" value="man" name="gender"/>남자
</fieldset>
<fieldset>
	<legend>취미</legend>
	<input type="checkbox" value="reading"  name="hobby"/>독서
	<input type="checkbox" value="game"  name="hobby"/>게임
	<input type="checkbox" value="sports"  name="hobby"/>운동
	<input type="checkbox" value="programming"  name="hobby"/>프로그래밍
</fieldset><br/>

<input type="submit" value="전송"/>
</form>
</body>
</html>