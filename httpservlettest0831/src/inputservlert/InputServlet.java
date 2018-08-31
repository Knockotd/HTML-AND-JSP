package inputservlert;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/personcreate")
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InputServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//파라미터를 읽어서 출력
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		String gender = request.getParameter("gender");
		String name= request.getParameter("name");
		String nickname= request.getParameter("nickname");
		String [] hobby = request.getParameterValues("hobby");
		
		System.out.println("email:"+email);
		System.out.println("pw:"+pw);
		System.out.println("gender:"+gender);
		System.out.println("name:"+name);
		System.out.println("nickname:"+nickname);
		for(String imsi : hobby) {
		System.out.println("hobby:"+imsi);
		}
		//결과 페이지에 전송할 데이터를 저장
		//리다이렉트는 리퀘스트 데이터를 안 들고감
		//request.setAttribute("msg", "회원가입에 성공하셨습니다.");
		request.getSession().setAttribute("msg", "회원가입에 성공하셨습니다.");
		
		
		//request에 저장했으므로 결과 페이지를 포워딩 하기
		//새로고침 하면 작업을 다시 수행
		/*RequestDispatcher dispatcher = request.getRequestDispatcher("createout.jsp");
		dispatcher.forward(request, response);*/
		response.sendRedirect("createout.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
