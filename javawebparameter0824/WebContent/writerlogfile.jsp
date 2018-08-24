<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page import="java.util.*, java.io.*" %>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//문자열을 파일에 기록
//접속한 아이피 주소 가져오기
String ip = request.getRemoteAddr();
Date date = new Date();

Calendar calendar = new GregorianCalendar();
int year = calendar.get(Calendar.YEAR);
int month = calendar.get(Calendar.MONTH);
int day = calendar.get(Calendar.DATE);

String filename = year+""+(month+1)+""+day+",txt";

//기록할 파일 스트림 객체 만들기
PrintWriter pw = new PrintWriter(new FileOutputStream("/Users/a503-26/Desktop/"+filename,true));
pw.println(ip+"/"+date+"\n");
pw.flush();
pw.close();
%>
<h1>이 사이트에 접속(새로고침)하면 로그 파일이 생성 됩니다.</h1>
</body>
</html>