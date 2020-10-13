package com.freeflux;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import com.sun.java_cup.internal.runtime.virtual_parse_stack;

/** 데이터에 접근할 수 있는 객체 (DAO) 역할 담당**/
public class DBConnectionMgr {
	public Connection conn = null;
	public PreparedStatement pstmt = null;
	public Statement stmt = null;
	public ResultSet rs = null;

	private final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String ORACLE_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";

    public DBConnectionMgr() {
    }

    /** 기본 생성자 : 각 Servlet 에서 가장 먼저 객체 생성 시 **/
	public void connect() {
		try {
			Class.forName(ORACLE_DRIVER);
			System.out.println("==> 드라이버 로딩 성공!");

			this.conn = DriverManager.getConnection(ORACLE_URL, "poll", "1234");
			System.out.println("==> DB접속성공!");

		} catch (ClassNotFoundException e) {
			System.out.println("DRIVER LOAD ERR => " + e.getMessage());

		} catch (SQLException e) {
			System.out.println("CONNECT ERR => " + e.getMessage());
		}
	}
	/** =========================================================== **/
	
	/**
	 * 설문의 가장 높은 num값 :
	 * 
	 * @return
	 */
	public int getMaxNum() {
		String sql = "select max(num) from tblPollList";
		int maxNum = 0; //seq 
		this.connect();
		try {
			this.pstmt= this.conn.prepareStatement(sql);
			
			this.rs=this.pstmt.executeQuery();
			
			if(this.rs.next()) {
				maxNum = this.rs.getInt(1);//가장 높은 num값
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"getMaxNum err");
		}

		return maxNum;
	}//getMaxNum() END
	
	/** =========================================================== **/
	
	/**
	 * 설문 등록 처리 : 
	 * 
	 * @param plBean, piBean
	 */
	public boolean insertPoll(PollListBean plBean, PollItemBean piBean) {
		boolean flag = false;
		String sql = null;
		
		try {
			this.connect();
			this.pstmt = null;
			sql = "insert into tblPollList(num, question, sdate, edate, wdate, type) values (seqPollList.nextval, ?, ?, ?, sysdate, ?)";
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, plBean.getQuestion()); //설문 주제 값을 꺼내온다
			this.pstmt.setString(2, plBean.getSdate());   //시작 날짜
			this.pstmt.setString(3, plBean.getEdate());   //종료 날짜
			this.pstmt.setInt(4, plBean.getType());			// 등록날짜
			
			int result = this.pstmt.executeUpdate();
			
			this.pstmt=null; //item객체를 채운다. 새롭게 채워야 하기 때문에 null 처리 해야 한다.
			
			if(result==1) {
				String[]item = piBean.getItem();
				
				int itemnum = this.getMaxNum();
				
				sql ="insert into tblPollItem(listnum, itemnum, item, count)"
						+" values("+itemnum+", ? , ? , 0)";
				this.pstmt = this.conn.prepareStatement(sql);  //위와 아래 쿼리문이 다르기 때문에 새롭게 객체를 선언해 줘야 한다.
				
				int j =0;
				System.out.println();
				for(int i =0; i< item.length; i++) {
					if(item[i]==null||item[i].length()==0) {
						break;
					}// 꼭 8개 설문지를 전부 채우지 않아도 되기 때문에 
					
				this.pstmt.setInt(1, i);
				this.pstmt.setString(2, item[i]);
				j = this.pstmt.executeUpdate();
				}
				if(j>0) {
					flag =true;  //j>0는 뜻은 업데이트가 잘 되었기 때문에
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"insertPoll err");
		}
		
		return flag;
	}
	
	/** =========================================================== **/
	
	/**
	 * 설문 목록 조회  : 
	 * 
	 * @return
	 */
	public List<PollListBean> getAllList() {
		this.connect();
		String sql = null;
		List<PollListBean> pollList = new ArrayList<PollListBean>();
		try {		
		sql="select * from tblPollList order by num desc";		
			this.pstmt = this.conn.prepareStatement(sql);
			this.rs = this.pstmt.executeQuery();
			while(this.rs.next()) {
				PollListBean plBean = new PollListBean();
				
				plBean.setNum(this.rs.getInt("num"));
				plBean.setQuestion(this.rs.getString("question"));
				plBean.setSdate(this.rs.getString("sdate"));
				plBean.setEdate(this.rs.getString("edate"));
				
				pollList.add(plBean);
			}
			//System.out.println(pollList);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"allList err");
		}

		return pollList;
	}
	
	/** =========================================================== **/
	
