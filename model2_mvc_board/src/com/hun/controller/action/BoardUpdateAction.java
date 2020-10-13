package com.hun.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hun.dao.BoardDAO;
import com.hun.dto.BoardVO;

public class BoardUpdateAction implements Action{

	public BoardUpdateAction() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoardVO bVO = new BoardVO();
		
		bVO.setNum(Integer.parseInt(request.getParameter("num")));
		bVO.setName(request.getParameter("name"));
		bVO.setPass(request.getParameter("pass"));
		bVO.setEmail(request.getParameter("email"));
		bVO.setTitle(request.getParameter("title"));
		bVO.setContent(request.getParameter("content"));
		
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.updateBoard(bVO);
		
		new BoardListAction().execute(request, response);
	}

}
