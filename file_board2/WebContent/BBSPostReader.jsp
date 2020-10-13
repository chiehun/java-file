<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.*" %>
<!DOCTYPE html>
<html>
    <head>
    	<title> 파일 읽기</title>
    	<script type="text/javascript">
    		function postList(){
    			document.location="BBSPostList.jsp";
    		}
    	</script>	
    </head>
    <body>
    	<h2>파일형 게시판 글내용 - 글내용 화면</h2>
        <%
            String selPath=request.getParameter("sel");
        	BufferedReader reader = null;
            try {
                String filePath = application.getRealPath("/WEB-INF/bbs/"+selPath);
                reader = new BufferedReader(new FileReader(filePath));
                while (true) {
                    String str = reader.readLine();
                    if (str == null)
                        break;
                    out.println(str + "<br />");
                }
            }
            catch (FileNotFoundException fnfe) {
            	out.println(fnfe.getMessage());
            }
            catch (IOException ioe) {
            	out.println(ioe.getMessage());
            }
            finally {
                try {
                    reader.close();
                }          
                catch (Exception e) {
                }
            }
        %>
        <input type="button" value="처음으로" onclick="postList()">
    </body>
</html>
