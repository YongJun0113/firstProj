<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<style>
	
	.big{
		display:flex;
		width:100%;
		justify-content: space-evenly;
	}
	.big>div{
		width:150px;
		height:250px;
		border:1px solid #000;
		margin-top : 20px;
		display:block;

	}
	.img>img{
		width:130px;
		height:150px;
		margin-top : 10px;
		margin-left : 10px;
	}
	.cate{
		height:100px;
		background-color : #ccc;
	}
	
	

</style>
<script src="../js/jquery-3.7.1.min.js"></script>

<script>
	$(function(){
		$(".box").click(function(){
			/* alert("눌림") */
			var prodNum = $(this).data("prodnum");
			location.href="ProductDetail?prodNum=" + prodNum;
			
		})
		
		$(".button").click(function(){
			/* alert("눌림")  */
			
			location.href="ProductWrite"
			
		})
		
	})


</script>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
<div class="wrapper">
	<div class="cate">카테고리</div>
	
	<div>
	 <c:if test="${param.admin != 'true' }">
            <div>
                <input type="button" class="button" value="글쓰기"/>
            </div>
        </c:if>
	
	</div>
	<c:forEach begin="1" end="4">
		<div class="big">
			<c:forEach items="${mainData}" var="dto" varStatus="no" begin="0" end="4">
				<div class="box" data-prodnum="${dto.prodNum}">
					<div class="img"><img src="${dto.prodFile }">
					</div>
					<div>${dto.prodTitle }</div>
					<div>${dto.prodPrice }</div>
				</div>
				
			</c:forEach>
		</div>
	</c:forEach>
</div>

</body>
</html>