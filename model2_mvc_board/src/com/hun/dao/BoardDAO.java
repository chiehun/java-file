package com.hun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hun.dto.BoardVO;
import com.hun.util.DBMananger;

public class BoardDAO {
	private static BoardDAO instance = new BoardDAO();

	/*
	 * private static String url = "jdbc:oracle:thin:@loaclhost:1521:XE"; private
	 * static String uid = "choehun"; private static String pwd = "1234";
	 */
	private BoardDAO() {
		// TODO Auto-generated constructor stub
	}

	public static BoardDAO getInstance() { // getInstance = DAO 객체 생성
		return instance;

	}

	public List<BoardVO> selectAllBoards() { // selectAllBoards() = 전체 리스트를 Select 해주는 메서드
		String sql = "select * from board order by num desc";
		List<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBMananger.getConnection();
			System.out.println("--------------");

			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				BoardVO bVO = new BoardVO();
				bVO.setNum(rs.getInt("num"));
				bVO.setName(rs.getString("name"));
				bVO.setEmail(rs.getString("email"));
				bVO.setPass(rs.getString("pass"));
				bVO.setTitle(rs.getString("title"));
				bVO.setContent(rs.getString("content"));
				bVO.setReadcount(rs.getInt("readcount"));
				bVO.setWritedate(rs.getTimestamp("writedate"));
				list.add(bVO);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + "select err");
		}finally {
			DBMananger.close(conn, stmt, rs);
		}

		return list;

	}

	// test all
	public void insertBoard(BoardVO bVO) {// ㅑinsertBoard 등록 해주는 메서드
		String sql = " insert into board(num, name, email, pass, title, content) "
				+ "values(board_seq.nextval, ?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBMananger.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bVO.getName());
			pstmt.setString(2, bVO.getEmail());
			pstmt.setString(3, bVO.getPass());
			pstmt.setString(4, bVO.getTitle());
			pstmt.setString(5, bVO.getContent());
			

			int r = pstmt.executeUpdate();
			if (r > 0) {
				System.out.println("INSERT 성공");
			} else {
				System.out.println("INSERT 실패");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			DBMananger.close(conn, pstmt);
		}
	}

	public void updateReadCount(String num) {// update 만들어주는 메서드
		String sql = "update board set readcount=readcount+1 where num=?";
		
		Connection conn= null;
		PreparedStatement pstmt=null;
		conn= DBMananger.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			int r = pstmt.executeUpdate();
			if (r > 0) {
				System.out.println("업데이트 성공");
			} else {
				System.out.println("업데이트 실패");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			DBMananger.close(conn, pstmt);
		}
	}

	// 게시판 글 상세 내용 보기 : 글번호로 찾아 온다 : 실패 null,
	public BoardVO selectOneBoardByNum(String num) {// 검색해 주는 메서드
		String sql ="select * from board where num = ?";
		
		BoardVO bVO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try {
			conn = DBMananger.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bVO = new BoardVO();
				bVO.setNum(rs.getInt("num"));
				bVO.setName(rs.getString("name"));
				bVO.setPass(rs.getString("pass"));
				bVO.setEmail(rs.getString("email"));
				bVO.setTitle(rs.getString("title"));
				bVO.setContent(rs.getString("content"));
				bVO.setReadcount(rs.getInt("readcount"));
				bVO.setWritedate(rs.getTimestamp("writedate"));	}
			
			int r = pstmt.executeUpdate();
			if (r > 0) {
				System.out.println("SELECT ONE 성공");
			} else {
				System.out.println("SELECT ONE 실패");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"");
		}finally {
			DBMananger.close(conn, pstmt, rs);
		}
		return bVO;
	}

	public BoardVO checkPassWord(String pass, String num) {
		return null;
	}

	public void deleteBoard(String num) {
		String sql = "delete board where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
		conn = DBMananger.getConnection();		
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			int r=pstmt.executeUpdate();
			if (r > 0) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"delete err");
		}
	}

	public void updateBoard(BoardVO bVO) {
		// TODO Auto-generated method stub
		String sql ="update board set name=?, email=?, pass=?, title=?, content=?, where num=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;		
		
		try {
			conn = DBMananger.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, bVO.getName());
			pstmt.setString(2, bVO.getEmail());
			pstmt.setString(3, bVO.getPass());
			pstmt.setString(4, bVO.getTitle());
			pstmt.setString(5, bVO.getContent());

			pstmt.executeUpdate();

			int r = pstmt.executeUpdate();
			if (r > 0) {
				System.out.println("update 성공");
			} else {
				System.out.println("update 실패");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"update err");
		} finally {
			DBMananger.close(conn, pstmt);
		}
	}
}
