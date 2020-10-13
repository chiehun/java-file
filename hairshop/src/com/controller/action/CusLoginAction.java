package com.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.hairDAO;
import com.dto.hairVO;

public class CusLoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "login_fail.jsp";
		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println(id+":  "+pw);
		hairDAO hairdao = hairDAO.getInstance();

		hairVO Hvo = hairdao.getMember(id);
		System.out.println(Hvo);
		if (Hvo!=null) {
			if (Hvo.getPw().equals(pw)) {
				session.removeAttribute("id");
				session.setAttribute("loginUser", Hvo); //-> 로그아웃 화면이 뜸
				url = "hairServlet?command=cus_res_check";
				System.out.println(url);
			}
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
