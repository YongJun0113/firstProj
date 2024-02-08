package board_p;

import jakarta.servlet.http.HttpServletRequest;	
import jakarta.servlet.http.HttpServletResponse;
import service_p.BoardService;
import dao_p.BoardDAO;
import dto_p.BoardDTO;

public class DeletePost implements BoardService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int perNum = Integer.parseInt(request.getParameter("perNum"));
		BoardDTO dto = new BoardDAO().getPostDetails(perNum);
		new BoardDAO().deletePost(perNum);
		
		request.setAttribute("mainUrl", "include/alert.jsp");
		request.setAttribute("returnToList", "BoardList");
		request.setAttribute("message", "삭제되었습니다.");
	}
}
