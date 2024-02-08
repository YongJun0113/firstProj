<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>원두창고</title>
<style>
	div{
		float: left;
	}
	.container{
		width:800px;
		height:800px;
	}
	.box{
		width:800px;
		height:150px;
		text-align : center;
		line-height : 150px;
	}
	.cate{
		margin: 5px;
		width:390px;
		height:200px;
	}
	.order{
		margin: 2px;
		border: 1px solid;
		width: 156px;
		height: 100px;
		text-align : center;
		line-height: 100px;
	}
	div{
		border: 1px solid;
		margin: 1px;
	}
	.outer{
		width: 750px;
		height: 50px;
	}
	.inner{
		width: 100px;
		float: left;
	}
</style>
</head>
<body>
<h1>마이페이지</h1>
<div class="container">
	<h2>나의 주문처리 현황</h2>
	<div class="box">
		<div class="order">결제대기</div>
		<div class="order">배송중</div>
		<div class="order">배송완료</div>
		<div class="order">취소/교환/환불</div>
	</div>
	<a href="/firstProj/order/OrderDetail">
		<div class="cate">주문내역</div>
	</a>
	<a href="/firstProj/profile/ProfileDetail">
		<div class="cate"> 회원정보</div>
	</a>
	<a href="/firstProj/consult/ConsultDetail">
		<div class="cate">1:1 상담</div>
	</a>
	<a href="/firstProj/review/ReviewDetail">
		<div class="cate">리뷰 관리</div>
	</a> 
</div>

</body>
</html>