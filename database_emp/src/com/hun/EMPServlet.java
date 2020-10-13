package com.hun;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EMPServlet
 */
@WebServlet("/EMPServlet")
public class EMPServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EMPServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "choehun", "1234");
			stmt = con.createStatement();
			sql = "select * from emp";
			rs = stmt.executeQuery(sql);
			
			request.setAttribute("result", rs);
			RequestDispatcher rd = request.getRequestDispatcher("empList.jsp");
			rd.forward(request, response);
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage()+" 드라이버 err");
		} catch (SQLException e) {
			System.out.println(e.getMessage()+"sql err!");
		}finally {	
			try {
			if(rs!= null) {
				rs.close();
			}
			if(stmt!=null) {
				stmt.close();
			}
			if(con != null) {
				
			}
				con.close();
			} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
		System.out.println("성공");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


}
