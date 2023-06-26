<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="kr.co.user.model.MemberDAO"%>
<%@page import="kr.co.user.model.MemberDTO"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원정보수정</title>
    <style>
        /* 전체 페이지 스타일 */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
        }

        /* 로그인 정보 컨테이너 스타일 */
        .login-info {
            text-align: center;
            margin-bottom: 20px;
        }

        .login-info h2 {
            font-size: 24px;
            color: #000;
            margin-bottom: 10px;
        }

        .login-info a {
            display: inline-block;
            margin-bottom: 10px;
            width:100px;
            color: #FFFFFF;
            text-decoration: none;
            padding: 5px 10px;
            border: 1px solid #008485;
            border-radius: 10px;
            background-color: #008485;
            transition: background-color 0.3s ease;
        }

</style>
</head>
<body>
<%
    String id = (String) session.getAttribute("id");
    MemberDAO md = new MemberDAO();
    MemberDTO member = md.LoginOk(id);

    String name = member.getName();
    String email = member.getEmail();
    String phone = member.getPhone();
    String role = member.getRoletype();
%>
<div class="login-info">
    <% if (id != null && session != null) { %>
        <h2><%= id %>님이 로그인</h2>
        <% if (role.equals("admin")) { %>
            <a href="/manage.jsp">회원관리</a><br/>
        <% } %>
        <a href="modify.jsp">회원정보수정</a><br/>
        <a href="/logout.jsp">로그아웃</a><br/>
    <% } else { %>
        <h2>메인페이지</h2>
        <a href="login.jsp">로그인하기</a><br/>
        <a href="join.html">회원가입</a><br/>
    <% } %>
</div>
</body>
</html>
