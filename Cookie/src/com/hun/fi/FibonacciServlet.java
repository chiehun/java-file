package com.hun.fi;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FibonacciServlet
 */
@WebServlet("/fibonacci")
public class FibonacciServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BigInteger arr[];
	/**
	 * @see Servlet#init(ServletConfig)
	 */ 
	public void init(ServletConfig config) throws ServletException {  //connection
		arr = new BigInteger[100];
		arr[0]= new BigInteger("1");  //long 보다 더 큰 데이터 변수 -> 내부적으로 문자열 형식으로 변환된다.
		arr[1]= new BigInteger("1");
		for (int cnt = 2; cnt < arr.length; cnt++) {
			arr[cnt] = arr[cnt-2].add(arr[cnt - 1]);
		}
				}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {  //close해제 코드
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("NUM");
		
		int num = Integer.parseInt(str);
		if(num > 100) {
			num = 100;
		}
		
		response.setContentType("text/html; charset= UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>피보나치 수열</title></head>");
		out.println("<body>");
		for(int cnt = 0; cnt < num; cnt++) {
			out.println(arr[cnt] + "<br/>");
		}
		out.print("</body>");
		out.print("</html>");
	}

}
