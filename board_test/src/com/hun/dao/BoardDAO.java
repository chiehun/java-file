package com.hun.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hun.dto.BoardModel;

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

	/** 접속 메서드 **/
	public void connect() {
		try {
			Class.forName(ORACLE_DRIVER);
			this.conn = DriverManager.getConnection(ORACLE_URL, "boardtest", "board");
			System.out.println("연결 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + "driver err");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + "connect err");
		}
		/** 게시판 목록 조회 : BoardListServlet의 doGet() 에서 호출 **/
		// @param boardModel
	}

	public List<BoardModel> selectList() {
		String sql_query = "select no, subject, writer, hit from board_tbl";
		List<BoardModel> array = null;
		
		try {						
			this.stmt = this.conn.createStatement();
			
			this.rs = this.stmt.executeQuery(sql_query);
			
			array = new ArrayList<BoardModel>();
			BoardModel bm=null;
			while(rs.next()) {
				bm = new BoardModel();
				bm.setNo(rs.getInt("no"));
				bm.setSubject(rs.getString("subject"));
				bm.setWriter(rs.getString("writer"));
				bm.setHit(rs.getInt("hit"));
				array.add(bm);
				bm=null;
			}			
			System.out.println(array);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"select err");
		}
		return array;			
	}

	public BoardModel selectOne(BoardModel boardModel) {
		String sql_query = "select * from board_tbl where no=?";
		return null;
	}// selectOne() end

	/**
	 * 게시글 등록 처리 : BoardWriteServlet의 dopost()에서 호출
	 * 
	 * @param boardModel
	 */
	public void insert(BoardModel boardModel) {
		String sql_query = "insert into board_tbl(no, subject, writer, contents )"
				+ " values (board_seq.nextval, ?, ?, ?)";
		try {
			
			this.pstmt=conn.prepareStatement(sql_query);
			this.pstmt.setInt(1, boardModel.getNo());
			this.pstmt.setString(2, boardModel.getSubject());
			this.pstmt.setString(2, boardModel.getContents());
			this.pstmt.setString(2, boardModel.getWriter());
			this.r =this.pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"prepare err");
		}
	}// insert() end

	/**
	 * 게시글 수정 처리 : BoardModifyServlet의 dopost()에서 호출
	 * 
	 * @param boardModel
	 **/
	public void update(BoardModel boardModel) {
		String sql_query = "update board_tbl set subject=?, writer=?, contents=? where no=?";
	}
	
	/**
	 * 게시글 조회수 증가 처리 및 조회수 수정 :
	 * BoardViewSerlvet 의 doㅎㄷㅅ
	 */
	public void updateHit(BoardModel boardModel) {
		String sql_query = "update board_tbl set hit=hit+1 where no=?";
	}//updateHit end
	
	/**게시글 삭제 처리 :BoardDeletServlet의 doget() 에서 호출
	 * 
	 * @param boardModel
	 */

	public void delete(BoardModel boardModel) {
		String sql_query = "delete from board_tbl where no=?";
	}
	/** 사용이 끝난 자원 해제 : 각 Servelt 에서 가장 나중에 호출
	 * 
	 * @param boardModel
	 */
	public void close() {
		 try {
			 if(this.rs != null) {
				 this.rs.close();
			 }
			 if (this.pstmt != null) {
				 this.pstmt.close();
			 }
			 if (this.stmt != null) {
				 this.stmt.close();
			 }
			 if( this.conn != null) {
				 this.conn.close();
			 }
			System.out.println("종료 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() +"close() err");
		}
		
	}
}
