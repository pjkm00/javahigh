<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int result = (int) request.getAttribute("result");
	if(result == 1){
%>
		
    <script>
		alert("삭제 완료되었습니다.");
		location.href = "<%=request.getContextPath()%>/board/boardMain.do"
	</script>	
<%
	}else if(result == 0){
%>
	<script>
		alert("삭제에 실패하였습니다.");
		location.href = "<%=request.getContextPath()%>/board/boardMain.do"
	</script>		
		
<%
	}
%>