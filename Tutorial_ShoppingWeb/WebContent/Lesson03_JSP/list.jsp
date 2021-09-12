<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<title>Java入門</title>
</head>
<body>
	<% ArrayList<String> list = new ArrayList<String>(); %>
	<% list.add("schoo "); %>
	<% list.add("WEB-"); %>
	<% list.add("campus"); %>
	
	<% for(int i = 0; i < list.size(); i++) {  %>
		<%= list.get(i) %>
	<% } %>
</body>
</html>