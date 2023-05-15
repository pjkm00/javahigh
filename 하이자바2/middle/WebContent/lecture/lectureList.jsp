<%@page import="java.util.ArrayList"%>
<%@page import="middle.read.LectureList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수강한 강의 조회 리스트</title>
</head>
<body>
	<%
		List<LectureList> List = (List<LectureList>) request.getAttribute("lectureList");
	
	%>
	<h3>수강목록</h3>
	<table name="lecture">
		<tr>
			<th>강의코드</th>
			<th>강의명</th>
			<th>교수명</th>
			<th>강의실 위치</th>
			<th>이수구분</th>
			<th>학점</th>
		</tr>
		
<%-- 		<%= for(LectureList l : List){%> --%>
<!-- 		<tr> -->
<%-- 			<td><%=l.getLecno()%></td> --%>
<%-- 			<td><%=l.getLecname()%></td> --%>
<%-- 			<td><%=l.getLecprofessor()%></td> --%>
<%-- 			<td><%=l.getLecloc()%></td> --%>
<%-- 			<td><%=l.getLecdiv()%></td> --%>
<%-- 			<td><%=l.getLeccredit()%></td> --%>
<!-- 		</tr>	 -->
<%-- 		<%}%> --%>
		
	
	</table>
	
	
</body>
</html>