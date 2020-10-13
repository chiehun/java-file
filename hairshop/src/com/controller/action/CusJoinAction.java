package com.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.hairDAO;
import com.dto.hairVO;


public class CusJoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "login.jsp";

		HttpSession session = request.getSession();

		hairVO memberVO = new hairVO();
		System.out.println(memberVO);
		memberVO.setId(request.getParameter("id"));
		System.out.println(memberVO.getId());
		memberVO.setPw(request.getParameter("pw"));
		memberVO.setName(request.getParameter("name"));
		memberVO.setphoneNumber(request.getParameter("phone"));
		memberVO.setAddress(request.getParameter("address"));		
		System.out.println(memberVO);
		
		session.setAttribute("id", request.getParameter("id"));
		
		hairDAO memberDAO = hairDAO.getInstance();
		memberDAO.insertMember(memberVO);		
		System.out.println(memberVO);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
