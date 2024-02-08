package myPage_con;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyPageMain implements MyPageService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("ㅇ어넝너어언");
		
	}

}
