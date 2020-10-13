package com.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.hairDAO;

public class LoginAction implements Action {

	public LoginAction() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = ""; // 회원관리
		String msg = "";
		String workerId = request.getParameter("workerid").trim();
		String workerPw = request.getParameter("workerpw").trim();

		hairDAO hDAO = hairDAO.getInstance();
		
		System.out.println("데이터 확인"+workerId+":"+workerPw);
		
		int result = hDAO.wokerCheck(workerId, workerPw);
		
		System.out.println("id,pw 확인 "+result);
		
		if (result == 1) {
			HttpSession session = request.getSession();
			session.setAttribute("workerId", workerId);
			url = "HairshopServlet?command=res_list";

		} else if (result == 0) {
			msg = "비밀번호 확인 필요";
		} else if (result == -1) {
			msg = "아이디 확인";
		}
		request.setAttribute("message", msg);
		request.getRequestDispatcher(url).forward(request, response);
	}
}
