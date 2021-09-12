<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Java入門</title>
</head>
<body>
	<% for(int i = 0; i < 5; i++) {  %>
	<h1>schoo WEB-campus</h1>
	<% } %>
	<p>%@ page.... これで始まるのが、ページディレクティブ。ここで言語やインポートとかの設定系が行える</p>
	<p>% ....のみで、スクリプトレット。Javaのコーディングができる。</p>
	<p>%= ....で、スクリプト式。変数の値設定や、メソッドの戻り値の設定に利用する。</p>
	<p>%--....--%%で、JSPコメント。コメントを記入する際はこれを利用する</p>
</body>
</html>
