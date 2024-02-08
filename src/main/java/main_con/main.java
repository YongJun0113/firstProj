package main_con;

import java.util.ArrayList;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import model_p.BoardDAO;
//import model_p.BoardDTO;
//import model_p.PPData;

public class main implements MainService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
//		PPData pData = new PPData(request);
//		pData.totalCalc(new BoardDAO().total());
//		ArrayList<BoardDTO> data =  new BoardDAO().list(pData);
//		request.setAttribute("mainData", data);
//		request.setAttribute("pData", pData);
		
		System.out.println("main.excute() 실행");
	}

}
