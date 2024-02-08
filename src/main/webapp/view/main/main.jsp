<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <script>
        window.onload = function(){
            var x = 0

            var box = document.getElementById("long")
            
            function gogo(){
                x++
                if(x>=3){
                    x=0
                }
                box.style.left = -1200 * x +"px"
            }
            
            //gogo()
            go = setInterval(gogo,3000)
          
        }
    </script>
<head>
<meta charset="UTF-8">
<title>main</title>
</head>
<body>
<form action="" name="frm">
    <div id="banner">
        <div id="long">
            <img id="bn" src="<c:url value="/view/main/img/main(1).jpg"/>" alt="">
            <img id="bn" src="<c:url value="/view/main/img/main(2).jpg"/>" alt="">
            <img id="bn" src="<c:url value="/view/main/img/main(3).gif"/>" alt="">
        </div>
    </div>
</form>
	<ul>
	    <li id="li_t"></li>
	    <li id="li_t"><h1>이 상품 어때요?></h1></li>
	    <li id="li_t"></li>
	</ul>
    
</body>
</html>