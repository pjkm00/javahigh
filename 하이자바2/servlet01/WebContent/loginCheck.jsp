<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login 페이지</title>
</head>
<body>
	<form action="/servlet01/loginCheckServlet.do">
		아이디 : <input type="text" name="id" >
		비밀번호 : <input type="password" name="pwd">
		<br><br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>