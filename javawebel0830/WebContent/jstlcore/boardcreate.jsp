<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
//map에 리스트로 2차원 배열을 만들어서 게시판 만들기

List<Map<String, Object>> list = new ArrayList<>();

Map<String, Object> map = new HashMap<>();

map.put("num",1);
map.put("title","가입인사");
map.put("nickname","사슴비행기");
map.put("regdate","2018-08-30");
map.put("regcnt","54");

list.add(map);

map = new HashMap<>();
map.put("num",2);
map.put("title","반가워요~!");
map.put("nickname","개미핥기");
map.put("regdate","2018-08-31");
map.put("regcnt","102");

list.add(map);


request.setAttribute("list", list);


RequestDispatcher dispatcher = request.getRequestDispatcher("boardview.jsp");
dispatcher.forward(request, response);
%>
