<%@page import="java.util.ArrayList"%>
<%@page import="kr.co.user.model.MemberDAO"%>
<%@page import="kr.co.user.model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body{
	width:100%;
	text-align: center;
	
}
.table-container {
  width: 100%;
  margin: 20px 0;
  
  border-radius: 4px;
  overflow: hidden;
}

.table-container table {
  width: 100%;
  border-collapse: collapse;
}

.table-container th, .table-container td {
  padding: 12px;
  text-align: center;
}

.table-container th {
  background-color: #f2f2f2;
  color: #333;
  font-weight: bold;
}

.table-container tr:nth-child(even) {
  background-color: #f9f9f9;
}

.table-container tr:hover {
  background-color: #e6e6e6;
}

.table-container .view-button {
  background: #008485;
  border: 1px solid #008485;
  color: #FFFFFF;
  padding: 8px 16px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 14px;
  border-radius: 10px;
  cursor: pointer;
  margin : 5px;
}

</style>
</head>
<%
		MemberDAO md = new MemberDAO();
		ArrayList<MemberDTO> list = md.selectMember();
		String result = request.getParameter("result");
%>
<body>
	<h2>회원관리</h2><div class="table-container">
  <table>
    <tr>
      <th>아이디</th>
      <th>패스워드</th>
      <th>이름</th>
      <th>핸드폰</th>
      <th>권한</th>
      <th>상태</th>
      <th>수정</th>
    </tr>
    
    <% for (MemberDTO member : list) { %>
      <tr>
        <td><%= member.getId() %></td>
        <td><%= member.getPw() %></td>
        <td><%= member.getName() %></td>
        <td><%= maskPhoneNumber(member.getPhone()) %></td>
        <td><%= member.getRoletype() %></td>
        <td><%= member.getStatetype() %></td>
        <td><a href="userModify.jsp?id=<%= member.getId() %>" class="view-button">수정</a></td>
      </tr>
    <% } %>
    <%!
    public String maskPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            return phoneNumber;
        }
        if (phoneNumber.startsWith("010") && phoneNumber.length() >= 10) {
            String front = phoneNumber.substring(0, 4);
            String masked = phoneNumber.substring(4).replaceAll("\\d", "*");
            return front + masked;
        } else {
            return phoneNumber;
        }
    }

    %>
  </table>
  <br/><a href="main.jsp">메인페이지로 이동</a>
</div>
</body>
<script>
//JavaScript 코드에서 파라미터 값을 받아와서 alert 창을 띄움
if(<%=result%>>0){
	alert("삭제 성공!");
}
var passwordElements = document.querySelectorAll("td:nth-child(2)");
passwordElements.forEach(function(element) {
  var password = element.textContent.trim();
  var maskedPassword = "";
  for (var i = 0; i < password.length; i++) {
    maskedPassword += "*";
  }
  element.textContent = maskedPassword;
});
</script>
</html>