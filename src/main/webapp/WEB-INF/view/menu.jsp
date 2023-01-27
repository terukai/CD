<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>

<link rel ="stylesheet"href="css/menu.css">

</head>
<body style="background-color:floralwhite">
	<%
		User ac = (User)session.getAttribute("user");
	%>
	<h3>CD管理システム</h3>
	<div class="menu">
	<p class="p1">ようこそ<%=ac.getName() %>さん</p><br>
	<a href="CDregisterServlet">新規登録</a><br>
	<br>
	<a href="CDlistServlet">CD一覧</a><br>
	<br>
	<a href="CDdeleteServlet">登録削除</a><br>
	<br>
	</div>
</body>
</html>