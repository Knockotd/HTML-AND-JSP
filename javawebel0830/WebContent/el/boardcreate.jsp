<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Data Save</title>
</head>
<body>
<%@ page import="java.util.*" %>
<%
Map<String, Object> map = new HashMap<>();
map.put("num",1);
map.put("title","제목1");
map.put("nickname","관리자");
map.put("regdate","2018-08-30");
map.put("readcnt",232);
request.setAttribute("data", map);

map = new HashMap<>();
map.put("num",2);
map.put("title","제목2");
map.put("nickname","관리자");
map.put("regdate","2018-08-30");
map.put("readcnt",22);
request.setAttribute("data1", map);


RequestDispatcher dispatcher = request.getRequestDispatcher("boardtable.jsp");
dispatcher.forward(request, response);

%>
</body>
</html>