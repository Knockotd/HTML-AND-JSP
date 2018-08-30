<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>choose 테스트</title>
</head>
<body>
<c:choose>
	<c:when test="${param.score >= 90}">
	<h1>당신의 점수는 A</h1>
	</c:when>
	
	<c:when test="${param.score >= 80 }">
	<h1>당신의 점수는 B</h1>
	</c:when>
	
	<c:when test="${param.score >= 70 }">
	<h1>당신의 점수는 C</h1>
	</c:when>

	<c:when test="${param.score >= 60 }">
	<h1>당신의 점수는 D</h1>
	</c:when>
	
	<c:otherwise>
	<h1>당신의 점수는 F</h1>
	</c:otherwise>
</c:choose>
</body>
</html>