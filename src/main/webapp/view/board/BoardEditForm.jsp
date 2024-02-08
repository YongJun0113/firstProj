<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<style>
	*{
		margin: 0;
		padding: 0;
	}
	textarea{
		width: 750px;
	}
	
	.inputText:nth-child(2) input, .inputText{
		display: inline-block;
		width: 500px;
		margin: 5px auto;
	}
	.divContainer{/* 수정 필요 */
        justify-content: center;
        align-items: center;
	}
	.divContainer div:nth-child(4) input[type="submit"]{
		float: right;
		background-color: #007bff;
		color: white;
	}
	.subButton > input {
	 float: right;
     padding: 8px 18px;
     background-color: #147814;
     color: white;
    }
    .subButton{
      float:right;
    }
</style>
<script>
	function cancel(){
		alert("취소되었습니다.")
		location.href="BoardList"
	}
</script>

<h2>게시판 수정하기</h2>
<form action="BoardEditHandler" method="post" enctype="multipart/form-data">
	<div class="divContainer">
		<select name="boardCate" value="${dto.boardCate}">
			<option value="상품">상품</option>
		  	<option value="주문/결제">주문/결제</option>
		  	<option value="취소/교환/환불">취소/교환/환불</option>
		  	<option value="기타">기타</option>
		 </select>
		<div class="inputText"><input type="text" name="perTitle" value="${dto.perTitle}"/></div>
		<div><textarea cols="30" rows="10" name="perContent">${dto.perContent}</textarea></div>
		<table border="" class = "table-cell">
			<td>첨부파일</td>
			<td><input type="file" name = "perFile"/></td>
		</table>
		<div class="subButton">
			<input type="submit" value="수정"/>
			<input type="button" value="취소" onclick="cancel()"/>
		</div>
	</div>
</form>