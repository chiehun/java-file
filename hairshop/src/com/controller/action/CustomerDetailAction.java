package com.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.hairDAO;
import com.dto.hairVO;

public class CustomerDetailAction implements Action {

	public CustomerDetailAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url="admin/customer_detail.jsp";
		
		hairDAO hDAO = hairDAO.getInstance();
		System.out.println(url+"___________");
		String id = request.getParameter("id").trim();
		
		ArrayList<hairVO> detail = hDAO.costomer_detailview(id);
	
		System.out.println("detailVIEW 부분 확인 "+" : " +detail.get(0).toString());
		//3. =>JSP 문제
		request.setAttribute("detail", detail);
		RequestDispatcher dispacher = request.getRequestDispatcher(url);
		dispacher.forward(request, response);
	}

}
