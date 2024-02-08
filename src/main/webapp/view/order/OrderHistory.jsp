<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<br/>
<table>
	<tr>
		<td>
			<select name="orderStatus">
				<option value="2024">2024년</option>
				<option value="2023">2023년</option>
				<option value="2022">2022년</option>
				<option value="2021">2021년</option>
			</select>
		</td>
		<td>
			<input type="button" value="조회" />
		</td>
	</tr>
	<tr>
	
	</tr>
</table>
<hr/>
<div>
<font size="1" color="fff">주문처리완료 후 36개월 이내의 최근 주문건은 주문내역조회 탭에서 확인할 수 있습니다.<br/>
상품구매금액은 주문 당시의 판매가와 옵션추가금액의 합(부가세 포함)에 수량이 반영된 값입니다.<br/></font>
</div>
<hr/>
<h3>주문 상품 정보</h3>
<hr/>
<table border="">
	<tr>
		<td>주문일자</td>
		<td>이미지</td>
		<td>상품정보</td>
		<td>수량</td>
		<td>상품구매금액</td>
		<td>주문처리상태</td>
		<td>취소/교환/반품</td>
	</tr>
	<c:forEach items="${mainData}" var="dto" varStatus="no">
	<tr>
		<td>${dto.orderDateStr }</td>
		<td>${dto.prodFile }</td>
		<td>${dto.prodInfo }</td>
		<td>${dto.orderCnt }</td>
		<td>${dto.prodPrice }</td>
		<td>${dto.deliveryStatus }</td>
		<td>${dto.orderStatus }</td>
		
	</tr>
	</c:forEach>
	
</table>
