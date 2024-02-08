<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link href="../include/css/pmslib.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="../include/js/jquery-3.7.1.min.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="../include/js/address.js"></script>
</head>
<body>
	<form method="post">
		<table border="">
			<tr bgcolor="#996600">
				<td colspan="2"><font color="#FFFFFF"><b>회원 가입</b></font></td>
			</tr>
			<tr>
				<td >아이디</td>
				<td >
					<input name="id" size="15">
					<!-- 아이디 입력 후 [ID중복확인] 버튼을 클릭하면 idCheck() 함수가 호출되면서
					ID중복검색 창(idCheck.jsp)이 하나 뜬다. ID중복검색 창에서는 폼에서 입력한 ID와 
					회원테이블의 ID를 중복체크한다. --> 
					<input type="button" value="ID중복확인" onClick="idCheck(this.form.id.value)">
					<!-- 아이디 중복 체크 여부 -->
				<!--  	<input type="hidden" name="" value="" />  --> 
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw" size="15"></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" name="pwcheck" size="15"></td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<input name="name" size="15">
				</td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					남<input type="radio" name="gender" value="1" checked> 
					여<input type="radio" name="gender" value="2">
				</td>
			</tr>
			<tr>
				<td>생년월일</td>
				<td>
					<input name="birthday" size="6">
				</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>
					<input name="email" size="40">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="text" id="sample4_postcode" name="postNum" placeholder="우편번호">
					<input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="text" id="sample4_roadAddress" name="streetAddr" placeholder="도로명주소">
					<input type="text" id="sample4_jibunAddress" name="addr" placeholder="지번주소">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<span id="guide" style="color:#999;display:none"></span>
					<input type="text" id="sample4_detailAddress" name="dtailAddr" placeholder="상세주소">
					<input type="text" id="sample4_extraAddress" placeholder="참고항목">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>