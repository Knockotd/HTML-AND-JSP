<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%
//문자열 배열 만들기
String [] arrays = {
		"가", "갸","거","겨","구","규","그","기"
};
//문자열 리스트 만들기
List<String> list = new ArrayList<>();
list.add("아");
list.add("야");
list.add("어");
list.add("여");
list.add("우");
list.add("유");
list.add("으");
list.add("이");
//맵 객체를 생성하고 데이터 저장
Map<String, Object> map = new HashMap<>();
map.put("모음", "가나다라마바사아자차카타파하");
map.put("자음","다댜더뎌두듀드디");

//,로 구분된 문자열 만들기
String ar = "나,냐,너,녀,누,뉴,느,니";


//결과 페이지에 전달하기 위해서 데이터 저장
request.setAttribute("arrays", arrays);
request.setAttribute("list", list);
request.setAttribute("map", map);
request.setAttribute("ar", ar);

//결과 페이지로 이동하기
RequestDispatcher dispatcher = request.getRequestDispatcher("forresult.jsp");
dispatcher.forward(request, response);
%>