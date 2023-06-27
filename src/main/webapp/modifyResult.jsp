<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
        // JavaScript 코드에서 파라미터 값을 받아와서 alert 창을 띄움
        var id = '<%= (String)session.getAttribute("id") %>';

		var message = "수정 성공!";
		alert(message);
		<%
		String result = (String) session.getAttribute("result");
		if (result != null && Integer.parseInt(result) > 0) {
		%>
		    window.location.href = "manage.jsp";
		<%
		} else {
		%>
		    // 원하는 동작 수행 (예: 페이지 이동)
		    window.location.href = "main.jsp?id=" + id;
		<%
		}
		%>

</script>
<body>
</body>
</html>