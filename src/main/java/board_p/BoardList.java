package board_p;

import java.util.ArrayList;

import boardNextPage_p.ListPager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.BoardService;
import dao_p.BoardDAO;
import dto_p.BoardDTO;


public class BoardList implements BoardService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("BoardList execute() 실행");
		String cate = request.getParameter("searchCate");
		String search = request.getParameter("search");
		
		if(search!=null) {
			ListPager page = new ListPager(request);
			ArrayList<BoardDTO> searchResult = new BoardDAO().serachList(cate, search);
			
			System.out.println(searchResult);
			request.setAttribute("searchResult", searchResult);
			request.getAttribute("searchResult");
			
			if(!cate.equals("")&&search.equals("")) {
				request.setAttribute("mainUrl", "include/alert.jsp");
				request.setAttribute("message", "검색어를 입력해주세요.");
				request.setAttribute("returnToList", "BoardList");
			}
		} else {
			ListPager page = new ListPager(request);
			
			ArrayList<BoardDTO> boardDataList = new BoardDAO().list(page);
			
			request.setAttribute("page", page);
			request.setAttribute("boardDataList", boardDataList);
		}
	}
}