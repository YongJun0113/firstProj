<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<br/>
<table>
	<tr>
		<td>
			<input type="button" value="오늘" />
			<input type="button" value="1주일" />
			<input type="button" value="1개월" />
		</td>
	</tr>
	<tr>
	
	</tr>
</table>
<hr/>
<div>
<font size="1" color="fff">기본적으로 최근 3개월간의 자료가 조회되며, 기간 검색시 주문처리완료 후 36개월 이내의 주문내역을 조회하실 수 있습니다.<br/>
완료 후 36개월 이상 경과한 주문은 [과거주문내역]에서 확인할 수 있습니다.<br/>
주문번호를 클릭하시면 해당 주문에 대한 상세내역을 확인하실 수 있습니다.<br/></font>
</div>
<hr/>
<h3>취소/반품/교환 내역</h3>
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
