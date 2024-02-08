package board_p;

import jakarta.servlet.http.HttpServletRequest;		
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import service_p.BoardService;
import dao_p.BoardDAO;
import dto_p.BoardDTO;

import java.io.IOException;

import etc_p.FileHandler;

public class WritePostHandler implements BoardService{
	
	String uploadFile(Part file, HttpServletRequest request) throws IOException {
		return new FileHandler(request).uploadFile(file);
	}
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {	
			BoardDTO dto = new BoardDTO();
			dto.setBoardCate(request.getParameter("boardCate"));
			dto.setPerTitle(request.getParameter("writeTitle"));
			dto.setPerContent(request.getParameter("writeContent"));
			dto.setPerFile(request.getParameter("perFile"));
			
			//new BoardDAO().writePost(dto);
			
			if (!dto.getPerTitle().isEmpty() && !dto.getPerContent().isEmpty()) {
			    new BoardDAO().writePost(dto);
			    request.setAttribute("message", "등록되었습니다.");
				request.setAttribute("mainUrl", "include/alert.jsp");
				request.setAttribute("returnToList", "BoardList");
			} else {
			    request.setAttribute("message", "작성하지 않은 필수 항목이 있습니다.\n모든 항목을 작성해 주세요.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
