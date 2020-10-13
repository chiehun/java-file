package com.hun.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hun.dao.ProductDAO;
import com.hun.dto.ProductVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class ProductWriteServlet
 */
@WebServlet("/productWrite.do")
public class ProductWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		RequestDispatcher dispatcher = request.getRequestDispatcher("productWrite.jsp");
		dispatcher.forward(request, response);
		
		//RequestDispatcher.forward() : 웹 경로 변경하지 않음!
								//	: http://~~~~~/프로젝트명/product
		// response.sendRedirect() : 웹 경로를 변경...
		//							: http://~~~~~~/프로젝트명/productWrite.jsp
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		
		ServletContext context = getServletContext();
		// 웹 프로젝트가 실행되면 Tomcat 서버의 server.xml 문서의 <context/>태그에
		// 현재 실행되고 있는 웹 애플리케이션이 설정되므로...
		// 먼저 웹 애플리케이션의 경로 추출하고 
		String path = context.getRealPath("upload");
		String encType ="UTF-8";
		int sizeLimit = 20 * 1024 * 1024;
		//<form method ="post" enctype="multipart/form-data" name="frm"> dp
		//반드시 MultipartRequest 객첼르 통해서 파라미터 갑을 추출!! 해야한다.
		
		MultipartRequest multi = new MultipartRequest(request, path, sizeLimit, encType, new DefaultFileRenamePolicy());
		
		
		//MultipartRequest 객체가 생성될 때 파일은 자동 업로드....
		
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		String description = multi.getParameter("description");
		
		
		String pictureUrl = multi.getFilesystemName("pictureUrl");
		
		ProductVO pVO = new ProductVO();
		pVO.setName(name);
		pVO.setPrice(price);
		pVO.setDescription(description);
		pVO.setPictureUrl(pictureUrl);
		System.out.println(pictureUrl);
		//System.out.println(name);
		//System.out.println(pVO);
		System.out.println(description);
		ProductDAO pDAO = ProductDAO.getInstance();
		pDAO.insertProduct(pVO); //실제로 저장되는건 파일명이 저장된다..
		System.out.println(pVO);
		response.sendRedirect("productList.do");
	}

}
