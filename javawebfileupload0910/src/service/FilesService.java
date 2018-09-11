package service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import vo.Files;

public interface FilesService {
	//데이터 삽입을 처리하기 위한 메소
	public boolean insertFiles(HttpServletRequest request);
	//테이블의 전체 데이터를 가져오는 메소드
	public List<Files> listFiles(HttpServletRequest request);
}
