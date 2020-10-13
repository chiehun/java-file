package com.freeflux.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.freeflux.dao.BoardDAO;
import com.freeflux.dto.BoardModel;

/**
 * Servlet implementation class BoardModifyServlet
 */
@WebServlet("/boardModify")
public class BoardModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// boardModify.jsp => "post" => parameter 값들을 저장할 객체
		// 전달되는 parameter 명 : subject,  writer, contents
		BoardModel boardModel=new BoardModel();
		int n=Integer.parseInt(request.getParameter("no"));
		boardModel.setNo(n);
				
		BoardDAO dao=new BoardDAO();
		dao.connect();
		BoardModel boardOne=dao.selectOne(boardModel);
		dao.close();
		
		request.setAttribute("MODEL", boardOne);
		RequestDispatcher rd=request.getRequestDispatcher("boardModify.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// boardModify.jsp => "post" => parameter 값들을 저장할 객체
		// 전달되는 parameter 명 : no, subject,  writer, contents
		BoardModel boardModel=new BoardModel();
		
		int n=Integer.parseInt(request.getParameter("no"));
		boardModel.setNo(n);
		boardModel.setSubject(request.getParameter("subject"));
		boardModel.setWriter(request.getParameter("writer"));
		boardModel.setContents(request.getParameter("contents"));
		
		BoardDAO dao=new BoardDAO();
		dao.connect();
		dao.update(boardModel);
		dao.close();
		
		response.sendRedirect("boardList");
	}

}



