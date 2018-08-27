<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>처리 파일</title>
</head>
<body>
<h2>처리 파일입니다.</h2>

<%
//post 방식에서의 인코딩 방식
request.setCharacterEncoding("utf-8");
//데이터 읽기
String email = request.getParameter("email");
String pw = request.getParameter("pw");
String name = request.getParameter("name");

System.out.println(email);


%>

<p>email : <%=email %></p>
<p>pw : <%=pw %></p>
<p>name : <%=name %></p>
</body>
</html>