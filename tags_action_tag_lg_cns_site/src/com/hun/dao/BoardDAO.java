package com.hun.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.hun.dto.BoardDTO;

public class BoardDAO {
	public Connection conn = null;
	public PreparedStatement pstmt = null;
	public Statement stmt = null;
	public ResultSet rs = null;
	public int r = 0;

	private final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String ORACLE_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	

	public BoardDAO() {
		// TODO Auto-generated constructor stub
	}

	public void connect() {
		try {
			Class.forName(ORACLE_DRIVER);
			System.out.println("==> 드라이버 로딩 성공!");

			this.conn = DriverManager.getConnection(ORACLE_URL, "lgcnc", "1234");
			System.out.println("==> DB접속성공!");

		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER LOAD ERR => " + e.getMessage());

		} catch (SQLException e) {
			System.out.println("CONNECT ERR => " + e.getMessage());
		}
	}
/** 게시판 목록 조회 : BoardListServlet의 goGet()에서 호출**/
	
	public List<BoardDTO> selectList(BoardDTO boardModel) {
		/**검색기능을 위한 변수**/
		String searchType = boardModel.getSearchType();
		String searchText = boardModel.getSearchText();
		String whereSQL ="";
		
		System.out.println(">>>>>>>>>>search<<<"+searchText);
		
		//
		
		//검색어 쿼리문 생성
		if(!searchText.equals("")) {
			if(searchType.equals("ALL")) {
				whereSQL +=" WHERE subject Like ? OR writer like ? or contents? and ";
System.out.println("ALL"+whereSQL);
			}else if(searchType.equals("SUBJECT")){
				whereSQL += " subject Like and ? ";
			}else if (searchType.equals("WRITER and")) {
				whereSQL += " writer Like ? and";
			}else if (searchType.equals("CONTENTS")) {
				whereSQL += " contents Like ? and";
			}
		}// 검색어 쿼리문 생성 종료 -+ subject Like and ?
		String bagic_query = "select no, subject, writer, hit, moddate from board_search_tbl where ";
		//String last_query =" rownum >= ? and rownum <=? order by no desc ";
		String last_query = " no between ? and ? order by no desc";
		String sql_query = bagic_query +whereSQL + last_query;
//select no, subject, writer, hit, moddate from board_search_tbl where contents Like ? and between >=?,<=? order by no desc 
		System.out.println("ALL"+"<<<<<" +sql_query);	
	 
		int pNO =Integer.parseInt(boardModel.getPageNum());
	 
		int startNO =(pNO-1)*boardModel.getListCount()+1;
	 
		int endNO = startNO+9;
		System.out.println(">>>>>>pageNum>>>>"+pNO);
		System.out.println(">>>>startNO +endNO"+startNO +">>>"+ endNO);
		List<BoardDTO> list = null;

		try {
			this.pstmt = this.conn.prepareStatement(sql_query);
			if(!"".equals(whereSQL)) {
				if("ALL".equals(searchType)) { // 전체 검색인 경우
					this.pstmt.setString(1,"%"+ searchText+"%");
					this.pstmt.setString(2,"%"+ searchText+"%");
					this.pstmt.setString(3,"%"+ searchText+"%");
					this.pstmt.setInt(4, startNO);
					this.pstmt.setInt(5, endNO);
				}else {
					this.pstmt.setString(1,"%"+ searchText+"%");
					this.pstmt.setInt(1, startNO);		//limit 추가
					this.pstmt.setInt(2, endNO);
				}
			}else {									//limit 추가
					this.pstmt.setInt(1, startNO);		//limit 추가
					this.pstmt.setInt(2, endNO);		//limit 추가
				}
			
	
			this.rs= this.pstmt.executeQuery();
						
			list = new ArrayList<BoardDTO>();
			BoardDTO model = null;
			
			while (rs.next()) {
				//String date = String.format(rs.getDate("moddate"));
				model = new BoardDTO();
				model.setNo(rs.getInt("no"));
				model.setSubject(rs.getString("subject"));
				model.setWriter(rs.getString("writer"));
				model.setHit(rs.getInt("hit"));
				model.setModdate(rs.getString("moddate"));
System.out.println("===>model : members <==" + model.toString());
				list.add(model);
				model = null;
			}
			
System.out.println("==>List : size <=="+ list.size());
				
		} catch (SQLException e) {
			System.out.println("selectList() ERR => " + e.getMessage());
		}
		return list;
	} // selectList() END
	

	public int selectCount(BoardDTO boardModel) {
		//page 객체
		int totalCount = 0;
		String searchType = boardModel.getSearchType();
		String searchText = boardModel.getSearchText();		
		String whereSQL = "";
		

		//검색어 쿼리문 생성
		if(!searchText.equals("")) {
			if(searchType.equals("ALL")) {
				whereSQL += " WHERE subject like ? or writer like ? or contents like ?";
				
			} else if(searchType.equals("SUBJECT")) {
				whereSQL += " WHERE subject like ?";
				
			} else if(searchType.equals("WRITER")) {
				whereSQL += " WHERE WRITER like ?";
			} else if(searchType.equals("CONTENTS")) {
				whereSQL += " WHERE CONTENTS like ?";
			}
		}
		String sql_query1 = "select count(no) as total from board_search_tbl"+whereSQL;
		System.out.println("<<<<sql_query "+sql_query1);
		try {
			// 게시물의 총 수를 얻는 쿼리 실행
			this.pstmt = this.conn.prepareStatement(sql_query1);
			if(!"".equals(whereSQL)) {
				if("ALL".equals(searchType)) { // 전체 검색인 경우
					this.pstmt.setString(1,"%"+ searchText +"%");
					this.pstmt.setString(2,"%"+ searchText +"%");
					this.pstmt.setString(3,"%"+ searchText +"%");
				}else {
					this.pstmt.setString(1,"%"+ searchText +"%");
				}
			}
			
			this.rs=this.pstmt.executeQuery(); 
			// 자바에서 테이블을 생성하고 싶을때 execute !!!
			
			if (this.rs.next()) {
				totalCount = this.rs.getInt("total");
				System.out.println("=============> totalcount"+totalCount);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return totalCount;

	} //selectCOUNT 
	public void close() {
		try {
			if (this.rs != null) {
				this.rs.close();
			}
			if (this.stmt != null) {
				this.stmt.close();
			}
			if (this.pstmt != null) {
				this.pstmt.close();
			}
			if (this.conn != null) {
				this.conn.close();
			}
		} catch (SQLException e) {
			System.out.println("CLOSED ERR => " + e.getMessage());
		}
	}
	
}
