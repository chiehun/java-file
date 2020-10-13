package com.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HairDAO;
import com.dto.HairVO;

public class CusResUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="admin/main.jsp";

		String id = request.getParameter("id");		
		HairDAO hdao=HairDAO.getInstance();
		hdao.costomer_appointment(id);
		
		ArrayList<HairVO> resList = hdao.costomer_appointmentlist();
		System.out.println(resList.get(0).toString());
		
		request.setAttribute("resList", resList);
		RequestDispatcher dispacher = request.getRequestDispatcher(url);
		dispacher.forward(request, response);
	}

}
