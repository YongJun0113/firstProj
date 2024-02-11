package notice_p;

import jakarta.servlet.http.HttpServletRequest;	
import jakarta.servlet.http.HttpServletResponse;
import service_p.NoticeService;
import dao_p.NoticeDAO;
import dto_p.NoticeDTO;

public class NoticeDetails implements NoticeService{
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		int noticeNum = Integer.parseInt(request.getParameter("noticeNum"));
		NoticeDTO dto = new NoticeDAO().getPostDetails(noticeNum);
		
		request.setAttribute("dto", dto);
		System.out.println("postDetails() 실행 : 게시물 자세히보기" + dto);
		
		
	}
}
