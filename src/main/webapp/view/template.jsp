<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<style>
        *{
            margin:0;
            padding:0;
        }
        ul{
            width:1200px;
            height: 50px;
        }
        a{
            text-decoration-line: none;
            color: #000;
            margin: 30px;
        }
        #li_logo{
            list-style: none;
            float: left;
            width: 400px;
            height: 50px;
            line-height: 50px;
            text-align: center;
        }
        #cli{
            list-style: none;
            float: left;
            width: 150px;
            height: 44px;
            line-height: 44px;
            text-align: center;
        }
        #header{
            width:1200px;
            height: 44px;
            float: right;
            text-align: right;
            font-size: 12px;
        }
        #category{
            width:1200px;
            height: 44px;
            display:flex;
        }
        #logo{
            width:1200px;
            height: 44px;
            display:flex;
        }
        #cate_list{
            width:800px;
            height: 44px;
            display:flex;
            justify-content: center;
        }
        #logo_list{
            width:800px;
            height: 44px;
            display:flex;
            justify-content: center;
        }
        #void{
            width:200px;
            height: 44px;
        }
               #li_t{
            list-style: none;
            float: left;
            width: 400px;
            height: 50px;
            line-height: 50px;
            text-align: center;
        }
        #banner{
            width:1200px;
            height: 500px;
            position: relative;
            overflow: hidden;
        }
        #long{
            width: 3600px;
            height: 500px;
            left: 0px;
            position: absolute;
            transition-duration: 2.0s;
        }
        #bn{
            width: 1200px;
            height: 500px;
            display: block;
            float: left;
        }
</style>
<head>
<meta charset="UTF-8">
<title>원두쓰리</title>
</head>
<body>
<table border="">
	<tr>
		<td><jsp:include page="inc/header.jsp"/></td>
	</tr>
	<tr>
		<td width="800px"><jsp:include page="${mainUrl }"/></td>
	</tr>
	<tr>
		<td><jsp:include page="inc/footer.jsp"/></td>
	</tr>
</table>
</body>
</html>

