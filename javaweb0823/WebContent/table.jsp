<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.util.*" %>
    
    <%
    
    //테이블 형식의 데이터 만들기
    
	List<Map<String, String>> list = new ArrayList<>();
    
    Map<String, String> map = new HashMap<>();
    
    map.put("name","박보검");
   map.put("frofile","차이나타운");
   list.add(map);
   
   map = new HashMap<>();
   map.put("name","황정민");
  map.put("frofile","곡성");
  list.add(map);   
    
  map = new HashMap<>();
  map.put("name","조정석");
 map.put("frofile","오나의귀신님");
 list.add(map);
    
 map = new HashMap<>();
 map.put("name","박보영");
map.put("frofile","늑대소년");
list.add(map);
    
map = new HashMap<>();
map.put("name","송중기");
map.put("frofile","태양의후예");
list.add(map);
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테이블 형태의 데이터 출력</title>

</head>
<body>
<h2>map의 list출력</h2>
<table border="1" align="center" width="300">
	<tr>
	<th>이름</th>
	<th>작품명</th>
	</tr>
	
	<% for(Map imsi : list){%>
	
	<tr>
	<td><%=imsi.get("name") %></td>
	<td><%=imsi.get("frofile") %></td>
	</tr>
	
	<%} %>
</table>
</body>
</html>