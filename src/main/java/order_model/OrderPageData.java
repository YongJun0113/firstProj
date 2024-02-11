package order_model;

import jakarta.servlet.http.HttpServletRequest;

public class OrderPageData {
	
	int limit = 3, pageLimit = 4;
	int nowPage = 1;
	int start, total, totalPage, startPage, endPage;
	
	public OrderPageData(HttpServletRequest request) {
		if(request.getParameter("nowPage") != null) {
			nowPage = Integer.parseInt(request.getParameter("nowPage"));
		}
		
		start = (nowPage-1)*limit;
		
		startPage = (nowPage-1)/pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit - 1;
		
	}
	
	public void totalCalc(int total) {
		this.total = total;
		
		totalPage = total/limit;
		
		if(total%limit!=0) {
			totalPage++;
		}
		
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		
		System.out.println(total + " , " + totalPage + " , " + endPage);
	}
	
	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getLimit() {
		return limit;
	}

	
	public int getPageLimit() {
		return pageLimit;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getTotalPage() {
		return totalPage;
	}
	
	
	
}
