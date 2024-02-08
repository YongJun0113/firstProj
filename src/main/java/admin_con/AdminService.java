package admin_con;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AdminService {
	void execute(HttpServletRequest request, HttpServletResponse response); 
}
