package com.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HairDAO;
import com.dto.HairVO;

public class CustomerDetailAction implements Action {
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "admin/customer_detail.jsp";
		String id = request.getParameter("id");

		HairDAO hDao = HairDAO.getInstance();
		HairVO hVo = new HairVO();
		
		hVo = hDao.customer_DetailInfo(id); // 고객 기본정보
		request.setAttribute("detail", hVo);

		ArrayList<HairVO> hVoList = hDao.customer_Procedure(id);	// 고객 시술내역
		request.setAttribute("procedureList", hVoList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
