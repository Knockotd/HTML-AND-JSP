package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.SimpleEmail;

import sun.net.www.protocol.http.HttpURLConnection;

public class EtcServiceImpl implements EtcService {
//*****싱글톤******//
	private EtcServiceImpl() {
		
	}
	
	private static EtcService etcService;
	
	public static EtcService sharedInstance() {
		if(etcService == null) {
			etcService = new EtcServiceImpl();
		}
		return etcService;
	}
//**************************************************************************//

//*****메일 보내기******//
	@Override
	public boolean mailSend(HttpServletRequest request) {
		boolean result = false;
		//네트워크를 사용하면 항상 try-catch를 해줘야 한다.
		try {
			request.setCharacterEncoding("utf-8");
			//파라미터 읽기
			String receiver = request.getParameter("receiver");
			String title = request.getParameter("title");
			String msg = request.getParameter("msg");
			
			//일반 이메일은 SimpleEmail
			SimpleEmail email = new SimpleEmail();
			//메일 서버 설정
			email.setHostName("smtp.naver.com");
			email.setSmtpPort(587);
			//메일을 암호화해서 전송하기 위한 설정
			email.setSSLOnConnect(true);
			email.setStartTLSEnabled(true);
			//인코딩 설정
			email.setCharset("utf-8");
			//받는 사람과 제목 및 내용 설정
			email.setMsg(msg);
			email.setSubject(title);
			email.addTo(receiver);
			//보내는 사람 설정 - gmail은 아이디와 메일 주소가 달라도 되지만 naver는 같아야 보내진다.
			email.setAuthentication("ggangpae3", "qkranstjr");
			email.setFrom("ggangpae3@naver.com", "관리자", "utf-8");
			//메일 보내기
			email.send();
			result = true;
		}catch(Exception e) {
			System.out.println("메일 보내기 오류:"+e.getMessage());
			e.printStackTrace();
		}
		return result;
	}
//**************************************************************************//	

//*****ajax로 외부 도메인 가져오는 방법******//
	@Override
	public String proxy(HttpServletRequest request) {
		String result = null;
		try {
			//다운로드 받을 주소를 문자열로 생성
			String addr="http://www.kma.go.kr/weather/forecast/mid-term-xml.jsp?stnId=109";
			//URL로 변환
			//한글이나특수문자가 있으면 인코딩을 해야 합니다.
			//java.net.URLEncoder.encode(url,인코딩방식)
			URL url = new URL(addr);
			//URLConnection 객체 만들기
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			//옵션 설정
			//이 시간동안 다운로드 받지 못하면 연결 해제
			con.setConnectTimeout(30000);
			//항상 새로운 데이터를 가져오도록 설정
			con.setUseCaches(false);
			//문자열을 다운로드 받을 수 있는 스트림 생성
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			//문자열을 복사하지 않고 추가할 수 있는 클래스의 인스턴스 생성
			//면접 보러갈 때 꼭 알고 가야하는 부분
			StringBuilder sb = new StringBuilder();
			while(true) {
				String line = br.readLine();
				if(line == null) {
					break;
				}
				sb.append(line);
			}
			//StringBuilder는 여분의 공간을 가지기 때문에 수정하지 않을 거라면 메모리 낭비입니다.
			result = sb.toString();
			br.close();
			con.disconnect();
					
		}catch(Exception e) {
			System.out.println(""+e.getMessage());
			e.printStackTrace();
		}
		
		return result;
	}
//**************************************************************************//

//*****푸시를 위한 메소드******//
	@Override
	public void push(HttpServletRequest request, HttpServletResponse response) {
		//출력을 위한 스트림 생성
		PrintWriter pw = null;
		try {
			//출력형식을 text/event-stream 으로 설정
			response.setContentType("text/event-stream");
			//출력 인코딩 설정
			response.setCharacterEncoding("utf-8");
			//출력 내용을 만들고 출력하기
			pw = response.getWriter();
			Random r = new Random();
			//data는 key이므로 공백을 넣으면 안된다. :은 키에 포함되지 않고 :앞까지가 key이다.
			pw.write("data:"+(r.nextInt(45)+1)+"\n\n");
			//5초 대기
			Thread.sleep(5000);
		}catch(Exception e) {
			System.out.println(""+e.getMessage());
			e.printStackTrace();
		}finally {
			if(pw!=null) {
				pw.close();
			}
		}
	}
//**************************************************************************//
}
