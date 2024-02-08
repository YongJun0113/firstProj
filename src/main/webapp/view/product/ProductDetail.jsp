<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<style>
	.wrapper{
		width:800px;
		height:1500px;
		border:1px solid #000;
	}
	.box1{
		height:500px;
	}
	.box2{
		height:600px
	}
	.box3{
		height:500px;
		background-color:#0ff;
	}
	img{
		width:300px;
		height:300px;
		margin:25px;
		float:left;
	}
	
	.content{
		width:400px;
		height:300px;
		margin:15px;
		float:right;
	}
	hr~div>div{
		width:50%;
		margin:15px 0px;
		float:left;
	}
	select {
		
		height:30px;
	
	}
	button{
		width:150px;
		height:50px;
		float:left;
		margin:20px;
		background-color:#fff;
		border-radius: 30px;
	}
	.box2>h1{
		text-align:center;
		
	}

</style>
<script src="../js/jquery-3.7.1.min.js"></script>
<script>
	$(function(){
		$(".btn1").click(function(){
			//alert("눌림")
			var chk = confirm("장바구니로 이동하시겠습니까?");
			 if(chk){
				
				location.href="/testProj/cart/CartReg?userId=aaa&prodCnt=${dto.prodNum }"
					+"&prodPrice=${dto.prodPrice }"
					+"&cartFile=${dto.prodFile }"
					+"&cartTitle=${dto.prodTitle }"
					+"&option1="+$("select[name='option1']").val()
					+"&option2="+$("select[name='option2']").val()
					+"&prodNum=${dto.prodNum }"
					+"&chk=true";
				 
			 }else{
				 
				 location.href="/testProj/cart/CartReg?userId=aaa&prodCnt=${dto.prodNum }"
						+"&prodPrice=${dto.prodPrice }"
						+"&prodFile=${dto.prodFile }"
						+"&prodTitle=${dto.prodTitle }"
						+"&option1="+$("select[name='option1']").val()
						+"&option2="+$("select[name='option2']").val()
						+"&prodNum=${dto.prodNum }"
						+"&chk=false";
			}
			
		})
		$(".btn2").click(function(){
			//alert("눌림")
			location.href="Cart"
			
		})
	})


</script>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<div  class="wrapper">
	<div class="box1">
		<div><img src="${dto.prodFile }"></div>
		<div class="content">
			<div><h1>${dto.prodTitle }</h1></div>
			<hr/>
			<div>
				<div>식품의 유형</div>
				<div>커피</div>
			</div>
			<div>
				<div>배송비</div>
				<div>3,000원</div>
			</div>
			<div>
				<div>판매가</div>
				<div>${dto.prodPrice }원</div>
			</div>
			<hr/>
			<div>
			<div>용량 선택</div>
				<div>
					 <select name="option1">
		                 <option value="200g">200g</option>
		                 <option value="1kg(+10,000원)">1kg(+10,000원)</option>
           			 </select>
				</div>
			</div>
			<div>
			<div>분쇄 선택</div>
				<div>
					 <select name="option2">
		                 <option value="원두상태">원두상태</option>
		                 <option value="프렌치 프레스 분쇄">프렌치 프레스 분쇄</option>
		                 <option value="드립 및 커피메이커 분쇄">드립 및 커피메이커 분쇄</option>
		                 <option value="더치 분쇄">더치 분쇄</option>
		                 <option value="모카포트 분쇄">모카포트 분쇄</option>
		                 <option value="에스프레소 분쇄">에스프레소 분쇄</option>
           			 </select>
				</div>
			</div>
			<hr/>
			<div>
				<button  class="btn1" >장바구니</button>
			</div>
			<div>
				<button  class="btn2">구매하기</button>
			</div>
		</div>
	</div>
	<hr/>
	<div class="box2">
		<h1>상품상세정보</h1>
		<div>${dto.prodInfo }</div>
	
	</div>
	<div class="box3">
		<h1>리뷰</h1>
		<a href="ReviewWrite">리뷰쓰기</a>
	</div>
</div>

</body>
</html>