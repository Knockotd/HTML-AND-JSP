<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="creamheros1" class="vo.creamheros" scope="request"/>
    <jsp:useBean id="creamheros2" class="vo.creamheros" scope="request"/>
    <jsp:useBean id="creamheros3" class="vo.creamheros" scope="request"/>
    <jsp:useBean id="creamheros4" class="vo.creamheros" scope="request"/>
    <jsp:useBean id="creamheros5" class="vo.creamheros" scope="request"/>
    <jsp:useBean id="creamheros6" class="vo.creamheros" scope="request"/>
    <jsp:useBean id="creamheros7" class="vo.creamheros" scope="request"/>
<!DOCTYPE html>
<%
creamheros1.setName("디디");
creamheros1.setRace("노르웨이 숲 믹스 / 크림 코트");
creamheros1.setColor("골드");
creamheros1.setGender("남아");
creamheros1.setSize("5.86kg");
creamheros1.setNick("둔둔이");

creamheros2.setName("티티");
creamheros2.setRace("브리티쉬 숏헤어/실버 코트");
creamheros2.setColor("올리브");
creamheros2.setGender("여아");
creamheros2.setSize("4.71kg");
creamheros2.setNick("딸래미");

creamheros3.setName("코코");
creamheros3.setRace("스코티쉬 스트레이트/화이트 코트");
creamheros3.setColor("밝은 하늘");
creamheros3.setGender("남아");
creamheros3.setSize("4.19kg");
creamheros3.setNick("핸섬한2대 둔둔이");

creamheros4.setName("모모");
creamheros4.setRace("페르시안 엑조틱 숏헤어/치즈 태비");
creamheros4.setColor("녹색");
creamheros4.setGender("남아");
creamheros4.setSize("3.83kg");
creamheros4.setNick("모모회장님");

creamheros5.setName("츄츄");
creamheros5.setRace("스코티쉬 폴드/삼색 고양이");
creamheros5.setColor("회색");
creamheros5.setGender("여아");
creamheros5.setSize("2.51kg");
creamheros5.setNick("시츄츄");

creamheros6.setName("루루");
creamheros6.setRace("먼치킨 믹스/갈색 고등어 태비");
creamheros6.setColor("골드");
creamheros6.setGender("남아");
creamheros6.setSize("2.70kg");
creamheros6.setNick("선장님");

creamheros7.setName("라라");
creamheros7.setRace("먼치킨/화이트 코트");
creamheros7.setColor("짙은 바다");
creamheros7.setGender("여아");
creamheros7.setSize("2.74kg");
creamheros7.setNick("자유로운 영혼");

%>
<!-- 포워딩 -->
<jsp:forward page="beanuse.jsp"/>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>