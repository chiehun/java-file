package com.hun;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ResultServlet
 */
@WebServlet("/result")
public class ResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String food = (String) session.getAttribute("food");
		String Animal = request.getParameter("Animal");
		session.invalidate(); // 세션 제거
		response.setContentType("text/html; charset=UTF-8");
		//-----Jsp---가 실행하는 부분
		PrintWriter out = response.getWriter();
		out.println("<head><title>성격테스트</title></head>");
		out.println("<body>");
		out.println("<h3>성격 테스트</h3>");
		out.printf("당신은 %s와 %s를 좋아하는 성격입니다.", food, Animal );
		out.println("</body>");
		out.println("</HTML>");
		
	}

}
