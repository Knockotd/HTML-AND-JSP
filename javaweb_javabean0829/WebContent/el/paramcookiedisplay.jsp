<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body{
background-image: url("../images/fish (1).png");
}
p{
text-align:center
}
img{
display:block;
margin-left:auto;
margin-right:auto;
border:3px solid #FE9A2E;
}

</style>
</head>
<body>
<h1>파라미터 : ${param.name}</h1>
<img src="../images/chuchu.gif" width="300px"/>
<hr>
<h1>쿠키의 해시코드 : ${cookie.sessionid}</h1>
<h1>쿠키 : ${cookie.sessionid.value}</h1>
<img src="../images/디디1.gif" width="300px"/>
<hr>
<h1>초기화 파라미터 : ${initparam.user05}</h1>
<%
//이렇게 가져다 쓰면 된다.
String attr = application.getInitParameter("user05");
System.out.println(attr);
%>
</body>
</html>