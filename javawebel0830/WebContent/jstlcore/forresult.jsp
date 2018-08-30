<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- items 의 값을 바꾸어가며 실습: arrays, list, map, ar -->
	<ul>
	<c:forEach var="imsi" items="${map}">
	<li>${imsi}
	</c:forEach>
	</ul>
</body>
</html>