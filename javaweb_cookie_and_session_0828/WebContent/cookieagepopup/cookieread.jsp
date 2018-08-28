<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ page import="java.net.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 수명 읽기</title>
</head>
<body>
<% 
Cookie [] cookies = request.getCookies();
boolean flag = false;
	if(cookies != null){
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("popup")){
				flag = true;
				break;
			}
		}
	}
	if(flag == false){
		out.println("<script>");
		// window.open('경로', '이름', 속성)
		out.println("window.open('https://www.google.com', 'google', 'width=600, height=300')");
		out.println("</script>");
	}
%>

</body>
</html>