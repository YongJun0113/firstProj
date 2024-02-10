package board_p;

import java.util.ArrayList;

import boardNextPage_p.ListPager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao_p.BoardDAO;
import dto_p.BoardDTO;

import service_p.BoardService;

public class BoardList implements BoardService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("BoardList execute() 실행");
		
		ListPager page = new ListPager(request);
		
		ArrayList<BoardDTO> boardDataList = new BoardDAO().list(page);
		
		request.setAttribute("page", page);
		request.setAttribute("boardDataList", boardDataList);
}
	}