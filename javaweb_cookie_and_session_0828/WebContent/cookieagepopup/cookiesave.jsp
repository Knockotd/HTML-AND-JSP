<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.net.*" %>
    <%
  Cookie cookie = new Cookie("popup","1234");
    //쿠키 수명 설정
    cookie.setMaxAge(60);
    //쿠키를 브라우저에 추가
    response.addCookie(cookie);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 수명 저장</title>
</head>
<body>
<a href="cookieread.jsp">쿠키 읽기</a>
</body>
</html> 