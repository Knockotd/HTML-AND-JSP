<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메일 보내기</title>
</head>
<body>
<form action="send.go" method="post">
받는 사람 : <input type="text" name="receiver" required="required"	/><br/>
제목 : <input type="text" name="title" /><br/>
내용 : <textarea rows="10" cols="30" name="msg"></textarea><br/>
<input type="submit" value="메일보내기" /><br/>

</form>
</body>
</html>