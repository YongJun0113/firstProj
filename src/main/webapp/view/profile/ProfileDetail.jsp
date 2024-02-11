<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script src="jquery-3.7.1.min.js"></script>
<script>
	$(function(){
	    $("#pwChkBtn").click(function(){
	        var pw = $("#pw").val();
	        var pwChk = $("#pwChk").val()
	        
	        if(pw == pwChk){
	        	alert("변경되었습니다.")
	            $("#pw").attr("readonly", true)
	            $("#pwChk").attr("readonly", true)
	        }else{
	            alert("비밀번호가 다릅니다.")
	        }
	    })
	    
	    $("#modify").click(function(){
	        var pwChk = $("#pwChk").val()
	        
	        location.href="ProfileModify?pw="+pwChk
	    })
	})
	
	function del(){
		
		if(confirm("정말로 삭제하시겠습니까?")){
			location.href = "ProfileDelete?userId=${dto.userId}"
		}
		
	}

</script>

<h2>ProfileDetail</h2>
<form name="frm" action="ProfileModify" method="post" enctype="multipart/form-data">
<table border="">
	<tr>
		<td>아이디</td><td>${dto.userId }</td>
	</tr>
	<tr>
		<td>비밀번호</td><td><input type="password" id="pw"/></td>
	</tr>
	<tr>
		<td>비밀번호 확인</td><td><input type="password" id="pwChk"/><input type="button" id="pwChkBtn" value="비밀번호 확인"/></td>
	</tr>
	<tr>
		<td>이름</td><td>${dto.userName }</td>
	</tr>
	<tr>
		<td>주소</td><td>${dto.addr }</td>
	</tr>
	<tr>
		<td>전화번호</td><td>${dto.tel }</td>
	</tr>
	<tr>
		<td>이메일</td><td>${dto.email }</td>
	</tr>
	<tr>
		<td>성별</td><td>${dto.gender }</td>
	</tr>
	<tr>
		<td>생년월일</td><td>${dto.birthStr }</td>
	</tr>
	<tr>
		<td colspan="2" align="right">
			<a href="ProfileDetail">취소</a>
			<input type="submit" value="수정 완료" />
			<a href="javascript:del()">삭제</a>
		</td>
	</tr>
</table>
</form>

