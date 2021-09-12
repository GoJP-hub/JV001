<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Java入門</title>
</head>
<body>
	<%-- 変数の宣言 --%>
	<% String str = "schoo WEB-campus"; %>
	
	<%-- 変数の内容を出力 --%>
	<p><%= str %></p>
	<%-- 演算式の結果を出力 --%>
	<p><%= 10 + 10 %></p>
	<%-- メソッドの処理結果を出力 --%>
	<p><%= str.length() %></p>
</body>
</html>
