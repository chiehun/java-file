<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String str = request.getParameter("RESULT"); 
		if (str.equals("SUCCESS")){
			out.println("저장되었습니다.");
		}else{
			out.println("파일에 데이터를 쓸 수 없습니다.");
	}
	response.sendRedirect("BBSPostList.jsp");
%>
