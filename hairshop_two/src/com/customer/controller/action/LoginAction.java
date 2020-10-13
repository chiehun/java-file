package com.customer.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.controller.action.Action;
import com.dao.HairDAO;
import com.dto.HairVO;

public class LoginAction  implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "login_fail.jsp";
		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		HairDAO hairdao = HairDAO.getInstance();

		HairVO Hvo = hairdao.getMember(id);

		if (Hvo!=null) {
			if (Hvo.getPw().equals(pw)) {
				session.removeAttribute("id");
				session.setAttribute("loginUser", Hvo);
				url = "HairshopServlet?command=cus_index";
				System.out.println(url);
				
			}
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
