<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>

</head>
<body>
<div id="header"><a href="/firstProj/member/memberForm">회원가입</a>|<a href="/firstProj/member/Loginmain">로그인</a>|<a href="">고객센터</a></div>
<div id="logo">
	<div id="void"><a href="/firstProj/main/Main"><img src="<c:url value="/view/inc/img/main_logo.png"/>" alt=""></a></div>
	<ul id="logo_list">
		<%-- <li id="li_logo"><img src="<c:url value="/main/inc/img/search_bar.png"/>" alt=""></li> --%>
		<li id="li_logo"><input type="text" /><input type="button" value="검색"/></li>
	</ul>
	<div id="void"><a href="/firstProj/admin/Admin">관리자</a></div>
	<div id="void"><a href="/firstProj/product/ProductList">상품</a></div>
	<div id="void"><a href="/firstProj/notice/NoticeList">공지사항</a>
	<div id="void"><a href="/firstProj/board/BoardList">1:1문의</a></div>
	</div>
	<div id="void"><a href="/firstProj/myPage/MyPageMain">aa</a></div>
</div>
<div id="category">
	<div id="void"></div>
	<ul id="cate_list">
		<li id="cli"><a href=""><span>신상품</span></a></li>
	    <li id="cli"><a href=""><span>베스트</span></a></li>
	    <li id="cli"><a href=""><span>특가/할인</span></a></li>
	</ul>
	<div id="void"></div>
</div>
</body>
</html>

