package com.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.hairDAO;
import com.dto.hairVO;


public class CusReservationInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="Hairshop?command=cus_res_check";
		String rsv_date= request.getParameter("rsv_date");
		String rsv_time= request.getParameter("rsv_time");
		String p_type= request.getParameter("p_type");
		System.out.println(rsv_date+"  :  "+rsv_time+"  :  "+p_type);
		hairVO hvo = new hairVO();
		hvo.setRsv_date(request.getParameter("rsv_date"));
		hvo.setRsv_time(request.getParameter("rsv_time"));
		hvo.setP_type(request.getParameter("p_type"));
		
		hairDAO hdao = hairDAO.getInstance();
		hdao.insertRSV(hvo);
		
		
		
	
	}

}
