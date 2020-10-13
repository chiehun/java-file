<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta  charset=UTF-8>
<title>프로젝트 실행 시 자동으로 응답(web)하느 파일 : index.jsp</title>
</head>
<body>

<%
response.sendRedirect("http://localhost:9000/model2_mvc_board/BoardServlet?command=board_list");

//BoardServelt?파라미터=요청사항
// @webServlet(/"BoardServlet")
//protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
%>
</body>
</html>