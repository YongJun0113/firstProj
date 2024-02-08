package board_p;

import java.io.IOException;	
import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.BoardService;
import dao_p.BoardDAO;
import dto_p.BoardDTO;

public class SearchResultHandler implements BoardService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String title = request.getParameter("title");
		ArrayList<BoardDTO> serachResult = new BoardDAO().serachList(title);
		request.setAttribute("mainUrl", "SearchResultHandler.jsp");
		request.setAttribute("serachResult", serachResult);

	}
}
