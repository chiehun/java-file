package com.hun.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBMananger {
	private static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private static String uid = "choehun";
	private static String pwd = "1234";
	private static String driver= "oracle.jdbc.driver.OracleDriver";
	
	public DBMananger() {
		
	}
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			System.out.println("driver 성공");
			conn = DriverManager.getConnection(url, uid, pwd);
			System.out.println("연결 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"connenct err");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"connenct err");
		}
		return conn;
	}
//select 을 수행한 후 리소스 해제를 위한 메소드
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"close err");
		}
	
	}
	public static void close(Connection conn, Statement stmt) {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"close err");
		}
		
	}
}
