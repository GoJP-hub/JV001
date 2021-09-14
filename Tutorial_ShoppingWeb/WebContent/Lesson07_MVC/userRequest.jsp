<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<%-- Java入門 MVCモデル V（ビュー） --%>
<%-- ID入力画面 --%>
<!DOCTYPE html>
<html>
	<head>
		<title>Java入門</title>
	</head>
	<body>
		<p>インプットフォーム</p>
		<%-- POSTTメソッドでテキストを送信 --%>
		<form action="../ControllerServlet" method="post">
			<p>IDを入力してください：<input type="text" name="id"></p>
			<p>IDはweb01またはweb02です</p>
			<input type="submit" value="リクエスト">
		</form>
	</body>
</html>