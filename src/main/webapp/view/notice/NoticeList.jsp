<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
	*{
		margin: 0;
		padding: 0;
	}
	.listTable{
		width: 750px;
		margin: 10px auto;
		text-align: center;
	}
	.writeButton{
		display: inline-block;
		padding: 8px 18px;
     	background-color: #147814;
    	color: white;
	}
	.searchContainer{
		float:right;
		margin: 10px auto;
	}
	h2{
		display: flex;
        justify-content: center;
        margin: 30px auto;
        align-items: center;
	}
	.pageNext{
		display:inline-block;
		color: white;
		background-color: #147814;
		width: 20px;
    	padding: 10px; 
	}
</style>
<form action="NoticeList" method="post">
    <div class="searchContainer">
        <input type="text" placeholder = "제목을 검색하세요." name="search"/>
        <input type="submit" value="찾기">
    </div>
</form>
<table border="" class="listTable">
	<tr>
		<td>번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>작성일</td>
	</tr>
	<c:choose>
		<c:when test="${NoticeDataList != null}">
			<c:forEach items="${NoticeDataList}" var = "dtoList" varStatus="row">
			<tr>
				<td>${row.index+1}</td>
				<td><a href="NoticeDetails?noticeNum=${dtoList.noticeNum}">${dtoList.noticeTitle}</a></td>
				<td>${dtoList.userId}</td>
				<td>${dtoList.noticeDate}</td>
			</tr>
			</c:forEach>
		</c:when>
		 <c:otherwise>
			<c:forEach items="${searchResult}" var = "dtoList" varStatus="row">
		<tr>
			<td>${row.index+1}</td>
			<td><a href="NoticeDetails?noticeNum=${dtoList.noticeNum}">${dtoList.noticeTitle}</a></td>
			<td>${dtoList.userId}</td>
			<td>${dtoList.noticeDate}</td>
		</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	<tr>
		<td colspan="6" align="center">
		<c:forEach var="i" begin="1" end="15">
			<c:choose>
				<c:when test="${page.nowPage==i}">
					<div class="pageNext">${i }</div>
				</c:when>
				<c:otherwise>
					<a href="NoticeList?nowPage=${i }" style="text-decoration: none;"> ${i }</a>
				</c:otherwise>
			</c:choose>
		</c:forEach>
		</td>
	</tr>
	<tr>
		<td colspan="6" align="right">
		<button onclick="button()" class="writeButton">글쓰기</button>
	</tr>
</table>
<script>
	function button() {
		location.href = "NoticeWritePost";
	}
</script>