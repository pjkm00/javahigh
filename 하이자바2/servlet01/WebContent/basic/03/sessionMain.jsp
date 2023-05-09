<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session 메인 페이지</title>
</head>
<body>
	<h2>Session 연습용 Main 페이지입니다.</h2>
	회원 아이디 : <%= session.getAttribute("memId") %>
	<hr>
	<!-- form에서 method값이 post가 아닌 모든 것은 get방식 -->
	<a href="<%=request.getContextPath()%>/SessionLoginServlet.do">로그인</a>
</body>
</html>