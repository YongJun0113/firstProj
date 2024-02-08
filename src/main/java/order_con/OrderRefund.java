package order_con;

import java.util.ArrayList;

import dao_p.OrderDAO;
import dto_p.OrderDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class OrderRefund implements OrderService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<OrderDTO> data = new OrderDAO().refundList();
		request.setAttribute("mainData", data);
		//request.setAttribute("pData", pData);
		
		System.out.println("OrderRefund.execute() 실행 : ");
		
	}
	
}
