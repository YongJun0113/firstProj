package board_p;

import jakarta.servlet.http.HttpServletRequest;		
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import service_p.BoardService;
import dao_p.BoardDAO;
import dto_p.BoardDTO;

import java.io.File;
import java.io.IOException;

import etc_p.FileHandler;

public class WritePostHandler implements BoardService{
	
	/*
	 * String uploadFile(Part file, HttpServletRequest request) throws IOException {
	 * return new FileHandler(request).uploadFile(file); }
	 */
	String uploadFile(Part file, HttpServletRequest request) throws IOException {
		if(!file.getSubmittedFileName().equals("")) {//파일명이 빈칸이 아닐때만 저장함
			
			String fileName = file.getSubmittedFileName();
			int pos = fileName.lastIndexOf(".");
			String fDomaine = fileName.substring(0, pos);
			String ext = fileName.substring(pos);
			int cnt=1;
			
			
			String dir = request.getServletContext().getRealPath("fff/");
			dir = "C:\\kimhyejung\\study\\javaWork\\firstProjMe\\src\\main\\webapp\\saveFile\\";
			
			File nowFile = new File(dir+fileName);
				while(nowFile.exists()) {//같은 이름의 파일이 이미 있을 경우
					fileName = fDomaine+"_"+cnt+ext;
					nowFile = new File(dir+fileName);
					cnt++;
				}
				
				file.write(dir+fileName);
				file.delete();
				
				return fileName;
				}
			return null;
	}
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		try {	
			String upLoadFile = new FileHandler(request).uploadFile(request.getPart("perFile"));
			
			BoardDTO dto = new BoardDTO();
			dto.setBoardCate(request.getParameter("boardCate"));
			dto.setPerTitle(request.getParameter("writeTitle"));
			dto.setPerContent(request.getParameter("writeContent"));
			dto.setPerFile(upLoadFile);
			
			if (!request.getParameter("writeTitle").trim().isEmpty() && !request.getParameter("writeContent").trim().isEmpty()) {
			    new BoardDAO().writePost(dto);
			    request.setAttribute("msg", "등록되었습니다.");
				request.setAttribute("mainUrl", "inc/alert.jsp");
				request.setAttribute("goUrl", "BoardList");
			}else{
				request.setAttribute("mainUrl", "inc/alert.jsp");
			    request.setAttribute("msg", "작성하지 않은 필수 항목이 있습니다.");
				request.setAttribute("goUrl", "WritePost");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
			
	}
	
}
