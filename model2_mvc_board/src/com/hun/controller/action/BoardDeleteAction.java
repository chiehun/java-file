package com.hun.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hun.dao.BoardDAO;

public class BoardDeleteAction implements Action{

	public BoardDeleteAction() {
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String num =request.getParameter("num");		
		BoardDAO bDAO = BoardDAO.getInstance();
		bDAO.deleteBoard(num);		
		new BoardListAction().execute(request, response);
	}

}
