package com.freeflux.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.freeflux.dto.BoardModel;

/** 실제 Oracle DB에 접속 : 각 Servlet 에서 사용 **/
public class BoardDAO {

	public Connection conn = null;
	public PreparedStatement pstmt = null;
	public Statement stmt = null;
	public ResultSet rs = null;
	public int r = 0;

	private final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String ORACLE_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";

	/** 기본 생성자 : 각 Servlet 에서 가장 먼저 객체 생성 시 **/
	public BoardDAO() {
	}

	/** 접속 메서드 : 각 Servlet 에서 가장 먼저 호출 **/
	public void connect() {
		try {
			Class.forName(ORACLE_DRIVER);
			System.out.println("==> 드라이버 로딩 성공!");

			this.conn = DriverManager.getConnection(ORACLE_URL, "boardtest", "board");
			System.out.println("==> DB접속성공!");

		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER LOAD ERR => " + e.getMessage());

		} catch (SQLException e) {
			System.out.println("CONNECT ERR => " + e.getMessage());
		}
	}

	/**
	 * 게시판 목록 조회  : BoardListServlet의 doGet() 에서 호츨 
	 * 
	 * @param boardModel
	 * @return
	 */
	public List<BoardModel> selectList() {
		String sql_query = "select no, subject, writer, hit from board_tbl";
		List<BoardModel> list=null;
		
		try {
			this.stmt=this.conn.createStatement();
			this.rs=this.stmt.executeQuery(sql_query);
			
			list=new ArrayList<BoardModel>();
			BoardModel model=null;
			
			while(rs.next()) {
				model=new BoardModel();
				model.setNo(rs.getInt("no"));
				model.setSubject(rs.getString("subject"));
				model.setWriter(rs.getString("writer"));
				model.setHit(rs.getInt("hit"));
				list.add(model);
				model=null;
			}
		} catch (SQLException e) {
			System.out.println("selectList() ERR => " + e.getMessage());
		}
		return list;
	}	// selectList() END

	/**
	 * 게시글 상세 조회 : BoardViewServlet의 doGet() 에서 호츨 
	 * 
	 * @param boardModel
	 * @return
	 */
	public BoardModel selectOne(BoardModel boardModel) {
		String sql_query = "select * from board_tbl  where no=?";
		BoardModel model=null;
		try {
			this.pstmt=this.conn.prepareStatement(sql_query);
			this.pstmt.setInt(1, boardModel.getNo());
			this.rs=this.pstmt.executeQuery();
			if(rs.next()) {
				model=new BoardModel();
				model.setNo(rs.getInt("no"));
				model.setSubject(rs.getString("subject"));
				model.setWriter(rs.getString("writer"));
				model.setContents(rs.getString("contents"));
				model.setHit(rs.getInt("hit"));
			}
		} catch (SQLException e) {
			System.out.println("selectOne() ERR => " + e.getMessage());
		}
		
		return model;
	} // selectOne() END

	/**
	 * 게시글 등록 처리 : BoardWriteServlet의 doPost() 에서 호츨 
	 * 
	 * @param boardModel
	 */
	public void insert(BoardModel boardModel) {
		String sql_query = "insert into board_tbl (no, subject, writer, contents)";
		sql_query += " values (board_seq.nextval, ?, ?, ?)";
		
		try {
			this.pstmt=this.conn.prepareStatement(sql_query);
			this.pstmt.setString(1, boardModel.getSubject());
			this.pstmt.setString(2, boardModel.getWriter());
			this.pstmt.setString(3, boardModel.getContents());
			this.r=this.pstmt.executeUpdate();
			if(this.r >0) {
				System.out.println("=> INSERT  SUCCESS !!");
			}
		} catch (SQLException e) {
			System.out.println("insert() ERR => " + e.getMessage());
		}
	}	// insert() END

	/**
	 * 게시글 수정 처리 : BoardModifyServlet의 doPost() 에서 호츨 
	 * 
	 * @param boardModel
	 */
	public void update(BoardModel boardModel) {
		String sql_query = "update board_tbl set subject=?, writer=?, contents=?";
		sql_query += " where no=?";
		try {
			this.pstmt=this.conn.prepareStatement(sql_query);
			this.pstmt.setString(1, boardModel.getSubject());
			this.pstmt.setString(2, boardModel.getWriter());
			this.pstmt.setString(3, boardModel.getContents());
			this.pstmt.setInt(4, boardModel.getNo());
			this.r=this.pstmt.executeUpdate();
			if(this.r >0) {
				System.out.println("=> UPDATE  SUCCESS !!");
			}
		} catch (SQLException e) {
			System.out.println("update() ERR => " + e.getMessage());
		}
	
	}

	/**
	 * 게시글 조회수 증가 처리 및 조회수 수정 :
	 * BoardViewServlet의 doGet() 에서 데이터 조회전에 호츨
	 * 
	 * @param boardModel
	 */
	public void updateHit(BoardModel boardModel) {
		String sql_query = "update board_tbl set hit=hit+1 where no=?";
		try {
			this.pstmt=this.conn.prepareStatement(sql_query);
			this.pstmt.setInt(1, boardModel.getNo());
			this.r=this.pstmt.executeUpdate();
			if(this.r >0) {
				System.out.println("=> UPDATE HIT  SUCCESS !!");
			}
		} catch (SQLException e) {
			System.out.println("updateHit() ERR => " + e.getMessage());
		}
		
	}

	/**
	 * 게시글 삭제 처리 : BoardDeleteServlet의 doGet() 에서 호츨 
	 * 
	 * @param boardModel
	 */
	public void delete(BoardModel boardModel) {
		String sql_query = "delete from board_tbl where no=?";
		try {
			this.pstmt=this.conn.prepareStatement(sql_query);
			this.pstmt.setInt(1, boardModel.getNo());
			this.r=this.pstmt.executeUpdate();
			if(this.r >0) {
				System.out.println("=> DELETE  SUCCESS !!");
			}
		} catch (SQLException e) {
			System.out.println("delete() ERR => " + e.getMessage());
		}
		
	}

	/**
	 * 사용이 끝난 자원 해제 : 각 Servlet 에서 가장 나중에 호출 
	 * 
	 * @param boardModel
	 */
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
	
	
	/**
	 * 게시판 총 레코드 수 조회
	 *  : BoardListServlet의 doGet() 에서 전체 데이터 조회전에 호츨 
	 * 
	 * @param boardModel
	 * @return
	 */
	public int selectCount(BoardModel boardModel) {
		return 0;
	}

}
