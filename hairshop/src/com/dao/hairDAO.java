package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.hairVO;

import com.util.DBManager;


public class hairDAO {

	private static hairDAO instance= new hairDAO();

	public hairDAO() {
		// TODO Auto-generated constructor stub
	}	
	public static hairDAO getInstance() {
		// TODO Auto-generated method stub
		return instance;
	}

	// 관리자 로그인 --완료
	public int wokerCheck(String userid, String userpw) {
		String sql = "select workerpw from worker where workerid=?";
		int result = -1;
		// 디비와 연동
		Connection conn = null;
		// 쿼리문(select)을 수행하기 위한 문장 객체
		PreparedStatement pstmt = null;
		// 결과값을 저장할 ResultSet
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if (rs.next()) { // 아이디가 일치하면
				result = 0;
				String dbpw = rs.getString(1);
				if (dbpw.equals(userpw)) {
					result = 1;
				}
			}
			DBManager.close(conn, pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + "로그인 체크 err");
		}
		return result;
	}// wokerCheck end

	// 등록,회원 가입
	public void costomer_insert() {//상우 완료
		
	}
	//검색 (이름, 전화번호 뒷자리(4))
	
	public void  costomer_searchone() {
		String sql = "select * from rPWjd lㅑ";
		int result = -1;
		// 디비와 연동
		Connection conn = null;
		// 쿼리문(select)을 수행하기 위한 문장 객체
		PreparedStatement pstmt = null;
		// 결과값을 저장할 ResultSet
		ResultSet rs = null;
	}
	//삭제
	public void costomer_delete(){//상우 완료
				
	}
	//예약  -- 완료
	public ArrayList<hairVO> costomer_appointmentlist() {
		String sql = "select d.rsv_date, d.rsv_time, d.id, d.rsv_status, r.name, r.phonenumber, d.rsv_date, d.p_type"
				+ " from rPWjd r, dPdir d where r.id = d.id"; 
				
		ArrayList<hairVO> list = new ArrayList<hairVO>();
		
		// 디비와 연동
		Connection conn = null;
		// 쿼리문(select)을 수행하기 위한 문장 객체
		PreparedStatement pstmt = null;
		// 결과값을 저장할 ResultSet
		ResultSet rs = null;
		
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		
			while(rs.next()) {
				hairVO hvo = new hairVO();
				hvo.setRsv_date(rs.getString("rsv_date"));
				hvo.setRsv_time(rs.getString("rsv_time"));
				hvo.setRsv_status(rs.getString("rsv_status"));
				hvo.setId(rs.getString("id"));
				hvo.setName(rs.getString("name"));
				hvo.setphoneNumber(rs.getString("phonenumber"));
				hvo.setRsv_date(rs.getString("rsv_date"));
				hvo.setP_type(rs.getString("p_type"));
				list.add(hvo);
			}
			System.out.println("예약 리스트 확인 "+list);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"예약 QUERY 오류");
		}
		return list;
		
	}
	//예약 확정 rsv_status +1 -- 완료 --- 1이상 넘어갈때 데이터가 사라지는 것 수정해야함
	public void costomer_appointment(String id) {
		String sql ="update dpdir set rsv_status=rsv_status+1 where id=?";
		// 디비와 연동
		Connection conn = null;
		// 쿼리문(select)을 수행하기 위한 문장 객체
		PreparedStatement pstmt = null;
		// 결과값을 저장할 ResultSet
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			int r = pstmt.executeUpdate();
			
			if (r > 0) {
				System.out.println("업데이트 성공");
			} else {
				System.out.println("업데이트 실패");
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"확정 오류");
		}		
	}
	//예약 삭제 버튼-- 완성
	public void costomer_appointdelete(String id) {
		String sql ="delete from dpdir where id=?";
		// 디비와 연동
		Connection conn = null;
		// 쿼리문(select)을 수행하기 위한 문장 객체
		PreparedStatement pstmt = null;
		// 결과값을 저장할 ResultSet
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			int r = pstmt.executeUpdate();
			if (r > 0) {
				System.out.println("삭제 성공");
			} else {
				System.out.println("삭제 실패");
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"확정 오류");
		}		
	}
	
	//상세 보기
	public ArrayList<hairVO> costomer_detailview(String id) {
		System.out.println("String id"+id);
		String sql = "select id, name, phoneNumber, address, enroll from rPWjd where id=?";
		
		ArrayList<hairVO> list = new ArrayList<hairVO>();
		// 디비와 연동
		Connection conn = null;
		// 쿼리문(select)을 수행하기 위한 문장 객체
		PreparedStatement pstmt = null;		
		
		// 결과값을 저장할 ResultSet
		ResultSet rs = null;
		// 디비와 연동
	
		conn=DBManager.getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();			
			while(rs.next()) {
				hairVO hvo = new hairVO();
			
				hvo.setId(rs.getString("id"));
				hvo.setName(rs.getString("name"));
				hvo.setphoneNumber(rs.getString("phoneNumber"));
				hvo.setAddress(rs.getString("address"));
				hvo.setEnroll(rs.getString("enroll"));
				list.add(hvo);
				
			}
			int r = pstmt.executeUpdate();
			if (r > 0) {
				System.out.println("detail ONE 성공");
			} else {
				System.out.println("detail ONE 실패");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"Detail err");
		}
		return list;
	}
	//전체 보기
	public void costmoer_selectList() {//상우 완료
		String sql = "select d.rsv_date, d.rsv_time, d.p_type, d.id, s.rsv_date, s.p_type,"+ 
				"from  dPdir d, sangSE where d.id=s.id";
	
	
	}
	//정보 갱신
	public void costmoer_update() {//상우 완료
		
	}
	//시술 내역, 날짜
	public void procedure_enroll() {
		String sql = "select rsv_date, p_type from sangSE where id=?";
		int i=0;
		Connection conn = null;
		// 쿼리문(select)을 수행하기 위한 문장 객체
		PreparedStatement pstmt = null;
		// 결과값을 저장할 ResultSet
		ResultSet rs = null;		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			pstmt.setString(1, rs.getString("id"));
			while(rs.next()) {
				rs.getString("rsv_date");
				rs.getString("p_type");
			}
		i=pstmt.executeUpdate();
		System.out.println(i+"시술 내역 + 날짜 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"시술 날짜 내역 오류");
		}
		
		
	}
	//------------------------------------고객 DAO---------------------------------------------------
	//아이디 중복 체크
	public hairDAO logincheck(String id) {
		String sql = "select pw from rPWjd where id=?";
		int result = -1;
		// 디비와 연동
		Connection conn = null;
		// 쿼리문(select)을 수행하기 위한 문장 객체
		PreparedStatement pstmt = null;
		// 결과값을 저장할 ResultSet
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if (rs.next()) { // 아이디가 일치하면
				result = 0;
				String dbpw = rs.getString(1);
				if (dbpw.equals(rs.getString("pw"))) {
					result = 1;
				}
			}
			DBManager.close(conn, pstmt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + "로그인 체크 err");
		}
		
		return null;
	}
	// 로그인 시 자료를 전부 전달하는 메서드
	public hairVO getMember(String id) {
		hairVO memberVO = null;
		String sql = "select * from rPWjd where id=?";

		Connection connn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			connn = DBManager.getConnection();
			pstmt = connn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				memberVO = new hairVO();
				memberVO.setId(rs.getString("id"));
				memberVO.setPw(rs.getString("pwd"));
				memberVO.setName(rs.getString("name"));
				memberVO.setAddress(rs.getString("address"));
				memberVO.setphoneNumber(rs.getString("phoneNumber"));
				memberVO.setEnroll(rs.getString("enroll"));			
			}
			int r = pstmt.executeUpdate();
			System.out.println(memberVO.toString());
			if(r>0) {
				return memberVO;
			}else {
				memberVO=null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage()+"로그인 접속 ERR");
		} finally {
			DBManager.close(connn, pstmt, rs);
		}
		return memberVO;
	}
	// 회원가입시 등록하는 메서드
	public int insertMember(hairVO memberVO) {
		int result = 0;
		String sql = "insert into rPWjd (id, pwd, name, phoneNumber, address)"
				+ "values(?, ?, ?, ?, ?)";

			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, memberVO.getId());
				pstmt.setString(2, memberVO.getPw());
				pstmt.setString(3, memberVO.getName());
				pstmt.setString(4, memberVO.getphoneNumber());
				pstmt.setString(5, memberVO.getAddress());
				result = pstmt.executeUpdate();
				System.out.println(result+"회원가입 성공");
			} catch (Exception e) {
				System.out.println(e.getMessage()+"회원가입 err");
			} finally {
				DBManager.close(conn, pstmt);
			}
			return result;
		}

	// 회원가입시 등록하는 메서드
		public void insertRSV(hairVO hvo) {
			int result = 0;
			String sql = "insert into dPdir (rsv_date , rsv_time, p_type) values(?, ?, ?)";

				Connection conn = null;
				PreparedStatement pstmt = null;
				try {
					System.out.println("!!");
					conn = DBManager.getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, hvo.getRsv_date());//rsv_date
					pstmt.setString(2, hvo.getRsv_time());//rsv_time
					pstmt.setString(3, hvo.getP_type());//p_type
					
					result = pstmt.executeUpdate();
					System.out.println(result+"예약 등록 성공");
				} catch (Exception e) {
					System.out.println(e.getMessage()+"예약 등록 err");
				} finally {
					DBManager.close(conn, pstmt);
				}
				
			}

	}
	

