package test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//dbData();
		
//		final String driver = "org.mariadb.jdbc.Driver";
//		final String DB_IP = "localhost";
//		final String DB_PORT = "3306";
//		final String DB_NAME = "testdb";
//		final String DB_URL = 
//				"jdbc:mariadb://" + DB_IP + ":" + DB_PORT + "/" + DB_NAME;
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			Class.forName(driver);
//			conn = DriverManager.getConnection(DB_URL, "root", "mariadb");
//			if (conn != null) {
//				System.out.println("DB 접속 성공");
//			}
//
//		} catch (ClassNotFoundException e) {
//			System.out.println("드라이버 로드 실패");
//			e.printStackTrace();
//		} catch (SQLException e) {
//			System.out.println("DB 접속 실패");
//			e.printStackTrace();
//		}
//
//		try {
//			String sql = "select * from testtable";
//
//			pstmt = conn.prepareStatement(sql);
//
//			rs = pstmt.executeQuery();
//			String userId = null;
//			String password = null;
//			String name = null;
//			while (rs.next()) {
//				userId = rs.getString(1);
//				password = rs.getString(2);
//				name = rs.getString(3);
//			}
//
//			System.out.println(userId);
//			System.out.println(password);
//			System.out.println(name);
//
//		} catch (SQLException e) {
//			System.out.println("error: " + e);
//		} finally {
//			try {
//				if (rs != null) {
//					rs.close();
//				}
//				if (pstmt != null) {
//					pstmt.close();
//				}
//
//				if (conn != null && !conn.isClosed()) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
	}
	
//	public static void test() {		
//		final String driver = "org.mariadb.jdbc.Driver";
//		final String DB_IP = "localhost";
//		final String DB_PORT = "3306";
//		final String DB_NAME = "testdb";
//		final String DB_URL = 
//				"jdbc:mariadb://" + DB_IP + ":" + DB_PORT + "/" + DB_NAME;
//
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//
//		try {
//			Class.forName(driver);
//			conn = DriverManager.getConnection(DB_URL, "root", "mariadb");
//			if (conn != null) {
//				System.out.println("DB 접속 성공");
//			}
//
//		} catch (ClassNotFoundException e) {
//			System.out.println("드라이버 로드 실패");
//			e.printStackTrace();
//		} catch (SQLException e) {
//			System.out.println("DB 접속 실패");
//			e.printStackTrace();
//		}
//		
//		try {
//			String sql = "select * from testtable";
//
//			pstmt = conn.prepareStatement(sql);
//
//			rs = pstmt.executeQuery();
//			String userId = null;
//			String password = null;
//			String name = null;
//			while (rs.next()) {
//				userId = rs.getString(1);
//				password = rs.getString(2);
//				name = rs.getString(3);
//			}
//
//			System.out.println(userId);
//			System.out.println(password);
//			System.out.println(name);
//			
//		} catch (SQLException e) {
//			System.out.println("error: " + e);
//		} finally {
//			try {
//				if (rs != null) {
//					rs.close();
//				}
//				if (pstmt != null) {
//					pstmt.close();
//				}
//
//				if (conn != null && !conn.isClosed()) {
//					conn.close();
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}		
//	}

	public int sum(int a, int b) {
		
		int hab = a + b;
		
		return hab;
	}	
	
	public String dbData() {
		String data = null;

		final String driver = "org.mariadb.jdbc.Driver";
		final String DB_IP = "localhost";
		final String DB_PORT = "3306";
		final String DB_NAME = "testdb";
		final String DB_URL = 
				"jdbc:mariadb://" + DB_IP + ":" + DB_PORT + "/" + DB_NAME;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {			
			Class.forName(driver);			
			conn = DriverManager.getConnection(DB_URL, "root", "mariadb");			
			if (conn != null) {
				System.out.println("DB 접속 성공");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
			e.printStackTrace();
		}
		
		try {
			String sql = "select * from testtable";

			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			String userId = null;
			String password = null;
			String name = null;
			while (rs.next()) {
				userId = rs.getString(1);
				password = rs.getString(2);
				name = rs.getString(3);
			}

			System.out.println(userId);
			System.out.println(password);
			System.out.println(name);
			
			data = userId;
			
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		
		return data;
	}
	
	public String insert(String yymmddP, String nameP, String ageP) {
		String data = null;
		
		final String driver = "org.mariadb.jdbc.Driver";
		final String DB_IP = "localhost";
		final String DB_PORT = "3306";
		final String DB_NAME = "testdb";
		final String DB_URL = 
				"jdbc:mariadb://" + DB_IP + ":" + DB_PORT + "/" + DB_NAME;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {			
			Class.forName(driver);			
			conn = DriverManager.getConnection(DB_URL, "root", "mariadb");			
			if (conn != null) {
				System.out.println("DB 접속 성공");
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로드 실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 접속 실패");
			e.printStackTrace();
		}
		
		try {
			String sql = "insert into testtable values ('";
			sql += yymmddP + "','" + nameP + "','" + ageP + "')";
			
			System.out.println(sql);			
			pstmt = conn.prepareStatement(sql);

			rs = pstmt.executeQuery();
			String userId = null;
			String name = null;			
			String phone = null;
			while (rs.next()) {
				userId = rs.getString(1);
				name = rs.getString(2);				
				phone = rs.getString(3);
			}
			
			data = "Y";			
		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}

				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		
		return data;
	}
}
