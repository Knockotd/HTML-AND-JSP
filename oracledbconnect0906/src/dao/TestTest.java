package dao;

import org.junit.jupiter.api.Test;

import vo.Members;

public class TestTest {

//	public static void main(String[] args) {
	@Test
	public void sampleTest() {
		UserDao userDao = UserDaoImpl.sharedInstance();
System.out.println(userDao.emailCheck("abcdabc@naver.com"));
	}

}
