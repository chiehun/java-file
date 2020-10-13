package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dto.HairVO;
import com.util.DBManager;


public class HairDAO {

   private static HairDAO instance= new HairDAO();

   public HairDAO() {

   }   
   
   public static HairDAO getInstance() {
	   
      return instance;
   }

   /** 관리자 로그인 **/
   public int wokerCheck(String userid, String userpw) {
      String sql = "select workerpw from worker where workerid = ?";
      int result = -1;
      // 디비와 연동
      Connection conn = null;
      // 쿼리문(select)을 수행하기 위한 문장 객체
      PreparedStatement pstmt = null;
      // 결과값을 저장할 ResultSet
      ResultSet rs = null;
      try {
         conn = DBManager.getConnection();
         System.out.println("1");
         pstmt = conn.prepareStatement(sql);
         System.out.println("2");
         pstmt.setString(1, userid);
         System.out.println("3");
         rs = pstmt.executeQuery();
         System.out.println("4");
         if (rs.next()) { // 아이디가 일치하면
            result = 0;
            String dbpw = rs.getString(1);
            if (dbpw.equals(userpw)) {
               result = 1;
            }
         }
         DBManager.close(conn, pstmt);
      } catch (SQLException e) {
         System.out.println(e.getMessage() + "로그인 체크 err");
      }
      return result;
   }// wokerCheck end

   // 등록,회원 가입
   public void costomer_insert() {//상우 완료
      
   }
   //검색 (이름, 전화번호 뒷자리(4))
   
