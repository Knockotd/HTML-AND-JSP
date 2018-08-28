<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인처리</title>
</head>
<body>
<%
//post 방식일 때 파라미터 인코딩을 해준다.
request.setCharacterEncoding("utf-8");

//파라미터 읽기
String id = request.getParameter("id");
String pw = request.getParameter("pw");

if(id.equals("system") && pw.equals("1234")){
	//out.println("로그인 성공");
	
	//로그인 정보를 세션에 저장
	session.setAttribute("id",id);
	//닉네임을 정해서 저장
	session.setAttribute("nick","관리자");
	//main.jsp 파일로 리다이렉트
	//새로고침했을 때 로그인을 다시하면 안되기 때문에 리다이렉트를 해야한다.
	response.sendRedirect("main.jsp");
	
}else{
	//out.println("틀림");
	if(id.equals("system")){session.setAttribute("msg","비밀번호가 틀렸습니다.");}
	else if(pw.equals("1234")){session.setAttribute("msg","아이디가 틀렸습니다.");}
	else{session.setAttribute("msg","아이디와 비밀번호가 틀렸습니다.");}
	response.sendRedirect("login.jsp");
}

%> 
</body>
</html>