package boardNextPage_p;

import jakarta.servlet.http.HttpServletRequest;

public class NoticeListPager {
	private int perPage = 15, pageLimit = 5;
	private int nowPage = 1;
	private int startInx;
	
	public NoticeListPager(HttpServletRequest request) {
		if(request.getParameter("nowPage")!=null) {
			nowPage = Integer.parseInt(request.getParameter("nowPage"));
		}
		startInx = (nowPage-1)*perPage;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public int getPageLimit() {
		return pageLimit;
	}

	public void setPageLimit(int pageLimit) {
		this.pageLimit = pageLimit;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getStartInx() {
		return startInx;
	}

	public void setStartInx(int startInx) {
		this.startInx = startInx;
	}
	
	
}
