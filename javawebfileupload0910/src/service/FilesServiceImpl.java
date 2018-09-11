package service;

import java.io.File;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.FilesDao;
import dao.FilesDaoImpl;
import vo.Files;

public class FilesServiceImpl implements FilesService {
	//Dao의 참조형 변수를 선언
	private FilesDao filesDao;
	
	private FilesServiceImpl() {
		filesDao = FilesDaoImpl.sharedInstance();
	}
		
		private static FilesService filesService;
		
		public static FilesService sharedInstance() {
			if(filesService==null) {
				filesService = new FilesServiceImpl();
			}
			return filesService;
		}

		@Override
		public boolean insertFiles(HttpServletRequest request) {
			
			try {
				//파라미터 읽기
				request.setCharacterEncoding("utf-8");
				
				//작업 처리
				//파일 업로드
				//파일을 저장할 디렉토리 경로 생성
				String uploadPath = request.getServletContext().getRealPath("/dbfilesupload");
				MultipartRequest multi = new MultipartRequest(request, uploadPath, 1024*1024*10, "utf-8", new DefaultFileRenamePolicy());
				
				//--가장 큰 code 찾아오기
				int code = filesDao.getMaxCode();
				
				//description 읽기
				String description = multi.getParameter("description");
				
				//업로드 된 파일 명 찾아오기
				Enumeration<String> fileName = multi.getFileNames();
				String file = fileName.nextElement();
				String filename = multi.getFilesystemName(file);
				
				//업로드 된 파일 크기 찾아오기
				File f = new File(uploadPath + "/" + filename);
				int filesize = (int) f.length();
				
				//Dao 파라미터 만들기
				Files files = new Files();
				files.setCode(code+1);
				files.setFilename(filename);
				files.setFilesize(filesize);
				files.setDescription(description);
				
				System.out.println(files);
				
				//Dao 메소드 호출해서 리턴
				return filesDao.insertFlieData(files);
			}catch(Exception e) {
				System.out.println("데이터 삽입 예외:"+e.getMessage());
				e.printStackTrace();
			}
			return false;
		}

		@Override
		public List<Files> listFiles(HttpServletRequest request) {
			
			return filesDao.listFiles();
		}
	
}
