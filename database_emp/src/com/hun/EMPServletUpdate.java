package com.hun;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EMPServletUpdate
 */
@WebServlet("/EMPServletUpdate")
public class EMPServletUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EMPServletUpdate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql_select_no = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "choehun", "1234");
			sql_select_no = "select * from emp where no =?";

			pstmt = con.prepareStatement(sql_select_no);
			pstmt.setInt(1, Integer.parseInt(request.getParameter("n")));
			
			rs = pstmt.executeQuery();

			request.setAttribute("result", rs);

			RequestDispatcher rd = request.getRequestDispatcher("empUpdate.jsp");
			rd.forward(request, response);

		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() + "drive 연결 실패");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + "sql err!!");
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
				System.out.println(e.getMessage() + "close 실패");
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException { // 데이터를 삽입했을때

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		String sql_insert = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "choehun", "1234");
			sql_insert = "update emp set age=?, name=?, phone=?";
			sql_insert += " , gender=?, job=?, pay=?, code=?  where no =?";

			pstmt = con.prepareStatement(sql_insert);
			pstmt.setInt(1, Integer.parseInt(request.getParameter("age")));
			pstmt.setString(2, request.getParameter("name"));
			pstmt.setString(3, request.getParameter("phone"));
			pstmt.setString(4, request.getParameter("gender"));
			pstmt.setString(5, request.getParameter("job"));
			pstmt.setInt(6, Integer.parseInt(request.getParameter("pay")));
			pstmt.setString(7, request.getParameter("code"));
			pstmt.setInt(8, Integer.parseInt(request.getParameter("no")));
			int b = pstmt.executeUpdate();
			System.out.println(b + "<== Update Record");
			
			if (b > 0) {
				response.sendRedirect("EMPServlet");
			} // response.sendRedirect("EMPServlet") ==empservlet 파일로 바로 이동 b>0 보다 크다는 뜻는 업데이트가 잘 되었기 때문
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + "드라아버 err");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + "SQL ERR!");
		} finally {

			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if(rs != null) {
					rs.close();
				}
				if(con !=null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage()+"query문 오류");
			}
		}
	}

}
