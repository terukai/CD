<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録確認</title>
</head>
<body>
	<p>下記の内容で登録します。よろしいですか？</p>
	<%
	User user = (User)session.getAttribute("input_data");
	%>
	メール：<%=user.getMail() %><br>
	パスワード：********<br>
	名前：<%=user.getName() %><br>
	
	<a href="RegisterExecuteServlet">OK</a><br>
	<a href="RegisterFormServlet">戻る</a>
	
</body>
</html>