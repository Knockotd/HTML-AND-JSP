package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;

import javax.naming.InitialContext;

import javax.naming.NamingException;

import javax.sql.DataSource;

import vo.Files;

public class FilesDaoImpl implements FilesDao {

	// 싱글톤 메소드 패턴

	private FilesDaoImpl() {
	}

	private static FilesDao filesDao;

	public static FilesDao sharedInstance() {

		if (filesDao == null) {

			filesDao = new FilesDaoImpl();

		}

		return filesDao;

	}

	// 데이터베이스 작업을 위한 변수

	protected Connection con;

	protected PreparedStatement ps;

	protected ResultSet rs;

	// 데이터베이스 접속을 수행해주는 메소드

	// 다른 곳에서도 쓸 것 같으면 protected로 일단 만들기.

	protected void connect() {

		try {

			// context.xml 파일의 DBConn 이라는 리소스 이름을 이용해서 데이터베이스 접속 만들기

			Context init = new InitialContext();

			DataSource ds = (DataSource) init.lookup("java:comp/env/DBConn");

			con = ds.getConnection();

		} catch (Exception e) {

			System.out.println(e.getMessage());

			e.printStackTrace();

		}

	}

	// 데이터베이스 자원을 해제하는 메소드

	protected void close() {

		try {

			if (rs != null)
				rs.close();

			if (ps != null)
				ps.close();

			if (con != null)
				con.close();

		} catch (Exception e) {

			System.out.println(e.getMessage());

			e.printStackTrace();

		}

	}

	@Override

	public int getMaxCode() {

		int code = -1;

		try {

			connect();

			ps = con.prepareStatement("select max(code) from files");

			rs = ps.executeQuery();

			// 데이터 읽기

			if (rs.next()) {

				code = rs.getInt("max(code)");

			}

		} catch (Exception e) {

			System.out.println("가장 큰 code 가져오기 에러:" + e.getMessage());

			e.printStackTrace();

		} finally {

			close();

		}

		return code;

	}

	@Override

	public boolean insertFlieData(Files files) {

		boolean result = false;
		int code = getMaxCode() +1;

		try {

			connect();

			ps = con.prepareStatement(

					"insert into files("

							+ "code, filename, filesize, description)"

							+ " values(?, ?, ?, ?)");

			ps.setInt(1, code );

			ps.setString(2, files.getFilename());

			ps.setInt(3, files.getFilesize());

			ps.setString(4, files.getDescription());

			int r = ps.executeUpdate();

			if (r > 0) {

				result = true;

			}

		} catch (Exception e) {

			System.out.println("데이터 저장 에러:" + e.getMessage());

			e.printStackTrace();

		} finally {

			close();

		}

		return result;

	}

	@Override
	public List<Files> listFiles() {
		List<Files> list = new ArrayList<Files>();
		try {
			connect();
			//Files 테이블의 전체 데이터를 가져오는 sql
			ps = con.prepareStatement("select * from files order by code");
			rs = ps.executeQuery();
			while(rs.next()) {
				Files files = new Files();
				files.setCode(rs.getInt("code"));
				files.setFilename(rs.getString("filename"));
				files.setFilesize(rs.getInt("filesize"));
				files.setDescription(rs.getString("description"));
				list.add(files);
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}finally {
			close();
		}
		return list;
	}

}