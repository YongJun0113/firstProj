package profile_con;

import java.util.ArrayList;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ProfileModify implements ProfileService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		ProfileDTO dto = new ProfileDTO();
		dto.setPw(request.getParameter("pw"));
		dto.setAddr(request.getParameter("addr"));
		new ProfileDAO().modify(dto);
		
		request.setAttribute("mainUrl", "ProfileModify.jsp");
		request.setAttribute("msg", "수정 완료되었습니다.");
		request.setAttribute("goUrl", "main/main");
	}
	
}
