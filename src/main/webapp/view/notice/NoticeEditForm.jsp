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
    .divHidden > input {
        display: none;
    }
</style>
<script>
	function cancel(){
		alert("취소되었습니다.")
		location.href="NoticeList"
	}
	function deleteFile(){
		if(confirm("파일을 삭제하시겠습니까? \n삭제된 파일은 복구할 수 없습니다.")){
			var forms = document.forms;
			forms.action = "DeletePost";
			forms.submit()
		}
	}
	
</script>

<h2>게시판 수정하기</h2>
<form name="forms" action="NoticeEditHandler" method="post" enctype="multipart/form-data">
	<div class="divContainer">
	<div class="divHidden"><input type="text" name="noticeNum" value="${dto.noticeNum }" readonly="readonly"/></div>
		<div class="inputText"><input type="text" name="noticeTitle" value="${dto.noticeTitle}"/></div>
		<div><textarea cols="30" rows="10" name="noticeContent">${dto.noticeContent}</textarea></div>
		<table border="" class = "table-cell">
			<td>첨부파일</td>
			<td>
			<c:choose>
				<c:when test="${dto.noticeFile!=null}">
					<input type="text" name="noticeFile" value="${dto.noticeFile }" readonly="readonly"/>
					<input type="button" onclick="deleteFile()" value="파일삭제" />
				</c:when>
				<c:otherwise>
					<input type="file" name = "noticeFile"/>
				</c:otherwise>
			</c:choose>
			</td>
		</table>
		<div class="subButton">
			<input type="submit" value="수정"/>
			<input type="button" value="취소" onclick="cancel()"/>
		</div>
	</div>
</form>