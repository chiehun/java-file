<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE >
   <%
   request.setCharacterEncoding("UTF-8");
   %>
<jsp:useBean id="proDAO" class="com.hun.product.DBconnect"/>
<jsp:useBean id="proDTO" class="com.hun.product.ProductDTO"/>
<jsp:setProperty property="*" name="proDTO"/>
<%int code = Integer.parseInt(request.getParameter("code")); %>
<% 
boolean flagList = proDAO.productDelete(code);
	out.println("proDAO.productInsert(proDTO); END");
	
	String msg = "상품 삭제 실패 했습니다";
	String url = "productList.jsp";
	
	if (flagList) {
		msg = "상품 삭제 성공하였습니다";
		url = "productList.jsp";
	}
%>
<script>
   alert("<%=msg%>");
   location.href="<%=url%>";
</script>