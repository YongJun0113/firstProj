
<%@page import="dao_p.MemberDAO"%>
<%@page import="dto_p.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

		
		/*
		String userid = request.getParameter("userid"); 
		String pw = request.getParameter("pw");
		
		MemberDAO dao = new MemberDAO();
		int result = dao.login(userid,pw);
		System.out.println(result + "<===리턴 받은 result");
		*/
		
		/*
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = new MemberDTO();
		dto.setUserid(request.getParameter("userid"));
		dto.setPw(request.getParameter("pw"));
		
		//int result = dao.login(dto.getUserid(), dto.getPw());
		int result = dao.login(dto);
		if(result == 1) { //아이디 비밀번호 다맞으면 js실행 페이지이동
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = 'test.jsp'"); //로그인성공시 메인페이지이동
			script.println("</script>");
		}else if(result == 0) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('비밀번호가 틀립니다.')");
			script.println("history.back()"); //비밀번호틀림 이전페이지디동
			script.println("</script>");
		} else if(result == -1){
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('존재하지않는아이디입니다.')");
			script.println("history.back()"); //db에 아이디없음
			script.println("</script>");
		} else if(result == -2) {
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('db오류.')");
			script.println("history.back()"); //db에러
			script.println("</script>");
		}
		*/
	/*
	MemberDTO dto = new MemberDTO();
	MemberDAO dao = new MemberDAO();	

	int result = dao.login(dto.getUserid(), dto.getPw());
	if(result == 1) { //아이디 비밀번호 다맞으면 js실행 페이지이동
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("location.href = 'test.jsp'"); //로그인성공시 메인페이지이동
		script.println("</script>");
	} else if(result == 0) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('비밀번호가 틀립니다.')");
		script.println("history.back()"); //비밀번호틀림 이전페이지디동
		script.println("</script>");
	} else if(result == -1){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('존재하지않는아이디입니다.')");
		script.println("history.back()"); //db에 아이디없음
		script.println("</script>");
	} else if(result == -2) {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('db오류.')");
		script.println("history.back()"); //db에러
		script.println("</script>");
	}
	*/
	//String userid = request.getParameter("userid");
	//String pw     = request.getParameter("pw");
	
%>
		
		
	
		<script type="text/javascript">
            alert('로그인성공');
            location.href='../main/main.jsp';
        </script>	
</body>
</html>