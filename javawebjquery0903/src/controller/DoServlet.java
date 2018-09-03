package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class DoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getRequestURI -> /jquery0903/login.do
		//getContextPath ->/jquery0903/
		//login.do 만 추출하기 위한 로직
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String str = requestURI.substring(contextPath.length()+1);
		switch(str) {
		case "login.do":
			System.out.println("로그인 요청 처리");
		case "register.do":
			System.out.println("회원가입 요청 처리");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
