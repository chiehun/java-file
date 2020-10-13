package com.hun.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hun.dao.BoardDAO;
import com.hun.dto.BoardModel;
import com.hun.util.PageNavigator;



/**
 * Servlet implementation class BoardListServlet
 */
@WebServlet("/BoardListServlet")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//파라미터
		String pageNum = request.getParameter("pageNum"); // 페이지 번호 // 페이지 번호를 눌렀을때 전달
		String searchType = request.getParameter("searchType"); // 검색 타입
		String searchText = request.getParameter("searchText"); // 검색어
		
		if(pageNum == null) {
			pageNum = "1";
		}
		if(searchText == null) {
			searchType = "";
			searchText = "";
		}
		
		//DTO
		BoardModel boardModel = new BoardModel();
		boardModel.setPageNum(pageNum);  // 1
		boardModel.setSearchType(searchType);  
		boardModel.setSearchText(searchText); //사용자가 입력한 검색어
		
		
		//DAO
		BoardDAO dao=new BoardDAO();
		dao.connect();
		// View 상요될 캑겣 설정
		 //게시물 총 수
		int totalCount = dao.selectCount(boardModel);
		System.out.println("ttotalCount >>>>>>"+totalCount);
		//BoardModel boardModel = null;
		
		// 게시물 목로은 언드 쿠리 실행
		List<BoardModel> boardList =dao.selectList(boardModel);
		//List<BoardModel> list= new ArrayList();
		// view 상요될 객체 생성
		request.setAttribute("totalcount", totalCount);
		
		//
		PageNavigator pageNavigator = new PageNavigator();
		String pageNums = pageNavigator.getPageNavigator(totalCount,
				boardModel.getListCount(), boardModel.getPagePerBlock(), Integer.parseInt(pageNum), searchType, searchText);
		
System.out.println(">>>>>>>pageNums>"+pageNums);
		
		request.setAttribute("PAGE_NAIGAITGER", pageNums);
		request.setAttribute("MODEL", boardModel);
		
		
System.out.println(">>>>>>list><"+boardList);
		request.setAttribute("LIST", boardList);
		boardList = dao.selectList(boardModel);
		dao.close();
		
		
		RequestDispatcher rd=request.getRequestDispatcher("boardlist.jsp");
		rd.forward(request, response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
