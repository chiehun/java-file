package com.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.hairDAO;
import com.dto.hairVO;


public class ReservationListAction implements Action {

	public ReservationListAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			String url="admin/main.jsp";
			
			hairDAO hDAO = hairDAO.getInstance();
			System.out.println(url+"___________");
			
			
			ArrayList<hairVO> resList = hDAO.costomer_appointmentlist();
			//1. System.out.println(boardlist.size());
			//2.
			System.out.println(resList.get(0).toString());
			//3. =>JSP 문제
			request.setAttribute("resList", resList);
			RequestDispatcher dispacher = request.getRequestDispatcher(url);
			dispacher.forward(request, response);
			
	}

}
