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
		<td width="250px">주문일자</td>
		<td width="700px">상품정보</td>
		<td width="100px">수량</td>
		<td width="150px">금액</td>
	</tr>
	<%-- <c:forEach items="" var="dto" varStatus="no"> --%>
	<tr>
		<td>2024-01-01</td>
		<td>콜롬비아 수프리모 옵션1:200g 옵션2:원두상태</td>
		<td>3</td>
		<td>24000</td>
	</tr>
	<%-- </c:forEach> --%>
	<tr>
		<td colspan="2" align="left">통계</td>
		<td>3</td>
		<td>24000</td>
	</tr>
</table>

</body>
</html>