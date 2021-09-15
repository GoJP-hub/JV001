<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<jsp:useBean id="user" scope="request" class="websample09.UserBean2" />

<!DOCTYPE html>
<html>
	<head>
		<title>Java入門</title>
	</head>
	<body>
		<p>リクエスト結果</p>
		<%--一般権限の場合はIDと年齢を非表示にする--%>
		<% if(user.getAuth() == 1) { %>
			<p>ID:<%=user.getId() %></p>
		<% } %>
			<p>名前:<%=user.getName() %></p>
		<% if(user.getAuth() == 1) { %>
			<p>年齢:<%=user.getAge() %></p>
		<% } %>
		
<%--
		<% if(user.getAuth() == 1) { %>
			<p>ID:<jsp:getProperty property="id" name="user"/></p>
		<% } %>
		
			<p>名前:<jsp:getProperty property="name" name="user"/></p>
		
		<% if(user.getAuth() == 1) { %>
			<p>年齢:<jsp:getProperty property="age" name="user"/></p>
		<% } %>
--%>
		<form>
			<input type="button" onclick="location.href='./WEB-sample09/userRequest2.jsp'" value="戻る">
		</form>
	</body>
</html>