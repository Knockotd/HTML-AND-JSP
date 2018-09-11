package dao;

import java.util.List;

import vo.Files;

public interface FilesDao {
	//Files 테이블에서 가장 큰 code를 찾아오는 메소드
	public int getMaxCode();
	//Files 테이블에 데이터를 삽입하는 메소드
	public boolean insertFlieData(Files files);
	//Files 테이블의 전체 데이터를 가져오는 메소드
	public List<Files> listFiles();
}
