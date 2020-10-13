package com.customer.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.action.Action;
import com.dao.HairDAO;
import com.dto.HairVO;

public class CusJoinAction  implements Action {

	public CusJoinAction(){
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "HairshopServlet?command=cus_login_form";

		HttpSession session = request.getSession();

		HairVO memberVO = new HairVO();
		System.out.println(memberVO);
		memberVO.setId(request.getParameter("id"));
		System.out.println(memberVO.getId());
		memberVO.setPw(request.getParameter("pw"));
		memberVO.setName(request.getParameter("name"));
		memberVO.setPhoneNumber(request.getParameter("phone"));
		memberVO.setAddress(request.getParameter("address"));		
		System.out.println(memberVO);
		
		session.setAttribute("id", request.getParameter("id"));
		
		HairDAO memberDAO = HairDAO.getInstance();
		memberDAO.insertMember(memberVO);		
		System.out.println(memberVO);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
