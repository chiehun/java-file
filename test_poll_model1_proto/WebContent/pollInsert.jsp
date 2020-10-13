<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Poll</title>
<link href="style.css" rel="stylesheet" type="text/css">
</head>

<body bgcolor="#FFFFCC">
	<div align="center">
		<br />
		<h2>투표프로그램</h2>
		<hr width="600" />
		
		<b>설문작성</b>
		<hr width="600" />
		<form action="pollInsertProc.jsp">
			<table border="1" width="500">
				<tr>
					<td><b>질문</b></td>
					<td colspan="2"><input name="question" size="30" /></td>
				</tr>
				<tr>
					<td rowspan="10"><b>항목</b></td>
					<%
						//설문항목들을 출력하기 위한 for() 위치
						for(int i=1; i<=4; i++){
							out.println("<td>"+(i*2-1)+":<input type='text' name='item' value=''/></td>");
						    out.println("<td>"+(i*2)+":<input type='text' name='item' value='' /></td>");
						    out.println("</tr>");						
							if(i == 9){
								out.println("");
							}else{
								out.println("<tr>");
							}
						}
					%>
				<tr>
					<td>시작일</td>
					<td colspan="2">
						<select name="sdateY">
							<option value="2020">2020
							<option value="2021">2021
						</select>년 
						<select name="sdateM">
								<%
									// 설문 시작 1~12월 까지 <option></option>을 작성하기 위한 for()
										for(int i=1; i<= 12; i++){
											out.println("<option value='"+i+"'>"+i+"</option>");
										}
								%>
						</select>월 
						<select name="sdateD">
								<%
									// 설문 시작 1~31일 까지 <option></option>을 작성하기 위한 for()
									// 28 / 30은 일단 무시...
									for(int i=1; i<= 31; i++){
											out.println("<option value='"+i+"'>"+i+"</option>");
										}
								%>
						</select>일
					</td>
				</tr>
				<tr>
					<td>종료일</td>
					<td colspan=2>
						<select name="edateY">
							<option value="2020">2020
							<option value="2021">2021
						</select>년 
						<select name="edateM">
							<%
								// 설문 종료 1~12월 까지 <option></option>을 작성하기 위한 for()
										for(int i=1; i<= 12; i++){
											out.println("<option value='"+i+"'>"+i+"</option>");
										}
							%>
						</select>월 
						<select name="edateD">
							<%
								// 설문 종료 1~31일 까지 <option></option>을 작성하기 위한 for()
								// 28 / 30은 일단 무시...
								for(int i=1; i<= 31; i++){
											out.println("<option value='"+i+"'>"+i+"</option>");
										}

							%>
						</select>일
					</td>
				</tr>
				<tr>
					<td>복수투표</td>
					<td colspan=2>
						<input type="radio" name="type" value="1" checked>yes 
						<input type="radio" name="type" value="0">no
					</td>
				</tr>
				<tr>
					<td colspan=3>
						<input type="submit" value="작성하기"> 
						<input type="reset" value="다시쓰기"> 
						<input type="button" value="리스트" onClick="javascript:location.href='pollList.jsp'">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>