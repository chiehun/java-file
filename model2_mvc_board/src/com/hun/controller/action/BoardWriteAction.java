package com.hun.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hun.dao.BoardDAO;
import com.hun.dto.BoardVO;

public class BoardWriteAction implements Action{

	public BoardWriteAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BoardVO bVO = new BoardVO();
		
		bVO.setName(request.getParameter("name"));
		bVO.setPass(request.getParameter("pass"));
		bVO.setEmail(request.getParameter("email"));
		bVO.setTitle(request.getParameter("title"));
		bVO.setContent(request.getParameter("content"));
		
		BoardDAO bDao = BoardDAO.getInstance();
		bDao.insertBoard(bVO);
		
		new BoardListAction().execute(request, response);
		
		
		/**String url ="/board/boardList.jsp";
		System.out.println(url+"___________");
		
		BoardDAO bDao = BoardDAO.getInstance();
		List<BoardVO> boardlist = bDao.selectAllBoards();
		//1. System.out.println(boardlist.size());
		//2. System.out.println(boardlist.get(0).toString());
		//3. =>JSP 문제
		request.setAttribute("boardList", boardlist);
		RequestDispatcher dispacher = request.getRequestDispatcher(url);
		dispacher.forward(request, response); 
		 * 
		 * 원래를 이렇게 코딩해야하는데 진행 속도를 빠르게 하기 위해서 이렇게 적어 놓았다.
		 * **/
	}

}
