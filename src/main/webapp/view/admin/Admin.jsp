<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자</title>
</head>
<body>
<h1>매출</h1>
<table border="">
	<tr>
		<td width="150px">주문일자</td>
		<td width="100px">주문번호</td>
		<td width="550px">상품정보</td>
		<td width="100px">수량</td>
		<td width="150px">금액</td>
		<td width="150px">총액</td>
	</tr>
	<c:forEach items="${mainData}" var="dto" varStatus="no">
	<tr>
		<td>${dto.orderDate }</td>
		<td>${dto.orderNum }</td>
		<td>${dto.prodTitle }
		${dto.prodCate }
		${dto.option1 }
		${dto.option2 }</td>
		<td>${dto.orderCnt }</td>
		<td>${dto.prodPrice }</td>
		<td>${dto.tot }</td>
	</tr>
	</c:forEach>
	<tr>
		<td colspan="5" align="left">통계</td>
		<td>${tData}</td>
	</tr>
</table>

</body>
</html>