<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>jsp include 는 다른 페이지의 수행결과를 포함하는 페이지 입니다.</p>
<jsp:include page="sub.jsp" flush="false">
		<jsp:param name="data" value="데이터" />
	</jsp:include>
</body>
</html>