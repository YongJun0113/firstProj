package product_p;

import dao_p.ProductDAO;
import dto_p.ProductDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.ProductService;



public class ProductDelete implements ProductService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		int prodNum = Integer.parseInt(request.getParameter("prodNum"));
		ProductDTO dto = new ProductDAO().detail(prodNum);
		
		new ProductDAO().delete(prodNum);
		request.setAttribute("dto", dto);
		
		request.setAttribute("mainUrl", "inc/alert.jsp");
		request.setAttribute("msg", "삭제되었습니다.");
		request.setAttribute("goUrl", "ProductList");
		
		
	}
}
