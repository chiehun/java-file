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
 * Servlet implementation class BoardViewServlet
 */
@WebServlet("/boardView")
public class BoardViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// boardList.jsp => "get" => parameter no 값을 저장할 객체
		// 전달되는 parameter 명 : no
		BoardModel boardModel=new BoardModel();
		int n=Integer.parseInt(request.getParameter("no"));
		boardModel.setNo(n);
		
		BoardDAO dao=new BoardDAO();
		dao.connect();
		dao.updateHit(boardModel);										// 조회수 증가
		BoardModel boardOne=dao.selectOne(boardModel);		// 해당 데이터만 조회
		dao.close();
		
		request.setAttribute("MODEL", boardOne);
		RequestDispatcher rd=request.getRequestDispatcher("boardView.jsp");
		rd.forward(request, response);
	}

}





