<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="kr.co.user.model.MemberDAO"%>
<%@page import="kr.co.user.model.MemberDTO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
<style>
	.group71{
		    width: 100%;
		    height: auto;
		    text-align: center;
		    margin: auto;
		    text-align: center;
		    padding: 80px 0 80px 0;
		}
		
		
		#rec6{
		    float: right;
		    padding: 15px;
		    width: 100%;
		    box-sizing: border-box;
		    height: 50px;
		    text-align: left;
		    background: #FFFFFF;
		    border: 1px solid #CDC9C9;
		    border-radius: 10px;
		}
		.rec6::placeholder{
		    position: absolute;
		    width: 147px;
		    height: 18px;
		
		    font-family: 'Inter';
		    font-style: normal;
		    font-weight: 400;
		    font-size: 15px;
		    line-height: 18px;
		    text-align: center;
		    color: #CDC9C9;
		}
		.rec7{
		    box-sizing: border-box;
		
		    position: absolute;
		    width: 141px;
		    height: 50px;
		    
		    background: #FFFFFF;
		    border: 1px solid #008485;
		    border-radius: 10px;
		
		}
		
		#login{
		    width: 69px;
		    height: 30px;
		
		    font-family: 'Inter';
		    font-style: normal;
		    font-weight: 400;
		    font-size: 25px;
		    line-height: 30px;
		    text-align: center;
		
		    color: #000000;
		}
		.idbox{
		    padding: 10px;
		    box-sizing: border-box;
		    text-align: left;
		    display: flex;
		
		    font-family: 'Inter';
		    font-style: normal;
		    font-weight: 400;
		    font-size: 15px;
		    line-height: 18px;
		    text-align: center;
		
		    color: #000000;
		
		
		}
		
		#modify2{
		    box-sizing: border-box;
		    width: 510px;
		    height: 50px;
		    background: #008485;
		    color : #FFFFFF;
		    border: 1px solid #008485;
		    border-radius: 10px;
		    margin-top: 10px;
		}
		.box2 > button > span{
		    width: 300.21px;
		    height: 18px;
		    font-family: 'Inter';
		    font-style: normal;
		    font-weight: 700;
		    font-size: 15px;
		    line-height: 18px;
		    text-align: center;
		    color: #008485;
		}
		
		.flexModify{
		    display: inline-block;
		    width: 510px;
		}	   		
		.gradio{
		    padding: 15px;
		    width: 10%;
		}	   
		input:-moz-read-only { /* For Firefox */
		    background-color: yellow;
		}
		
		input:read-only {
		    background-color: yellow;
		}
</style>
</head>
<body>	
	<%
		String id = request.getParameter("id");
		MemberDAO md = new MemberDAO();
		MemberDTO member = md.LoginOk(id);
	
		String name = member.getName();
		String email = member.getEmail();
		String phone = member.getPhone();
		String state = member.getStatetype();
		String role = member.getRoletype();
		String pw = (String)session.getAttribute("pw");
		
	%>
	<div class="group71">
        <div class="group31">
			<form action="/UserModify" method="post">
				<span id="login">회원정보수정</span>
                <br/>
                <div class="flexModify"> 
                    <span class="idbox">아이디</span>
                    <input type="text" name="id" class="rec6" id="rec6" value="<%=id %>" readonly="readonly" style="background-color: lightgray; color: black;"/>                     
                </div>
                 <br/>
                <div class="flexModify"> 
                    <span class="idbox">패스워드</span>
                    <input type="password" name="pw" class="rec6" id="rec6" value="<%=pw%>" readonly="readonly" style="background-color: lightgray; color: black;"/>                     
                </div>
                 <br/>
                <div class="flexModify"> 
                    <span class="idbox">이름</span>
                    <input type="text" name="name" class="rec6" id="rec6" value="<%=name%>"/>                     
                </div>
                 <br/>
                <div class="flexModify"> 
                    <span class="idbox">핸드폰</span>
                    <input type="text" name="phone" class="rec6" id="rec6" value="<%=phone%>" readonly="readonly" style="background-color: lightgray; color: black;"/>                     
                </div>
                 <br/>
               	<div class="flexModify"> 
                    <span class="idbox">이메일</span>
                    <input type="text" name="email" class="rec6" id="rec6" value="<%=email%>"/>                     
                </div>
               
	             <br/>
				<div class="flexModify">
				    <span class="idbox">권한</span>
				    <label for="userRole">사용자:</label>
				    <input type="radio" name="roletype" value="user" class="gradio" id="userRole" <% if (role.equals("user")) out.print("checked"); %>>
				    <label for="adminRole">관리자:</label>
				    <input type="radio" name="roletype" value="admin" class="gradio" id="adminRole" <% if (role.equals("admin")) out.print("checked"); %>>
				</div>
	             <br/>
				<div class="flexModify">
				    <span class="idbox">상태</span>
				    <select name="statetype" class="rec6" id="rec6">
				        <option value="승인대기" <% if (state.equals("승인대기")) out.print("selected"); %>>승인대기</option>
				        <option value="정상" <% if (state.equals("정상")) out.print("selected"); %>>정상</option>
				        <option value="일시정지" <% if (state.equals("일시정지")) out.print("selected"); %>>일시정지</option>
				    </select>
				</div>
	             
               
	             <br/>
				<button id="modify2">
	                    <span>수정하기</span>
	            </button>
			</form>
			<% if(state.equals("일시정지")){ %>
				<form action="/DeleteUser" method="post">
					<input type="hidden" value="<%=id%>" name="id"/>
					<button type="submit" id="modify2">탈퇴승인</button>
				</form>
			<% }%>
			<br/>
			<a href="manage.jsp">뒤로가기</a>
			
		</div>
    </div>
</body>
</html>