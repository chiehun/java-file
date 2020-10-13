<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% String contents = request.getParameter("contents"); %>
<!DOCTYPE >
<html>
<head>
<meta  charset=UTF-8>
<title>temlate.jsp</title>
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
		<jsp:include page="<%= contents %>"/>	
		</td>
		
		<td whidth= "350" valign= "top">
		<jsp:include page="<%= contents %>"/>
			
		</td>
		</tr>
		
		
	</table>
</body>
</html>