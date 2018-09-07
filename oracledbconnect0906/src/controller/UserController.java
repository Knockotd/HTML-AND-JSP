package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import service.UserService;
import service.UserServiceImpl;
import vo.Members;

@WebServlet("/user/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private UserService userService;
    public UserController() {
    	  super();
    	userService = UserServiceImpl.sharedInstance();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청경로에서 프로젝트 경로를 제거
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length()+1);
		
		/*--디버깅
		//세션을 사용하는 경우가 많으므로 여기서 세션을 생성
		//command가 콘솔에 출력이 안되면 : url을 제대로 처리하지 못하는 것입니다. -> form에서 전송할 때 사용할 url과 servlet이 처리하는 url이 같은지 확인
		System.out.println("요청 경로 : "+command);
		--*/
		
		HttpSession session = request.getSession();
		switch(command) {
		case "user/login":
			//서비스 메소드 호출
			Members user = userService.login(request);
			
			//로그인에 실패한 경우
			
			//--디버깅--//
			System.out.println(user); //null
			//--디버깅--//
			
			if(user == null) {
				session.setAttribute("user", user);
				session.setAttribute("msg", "email이나 비밀번호가 틀렸습니다.");
				
			}else {
			//로그인 성공
				session.setAttribute("user", user);
			}
			//로그인 성공 여부에 관계없이 메인 페이지로 리다이렉트
			//현재 요청이 user/login 이므로 현재 위치는 user 이다.
			//메인으로 갈려면 user의 상위로 이동해야 합니다.
			response.sendRedirect("../");
			break;
		case "user/logout":
			//세션을 초기화
			session.invalidate();
			//시작 페이지로 리다이렉트(로그아웃도 2번되면 안되니깐)
			response.sendRedirect("../");
			break;
		case "user/register":
			//단순 페이지 이동
			//출력하는 페이지의 경로를 설정할 때는
			//url을 기준으로 합니다.
			//지금 url이 user/register 이므로
			//기준위치는 WebContext/user 입니다.
			RequestDispatcher dispatcher = 
				request.getRequestDispatcher(
					"../member/register.jsp");
			dispatcher.forward(request, response);
			break;
		case "user/insert":
			//이 문장이 안나오면 주소 확인(링크)
			System.out.println("회원가입처리");
			boolean r = userService.registerMember(request);
			if(r==true) {
				//회원가입에 성공했을 때 처리
				response.sendRedirect("../");
				session.setAttribute("msg", "회원가입 성공! 로그인하세요.");
			}else {
				//회원가입에 실패했을 때 처리
				response.sendRedirect("register");
				session.setAttribute("registermsg", "회원가입 실패! 다시 입력해주세요.");
			}
			break;
		case "user/emailcheck":
			boolean result = userService.emailCheck(request);
			//json으로 출력할 때는 리턴받은 데이터를 바로 저장하지 말고
			//JSON 객체로 변환해서 저장
			JSONObject obj = new JSONObject();
			obj.put("result", result);
			//데이터 저장
			request.setAttribute("result", obj);
			//결과 페이지로 포워딩 - 리다이렉트로도 가능
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("/member/emailcheck.jsp");
			//404 에러가 나면 바로 위의 페이지가 없는 것이다.
			dispatcher1.forward(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
