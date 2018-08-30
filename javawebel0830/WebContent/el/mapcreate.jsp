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
/*
//Map 데이터 생성
Map <String, Object> map = new HashMap<>();
map.put("name", "루루");
map.put("age", "24");

//request에 저장
request.setAttribute("data", map);
*/

//DTO(VO) 클래스로 데이터 생성
dto.Cats cats = new dto.Cats();
cats.setName("루루");
cats.setAge(24);

//request에 저장
request.setAttribute("data", cats);


//결과를 출력할 페이지로 포워딩
RequestDispatcher dispatcher = request.getRequestDispatcher("mapdisplay.jsp");
dispatcher.forward(request,response);
%>
</body>
</html>