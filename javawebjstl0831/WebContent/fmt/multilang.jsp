<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <!-- jstl 의 fmt 기능을 위한 태그 라이브러리 설정 -->
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <!-- 다국어 설정 파일의 대표 이름 설정 -->
    <fmt:setBundle basename="intro"/>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="date" value="<%=new Date() %>"></c:set>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다국어지원</title>
</head>
<body>
	<h1><fmt:message key="title"/></h1>
	서울: <fmt:formatDate value="${date }" type="both"/>
	<br/>
	<fmt:timeZone value="Europe/London">
	런던:<fmt:formatDate value="${date }" type="both"/>
	</fmt:timeZone>
</body>
</html>