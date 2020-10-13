package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.controller.action.Action;

@WebServlet("/HairshopServlet")
public class HairshopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HairshopServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command =request.getParameter("command");
		System.out.println("HairshopServlet에서 받은 요청 : "+ command);
		
		ActionFactory af = ActionFactory.getInstance();
		Action action = af.getaction(command);//admin_
		
		if(action != null) {
			action.execute(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