   public void  costomer_searchone() {
      String sql = "select * from rPWjd where id=%?% || phoneNumber=";
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
   //예약
   public ArrayList<HairVO> costomer_appointmentlist() {
	   	String sql = "select r.id, r.name, r.phonenumber, d.rsv_date, d.rsv_time, d. rsv_status, s.rsv_date, s.p_type from rpwjd r, dpdir d, sangse s where r.id = d.id and d.rsv_seq = s.rsv_seq and d.rsv_status not in (2) order by d.rsv_seq desc;";
	            
	      ArrayList<HairVO> list = new ArrayList<HairVO>();
	      
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
	             HairVO hvo = new HairVO();
	             hvo.setId(rs.getString("id"));
	             hvo.setRsv_date(rs.getString("rsv_date"));
	             hvo.setRsv_time(rs.getString("rsv_time"));
	             hvo.setName(rs.getString("name"));
	             hvo.setPhoneNumber(rs.getString("phoneNumber"));
	             hvo.setRsv_date(rs.getString("rsv_date"));
	             hvo.setP_type(rs.getString("p_type"));
	             list.add(hvo);
	             System.out.println(list.size());
	          }
	            
	      } catch (SQLException e) {
	         System.out.println(e.getMessage()+"예약 QUERY 오류");
	      }
	      return list;      
	   }

	public void costmoer_update(HairVO hVO) {// 상우 완료
		String sql = "update set d.rsv_date=?, d.rsv_time=?, d.rsv_status=?, r.name=?, r.phonenumber=?, d.rsv_date=?, d.p_type=?"
				+ " from dPdir d, sangSE s " + "where d.id=s.id";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hVO.getRsv_date());

		} catch (SQLException e) {
			System.out.println("costmoer_update err : " + e.getMessage());
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
   
 //예약 확정 rsv_status +1
 	public void costomer_appointment(String id) {
 		String sql ="update dpdir set rsv_status=rsv_status+1 where id=?";
 		// 디비와 연동
 		Connection conn = null;
 		// 쿼리문(select)을 수행하기 위한 문장 객체
 		PreparedStatement pstmt = null;
 		// 결과값을 저장할 ResultSet
 		
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
 	
   //상세 보기 - 고객 기본 정보 조회
   public HairVO customer_DetailInfo(String id) {
	   String sql = "select id, name, phonenumber, address, enroll from rpwjd where id = ?";
	   HairVO hVo = null;
	   System.out.println(sql);
	   Connection conn = null;
	   PreparedStatement pstmt = null;
	   ResultSet rs = null;
	   
	   try {
		conn = DBManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		
		if(rs.next()) {
			hVo = new HairVO();
			hVo.setId(rs.getString("id"));
			hVo.setName(rs.getString("name"));
			hVo.setPhoneNumber(rs.getString("phonenumber"));
			hVo.setAddress(rs.getString("address"));
			hVo.setEnroll(rs.getString("enroll"));	
			
		}
	} catch (SQLException e) {
		System.out.println("customer_DetailInfo ERR : " + e.getMessage());
	} finally {
		DBManager.close(conn, pstmt);
	}
	return hVo; 
   } // customer_detailView() END
   
   
   //상세보기 -- 시술내역 리스트 조회
   public ArrayList<HairVO> customer_Procedure(String id) {
	   String sql = "select rsv_date, p_type from sangse where id = ? order by rsv_date desc";
	   
	   HairVO hVo = null;
	   
	   Connection conn = null;
	   PreparedStatement pstmt = null;
	   ResultSet rs = null;
	   
	   ArrayList<HairVO> list = new ArrayList<HairVO>();
	   try {
		conn = DBManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			hVo = new HairVO();
			hVo.setSisul_date(rs.getString("rsv_date"));
			hVo.setSisul_type(rs.getString("p_type"));
			list.add(hVo);
		}
		
	} catch (SQLException e) {
		System.out.println("customer_Procedure ERR : " + e.getMessage());
	} finally {
		DBManager.close(conn, pstmt, rs);
	}
	   return list;
    } // customer_Procedure() END
   
   
   
   
    /** 상세정보 수정 **/
	public void customer_detailUpdate(HairVO hVo) {
		String sql = "update rpwjd set name = ?, phonenumber = ?, address = ? where id = ? ";	
		Connection conn = null;
		PreparedStatement pstmt = null;
		int i;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hVo.getName());
			pstmt.setString(2, hVo.getPhoneNumber());
			pstmt.setString(3, hVo.getAddress());
			pstmt.setString(4, hVo.getId());
			pstmt.executeUpdate();
			i = pstmt.executeUpdate();
			System.out.println("고객정보 수정완료 : "+ i);
		} catch (SQLException e) {
			System.out.println("customer_detailUpdate ERR : " + e.getMessage());
		} finally {
			DBManager.close(conn, pstmt);
		}
	} // customer_detailUpdate() END
   
	
   /**시술 내역 수정**/
   public void customer_ProcedureUpdate(String date, String type) {
      String sql = "update sangse set p_type = ? where rsv_date = ?";
   
      Connection conn = null;
      PreparedStatement pstmt = null;
      
      try {
        conn = DBManager.getConnection();
        pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, type);
		pstmt.setString(2, date);
		pstmt.executeUpdate();
		
	} catch (SQLException e) {
		System.out.println("customer_ProcedureUpdate ERR : " + e.getMessage());
	} finally {
		DBManager.close(conn, pstmt);
	}
      
   } // customer_ProcedureUpdate() END
   
   
   //전체 보기
   public ArrayList<HairVO> costmoer_selectList() {//상우 완료
      String sql = "select d.rsv_date, d.rsv_time, d.p_type, d.id, s.rsv_date, s.p_type,"+ 
            " from dPdir d, sangSE s where d.id=s.id";
      // 디비와 연동
      Connection conn = null;
      // 쿼리문(select)을 수행하기 위한 문장 객체
      PreparedStatement pstmt = null;
      
      
      // 결과값을 저장할 ResultSet
      ResultSet rs = null;
      return null;
      
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

/**--------------------------고객 DAO-----------------------------**/
	public int insertMember(HairVO memberVO) {
		// TODO Auto-generated method stub
		int result = 0;
		String sql = "insert into rPWjd (id, pwd, name, phoneNumber, address) " + "values(?, ?, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberVO.getId());
			pstmt.setString(2, memberVO.getPw());
			pstmt.setString(3, memberVO.getName());
			pstmt.setString(4, memberVO.getPhoneNumber());
			pstmt.setString(5, memberVO.getAddress());
			result = pstmt.executeUpdate();
			System.out.println(result + "회원가입 성공");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "회원가입 err");
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	public HairVO getMember(String id) {
		HairVO memberVO = null;
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
				memberVO = new HairVO();
				memberVO.setId(rs.getString("id"));
				memberVO.setPw(rs.getString("pwd"));
				memberVO.setName(rs.getString("name"));
				memberVO.setAddress(rs.getString("address"));
				memberVO.setPhoneNumber(rs.getString("phoneNumber"));
				memberVO.setEnroll(rs.getString("enroll"));
			}
			int r = pstmt.executeUpdate();
			
			if (r > 0) {
				return memberVO;
			} else {
				memberVO = null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + "로그인 접속 ERR");
		} finally {
			DBManager.close(connn, pstmt, rs);
		}
		return memberVO;
	}
	
	public void insertRSV(HairVO hvo) {
		int result = 0;
		String sql = "insert into dPdir (rsv_seq, rsv_date , rsv_time, p_type, id) values(dpdir_seq.nextval, ?, ?, ?, ?)";
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, hvo.getRsv_date());
			 pstmt.setString(2, hvo.getRsv_time());
			 pstmt.setString(3, hvo.getP_type());
			 pstmt.setString(4, hvo.getId());

		   	result = pstmt.executeUpdate();
			System.out.println(result + " : 예약등록 성공");
		} catch (Exception e) {
			System.out.println(e.getMessage() + "예약등록 err");
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	public void reservation_lookup(String id) {
		// TODO Auto-generated method stub
		String sql = "select rsv_date, rsv_time, p_type from dPdir where id=?";
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement pstmt = null;		
		ResultSet rs = null;
		int result;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				rs.getString("rsv_date");
				rs.getString("rsv_time");
				rs.getString("p_type");
				rs.getString("rsv_status");
			}
			result = pstmt.executeUpdate();
			System.out.println(result+"111111성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		System.out.println(e.getMessage()+"예약 조회 ERR");
		}
	}

	public void reservation_delete(String id) {
		// TODO Auto-generated method stub
		String sql = "delete rsv_date, rsv_time, p_type, rsv_status from dPdir where id=?";
		System.out.println(sql);
		Connection conn = null;
		PreparedStatement pstmt = null;		
		ResultSet rs = null;
		int result;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				rs.getString("rsv_date");
				rs.getString("rsv_time");
				rs.getString("p_type");
				rs.getString("rsv_status");
			}
			result = pstmt.executeUpdate();
			System.out.println(result+"111111성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		System.out.println(e.getMessage()+"예약 조회 ERR");
		}
	}

} // class() END