<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>폼 데이터 읽기</title>
</head>
<body>
<%
String email = request.getParameter("email");
String gender = request.getParameter("gender");
//String hobby = request.getParameter("hobby");
String [] hobbys = request.getParameterValues("hobby");
%>

이메일:<%=email %>
성별:<%=gender %>
취미:<%for(String imsi : hobbys){ %>
	<%=imsi %>,
<% } %>
</body>
</html>