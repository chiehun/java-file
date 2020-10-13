package com.customer.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.action.Action;
import com.dao.HairDAO;
import com.dto.HairVO;

public class CusReservationDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "main.jsp";
		String id = request.getParameter("id");
	
		System.out.println(id+" : "+"예약 삭제 id 값");
		
		HairDAO Hdao = HairDAO.getInstance();
		
		Hdao.reservation_delete(id);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
