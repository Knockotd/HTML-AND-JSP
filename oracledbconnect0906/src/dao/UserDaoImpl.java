package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import vo.Members;

public class UserDaoImpl implements UserDao {

	//데이터베이스 연결을 위한 변수
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	private UserDaoImpl() {
	}
	
	private static UserDao userDao;
	
	public static UserDao sharedInstance() {
		if(userDao == null) {
			userDao = new UserDaoImpl();
		}
		return userDao;
	}

	@Override
	public Members login(Members members) {
		/*--디버그--//
		//넘어온 파라미터를 출력
		//email 과 password가 제대로 저장되었는지 확인
		System.out.println("service에서 넘어온 데이터 : "+ members);
		//--디버그--*/
		Members user = null;
		try {
			//context.xml 파일의 내용을 읽어오기
			Context init = new InitialContext();
			//읽은 내용 중에서 DBConn 이라는 이름의 내용을 읽어서 데이터베이스 접속정보를 생성합니다.
			DataSource ds = (DataSource) init.lookup("java:comp/env/DBConn");
			//접속 정보를 이용해서 커넥션을 빌려오기
			con = ds.getConnection();
			
			//Statement 인스턴스를 생성하고 SQL 실행
			ps = con.prepareStatement("select email, name from members where trim(email)=? and trim(password)=?");
			
			//?에 값 채우기
			ps.setString(1, members.getEmail().trim());
			ps.setString(2, members.getPassword().trim());
			
			//SQL 실행
			rs = ps.executeQuery();
			
			//결과를 읽기
			//읽은 데이터가 있는 경우에 user에 인스턴스를 생성해서 대입
			//읽은 데이터가 없으면 user는 null
			if(rs.next()) {
				//인스턴스를 생성하고 결과를 저장
				user = new Members();
				user.setEmail(rs.getString("email"));
				user.setName(rs.getString("name"));
				
				
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			
				try {
					if(rs != null) rs.close();
					if(ps != null) ps.close();
					if(con != null) con.close();
				} catch (Exception e) {
				}
		}
		
		//email 과 password 가 일치하는 데이터가 없으면 null 이 리턴
		//일치하는 데이터가 있으면 인스턴스를 생성해서 리턴
		
		/*--디버그--//
		System.out.println("리턴하는 데이터 :"+user);
		//--디버그--*/
		return user;
	}

	@Override
	public boolean registerMember(Members members) {
		boolean result = false;
		try {
			//context.xml 파일의 내용을 읽어오기
			Context init = new InitialContext();
			//읽은 내용 중에서 DBConn 이라는 이름의 내용을 읽어서 데이터베이스 접속정보를 생성합니다.
			DataSource ds = (DataSource) init.lookup("java:comp/env/DBConn");
			//접속 정보를 이용해서 커넥션을 빌려오기
			con = ds.getConnection();
			//SQL 실행 객체 생성
			ps = con.prepareStatement("insert into members(email, password, name, mphone, addr, recoveremail) values(?,?,?,?,?,?)");
			//?에 데이터 바인딩
			ps.setString(1, members.getEmail());
			ps.setString(2, members.getPassword());
			ps.setString(3, members.getName());
			ps.setString(4, members.getMphone());
			ps.setString(5, members.getAddr());
			ps.setString(6, members.getRecoverEmail());
			//sql 실행
			int r = ps.executeUpdate();
			//정상적으로 수행되면,r이 0보다 큰 숫자를 리턴합니다.
			if(r>0) {
				result = true;
			}
		}catch(Exception e) {
			//예외 메시지 확인
			System.out.println(e.getMessage());
			//예외를 역추적
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch(Exception e) {
				
			}
		}
		return result;
	}

	@Override
	public boolean emailCheck(String email) {
		boolean result = false;
		try {
			//context.xml 파일의 내용을 읽어오기
			Context init = new InitialContext();
			//읽은 내용 중에서 DBConn 이라는 이름의 내용을 읽어서 데이터베이스 접속정보를 생성합니다.
			DataSource ds = (DataSource) init.lookup("java:comp/env/DBConn");
			//접속 정보를 이용해서 커넥션을 빌려오기
			con = ds.getConnection();
			//SQL 실행 객체 생성
			ps = con.prepareStatement(
					"select email "
					+ "from members "
					+ "where email = ?");
			//?에 데이터 바인딩
			ps.setString(1, email);
			//sql 실행
			rs = ps.executeQuery();
			//데이터가 검색되면 result 는 true
			if(rs.next()) {
				result = true;
			}else {
			}
		}catch(Exception e) {
			//예외 메시지 확인
			System.out.println(e.getMessage());
			//예외를 역추적
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
			}catch(Exception e) {
				
			}
		}
		return result;
	}
}
