<%@page import="dao_p.BoardDAO"%>
<%@page import="dto_p.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
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
</style>
<script>
	function button() {
		location.href = "WritePost";
	}
</script>
<h2>1:1 문의</h2>
<table border="" class="listTable">
	<tr>
		<td>번호</td>
		<td>카테고리</td>
		<td>제목</td>
		<td>작성자</td>
		<td>작성일</td>
		<td>답변</td>
	</tr>
	<c:forEach items="${serachResult}" var = "serach" varStatus="row">
	<tr>
		<td>${row.index+1}</td>
		<td>${serach.boardCate}</td>
		<td><a href="PostDetails?perNum=${serach.perNum}">${serach.perTitle}</a></td>
		<td>${serach.userId}</td>
		<td>${serach.perDate}</td>
		<td>${serach.perAnswer}</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="6" align="right">
		<button onclick="button()" class="writeButton">글쓰기</button>
	</tr>
</table>