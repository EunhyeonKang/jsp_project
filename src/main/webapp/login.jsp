<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
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
		
		#login2{
		    box-sizing: border-box;
		    width: 510px;
		    height: 50px;
		    background: #008485;
		    color: #FFFFFF;
		    border: 1px solid #008485;
		    border-radius: 10px;
		    margin-top: 30px;
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
		
		.flexlogin{
		    display: inline-block;
		    width: 510px;
		}	   			   
</style>
</head>
<%
	String result = request.getParameter("result");
%>
<body onload="showAlert()">
	<div class="group71">
        <div class="group31">
            <form action="/LoginOk" method="post">
                <span id="login">로그인</span>
                <br/>
                <div class="flexlogin">
                    <span class="idbox">아이디</span>
                    <input type="text" name="id" class="rec6" id="rec6" placeholder="아이디를 입력해주세요"/>                     
                </div>
                <br/>
                <div class="flexlogin">
                    <span class="idbox">비밀번호</span>
                    <input type="password" name="pw" class="rec6" id="rec6" placeholder="비밀번호를 입력해주세요"/>                     
                </div>
                <br/>
                
                <button id="login2">
                    <span>로그인하기</span>
                </button>
            </form>
            <br/>
            <a href="join.html">회원가입</a>
            <a href="main.jsp">메인페이지</a>
        </div>
    </div>
</body>
<script type="text/javascript">
    function showAlert() {
    	if(<%=result%> >0){
    		alert("회원가입 성공!");
    	}
    }
  </script>
</html>