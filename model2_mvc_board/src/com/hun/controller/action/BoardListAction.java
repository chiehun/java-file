package com.hun.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hun.dao.BoardDAO;
import com.hun.dto.BoardVO;

public class BoardListAction implements Action{

	public BoardListAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url ="/board/boardList.jsp";
		System.out.println(url+"___________");
		
		BoardDAO bDao = BoardDAO.getInstance();
		List<BoardVO> boardlist = bDao.selectAllBoards();
		//1. System.out.println(boardlist.size());
		//2. System.out.println(boardlist.get(0).toString());
		//3. =>JSP 문제
		request.setAttribute("boardList", boardlist);
		RequestDispatcher dispacher = request.getRequestDispatcher(url);
		dispacher.forward(request, response);
		
	}

}
