package com.controller.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HairDAO;
import com.dto.HairVO;


public class ReservationListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url="admin/main.jsp";
			
			HairDAO hDAO = HairDAO.getInstance();
			
			ArrayList<HairVO> resList = hDAO.costomer_appointmentlist();

			request.setAttribute("resList", resList);
			RequestDispatcher dispacher = request.getRequestDispatcher(url);
			dispacher.forward(request, response);
			
	}

}
