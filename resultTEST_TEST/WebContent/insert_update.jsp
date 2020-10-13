<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page errorPage="error.jsp"%>
   <%@ page import="java.sql.*"%>
  <% request.setCharacterEncoding("UTF-8"); %>
  <jsp:useBean id="data" class="com.hun.MememberBeen"/>
  <jsp:setProperty name="data" property="*"/>
  <%
  //DB접속 정보
	String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	String user = "poll";
	String passwd = "1234";
	Connection con;
	PreparedStatement pstmt;
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	con = DriverManager.getConnection(url, user, passwd);
	
	String cmd= request.getParameter("cmd");
	String sql="";
	if( cmd.equals("삽입")){
		
		sql ="insert into member_jdbc values(?,?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, data.getName());
		pstmt.setString(2, data.getAddress());
		pstmt.setString(3, data.getEmail());
		pstmt.executeUpdate();
	}
			
		response.sendRedirect("base_form.jsp");
%>
  
  
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
</head>
<body>

</body>
</html>