	/**
	 * 설문 리스트 조회 : 
	 * pollfrom.jsp 파일에서 getlist 값을 가지고 올때 사용된다.
	 * 결과를 호출할때 num 값이 없다 
	 * list는 한 레코드를 가지고 오기때문에 list가 아니라 객체로 받을 수 있다.
	 */
	public PollListBean getList(int num) {
		String sql = null;

		PollListBean plBean = new PollListBean();
		try {
		this.connect();
		if(num==0) {
			sql= "select * from tblPollList order by num desc"; // 설문 작성 후 전체
		}else {
			sql= "select * from tblPollList where num="+ num;  // 선택한 설문만...
		}
	
			this.pstmt = this.conn.prepareStatement(sql);  // 전체 데이터 쪽에서  num 값이 제일 큰 데이터
			this.rs= this.pstmt.executeQuery();
			if(this.rs.next()) {
				plBean.setQuestion(this.rs.getString("question")); //설문 내용
				plBean.setType(this.rs.getInt("type")); //복수 선택여부 : checkbox / radio
				plBean.setActive(this.rs.getInt("active")); //설문 가능 여부
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("getList err"+e.getMessage());
		}
		return plBean;  // plBean-> pollform.jsp
	}
	
	/** =========================================================== **/
	
	/**
	 * 설문 아이템  조회 : 
	 * 
	 * @param num
	 * @return
	 */
	public List<String> getItem(int num) {
		String sql = null;

		List<String> vlist = new ArrayList<String>();
		try {
		this.connect();
		if(num == 0) {
			num =getMaxNum();  //list 에서 가장 큰 num 값을 꺼내오기 때문에 똑같이 매핑하기 위해서는 똑같이 0일때 getMaxNum값을 꺼내와야한다.
		}
		sql = "select item from tblPollItem where listnum = ?";
		
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setInt(1, num);
			this.rs= this.pstmt.executeQuery();
			
			while(this.rs.next()) {
				vlist.add(this.rs.getString(1));  // 또는 this.rsgetString("item") // 필드명이 여러개면 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("getItem() err =>"+e.getMessage());
		}
		return vlist;
	}
	
	/** =========================================================== **/
	

	/**
	 * 설문 아이템  투표수 증가 : 
	 * 
	 * @param num, itemnum
	 * @return
	 */
	//ut.println("<input type=checkbox name='itemnum' value='"+i+"'>");
	public boolean updatePoll(int num, String[] itemnum) {//ex) num =1, itemnum ==0,1
		boolean flag = false;
		String sql = null;
		try {
		this.connect();
		sql = "update tblPollItem set count = count+1 where listnum=? and itemnum = ?";
		this.pstmt = this.conn.prepareStatement(sql);
		if(num == 0) {
			num=this.getMaxNum();
		}
		
		for(int i=0; i<itemnum.length; i++) {
			if(itemnum[i]==null|| itemnum[i].equals("")) {
				break;  // 왜 break 전체 검색이 끝났을때 
			}
			this.pstmt.setInt(1, num);
			this.pstmt.setInt(2, Integer.parseInt(itemnum[i]));
			int j = this.pstmt.executeUpdate();
			if(j>0) {
				flag=true;
			}
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return flag;
	}
	
	/** =========================================================== **/
	
	/**
	 * 설문 아이템  조회 : 
	 * 
	 * @param num, itemnum
	 * @return
	 */
	public List<PollItemBean> getView(int num) {
		String sql = null;
		List<PollItemBean> vlist = new ArrayList<PollItemBean>();
		try {
		this.connect();
		sql = "select item, count from tblPollItem where listnum=?";
		
			this.pstmt = this.conn.prepareStatement(sql);

			if(num == 0){
				this.pstmt.setInt(1, this.getMaxNum());
			}else {
				this.pstmt.setInt(1, num);
			}
			
			this.rs = this.pstmt.executeQuery();
			while (this.rs.next()) {
				PollItemBean piBean =new PollItemBean();
				
				String item[] = new String[1];	//배열을 받아야하기 때문에 1개를 받더라고 배열을 받을 수 있게 해줬다
				item[0] =this.rs.getString(1);	//tblPollitem 테이블의 item 필드 값
				piBean.setItem(item);			//private String[] item; // 아이템 내용
				piBean.setCount(this.rs.getInt(2));	//tblPollItem 테이블의 count 필드 값
				
				vlist.add(piBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"updatePoll() err");
		}
		
		return vlist;//pollview.jsp vlist로 간다
	}
	
	
	
	/**
	 * 설문 count 합계 조회 : 
	 * 
	 * @param num, itemnum
	 * @return
	 */
	public int sumCount(int num) {

		String sql = null;
		int count = 0;
		try {
		this.connect();
		sql="select sum(count) from tblPollItem where listnum=?";		
			this.pstmt = conn.prepareStatement(sql);
			if(num==0) {
				this.pstmt.setInt(1, this.getMaxNum());
			}else {
				this.pstmt.setInt(1, num);
			}
			
			this.rs = this.pstmt.executeQuery();
			if(this.rs.next()) {
				count = this.rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"sumcount() err");
		}
		

		return count;
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
}
