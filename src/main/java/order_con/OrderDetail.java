package order_con;

import java.util.ArrayList;

import dao_p.OrderDAO;
import dto_p.OrderDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




public class OrderDetail implements OrderService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//OrderPageData pData = new OrderPageData(request);
		//pData.totalCalc(new OrderDAO().total());
		ArrayList<OrderDTO> data = new OrderDAO().detailList();
		request.setAttribute("mainData", data);
		System.out.println("OrderDetail.execute() 실행 : ");
		
	}
	
}
