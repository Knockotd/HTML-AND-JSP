<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//	다른 URL로 포워딩 - 현재 도메인 내에서만 이동이 가능
	//프로젝트 안에 있는 파일의 경로를 설정
	//URL이 변경되지 않습니다.
	//새로고침을 하면 animal.jsp가 새로고침 되는게 아니고 현재 페이지가 새로고침 됩니다.
	//pageContext.forward("animal.jsp");

	//리다이렉트 - 외부 도메인으로 이동 가능
	//새로고침을 하면 animal.jsp가 새로고침됩니다.
	//URL이 변경됩니다.
	response.sendRedirect("animal.jsp");
%>
</body>
</html>