package com.hun.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

import com.hun.Member;

public class MemberDao { //db와 쿼리문을 만드는 구조
	
	Connection conn=null;
	PreparedStatement pstmt = null;
	ResultSet rs= null;
	public MemberDao() {
		// TODO Auto-generated constructor stub
	}//생성자 end
	
	public Member selectById(Connection conn, String id) {
	String query = "select * from member where memberid=?";// id 와 같은 모든 것 출력
	
	try {
		pstmt = conn.prepareStatement(query);
		pstmt.setString(1, id);
		rs =pstmt.executeQuery();
		Member member = null;// member 객체에 데이터를 저장
		while(rs.next()) {
			member = new Member(rs.getString("memberid"),rs.getString("name"),rs.getString("password"), toDate(rs.getTimestamp("rdgdate")));
		}
		return member;
	}	catch (SQLException e) {
		System.out.println(e.getMessage()+"query문 오류");
		
	}finally {		
		try {
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"종료 오류");
		}
	
	}
	return null;//???
	
	}

	private Date toDate(Timestamp timestamp) { //member변수에 DateClass 형식을 선언해 주었기 때문에 맞춰줘야한다
		// TODO Auto-generated method stub
		return timestamp == null? null : new Date(timestamp.getTime());
	}
	
	public void insert(Connection conn, Member mem) {
		String query = "insert into member values(?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getName());
			pstmt.setString(3, mem.getPassword());
			pstmt.setTimestamp(4, new Timestamp(mem.getRegDate().getTime())); //schedule클래스로 바꿀수 있지않을까?!
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
