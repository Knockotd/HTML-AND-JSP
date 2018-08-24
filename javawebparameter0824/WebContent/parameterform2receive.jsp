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
request.setCharacterEncoding("utf-8");
String animal = request.getParameter("animal");
String kind1 = request.getParameter("kind1");
String kind2 = request.getParameter("kind2");
String kind3 = request.getParameter("kind3");
String kind4 = request.getParameter("kind4");
String kind5 = request.getParameter("kind5");
String image = request.getParameter("image");
String explain = request.getParameter("explain");
%>

동물이름:<%= animal%><br/>
사진:<br/><img src="<%=image%>" width="200"  height="200"><br/>
종:<%=kind1+"계/"+kind2+"문/"+kind3+"강/"+kind4+"목"+kind5+"과" %><br/>
설명:<br/><textarea cols="50" rows="50" resizable="false"><%=explain %></textarea><br/>


<!--% Thread th = new Thread();
th.sleep(5000);
response.sendRedirect("https://terms.naver.com/entry.nhn?docId=1381675&cid=40942&categoryId=32618");
%> -->
</body>
</html>