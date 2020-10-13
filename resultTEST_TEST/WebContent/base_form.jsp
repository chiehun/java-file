<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*,javax.sql.DataSource,javax.naming.*"%>

<!DOCtype html>
<html>
<head>
<meta charset="UTF-8">
<title> JDBC : ResultSet  </title>
</head>


<body>

	<table border=1>
		<tr>
			<th>INSERT / UPDATE FORM</th>
			<th>MEMBER_LIST</th>
		</tr>
		<tr>
			<td>
				<!-- 멤버 추가 -->
				<form method="POST" action="insert_update.jsp" >
					<table border=1>
						<tr>
							<td>이름</td>
							<td><input type="text" name="name" required /></td>
						</tr>
						<tr>
							<td>주 소</td>
							<td><input type="text" name="address" required /></td>
						</tr>
						<tr>
							<td>E-mail : 중복불가</td>
							<td><input type="email" name="email" required /></td>
						</tr>
						<tr>
							<td colspan=2 align=center>
							 <input type=submit name="cmd" value="삽입">
							 <input type=submit name="cmd" value="수정">
                             <font size=1>수정시 Email 정확히 입력</font>
							</td>
						</tr>
					</table>

				</form>

			</td>
			<td>

				<form method=post action=delete.jsp>
					<table >
						<tr>

							<td  align=center width=100>이 름</td>
							<td  align=center width=100>주 소</td>
							<td  align=center width=100>Email</td>
							<td  align=center width=50>check</td>
						</tr>


						<%
							//DB접속 정보
							String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";	
							String user = "poll";
							String passwd = "1234";
							Connection con;
							Statement stat;
							Class.forName("oracle.jdbc.driver.OracleDriver");
							con = DriverManager.getConnection(url, user, passwd);

							stat = con.createStatement();
							ResultSet rs = stat.executeQuery("select * from member_jdbc");
						%>

						<tr>

							<%
								while (rs.next()) {
							%>

							<td align=center><%=rs.getString(1)%></td>
							<td align=center><%=rs.getString(2)%></td>
							<td align=center><%=rs.getString(3)%></td>
							<td align=center>
							<input type="checkbox" name="check" value="<%=rs.getString(3)%>" />
							</td>
						</tr>

						<%
							}
						%>

						<tr>
							<td colspan=4 align=right>
								<input type=submit value=삭제>
							</td>
						</tr>

					</table>
				</form>
				<p>
				<p>
			</td>
		</tr>
	</table>

</body>
</html>