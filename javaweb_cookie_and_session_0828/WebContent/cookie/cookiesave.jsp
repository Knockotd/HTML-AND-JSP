<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 쿠키에 저장되는 데이터가 한글이라서 utf-8로 인코딩하기 위한 클래스를 사용하기 위해서 import -->
<%@ page import="java.net.*" %>
<%
//공백과 한글 인코딩 후 쿠키 생성
String msg = "Java web Programming";
//utf-8로 인코딩
String value = URLEncoder.encode(msg, "utf-8");
String msg1 = "인코딩 인코딩 이이이이인코";
//utf-8로 인코딩
String value1 = URLEncoder.encode(msg1, "utf-8");

//쿠키 생성
Cookie cookie = new Cookie("JSP", value);
cookie.setMaxAge(60);
Cookie cookie1 = new Cookie("JSP1", value1);
//브라우저에 쿠키 저장
response.addCookie(cookie);
response.addCookie(cookie1);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 생성</title>
</head>
<body>
<a href="cookie/cookieread.jsp">쿠키 읽기</a>
</body>
</html>