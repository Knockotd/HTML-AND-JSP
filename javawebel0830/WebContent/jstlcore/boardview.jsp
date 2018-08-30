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

<table rules="rows" width="700" align="center" cellpadding="5">

	<tr>
		<th width="30" >번호</th>
		<th width="400">글제목</th>
		<th width="100">작성자</th>
		<th width="100">작성일</th>
		<th width="50">조회수</th>
	</tr>
	<c:forEach var="imsi" items="${list }">
		<tr>
			<td align="right">${imsi.num}</td>
			<td>${imsi.title}</td>
			<td>${imsi.nickname}</td>
			<td>${imsi.regdate}</td>
			<td>${imsi.regcnt}</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>