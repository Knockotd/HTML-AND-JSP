package service;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import dao.UserDao;
import dao.UserDaoImpl;
import vo.Members;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	//외부에서 인스턴스 생성을 못하도록 생성자를 private으로 설정.
	private UserServiceImpl() {
		userDao = UserDaoImpl.sharedInstance();
	}
	
	//인스턴스 한개의 주소를 저장할 수 있는 변수를 선언. 한개만 만들어져야 하기 때문에 static을 붙임.
	private static UserService userService;
	
	//밖에서 인스턴스를 사용할 수 있도록 public으로 인스턴스의 주소를 리턴해주는 메소드 생성.
	//처음 한번만 인스턴스를 생성하도록 하는 코드를 추가한다. userService == null
	public static UserService sharedInstance() {
		if(userService == null) {
			userService = new UserServiceImpl();
		}
		return userService;
	
}

	@Override
	public Members login(HttpServletRequest request﻿) {
		//파라미터 전부 읽기
		String email = request﻿.getParameter("email");
		String password = request﻿.getParameter("password");
		
		//--디버그--//
		//이 메시지가 안나오는 경우는 controller의 url을 확인해보고 메소드 이름을 확인해야 합니다.
		//파라미터가 잘못나오는 경우는 jsp 파일의 name과 getParameter의 이름을 확인
				System.out.println("controller에서 넘어온 파라미터 : "+email);
				System.out.println("controller에서 넘어온 파라미터 : "+password);
		//--디버그--//
				
		//수행할 연산이 있으면 연산을 수행
		
		//호출할 Dao 메소드의 매개변수를 생성
		Members member = new Members();
		member.setEmail(email);
		member.setPassword(password);
		
		//Dao 메소드 호출
		Members user = userDao.login(member);
		//결과 리턴
		return user;

	}

	@Override
	public boolean registerMember(HttpServletRequest request) {
		System.out.println("서비스 도착");
		boolean result = false;
		
		//1. 파라미터 읽기
		//1) 인코딩
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		//2) 파라미터 읽기
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String mphone = request.getParameter("mphone");
		String addr = request.getParameter("addr");
		String recoveremail = request.getParameter("recoveremail");
		//파라미터 출력- null이 나오면 jsp 페이지에 사용한 name과 파라미터 이름 확인
		System.out.println(email);
		System.out.println(password);
		System.out.println(name);
		System.out.println(mphone);
		System.out.println(addr);
		System.out.println(recoveremail);
		
		//2. Dao 메소드의 파라미터 만들기
		Members members = new Members();
		members.setEmail(email);
		members.setPassword(password);
		members.setName(name);
		members.setMphone(mphone);
		members.setAddr(addr);
		members.setRecoverEmail(recoveremail);
		
		System.out.println(members);
		
		//3. Dao 메소드를 호출
		result = userDao.registerMember(members);
		
		return result;
	}

	@Override
	public boolean emailCheck(HttpServletRequest request) {
		//파라미터 읽어오기
		String email = request.getParameter("email");
		//Dao의 메소드 호출
		boolean result = userDao.emailCheck(email);
		return result;
	}
}
