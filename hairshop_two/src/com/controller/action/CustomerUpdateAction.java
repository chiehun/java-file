package com.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.HairDAO;
import com.dto.HairVO;
import com.sun.javafx.collections.MappingChange.Map;

public class CustomerUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url = "HairshopServlet?command=cus_detail";
			
			HairDAO hDao = HairDAO.getInstance();
			HairVO hVo = new HairVO();

			hVo.setId(request.getParameter("id")); 
			hVo.setName(request.getParameter("name"));
			hVo.setPhoneNumber(request.getParameter("phone"));
			hVo.setAddress(request.getParameter("address"));
			hDao.customer_detailUpdate(hVo); // 고객 정보 업데이트

			String[] dateArr = request.getParameterValues("p_enroll");
			String[] typeArr = request.getParameterValues("p_type");
			
			for(int i=0; i<dateArr.length; i++) {
				String date = dateArr[i];
				String type = typeArr[i];
				hDao.customer_ProcedureUpdate(date,type);
			}
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
	}

}
