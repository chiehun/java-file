package com.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.hairDAO;
import com.dto.hairVO;

public class CusResUpdateAction implements Action {

	public CusResUpdateAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="admin/main.jsp";
		String msg="";
		String id = request.getParameter("id");		
		System.out.println(url+"___________");
		hairDAO hdao=hairDAO.getInstance();
		hdao.costomer_appointment(id);
		
		
		ArrayList<hairVO> resList = hdao.costomer_appointmentlist();
		System.out.println(resList.get(0).toString());
		
		request.setAttribute("resList", resList);
		RequestDispatcher dispacher = request.getRequestDispatcher(url);
		dispacher.forward(request, response);
		//1이상 일떼
		
	}

}
