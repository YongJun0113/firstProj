<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		background-color: #147814;
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
	.table-cell td:first-of-type {
	  width:130px;
	  background-color: lightgray;
	}
</style>
<script>
 	function cancel(){
		alert("취소되었습니다.")
		location.href="NoticeList"
	}
</script>
<h2>게시판 글쓰기</h2>
<form action="NoticeWritePostHandler" method="post" enctype="multipart/form-data">
	<div class="divContainer">
		<div class="inputText"><input type="text" placeholder="제목을 입력해주세요" name="writeTitle"/></div>
		<div><textarea placeholder="내용을 입력해주세요" cols="30" rows="10" name="writeContent"></textarea></div>
		<table border="" class = "table-cell">
			<td>첨부파일</td>
			<td><input type="file" name = "noticeFile"/></td>
		</table>
		<div class = "subButton">
			<input type="submit" value="등록"/>
			<input type="button" value="취소" onclick="cancel()"/>
		</div>
	</div>
</form>