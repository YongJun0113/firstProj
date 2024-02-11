package profile_con;

import java.util.ArrayList;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ProfileDetail implements ProfileService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		ArrayList<ProfileDTO> data = new ProfileDAO().profileList();
		request.setAttribute("mainData", data);
		System.out.println("ProfileDetail.execute() 실행 : ");
	}

}
