<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//데이터 저장
/*request.setAttribute("name", "루루");
request.setAttribute("score", 2017);
*/
//결과 페이지로 포워딩
/*
RequestDispatcher dispatcher = request.getRequestDispatcher("attrdisplay.jsp");
dispatcher.forward(request, response);
*/

//결과 페이지로 redirect : request의 데이터는 전달이 안됨.
//세션


session.setAttribute("name", "루루");
session.setAttribute("score", 2017);

response.sendRedirect("attrdisplay.jsp");
%>