<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<style>
	img{
		width:100px;
	}
</style>
<script>
 function del(){
	 
	 if(confirm("정말 삭제하시겠습니까?")){
		
	 }
	 
 }

</script>
<body>
<h1>장바구니</h1>
<form action="order.jsp">
	<table border="">

		<tr>
			<td><input type="checkbox"/></td>
			<td>사진</td>
			<td>상품이름</td>
			<td>수량</td>
			<td>금액</td>
			<td>배송비</td>
			<td>삭제</td>
		</tr>
		<c:forEach items="${mainData }" var="dto" varStatus="no">
		<tr>
			<td><input type="checkbox"/></td>
			
			<td><img src="${dto.cartFile }"/></td>
			<td>${dto.cartTitle}</td>
			<td>${dto.prodCnt }</td>
			<td>${dto.prodPrice }</td>
			<td rowspan="${no.index }">3,000원</td>
			<td><a href="javascript:del()">삭제</a></td>
		
		</tr>
		</c:forEach>
		<tr >
			<td colspan="7"><input type="submit" value="주문하기"/></td>
		</tr>
	</table>
	


</form>
</body>
</html>