<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//문자열을 저장할 수 있는 List를 만들고 데이터를 저장
	List<String> list =new ArrayList<String>();
	list.add("황제펭귄");
	list.add("먼치킨고양이");
	list.add("웰시코기");
	
	for(String imsi : list){
		out.println("<p>"+imsi+"</p>");
	}
%>
</body>
</html>