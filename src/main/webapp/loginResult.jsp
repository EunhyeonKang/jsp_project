<%@page import="kr.co.user.model.MemberDAO"%>
<%@page import="kr.co.user.model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<style>
body{
	width:100%;
	text-align: center;
}
</style>
</head>

<body>
	<%
	String id = (String) session.getAttribute("id");

	%>
	
</body>
<script type="text/javascript">
        // JavaScript 코드에서 파라미터 값을 받아와서 alert 창을 띄움

        var message = "<%=id%>"+"님 로그인 성공!";
        alert(message);
        
        // 원하는 동작 수행 (예: 페이지 이동)
        window.location.href = "main.jsp";
        		
</script>
</html>