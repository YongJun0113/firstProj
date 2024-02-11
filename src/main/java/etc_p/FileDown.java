package etc_p;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Servlet implementation class FileDown
 */
@WebServlet("/FileDown")//파일 다운로드 서블릿
public class FileDown extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDown() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String directory = request.getServletContext().getRealPath("saveFile/");
		directory = "C:\\kimhyejung\\study\\javaWork\\first-Proj-Team\\firstProj\\src\\main\\webapp\\saveFile\\";//추후 수정 필요(개인마다 경로가 다름)
		
		String fName = request.getParameter("fName");
		response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fName,"utf-8"));
		
		ServletOutputStream out = response.getOutputStream();
		FileInputStream in = new FileInputStream(directory+fName);
		
		byte [] buf = new byte[1024];
		//int len = in.read(buffer);
		/*
		 * while(len!=-1) { out.write(buffer, 0, len); }
		 */
		while(in.available()>0) {
			int len = in.read(buf);
			out.write(buf, 0, len);
		}
		in.close();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
