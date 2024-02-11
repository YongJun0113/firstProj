package service_p;

import java.net.http.HttpResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface MemberService {
	void execute(HttpServletRequest request, HttpServletResponse response);
}
