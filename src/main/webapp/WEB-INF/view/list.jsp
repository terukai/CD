<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="dto.CD" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CD一覧ページ</title>
</head>
<body>
	<h1>登録CD一覧</h1>
	<table border=1>
		<tr>
			<th>ID</th>
			<th>タイトル</th>
			<th>作曲者</th>
			<th>歌手</th>
			<th>リリース日</th>
			<th>時間</th>
		</tr>
	<%
		List<CD> list = (ArrayList<CD>)request.getAttribute("list");
		for(CD cd : list){
	%>
		<tr>
			<td><%=cd.getId() %></td>
			<td><%=cd.getTitle() %></td>
			<td><%=cd.getComposter() %></td>
			<td><%=cd.getSinger() %></td>
			<td><%=cd.getRelease() %></td>
			<td><%=cd.getLength() %></td>
		</tr>
	<%} %>
	<a href="TopSErvlet">戻る</a><br>
</body>
</html>