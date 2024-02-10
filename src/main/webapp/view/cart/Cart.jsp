<%@page import="java.util.ArrayList"%>
<%@page import="dto_p.CartDTO"%>
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

 function del(no){
	 
	 if(confirm("정말 삭제하시겠습니까?")){
		 location.href = "CartDelete?no="+no;
	 }
	 
 }

</script>
<%
    int tot = 0;
    for (CartDTO dto : (ArrayList<CartDTO>) request.getAttribute("mainData")) {
        tot += dto.getProdCnt() * dto.getProdPrice();
    }
    request.setAttribute("tot", tot);
%>
<body>
<h1>장바구니</h1>
<form action="Order">
	<table border="">

		<tr>
			<td><input type="checkbox" name=""/></td>
			<td>번호</td>
			<td>사진</td>
			<td>상품이름</td>
			<td>수량</td>
			<td>용량</td>
			<td>분쇄</td>
			<td>금액</td>
			<td>삭제</td>
		</tr>
		<c:forEach items="${mainData }" var="dto" varStatus="no">
		<tr>
			<td><input type="checkbox" name="chk" value="${dto.no}"/></td>
			<td>${no.index+1 }</td>
			<td><img src="${dto.cartFile }"/></td>
			<td>${dto.cartTitle}</td>
			<td>${dto.prodCnt }</td>
			<td>${dto.option1 }</td>
			<td>${dto.option2 }</td>
		<c:choose>
		<c:when test="${dto.option1 eq '1kg( 10,000원)' }">
			<td>${(dto.prodPrice*dto.prodCnt)+10000 }</td>
		</c:when>
		<c:otherwise>
			<td>${dto.prodPrice*dto.prodCnt }</td>
		</c:otherwise>
		</c:choose>
			<td><a href="#" onclick="del(${dto.no })">삭제</a></td>
		
		</tr>
		</c:forEach>
		<tr>
            <td colspan="4">총금액</td>
            <td colspan="4">${tot } + 배송비 3,000원 = ${tot+3000 } </td>
        </tr>
		<tr >
			<td colspan="8"><input type="submit" value="주문하기"/></td>
		</tr>
	</table>

</form>
</body>
</html>