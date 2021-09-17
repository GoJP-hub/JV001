<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="user_lesson10" scope="session" class="lesson10_login.LoginUserBean" />

<!DOCTYPE html>
<html>
	<head>
		<title>Java入門</title>
		<link href="/Tutorial_ShoppingWeb/Lesson10_Login/css/login.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<h1>ログインユーザ情報</h1>
		<p>ID:<jsp:getProperty property="id" name="user_lesson10"/></p>
		<p>名前:<jsp:getProperty property="name" name="user_lesson10"/></p>
		<p>年齢:<jsp:getProperty property="age" name="user_lesson10"/></p>
		<form>
			<input class="common_button" type="button" onclick="location.href='./Lesson10_Login/login.jsp'" value="戻る">
		</form>
	</body>
</html>