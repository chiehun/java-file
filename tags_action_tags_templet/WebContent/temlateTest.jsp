<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String contentPage = request.getParameter("CONTENTPAGE");
	
	//templateTest.jsp?CONTENTPAGE=content.jsp
	//String contentPage = "contest.jSP"
%>
<!DOCTYPE >
<html>
<head>
<meta charset=UTF-8>
<title>temlateTest.jsp</title>
</head>
<body>
	<table width="600" border="1" cellpadding="0" cellspacing="0"
		align="center">

		<tr height="80">
		<td colspan= "2"><!-- 상단영역 -->
		   <jsp:include page= "top.jsp" flush= "false"/>
		</td>
		</tr>
		
		<tr height="300">
		<td width= "150" valign= "top"> <!-- 좌측영역 --> 
		<jsp:include page= "left.jsp" flush= "false" />		
		</td>
		
		<td whidth= "350" valign= "top">
		<jsp:include page="<%= contentPage %>"/>
			
		</td>
		</tr>
		
		
		<tr height="80">		
		<td colspan= "2"><!-- 상단영역 -->
		   <jsp:include page= "bottom.jsp" flush= "false"/>
		</td>
		</tr>

	</table>

</body>
</html>