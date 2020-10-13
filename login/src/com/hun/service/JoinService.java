package com.hun.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import com.hun.Member;
import com.hun.db.MemberDao;

public class JoinService {

	private MemberDao memberDao = new MemberDao();

	public void join(Service joinReq) throws SQLException {
		Connection conn= null;	
		try {
			Class.forName("com.mysql.jdbc.Driver");
					
			conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test_db","root","1234");
			
			Member member = memberDao.selectById(conn, joinReq.getId() );
			if(member != null) {
				conn.rollback();
			}
			memberDao.insert(conn, new Member(
					joinReq.getId(), joinReq.getName(), joinReq.getPassword(), new Date()));
			conn.commit();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			conn.rollback();
			System.out.println(e.getMessage());
			throw new RuntimeException(e);
						
		} finally {
			conn.close();
		}
		
		
	}

}
