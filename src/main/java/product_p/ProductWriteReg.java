package product_p;

import dao_p.ProductDAO;
import dto_p.ProductDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service_p.ProductService;

public class ProductWriteReg implements ProductService{
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		ProductDTO dto = new ProductDTO();
		dto.setProdCate(request.getParameter("prodCate"));
		dto.setProdFile(request.getParameter("prodFile"));
		dto.setProdTitle(request.getParameter("prodTitle"));
		dto.setProdPrice(Integer.parseInt(request.getParameter("prodPrice")));
		dto.setProdInfo(request.getParameter("prodInfo"));

	
		new ProductDAO().write(dto);
		
		
		request.setAttribute("mainUrl", "inc/alert.jsp");
		request.setAttribute("msg","상품이 등록되었습니다.");
		request.setAttribute("goUrl", "ProductList");
		
	}
}
