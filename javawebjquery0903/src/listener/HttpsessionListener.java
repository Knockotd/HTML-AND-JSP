package listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class HttpsessionListener implements HttpSessionListener {
	static int cnt;
	//세션이 생성될 때 호출되는 메소드
	//세션의 생성 : 새로운 사용자가 접속
	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		cnt=cnt+1;
		System.out.println(cnt+"명 접속중");
	}

	//세션이 종료될 때 호출되는 메소드
	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		cnt=cnt-1;
		System.out.println(cnt+"명 접속중");
	}

}
