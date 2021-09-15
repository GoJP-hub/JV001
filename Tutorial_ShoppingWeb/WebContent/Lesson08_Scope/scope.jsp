<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Java入門</title>
	</head>
	<body>
		<p>インプットフォーム</p>
		<form action="../lesson08_scope/ScopeSetServlet" method="post">
			<p>名前を入力してください：<input type="text" name="name_request"></p>
			<input type="submit" value="送信">
		</form>
	</body>
</html>