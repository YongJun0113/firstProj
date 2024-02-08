package product_p;

import java.util.ArrayList;

import dao_p.ProductDAO;
import dto_p.ProductDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.ProductService;



public class ProductList implements ProductService {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("왓냐");
		ArrayList<ProductDTO> data = new ProductDAO().list();
		request.setAttribute("mainData", data);
		
	}
}