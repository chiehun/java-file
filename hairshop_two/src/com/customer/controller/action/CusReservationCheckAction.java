package com.customer.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.action.Action;
import com.dao.HairDAO;
import com.dto.HairVO;

public class CusReservationCheckAction  implements Action {

	public CusReservationCheckAction(){
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "reservation_lookup.jsp";
		String id = request.getParameter("id");
		String rsv_date = request.getParameter("rsv_date");
		String rsv_time = request.getParameter("rsv_time");
		String p_type= request.getParameter("p_type");
		System.out.println(id+" : " +rsv_date+" : "+rsv_time+" : " +p_type+" : ");
		
		
		HairDAO Hdao = HairDAO.getInstance();
		
		Hdao.reservation_lookup(id);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
