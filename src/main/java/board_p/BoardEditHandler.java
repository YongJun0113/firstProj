package board_p;

import jakarta.servlet.http.HttpServletRequest;	
import jakarta.servlet.http.HttpServletResponse;
import service_p.BoardService;
import dao_p.BoardDAO;
import dto_p.BoardDTO;

public class BoardEditHandler implements BoardService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			BoardDTO dto = new BoardDTO();
			dto.setPerTitle(request.getParameter("perTitle"));
			dto.setUserId(request.getParameter("userId"));
			dto.setPerContent(request.getParameter("perContent"));
			dto.setPerFile(request.getParameter("perFile"));
			
			new BoardDAO().editPost(dto);
			
			request.setAttribute("mainUrl", "include/alert.jsp");
			request.setAttribute("message", "수정되었습니다.");
			request.setAttribute("returnToList", "BoardList");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
