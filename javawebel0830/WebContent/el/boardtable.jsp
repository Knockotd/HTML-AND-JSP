<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
<table border="1" align="center">
<tr>
<th>글번호</th>
<th>글제목</th>
<th>작성자</th>
<th>작성일</th>
<th>조회수</th>
</tr>

<!-- 1행 -->
<tr>
<td>
${data.num}
</td>
<td>
<a href="derailpage${data.num }.jsp?${data.num }">
${data.title}
</a>
</td>
<td>
${data.nickname}
</td>
<td>
${data.regdate}
</td>
<td>
${data.readcnt}
</td>
</tr>

<!-- 2행 -->
<tr>
<td>
${data1.num}
</td>
<td>
<a href="derailpage${data1.num }.jsp?${data1.num }">
${data1.title}
</a>
</td>
<td>
${data1.nickname}
</td>
<td>
${data1.regdate}
</td>
<td>
${data1.readcnt}
</td>
</tr>

</table>
</body>
</html>