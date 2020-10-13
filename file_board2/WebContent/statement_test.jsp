<%@page import="javax.websocket.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, java.util.*, com.hun.BBSClass"%>
<%
	ArrayList<BBSClass> list=null;

%>

	<%	//DAO , DTO
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/bbsdb";
			String id = "root";
			String pw = "1234";
			conn = DriverManager.getConnection(url, id, pw);
			if (conn == null) {
				throw new Exception("db 를 연결할 수 없습니다");
				
			}
			//--------------------------------
			
			stmt = conn.createStatement();
			String query = "select * from bbs";
			rs = stmt.executeQuery(query);			
			
			list = new ArrayList<BBSClass>();
			BBSClass bbs=null;
			while(rs.next()){
				bbs=new BBSClass(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
			list.add(bbs);
			}
		} 
		finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				out.print(e.getMessage());
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				out.print(e.getMessage());
			}
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				out.print(e.getMessage());
			}
		}
	
	request.setAttribute("List", list);
	RequestDispatcher rd = request.getRequestDispatcher("list_test.jsp");
	rd.forward(request, response);
		%>	
	
