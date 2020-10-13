package com.hun.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hun.dao.BoardDAO;
import com.hun.dto.BoardVO;

public class BoardViewAction implements Action{

	public BoardViewAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "/board/boardView.jsp";
		String num = request.getParameter("num");
		
		BoardDAO bDAO = BoardDAO.getInstance();
		System.out.println(bDAO.toString());
		bDAO.updateReadCount(num); // 조회수 증가시켜주는 
		BoardVO bVO = bDAO.selectOneBoardByNum(num); // 증가시켜준 것을 가지고 다시 select
		
		request.setAttribute("board", bVO);
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
