<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="user" scope="request" class="lesson07_mvc.UserBean" />

<!DOCTYPE html>
<html>
	<head>
		<title>Java入門</title>
	</head>
	<body>
		<p>リクエスト結果</p>
		<p>ID:<%=user.getId() %></p>
		<p>名前:<%=user.getName() %></p>
		<p>年齢:<%=user.getAge() %></p>
		<form>
			<input type="button" onclick="location.href='../Lesson07_MVC/userRequest.jsp'" value="戻る">
		</form>
	</body>
</html>