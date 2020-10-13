<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<%
	request.setCharacterEncoding("UTF-8");
	String uploadPath = request.getRealPath("upload"); // webcount/upload

	int size = 10 * 1024 * 1024;
	String name = "";
	String subject = "";
	String filename1 = "";
	String filename2 = "";
	try {
		MultipartRequest multi = new MultipartRequest(request, uploadPath, size, "UTF-8",
				new DefaultFileRenamePolicy());

		name = multi.getParameter("name");
		subject = multi.getParameter("subject");

		Enumeration files = multi.getFileNames();

		String file1 = (String) files.nextElement();
		filename1 = multi.getFilesystemName(file1);

		String file2 = (String) files.nextElement();
		filename2 = multi.getFilesystemName(file2);
		
	} catch (IOException e) {
		out.println(e.getMessage()+"multipartRequest err");
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>파일 업로드 : fileUploadProc.jsp</title>
</head>
<body>
	<form name="filecheck" action="fileCheck.jsp" method="post">
		<input type="hidden" name="name" value="<%=name%>"> <input
			type="hidden" name="subject" value="<%=subject%>"> <input
			type="hidden" name="filename1" value="<%=filename1%>"> <input
			type="hidden" name="filename2" value="<%=filename2%>">
	</form>
	<%--
<form> 태그와 name 속성을 이용하여 javaSrcipt 함수를 이용하여 서버로 전송 하는 방법
 --%>
 
	<a href="#" onclick="javasript:filecheck.submit()">
	 업로드 확인 및 다운로드 페이지 이동 </a>
</body>
</html>
