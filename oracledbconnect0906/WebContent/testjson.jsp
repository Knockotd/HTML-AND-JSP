<%@ page language="java" contentType="text/json; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.json.*" %>
<%
	JSONObject obj = new JSONObject();
	obj.put("name","이순신");
	
	JSONArray ar = new JSONArray();
	ar.put("박보검");
	ar.put("양요섭");
	ar.put("김하온");
	ar.put("몰");
	
%>
<%=obj%>
<%=ar %>
