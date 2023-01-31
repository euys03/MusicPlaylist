package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTemplate {
	// 연결 싱글톤 적용
	private static Connection conn;
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USER = "MUSICWEB";
	private static final String PASSWORD = "musicweb";

	private JDBCTemplate() {}
	
	public static Connection getConnection() {
		
		try {
			if(conn == null || conn.isClosed()) {
				// 드라이브 등록
				Class.forName(DRIVER_NAME);
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
				conn.setAutoCommit(false);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;	// 싱글톤이 적용된 연결 생성 완료
			
	}
	
	
	// 커밋	
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				// true = isClosed(닫힘), false = !isClosed(열림)
				conn.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 롤백
	public static void rollback(Connection conn2) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
