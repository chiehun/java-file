<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>

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
							
							Statement stmt;
							Class.forName("oracle.jdbc.driver.OracleDriver");
							con = DriverManager.getConnection(url, user, passwd);
							
							// Statement 타입의 stmt 생성시 커서가 양방향스크롤이 가능하고
							//Update가 가능한 ResultSet을 생성
							
					
							stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
							/** ResultSet rs = stmt.excuteQuery("select * from member";
							- 쿼리문ㅇ 사용시 '*' 키워드는 가독성, 성능상의 이유로 간으한 사용을 지양'
							- ResultSet타입의 rs는 결과 set을 의미하며, rs를 위로 아래로 움직일 수 있으며, rs를 이용 삽입, 삭제, 수정 작업이 가능							
							**/							
							ResultSet rs = stmt.executeQuery("select name, address, email, from member_jdbc");
							
							rs.last(); //커서를 마지막에 위치시킴  frist는 맨 처음 레코드로 이동시켜주는 
							int row = rs.getRow();
							out.print("Last "+ row);
							
							//rs.absolute(레코드 위치);
							rs.absolute(3);// 커서를 세번째 레코드위에 위치시켜 두번째 컬럼의 데이터를 수정
							//rs.updateString (필드 위치, 변경값);
							rs.updateString(2, "주소변경테스트"); // 변경 사항을 가지고 있는 데이터를 가지고 있는 것
							rs.updateRow(); //실질적으로 updateRow() 명령을 수행해야 수정됨 //
							
							rs.beforeFirst();
							//beforeFirst() 첫번째 레코드 이전위치, 즉 메타정보 위치로 커서를 이동 시켜 주는 메서드
						%>
						
						<tr>
						<td>이름</td>
						<td>주소</td>
						<td> Email</td>
						

						<tr>

							<%
							//next()를 이용 커서를 하나씩 이동하면서 모든 레코드 정보를 출력
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