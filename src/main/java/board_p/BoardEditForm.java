package board_p;

import dao_p.BoardDAO;
import dto_p.BoardDTO;
import jakarta.servlet.http.HttpServletRequest;	
import jakarta.servlet.http.HttpServletResponse;
import service_p.BoardService;


public class BoardEditForm implements BoardService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int perNum = Integer.parseInt(request.getParameter("perNum"));
		BoardDTO dto = new BoardDAO().getPostDetails(perNum);
		request.setAttribute("dto", dto);
		
		
		
	}
}
