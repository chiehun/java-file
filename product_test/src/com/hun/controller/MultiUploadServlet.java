package com.hun.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class MultiUploadServlet
 */
@WebServlet("/upload2.do")
public class MultiUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MultiUploadServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		// TODO Auto-generated method stub
		// doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter(); // 전송 결과를 웹브라우저에 직접 출력

		// 여기를 바꿔주면 다운 받는 경로가 바뀜(단, 실제 존재하는 폴더를 지정)
		String savaPath = "upload";

		// 최대 업로드 파일 크기 5MB로 제한
		int uploadFileSizeLimit = 5 * 1024 * 1024;

		String encType = "UTF-8";

		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savaPath);
		System.out.println("서버상의 실제 디렉토리");
		System.out.println(uploadFilePath);

		try {
			MultipartRequest multi = new MultipartRequest(request, // request 객체
					uploadFilePath, // 서버상의 실제 디렉토리
					uploadFileSizeLimit, // 최대 업로드 파일 크기
					encType, // 인코딩 방법
					// 동일한 이름이 존재하면 새로운 이름이 부여됨
					new DefaultFileRenamePolicy());
			// 업로드된 파일의 이름 얻기 : <input type="file"/>의 파리미터명
			//String fileName = multi.getFilesystemName("uploadFile");
			// 두개 이상의 파일을 업로드 할때는 열거 타입으로 만들어줘야 한다. 1개 파일이 생성되었기때문에
			Enumeration files = multi.getFileNames();
			
			while(files.hasMoreElements()) {
				String file =(String) files.nextElement();
				String file_name = multi.getFilesystemName(file);
				
				//중복된 파일을 업로드 할 경우 파일명이 바뀐다.(~~1, ~~2, ~~)
				//getOriginalFileName()은 변경되기 전 이름을 추출....
				String ori_file_name = multi.getOriginalFileName(file);
				
				out.print("<br> 업로드된 파일명 : " +file_name );
				out.print("<br> 원 본업로드된 파일명 : " +ori_file_name );
				out.print("<hr>");
			}

		} catch (Exception e) {
			System.out.println("예외 발생" + e.getMessage());

		}

	}
}
