<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Java入門</title>
	</head>
	<body>
		<p>インプットフォーム</p>
		<p>値を入力してください</p>

		<%-- GETメソッドでテキストを送信 --%>
		<form action="../lesson05_Form/FormServlet">
			<p>ここに値を入れてください：<input type="text" name="text1"></p>
			<p>ここに値を入れてください：<input type="text" name="text2"></p>
			<input type="submit" value="GETで送信">
		</form>

		<%-- POSTメソッドでテキストを送信 --%>
		<form method="post" action="../lesson05_Form/FormServlet">
			<p>ここに値を入れてください：<input type="text" name="text1"></p>
			<p>ここに値を入れてください：<input type="text" name="text2"></p>
			<input type="submit" value="POSTで送信">
		</form>
	</body>
</html>