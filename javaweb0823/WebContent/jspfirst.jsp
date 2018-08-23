<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <!-- 불필요한 공백 제거 -->
    <%@ page trimDirectiveWhitespaces="true" %>
    <!-- 패키지 import -->
    <%@ page import="java.util.*" %>
    <%
    //현재 시간을 갖는 캘린더 객체 만들기
    Calendar calendar = new GregorianCalendar();
   
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>처음 만드는 JSP파일</title>
</head>
<body>
<h3>* 처음 만들어보는 JSP파일입니다.</h3>
<h3>* 스크립트 사용</h3>
<h5>Calendar 객체를 오늘 날짜를 가지고 생성해서 년 월 일을 출력</h5>
<p>년도:<%=calendar.get(Calendar.YEAR) %><br/>
월:<%=calendar.get(Calendar.MONTH)+1 %><br/>
일:<%=calendar.get(Calendar.DATE) %><br/>



</body>
</html>