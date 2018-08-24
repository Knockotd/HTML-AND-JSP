<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*, java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동물 정보</title>
</head>
<body>
<%
//문자열을 파일에 기록
//접속한 아이피 주소 가져오기
String ip = request.getRemoteAddr();
Date date = new Date();
//기록할 파일 스트림 객체 만들기
PrintWriter pw = new PrintWriter(new FileOutputStream("/Users/a503-26/Desktop/"+"log.txt",true));
pw.println(ip+"/"+date+"\n");
pw.flush();
pw.close();
%>

<%
//web.xml 파일에 설정한 초기화 파라미터 읽기
String animal =
application.getInitParameter("animal");
//읽은 내용을 화면에 출
out.println("읽어온파라미터:"+animal+"<br/>");
%>
<form action="parameterform2receive.jsp" method="post">

<table align="center" cellspacing="10" >
<tr>
<td colspan="2" align="right">
<h2 align="center">동물정보</h2>
</td>
</td>
</tr>

<tr>
<td width="100" align="right">이름:</td>
<td width="150">
<input type="text" name="animal" size="20"/>
</td>
</tr>

<tr>
<td width="100" align="right">계:</td>
<td width="150">
<input type="text" name="kind1" size="20"/><br/>
</td>
</tr>

<tr>
<td width="100" align="right">문:</td>
<td width="150">
<input type="text" name="kind2" size="20"/><br/>
</td>
</tr>

<tr>
<td width="100" align="right">강:</td>
<td width="150">
<input type="text" name="kind3" size="20"/><br/>
</td>
</tr>

<tr>
<td width="100" align="right">목:</td>
<td width="150">
<input type="text" name="kind4" size="20"/><br/>
</td>
</tr>

<tr>
<td width="100" align="right">과:</td>
<td width="150">
<input type="text" name="kind5" size="20"/><br/>
</td>
</tr>

<tr>
<td width="100" align="right">이미지 주소 url:</td>
<td width="150">
<input type="text" name="image"/>
</td>
</tr>

<tr>
<td width="100" align="right">설명:</td>
<td width="150">
<textarea cols="40" rows="10" name="explain" style="risize:none;"></textarea>
</td>
</tr>

<tr>
<td colspan="2" align="center">
<input type="submit" value="작성"/>
<input type="reset" value="취소"/>
</td>
</tr>


</table>

</form>
</body>
</html>