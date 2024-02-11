package profile_con;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ProfileDelete implements ProfileService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter("userId");
		
		new ProfileDAO().delete(userId);
		
		request.setAttribute("mainUrl", "ProfileDelete.jsp");
		request.setAttribute("msg", "회원 탈퇴되었습니다.");
		request.setAttribute("goUrl", "main/main");
		
	}
	
}
