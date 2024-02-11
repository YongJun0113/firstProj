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
<h2>1:1 문의</h2>
<form action="BoardList" method="post">
    <div class="searchContainer">
    	<select name = "searchCate">
  			<option>카테고리</option>
		  	<option>제목</option>
    	</select>
        <input type="text" placeholder = "검색어를 입력해주세요." name="search"/>
        <input type="submit" value="찾기">
    </div>
</form>
<table border="" class="listTable">
	<tr>
		<td>번호</td>
		<td>카테고리</td>
		<td>제목</td>
		<td>작성자</td>
		<td>작성일</td>
		<td>답변</td>
	</tr>
	<c:choose>
		<c:when test="${boardDataList != null}">
			<c:forEach items="${boardDataList}" var = "dtoList" varStatus="row">
			<tr>
				<td>${row.index+1}</td>
				<td>${dtoList.boardCate}</td>
				<td><a href="PostDetails?perNum=${dtoList.perNum}">${dtoList.perTitle}</a></td>
				<td>${dtoList.userId}</td>
				<td>${dtoList.perDate}</td>
				<td>${dtoList.perAnswer}</td>
			</tr>
			</c:forEach>
		</c:when>
		 <c:otherwise>
			<c:forEach items="${searchResult}" var = "dtoList" varStatus="row">
		<tr>
			<td>${row.index+1}</td>
			<td>${dtoList.boardCate}</td>
			<td><a href="PostDetails?perNum=${dtoList.perNum}">${dtoList.perTitle}</a></td>
			<td>${dtoList.userId}</td>
			<td>${dtoList.perDate}</td>
			<td>${dtoList.perAnswer}</td>
		</tr>
			</c:forEach>
		</c:otherwise>
	</c:choose>
	<tr>
		<td colspan="6" align="center">
		<div id="aa"> </div>
		<c:forEach var="i" begin="1" end="5">
		
			<c:choose>
				<c:when test="${page.nowPage==i}">
					<div class="pageNext">${i }</div>
					<input id="in" style="display: none" value="${i }"/>
				</c:when>
				<c:otherwise>
					<a href="BoardList?nowPage=${i }" style="text-decoration: none;" onclick="inClick()"> ${i }</a>
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
		location.href = "WritePost";
	}
/* 	paging();
	   function paging(e) {
		   
		   //if(e.this.value() != null || e.this.value() != undefined) alert(e.this.value());
		  var html = "";
	      html = "<a id='startBtn' onClick='paging()'> < </a>"
	      for(var i = 1; i <= 5; i++) {
	         html += "<a href='BoardList?nowPage=" + (i) + "' style='text-decoration: none; id='" + (i) + "'>" + ( i ) + "</a>";
	    	  //html += "<a href='BoardList?nowPage=1 style='text-decoration: none; id='1'>1</a>";
				
	      }
	      html += "<a id='endBtn' onClick='paging()'> > </a>"
	      var tt = document.getElementById("aa");
	      
	      tt.innerHTML = html;
	      
	      alert(tt.innerHTML);
	      //.innerHTML = html;
	   } */
</script>