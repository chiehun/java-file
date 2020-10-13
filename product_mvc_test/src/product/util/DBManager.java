package product.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {
	final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String ORACLE_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	String id = "choehun";
	String pw = "1234";

	public DBManager() {
		// TODO Auto-generated constructor stub
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(ORACLE_DRIVER);
			conn = DriverManager.getConnection(ORACLE_URL, id, pw);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("drvier err" + e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + "connection err");
		}
		return conn;

	}

	public void close(Connection conn, Statement stmt, ResultSet rs) {

		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"close err");
		}

	}
	public void close(Connection conn, Statement stmt) {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"close err");
		}
		
		
	}
}
