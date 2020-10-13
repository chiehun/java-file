<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//DB접속 정보
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	String user = "poll";
	String passwd = "1234";
	Connection con;
	PreparedStatement pstmt;
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con = DriverManager.getConnection(url, user, passwd);
	

	String[] del_data = request.getParameterValues("check");
	String sql = "delete from member_jdbc where email=?";

	for (int i = 0; i < del_data.length; i++) {
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, del_data[i]);
		pstmt.executeUpdate();
	}
	response.sendRedirect("base_form.jsp");
%>
</body>
</html>