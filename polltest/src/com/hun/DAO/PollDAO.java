package com.hun.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PollDAO {
	public Connection conn = null;
	public PreparedStatement pstmt = null;
	public Statement stmt = null;
	public ResultSet rs = null;
	public int r = 0;

	private final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String ORACLE_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	public PollDAO() {
		// TODO Auto-generated constructor stub
	}
	public void connect() {
		try {
			Class.forName(ORACLE_DRIVER);
			DriverManager.getConnection(ORACLE_URL, "poll", "1234");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"DRIVER ERR");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"connect err");
		}		
	}
	/**
	 * 전체 목록 호출  : pollListServlet의 doGet() 에서 호츨 
	 * 
	 * @param boardModel
	 * @return
	 */
	public void select() {
		try {
			String query="select num, question ,sdate, edate from pollList";
			this.stmt=this.conn.createStatement();
			this.stmt.executeQuery(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"query1 err");
		}
	}
}
