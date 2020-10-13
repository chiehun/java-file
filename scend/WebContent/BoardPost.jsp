<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "java.io.*, java.util.Date, java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8">
<title>BoardPost.jsp</title>
</head>
<body>
<h2>글 파일 저장</h2>
<%
	request.setCharacterEncoding("UTF-8");
	String writer= request.getParameter("WRITER");
	String title= request.getParameter("TITLE");
	String content= request.getParameter("CONTENT");
	
	Date date=new Date();	//현재 날짜
	Long time=date.getTime(); // 현재 날짜를 숫자로 20200806
	
	SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	out.print("<br/>");
	SimpleDateFormat TIME_FORMAT = new SimpleDateFormat(" HH:mm:ss ");
	
	String filename= time+".txt";
	PrintWriter pwriter=null;
	try{
		
		String filepath ="c:/bbs/" + filename; //c://123456789.txt
		pwriter=new PrintWriter(filepath);
		pwriter.printf("제목 : %s %n ", title);
		pwriter.printf("작성자 : %s %n", writer);
		pwriter.println(content);
		out.println("저장 되었습니다");	//웹 브라우저에 출력할 내용
	}catch(IOException ioe){
		out.print("파일에 데이터를 쓸 수 없습니다.");
	}finally{
		try{
			pwriter.close();
		}catch(Exception e){
			out.print("객체를 닫을 수 없습니다.");
		}
	}
%>
<br/>
<button onclick="location.href='Boradlist.jsp'">글목록</button>
</body>
</html>