<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<sql:setDataSource url="jdbc:oracle:thin:@127.0.0.1:1521:XE"
		driver="oracle.jdbc.driver.OracleDriver" user="poll"
		password="1234" var="db" scope="application" />
	<%--
		<sql:setDataSource/> 역할
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connecttion db = DriverManager.getConnection("jdbc:oracle:thin:@127.0.01:1521:XE", "freefluls)
		 --%>


	<%--request.getParameter("mode")//"login" --%>
	<c:if test="${param.mode=='login'}">
		<sql:query var="login" dataSource="${db}">
	select id from tbljoin where id=? and pass=?
	<sql:param value='${param.id}' />
			<sql:param value='${param.pass}' />
		</sql:query>
		<%--
<sql:query var="login" dataSource="${db}">의 역할
select id from tblJoin where id=? and pass=?

PreparedStatement pstmt = db.prepareStatment(sql)

첫 번째 ? : 전달받은 파라미터를 이용하여 값 설정 pstmt.setString(1,값)
두 번째 ? : 전달받은 파라미터를 이용하여 값 설정 pstmt.setString(2,값)
ResultSet login= executeQuery();

 --%>
		<c:choose>
			<c:when test="${login.rowCount==0}">
				<c:set var="msg" value="로그인에 실패 하였습니다." scope="session" />
			</c:when>
			<%--
login.rowCount의 역할
ResultSetMetaData rsmd=login.getMetaData();
rsmd.getRowCount();
 --%>
			<c:when test="${login.rowCount==1}">
				<c:set var="text" value="${param.id}" scope="session" />
				<c:remove var="msg" scope="session" />
			</c:when>
		</c:choose>
	</c:if>
	<%--
param.id 의 역할

String id = request.getParameter("id")

 --%>
	<c:if test="${param.mode=='logout'}">
		<c:remove var="id" scope="session" />
	</c:if>
	<c:redirect url="login.jsp"></c:redirect>

	<%--
	<c:redirect url="login.jsp"/>의 역할
	response.sendRedirect("login.jsp");
	 --%>
</body>
</html>