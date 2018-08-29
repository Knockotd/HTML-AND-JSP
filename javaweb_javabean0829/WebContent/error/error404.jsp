<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>404에러 페이지</title>
<style>
body{
background-image: url('../images/404error.png')
}
p, h3{
text-align:center;
}
#a{
text-align:center;
}
img{
display:block;
margin-left:auto;
margin-right:auto;
}

</style>
</head>
<body>
<p>5초 후에 메인페이지로 이동합니다.</p>
<h3>404. That’s an error.</h3>
<div id=a>
<strong>The requested URL /skdfjk was not found on this server.</strong><br/>
That’s all we know.
</div>

<div><img src="../images/errorimage.png" align="center" width="200"></div>
</body>
<script>
setTimeout(function(){
	location.href="../javabean/beanceate.jsp"
}, 5000)
</script>
</html>