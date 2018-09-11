package controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.FileUploadService;
import service.FileUploadServiceImpl;
import service.FilesService;
import service.FilesServiceImpl;
import vo.Files;

@WebServlet("*.file")
public class FileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private FileUploadService fileUploadService;
	private FilesService filesService;
	
       
    public FileController() {
        super();
        fileUploadService = FileUploadServiceImpl.sharedInstance();
        filesService = FilesServiceImpl.sharedInstance();
    }

    
    //get 요청이 왔을 때 호출되는 메소드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//공통된 요청 주소 부분을 제외 한 요청 추출하기
		//전체 요청 경로 가져오기
		String requestURI = request.getRequestURI();
		//서버 경로 : contextPath
		String contextPath = request.getContextPath();
		//request.URI 에서 contextPath 와 / 제거
		String command = requestURI.substring(contextPath.length()+1);
		
		//세션 객체를 가져오기
		HttpSession session = request.getSession();
		
		
		RequestDispatcher dispatcher = null;
		//URL에 따른 분기문 만들기
		//항목이 많으면 switch가 더 구분하기 편하고 빠르다.
		switch(command) {
		case "fileupload.file":
			//단순 페이지 이동이나 서버에서 데이터를 조회한 후 출력할 때는
			//포워딩을 주로 이용합니다.
			//포워딩 이용하는 방법 : 계속 써야 한다면 switch 밖에 객체를 만들고 사용 : dispatcher
			dispatcher = request.getRequestDispatcher("views/fileupload.jsp");
		dispatcher.forward(request, response);
		
		break;
		case "upload.file":
			//요청 처리를 위한 메소드 호출
			Map<String, Object> map = fileUploadService.fileUpload(request);
			/* 처리 결과를 저장
			request.setAttribute("map", map);
			//처리 결과를 출력할 페이지로 이동
			dispatcher = request.getRequestDispatcher("views/result.jsp");
			dispatcher.forward(request, response); */
			
			//작업을 수행한 경우는 리다이렉트
			session.setAttribute("map", map);
			//리다이렉트를 할 때는 결과 페이지 경로를 적는 것이 아니고 url을 설정해서 url을 처리하는 부분에서 포워딩을 시킵니다.(위치투명성을 위해)
			response.sendRedirect("uploadresult.file");
			break;
		case "uploadresult.file":
			dispatcher = request.getRequestDispatcher("views/result.jsp");
			dispatcher.forward(request, response);
			break;
		case "input.file" :
			dispatcher = request.getRequestDispatcher("views/input.jsp");
			dispatcher.forward(request, response);
			break;
		case "insert.file":
			boolean result = filesService.insertFiles(request);
			if(result == true) {
				//메인 페이지로 리다이렉트
				//./ : 현재 디렉토리로 이동 ( /뒷부분이 삭제됨)
				response.sendRedirect("./");
			}else {
				//실패한 경우는 데이터 삽입 페이지로 이동
				response.sendRedirect("input.file");
			}
			break;
		case "list.file" :
			List<Files> list = filesService.listFiles(request);
			
			request.setAttribute("list", list);
			
			dispatcher = request.getRequestDispatcher("views/list.jsp");
			dispatcher.forward(request, response);
			break;
		}
	}

	//post 요청이 왔을 때 호출되는 메소드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post 요청이 왔을 때 doGet을 호출
		//한 곳에서 모든 요청을 처리하기 위해서(헷갈리지 말라고)
		doGet(request, response);
	}

}
