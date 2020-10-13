<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import= "java.io.*, java.util.Date, java.text.SimpleDateFormat" %>
<!DOCTYPE html >
<html>
<head>
<meta  charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2>BoardContent.jsp</h2>
	
	<% request.setCharacterEncoding("UTF-8");
	String filename =request.getParameter("f");
	/** 파일 이름을 이용한 날짜 시간 출력하기**/
	String[] split =filename.split(".txt");
	Long times= Long.parseLong(split[0]);
	Date currentTime = new Date(times);
	
	SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	out.print("<br/>");
	SimpleDateFormat TIME_FORMAT = new SimpleDateFormat(" HH:mm:ss ");
	
	out.print(DATE_FORMAT.format(currentTime));
	out.print(TIME_FORMAT.format(currentTime)+"<br/>");
	out.print("---------------------<br/>");
	
	BufferedReader reader=null;
	try{
		String filepath = "c:/bbs/"+ filename;
		reader= new BufferedReader(new FileReader(filepath));
		String str=null;	
		while((str=reader.readLine())!=null){
			out.print(str+"<br/>");
		}		
	}catch(FileNotFoundException fee){
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
	<button onclick="location.href='BoardList.jsp">글목록</button>
</body>

</html>