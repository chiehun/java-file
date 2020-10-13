package com.hun.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hun.dao.BoardDAO;
import com.hun.dto.BoardVO;

public class BoardCheckPassAction implements Action {

	public BoardCheckPassAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		String num = request.getParameter("num");
		String pass = request.getParameter("pass"); //사용자가 입력한 값
		System.out.println(pass);
		BoardDAO bDao = BoardDAO.getInstance();
		BoardVO bVO = bDao.selectOneBoardByNum(num); //bVO.getPass() 해당 번호의 암호 값
		
		if(bVO.getPass().equals(pass)) {////해당 번호의 암호 값 VS 사용자가 입력한 값
			url="/board/checkSuccess.jsp";
			System.out.println("성공했습니다");
		}else {//실패
			url="/board/boardCheckPass.jsp";
			request.setAttribute("message", "비밀번호가 틀렸습니다");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
