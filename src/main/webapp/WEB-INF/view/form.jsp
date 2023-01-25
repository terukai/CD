<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="dto.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	request.setCharacterEncoding("UTF-8");
			String errorCode = request.getParameter("error");
			if(errorCode != null && errorCode.equals("1")){
				User user = (User)session.getAttribute("input_data");
	%>
		<p style="color:red">登録に失敗しました。</p>
		<a href="./">戻る</a>

	<%
		} else {
	%>
	<h3>新規登録</h3>
	<form action="RegisterConfirmServlet" method="post">
		メール：<input type="email" name="mail"><br>
	 	PW：<input type="password" name="pw"><br>	
		名前：<input type="text" name="name"><br>
		<input type="submit" value="登録">
	</form>
	<%
		}
	%>
</body>
</html>