<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 이전 페이지에서 만든 bean 가져오기 -->
    <jsp:useBean id="creamheros1" class="vo.creamheros" scope="request"/>
    <jsp:useBean id="creamheros2" class="vo.creamheros" scope="request"/>
    <jsp:useBean id="creamheros3" class="vo.creamheros" scope="request"/>
    <jsp:useBean id="creamheros4" class="vo.creamheros" scope="request"/>
    <jsp:useBean id="creamheros5" class="vo.creamheros" scope="request"/>
    <jsp:useBean id="creamheros6" class="vo.creamheros" scope="request"/>
    <jsp:useBean id="creamheros7" class="vo.creamheros" scope="request"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
p{
text-align:center
}
img{
display:block;
margin-left:auto;
margin-right:auto;
border:1px solid green;
}
</style>
</head>
<body>
<%
out.println("<div><img src='http://cdn.creamheroes.com/communityImages/profile/default_dd.jpg' width='200' ></div>");
out.println("<p>"
+creamheros1.getName()+"<br/>"
+creamheros1.getRace()+"<br/>"
+creamheros1.getColor()+"<br/>"
+creamheros1.getGender()+"<br/>"
+creamheros1.getSize()+"<br/>"
+creamheros1.getNick()+"</p><hr>");

out.println("<div><img src='https://scontent-atl3-1.cdninstagram.com/vp/62d5b0e69313664bc400f5393c80c734/5C098BAF/t51.2885-15/e35/26068245_1332422073528319_2095094964068286464_n.jpg' width='200'></div>");
out.println("<p>"
+creamheros2.getName()+"<br/>"
+creamheros2.getRace()+"<br/>"
+creamheros2.getColor()+"<br/>"
+creamheros2.getGender()+"<br/>"
+creamheros2.getSize()+"<br/>"
+creamheros2.getNick()+"</p><hr>");

out.println("<div><img src='https://pbs.twimg.com/media/DLyUn6oVAAAFGXk.jpg' width='200' ></div>");
out.println("<p>"
+creamheros3.getName()+"<br/>"
+creamheros3.getRace()+"<br/>"
+creamheros3.getColor()+"<br/>"
+creamheros3.getGender()+"<br/>"
+creamheros3.getSize()+"<br/>"
+creamheros3.getNick()+"</p><hr>");

out.println("<div><img src='https://i.pinimg.com/originals/ec/ab/06/ecab066d8b1c1365614767890ab25a5e.jpg' width='200' ></div>");
out.println("<p>"
+creamheros4.getName()+"<br/>"
+creamheros4.getRace()+"<br/>"
+creamheros4.getColor()+"<br/>"
+creamheros4.getGender()+"<br/>"
+creamheros4.getSize()+"<br/>"
+creamheros4.getNick()+"</p><hr>");


out.println("<div><img src='http://cdn.creamheroes.com/communityImages/profile/20171123115121949.jpg' width='200' ></div>");
out.println("<p>"
+creamheros5.getName()+"<br/>"
+creamheros5.getRace()+"<br/>"
+creamheros5.getColor()+"<br/>"
+creamheros5.getGender()+"<br/>"
+creamheros5.getSize()+"<br/>"
+creamheros5.getNick()+"</p><hr>");

out.println("<div><img src='https://pbs.twimg.com/media/DNORf2tUIAEoukD.jpg' width='200' ></div>");
out.println("<p>"
+creamheros6.getName()+"<br/>"
+creamheros6.getRace()+"<br/>"
+creamheros6.getColor()+"<br/>"
+creamheros6.getGender()+"<br/>"
+creamheros6.getSize()+"<br/>"
+creamheros6.getNick()+"</p><hr>");

out.println("<div><img src='https://i.pinimg.com/originals/29/4e/ce/294ecebe707f75e04f9bfca9025d07d0.jpg' width='200' ></div>");
out.println("<p>"
+creamheros7.getName()+"<br/>"
+creamheros7.getRace()+"<br/>"
+creamheros7.getColor()+"<br/>"
+creamheros7.getGender()+"<br/>"
+creamheros7.getSize()+"<br/>"
+creamheros7.getNick()+"</p><hr>");

%>
</body>
</html>