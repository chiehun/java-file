package com.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.hairDAO;
import com.dto.hairVO;

public class CusResDeleteAction implements Action {

	public CusResDeleteAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url ="admin/main.jsp";
		String id = request.getParameter("id");		
		System.out.println(url+"___________");
		hairDAO hdao=hairDAO.getInstance();
		hdao.costomer_appointdelete(id);
		
		ArrayList<hairVO> resList = hdao.costomer_appointmentlist();
		System.out.println(resList.get(0).toString());
		
		request.setAttribute("resList", resList);
		RequestDispatcher dispacher = request.getRequestDispatcher(url);
		dispacher.forward(request, response);
	}

}
