package com.customer.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.action.Action;
import com.dao.HairDAO;
import com.dto.HairVO;

public class CusReservationInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="HairshopServlet?command=cus_res_check";
		
		HairVO hvo = new HairVO();
		hvo.setRsv_date(request.getParameter("rev_date"));
		hvo.setRsv_time(request.getParameter("rev_time"));
		hvo.setP_type(request.getParameter("p_type"));
		hvo.setId(request.getParameter("id"));
		System.out.println("세션 아이디값 : " + hvo.getId());
		HairDAO hdao = HairDAO.getInstance();
		hdao.insertRSV(hvo);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
