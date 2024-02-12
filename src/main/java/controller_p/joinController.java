package controller_p;

import java.io.IOException;

import dao_p.MemberDAO;
import dto_p.MemberDTO;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class joinController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/member/memberForm.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String userid     = req.getParameter("userid");
		String pw         = req.getParameter("pw");
		String username   = req.getParameter("username");
		String gender     = req.getParameter("gender");
		String tel        = req.getParameter("tel");
		String email      = req.getParameter("email");
		String postNum    = req.getParameter("postNum");
		String streetAddr = req.getParameter("streetAddr");
		String addr       = req.getParameter("addr");
		String dtailAddr  = req.getParameter("dtailAddr");
		String status     = req.getParameter("status");
		String admin      = req.getParameter("admin");
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberDTO dto = new MemberDTO();
		dto.setUserid(userid);
		dto.setPw(pw);
		dto.setUsername(username);
		dto.setGender(gender);
		dto.setTel(tel);
		dto.setEmail(email);
		dto.setPostNum(postNum);
		dto.setStreetAddr(streetAddr);
		dto.setAddr(addr);
		dto.setDtailAddr(dtailAddr);
		dto.setStatus(status);
		dto.setAdmin(admin);
		
		int joinResult = dao.join(dto);
		
		if (joinResult == 1) {
			req.setAttribute("joinResult", joinResult);
			HttpSession session = req.getSession();
			session.setAttribute("sessionID", userid);
			RequestDispatcher rd = req.getRequestDispatcher("/member/loginmain.jsp");
			rd.forward(req, resp);
		} else {
			req.setAttribute("joinResult", 0);
			RequestDispatcher rd = req.getRequestDispatcher("/member/memberForm.jsp");
			rd.forward(req, resp);
		}
	}
	
}