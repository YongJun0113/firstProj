<%@page import="dto_p.MemberDTO"%>
<%@page import="dao_p.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인화면</title>
<link href="../include/css/pmslib.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../include/js/jquery-3.7.1.min.js"></script>
<script type="text/javascript" src="../include/js/pmsjslib.js"></script>
</head>
<body>
	<div class="loginmain">
		<div class="loginwrap">
			<div class="loginheader">
				<div class="loginNav">
					<div class="backBtn">
						<a href="javascript:window.history.back();">
						
						</a>
					</div>
					<div class="mainBtn">
						<a href="javascript:window.history.back();"></a>
					</div>
				</div>
				<h1>
					<a href="">
						<img class="loginmain_title_1"   rel="stylesheet">
					</a>
				</h1>				
			</div>
			<div class="loginbannersec">
			
			</div>
			<div class="memberloginsec">
				<div class="formwrap">
					<form method="post" action="loginReg.jsp">
						<div class="inputboxid">
							<input type="text" name="userid" style="width:380px; height:50px;">
						</div>
						<div class="orderno"></div>
						<div class="inputboxpw">
							<input type="text" name="pw" style="width:380px; height:50px;">
						</div>
						<button type="submit" style="width:380px; height:50px;" >로그인</button>
					</form>
				</div>
			</div>
			<div class="loginfooter">
			
			</div>
		</div>
	</div>
</body>
</html>