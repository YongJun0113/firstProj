package board_p;

import java.util.ArrayList;	

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.BoardService;
import dao_p.BoardDAO;
import dto_p.BoardDTO;

public class BoardList implements BoardService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("BoardList execute() 실행");
		ArrayList<BoardDTO> boardDataList = new BoardDAO().list();
		request.setAttribute("boardDataList", boardDataList);
		System.out.println("게시판 실행");
	}
}
