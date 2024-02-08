package cart_p;

import dao_p.CartDAO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.CartService;

public class Order implements CartService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int chk = Integer.parseInt(request.getParameter("chk"));

		
		
		
		new CartDAO().delete(chk);
		System.out.println(request.getParameter("chk"));
		
	}
	
}
