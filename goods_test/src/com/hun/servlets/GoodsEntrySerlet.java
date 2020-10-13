package com.hun.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hun.dao.OracleDAO;
import com.hun.dto.GoodsDTO;

/**
 * Servlet implementation class GoodsEntrySerlet
 */
@WebServlet("/GoodsEntry")
public class GoodsEntrySerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GoodsEntrySerlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GoodsDTO dto = new GoodsDTO();
		
		int code = Integer.parseInt(request.getParameter("code"));
		dto.setCode(code);
		
		String product = request.getParameter("product");
		dto.setProduct(product);		
		
		String content = request.getParameter("content");
		dto.setContent(content);		
		
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		dto.setQuantity(quantity);		
		
		int discount = Integer.parseInt(request.getParameter("discount"));
		dto.setDiscount(discount);		
		
		int delivery_change = Integer.parseInt(request.getParameter("delivery_change"));
		dto.setDelivery_change(delivery_change);
		
		int price = Integer.parseInt(request.getParameter("price"));
		dto.setPrice(price);
		
		String name = request.getParameter("name");
		dto.setName(name);		
		
		System.out.println("==> dto.toString() "+dto.toString());
		
		OracleDAO dao = new OracleDAO();
		dao.connect();
		dao.insert(dto);
		dao.close();		
		
	response.sendRedirect("GoodsList");//get 방식
	}

	

}
