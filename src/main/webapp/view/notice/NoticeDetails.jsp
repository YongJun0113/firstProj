<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	*{
		margin: 10 auto;
		padding: 0;
	}
	td {
	  width: 5%;
	}
	button {
	 float: right;
     padding: 8px 18px;
     background-color: #147814;
     color: white;
    }
	.border-cell{
		border-top: 1.5px solid black;
    	border-bottom: 1.5px solid black;
	}
	.title-cell{
		background-color: lightgray;
	}
</style>
<script>
function edit(){
		location.href="NoticeEditForm?noticeNum=${dto.noticeNum}"
	}
	function deletePost(){
		if(confirm("게시물을 삭제하면 복구할 수 없습니다. 정말로 삭제하시겠습니까?")){
			location.href="NoticeDelete?noticeNum=${dto.noticeNum}"
		}
	}
	function list(){
		location.href="NoticeList"
	}
</script>
<table class="border-cell" border="">
	<tr>
		<td colspan = "6">${dto.noticeTitle}</td>
	</tr>
	<tr class="border-cell">
		<td class="title-cell">작성자</td>
		<td>${dto.userId}</td>
		<td class="title-cell">작성일</td>
		<td>${dto.noticeDate}</td>
	</tr>
	<tr>
		<td colspan = "6">${dto.noticeContent}</td>
	</tr>
	<c:if test="${dto.noticeFile!=null}">
	<tr>
		<td class="title-cell">첨부파일</td>
		<td>
		<a href="<c:url value="/FileDown?fileName=${dto.noticeFile}"/>">${dto.noticeFile}</a>
		</td>
	</c:if>
	</tr>
	<tr>
		<td colspan = "6">
			<button onclick="edit()">수정</button>
			<button onclick="deletePost()">삭제</button>
			<button onclick="list()">목록</button>
		</td>
	</tr>
</table>