<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE >
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<html>
<head>
<meta  charset=UTF-8>
<title>sql_update_result.jsp</title>
</head>
<body>
<sql:setDataSource url="jdbc:oracle:thin:@127.0.0.1:1521:XE"
		driver="oracle.jdbc.driver.OracleDriver" user="namecard"
		password="1234" var="dataSource" scope="application" />
	<fmt:setLocale value="ko_kr"/>
	
	<%-- UPDATE query --%>
	<sql:update var="result" dataSource= "${dataSource}">
	update employee_tbl set ENAME=? where EMPNO=?
	<sql:param value="test"/>
	<sql:param value="1"/>	
	</sql:update>
	
	
	
	<%--select query --%>
	<sql:query var="emp" dataSource="${dataSource}">
	SELECT EMPNO AS 사원번호, ENAME AS 이름, SAL AS 월급여, HIREDATE AS 입사일
	FROM employee_tbl
		
	</sql:query>
	
	<table border="1">
		<tr>
			<%-- 필드 정보를 출력 --%>
			<c:forEach var="columnName" items="${emp.columnNames}">
				<th><c:out value="${columnName}" /></th>
			</c:forEach>
		</tr>
		<%-- 데이터를 한 줄 씩 출력 --%>
		<c:forEach var="row" items="${emp.rowsByIndex}">
			<tr>

				<%-- 필드의 길이만큼 반복 --%>
				<c:forEach var="column" items="${row}" varStatus="i">
					<c:choose>
						<c:when test="${i.index==3}">
							<td><fmt:formatDate value="${column}" pattern="yyyy/MM/dd" /></td>
						</c:when>
						<c:otherwise>
							<td><c:out value="${column}" /></td>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>