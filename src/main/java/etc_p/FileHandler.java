package etc_p;

import java.io.File;	
import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

public class FileHandler {
	String directory;
	
	public FileHandler(HttpServletRequest request) {
		directory = request.getServletContext().getRealPath("saveFile/");
		directory = "C:\\kimhyejung\\study\\javaWork\\firstProjMe\\src\\main\\webapp\\saveFile";//추후 수정 필요
		System.out.println(directory);
		
	}	
	
	public String uploadFile(Part file) throws IOException {
		int cnt = 1;
		//getSubmittedFileName : 업로드한 파일의 원래 이름
		if(!file.getSubmittedFileName().equals("")) {

			String fileName = file.getSubmittedFileName();
			int dot = fileName.lastIndexOf(".");
			String domain = fileName.substring(0, dot);
			String ext = fileName.substring(dot);
			
			File userFile = new File(directory+fileName);
			
			while(userFile.exists()) {
				fileName = domain+"("+cnt+")"+ext;
				userFile = new File(directory+fileName);
				cnt++;
			}
			file.write(directory+fileName);
			file.delete();
			
			return fileName;
		}
		return null;
	}
	
	public void deleteFile(String fileName) {
		new File(directory+fileName).delete();
	}
}
