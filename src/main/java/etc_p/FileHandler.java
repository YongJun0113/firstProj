package etc_p;

import java.io.File;	
import java.io.IOException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;

public class FileHandler {
	String directory;
	
	public FileHandler(HttpServletRequest request) {
		directory = request.getServletContext().getRealPath("saveFile/");
//		directory = "/firstProj/src/main/webapp/saveFile/";
		directory = "C:\\kimhyejung\\study\\javaWork\\first-Proj-Team\\firstProj\\src\\main\\webapp\\saveFile\\";
		System.out.println(directory);
		
	}	
	
	public String uploadFile(Part file) throws IOException {
		int cnt = 1;
		//getSubmittedFileName : 업로드한 파일의 원래 이름
		if(!file.getSubmittedFileName().equals("")) {

			String fName = file.getSubmittedFileName();
			int dot = fName.lastIndexOf(".");
			String domain = fName.substring(0, dot);
			String ext = fName.substring(dot);
			
			File userFile = new File(directory+fName);
			
			while(userFile.exists()) {
				fName = domain+"("+cnt+")"+ext;
				userFile = new File(directory+fName);
				cnt++;
			}
			file.write(directory+fName);
			file.delete();
			
			return fName;
		}
		return null;
	}
	
	public void deleteFile(String fName) {
		new File(directory+fName).delete();
	}
}
