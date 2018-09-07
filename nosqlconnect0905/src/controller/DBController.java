package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Buy;

@WebServlet("*.db")
public class DBController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DBController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 요청 주소에서 공통된 부분을 제외한 부분을 추출
		String requestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = requestURI.substring(contextPath.length() + 1);
		switch (command) {
		case "dataselect.db" :
			Connection con4 = null;
			PreparedStatement ps4 = null;
			ResultSet rs4 = null;
			
			//데이터 1개를 리턴하는 경우는 변수만 생성
			Buy buy1 = null;

			try {
				// 드라이버 클래스 로드
				Class.forName("com.mysql.jdbc.Driver");
				// 데이터베이스 연결
				con4 = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cats?characterEncoding=UTF-8&serverTimezone=UTC", "root",
						"********");
				ps4 = con4.prepareStatement("select * from buytbl where num=?");
				//파라미터를 읽을 때는 무조건 String으로 읽어야 합니다.
				String num = request.getParameter("num");
				//문자열을 정수로 변환해서 ?에 바인딩
				ps4.setInt(1, Integer.parseInt(num));

				// sql을 실행하고 결과를 저장하기
				rs4 = ps4.executeQuery();
				
				//리턴된 데이터를 읽어서 buy에 저장
				if(rs4.next()) {
					buy1=new Buy();
					buy1.setNum(rs4.getInt("num"));
					buy1.setUserid(rs4.getString("userid"));
					buy1.setProductname(rs4.getString("productname"));
					buy1.setGroupname(rs4.getString("groupname"));
					buy1.setPrice(rs4.getInt("price"));
					buy1.setAmount(rs4.getInt("amount"));
				}
				System.out.println(buy1);

			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (rs4 != null)
						rs4.close();
					if (ps4 != null)
						ps4.close();
					if (con4 != null)
						con4.close();
				} catch (Exception e) {
				}
			}
			break;
		case "dataselectlist.db" :
			Connection con3 = null;
			PreparedStatement ps3 = null;
			ResultSet rs3 = null;
			//select 구문은 결과를 저장할 변수가 필요 - 전체행은 무조건 list
			List<Buy> list = new ArrayList<Buy>();
			try {
				// 드라이버 클래스 로드
				Class.forName("com.mysql.jdbc.Driver");
				// 데이터베이스 연결
				con3 = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cats?characterEncoding=UTF-8&serverTimezone=UTC", "root",
						"********");
				ps3 = con3.prepareStatement("select * from buytbl");

				// sql을 실행하고 결과를 저장하기
				rs3 = ps3.executeQuery();
				
				//리턴된 데이터를 읽어서 list에 저장
				while(rs3.next()) {
					Buy buy = new Buy();
					buy.setNum(rs3.getInt("num"));
					buy.setUserid(rs3.getString("userid"));
					buy.setProductname(rs3.getString("productname"));
					buy.setGroupname(rs3.getString("groupname"));
					buy.setPrice(rs3.getInt("price"));
					buy.setAmount(rs3.getInt("amount"));
					list.add(buy);
				}
				if(list.size()>0) {
					System.out.println("조회 성공");
				}else{
					System.out.println("데이터가 없습니다.");
				}
				for(Buy imsi : list) {
					System.out.println(imsi);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (rs3 != null)
						rs3.close();
					if (ps3 != null)
						ps3.close();
					if (con3 != null)
						con3.close();
				} catch (Exception e) {
				}
			}
			break;
		case "datadelete.db":
			Connection con2 = null;
			PreparedStatement ps2 = null;
			try {
				// 드라이버 클래스 로드
				Class.forName("com.mysql.jdbc.Driver");
				// 데이터베이스 연결
				con2 = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cats?characterEncoding=UTF-8&serverTimezone=UTC", "root",
						"********");
				ps2 = con2.prepareStatement("delete from usertbl where userid = ?");
				ps2.setString(1, "abcdefg");

				// sql을 실행하고 결과를 저장하기
				int result = ps2.executeUpdate();
				if (result > 0) {
					System.out.println("삭제 성공!");
				} else {
					System.out.println("에러는 없지만 삭제는 하지 않음!");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (con2 != null)
						con2.close();
					if (ps2 != null)
						ps2.close();
				} catch (Exception e) {
				}
			}
			break;
		case "datainsert.db":
			Connection con1 = null;
			PreparedStatement ps = null;
			try {
				// 드라이버 클래스 로드
				Class.forName("com.mysql.jdbc.Driver");
				// 데이터베이스 연결
				con1 = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cats?characterEncoding=UTF-8&serverTimezone=UTC", "root",
						"********");
				ps = con1.prepareStatement(
						"insert into usertbl(userid, name, birthyear, addr, mobile, mdate)values(?,?,?,?,?,?)");
				ps.setString(1, "abcdefg");
				ps.setString(2, "관리자");
				ps.setInt(3, 1993);
				ps.setString(4, "인천광역시");
				ps.setString(5, "01012123434");
				ps.setDate(6, new Date(93, 8, 17));

				// sql을 실행하고 결과를 저장하기
				int result = ps.executeUpdate();
				if (result > 0) {
					System.out.println("삽입 성공!");
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			} finally {
				try {
					if (con1 != null)
						con1.close();
					if (ps != null)
						ps.close();
				} catch (Exception e) {
				}
			}
			break;
		case "mysql.db":
			try {
				// 드라이버 클래스 로드
				Class.forName("com.mysql.jdbc.Driver");
				// 데이터베이스 연결
				Connection con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/cats?characterEncoding=UTF-8&serverTimezone=UTC", "root",
						"********");
				System.out.println(con);
				con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			break;
		case "oracle.db":
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.101:1521:xe", "user05",
						"user05");
				System.out.println(con);
				con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
				e.printStackTrace();
			}
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
