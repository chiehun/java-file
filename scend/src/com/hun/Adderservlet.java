package com.hun;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Adderservlet
 * 
 * HttpServlet implements Servlet : HttpServlet이 Servlet를 구현 받았기 때문에
 */
@WebServlet("/adder") //webServelt adder : servlet.클래스에 대한 웹주소 웹명칭을 선언해주는 어노테이션
public class Adderservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;  //톰캣 서버가 servlet 만들어주는 상수이기때문에 절대 수정 불가능
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adderservlet() {
        super(); //부모 생성자에 의해서 초기화 된다.
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub        http://localhost:9000/scend/adder
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//request.getContextPath() = scend = 요청 사항
		//response.getWriter() = printwritter객체를 얻어낸다
		// 확인하는 코드
		/**
		int total =0;
		for(int cnt=1; cnt <= 100; cnt++) {
			total += cnt;
		}
		request.setAttribute("result", total);
		RequestDispatcher rd = request.getRequestDispatcher("Hendred.jsp");
		rd.forward(request, response); //  반드시 request, reponse를 반드시 넘겨줘야 한다.**/
		String str1 = request.getParameter("NUM1");
		String str2 = request.getParameter("NUM2");
		
		int num1 = Integer.parseInt(str1);
		int num2 = Integer.parseInt(str2);
		
		int sum = num1+num2;
		
		request.setAttribute("result", sum);
		RequestDispatcher rd= request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
		
		
		
	//	response.setContentType("text/html; charset=UTF-8");
		// post 방식에서는 필수
	PrintWriter out = response.getWriter();
	//	out.println("<html>");
	//	out.println("<body>");
		out.printf("%d + %d = %d", num1, num2, sum);
	//	out.println("</html>");
	//	out.println("</body>");
		//브라우저 상 표현 해주려면 
	}

}
