<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%
   request.setCharacterEncoding("UTF-8");
   %>
<jsp:useBean id="proDAO" class="com.hun.product.DBconnect"/>
<jsp:useBean id="proDTO" class="com.hun.product.ProductDTO"/>
<jsp:setProperty property="*" name="proDTO"/> 
<% 
boolean flagList = proDAO.productInsert(proDTO);
	out.println("proDAO.productInsert(proDTO); END");
	
	String msg = "상품등록이 실패 하였습니다.";
	String url = "productInsert.jsp";
	
	if (flagList) {
		msg = "상품 등록이 성공하였습니다";
		url = "productList.jsp";
	}
%>
<script>
   alert("<%=msg%>");
   location.href="<%=url%>";
</script>