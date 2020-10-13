<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%  
	String contentPage = request.getParameter("CONTENT_PAGE");
	String leftPage = request.getParameter("LEFT_PAGE");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Template 페이지 연습</title> 
</head> 

<body>
	<table width="1200" border="1" cellpadding="0" cellspacing="0"  align="center">   
	   <tr height="80" >    
		   <td colspan= "2"  align="center"> <!-- 상단 영역 --> 
		   		<jsp:include page= "top.jsp" flush= "false" />    
		   </td>   
	   </tr>   
	   
	   <tr height="180">    <!-- 가운데 영역 -->
		   <td width= "150" valign= "top"  align="center"> <!-- 좌측 영역 --> 
		   		<jsp:include page= "<%= leftPage %>" flush= "false" />    
		   </td>    
		   
		   <td width= "1020" valign= "top"  align="center"> <!-- 본문 내용 --> 
		   		<jsp:include page= "<%= contentPage %>" flush= "false" />    
		   </td>   
	   </tr>   
	   
	   <tr height="80" >    
		   <td colspan= "2"  align="center"> <!-- 하단 영역 --> 
		   		<jsp:include page= "bottom.jsp" flush= "false" />    
		   </td>   
	   </tr> 
	</table>
</body>
</html>