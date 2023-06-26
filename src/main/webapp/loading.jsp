<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script type="text/javascript">
    // Java 서블릿으로부터 전달된 파라미터 값을 JavaScript 변수에 할당
    <%
    String id = (String) session.getAttribute("id");
    String state = request.getParameter("state");
    String message = id + "님! " + state + " 상태입니다! 관리자에게 요청바랍니다.";
    session.invalidate();
    %>
    

    // JavaScript 코드에서 파라미터 값을 받아와서 alert 창을 띄움
   	var message = '<%= message %>';
    alert(message);

    
    window.location.href = "login.jsp";
</script>
</body>
</html>