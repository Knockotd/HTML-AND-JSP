<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>피보나치 수열 출력</title>
</head>
<body>
<%
//20번째 피보나치 수열의 값 구하기
//피보나치 수열 : 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
//첫번째와 두번째는 1
//세번째 부터는 앞의 2개의 합

int n1 =1;
int n2 =1;
int idx = 1;
int result = 0;
while(idx<=20){
	
	if(idx<=2){
		idx=idx+1;
	}else{
		result = n1+n2;
		n1=n2;
		n2=result;
		idx=idx+1;
	}
}
%>
20번째 피보나치 수열의 값은 <%=result %> 입니다.
</body>
</html>