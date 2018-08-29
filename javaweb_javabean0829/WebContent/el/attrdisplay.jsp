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
h1, h3{
text-align:center;
}
img{
display:block;
margin-left:auto;
margin-right:auto;
border:3px solid #FE9A2E;
}
footer{
position:absolute;
    bottom:0;
    width:100%;
    height:70px;   
text-align:right;
}
</style>
</head>
<body>
<p>
<h1>냥이 이름: ${sessionScope.name}</h1>
<h3>나이: ${(2018-score)*12+8}살</h3>
<img src="../images/루루5.gif">
</p>
<footer>생선 이미지 출처: https://www.flaticon.com/free-icon/fish_830525#term=fish&page=2&position=65</footer>
</body>
</html>