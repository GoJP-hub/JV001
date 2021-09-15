<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Java入門</title>
	</head>
	<body>
		<p>アクセス回数</p>
		<p><%=session.getAttribute("name_session") %>さんのアクセス回数</p>
		<p>リクエスト：<%=request.getAttribute("access_request") %>回</p>
		<p>セッション：<%=session.getAttribute("access_session") %>回</p>
		<p>アプリケーション：<%=application.getAttribute("access_application") %>回</p>
		<form>
			<input type="button" onclick="location.href='../Lesson08_Scope/scope.jsp'" value="戻る">
		</form>
	</body>
</html>