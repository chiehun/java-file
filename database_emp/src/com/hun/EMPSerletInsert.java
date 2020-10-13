package com.hun;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EMPSerletInsert
 */
@WebServlet("/EMPServletInsert")  //EMPServletInsert
public class EMPSerletInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EMPSerletInsert() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		// 객체선언
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String query = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Statement stmt = null;
		try {
			
			query = "insert into emp (no, age, name, phone, gender, job, pay, code)";
			query += "values ( ?, ?,  ?, ?, ?, ?, ?, ? )";
			Class.forName(driver);
			con = DriverManager.getConnection(url, "choehun", "1234");
			String sql_max_no = "select max(no) from emp";
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql_max_no);
			rs.next();
			int max_no= rs.getInt(1);
			pstmt = con.prepareStatement(query);			
			pstmt.setInt(1, max_no+1);
			pstmt.setInt(2, Integer.parseInt(request.getParameter("age")));
			pstmt.setString(3, request.getParameter("name"));
			pstmt.setString(4, request.getParameter("phone"));
			pstmt.setString(5, request.getParameter("gender"));
			pstmt.setString(6, request.getParameter("job"));
			pstmt.setInt(7, Integer.parseInt(request.getParameter("pay")));
			pstmt.setString(8, request.getParameter("code"));

			int b = pstmt.executeUpdate();
			System.out.println(b + "insert 성공");
			if (b > 0) {
				response.sendRedirect("EMPServlet");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + "driver 연결 오류");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("connection err" + e.getMessage());
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
				if (con != null) {
					con.close();
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage()+"SQLE ERR");
			}
		}
	}

}
