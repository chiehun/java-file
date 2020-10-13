<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>텍스트 파일 읽기</title>
</head>
<body>

<%
BufferedReader reader= null;
try{
	String filepath = application.getRealPath("/WEB-INF/if.txt");
	reader= new BufferedReader(new FileReader(filepath));
	String str=null;
	while((str=reader.readLine())!=null){
		out.println(str+ "<br/>");
	}
}catch(FileNotFoundException fefe){
	out.println("파일이 존재하지 않습니다");
}catch(IOException ioe){
	out.println("파일을 읽을 수 없습니다");
}finally{
	try{
		reader.close();
	}catch(IOException ioe){
		out.println("객체를 닫을 수 없습니다");
	}
}

%>
</body>
</html>