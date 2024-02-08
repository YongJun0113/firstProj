package main_con;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface MainService {
	void execute(HttpServletRequest request, HttpServletResponse response); 
}
