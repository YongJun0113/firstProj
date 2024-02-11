package notice_p;

import java.util.ArrayList;

import boardNextPage_p.NoticeListPager;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao_p.NoticeDAO;
import dto_p.NoticeDTO;

import service_p.NoticeService;

public class NoticeList implements NoticeService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("NoticeList execute() 실행");
		
		NoticeListPager page = new NoticeListPager(request);
		
		ArrayList<NoticeDTO> NoticeDataList = new NoticeDAO().list(page);
		
		request.setAttribute("page", page);
		request.setAttribute("NoticeDataList", NoticeDataList);
	}
}