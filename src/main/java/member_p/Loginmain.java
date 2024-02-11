package member_p;

import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import service_p.MemberService;

public class Loginmain implements MemberService {
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("member");
		
	}
}