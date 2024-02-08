package cart_p;

import java.util.ArrayList;

import dao_p.CartDAO;
import dto_p.CartDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.CartService;



public class Cart implements CartService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<CartDTO> data = new CartDAO().list();
		request.setAttribute("mainData", data);
		
	}
}
