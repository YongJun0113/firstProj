package admin_con;

import java.util.ArrayList;

import admin_model.AdminDAO;
import admin_model.AdminDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class Admin implements AdminService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		ArrayList<AdminDTO> data = new AdminDAO().list();
		int tData = new AdminDAO().total();
		request.setAttribute("mainData", data);
		request.setAttribute("tData", tData);
		
		System.out.println("admin.excute() 실행");
	}

}
