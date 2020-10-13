package com.hun.product.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hun.product.dto.ProductDTO;

public class DBmanager {
	final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	final String ORACLE_URL ="jdbc:oracle:thin:@127.0.0.1:1521:XE";
	Connection conn = null;
	PreparedStatement pstmt= null;
	Statement stmt = null;
	ResultSet rs = null;
	public DBmanager() {
		// TODO Auto-generated constructor stub
	}

	public void Connection() {
		Connection conn = null;
		try {
			Class.forName(ORACLE_DRIVER);
			System.out.println("DB 연결 성공");
			conn = DriverManager.getConnection(ORACLE_URL, "choehun", "1234");
			System.out.println("Connection 연결 성공");
			} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			System.out.println("연결 실패");
		} catch (SQLException e) {
				// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"CONNECT ERR");
		
			}
	}

	public void ProductInsert() {//상품 등록
		String query="insert into  product(?,?,?,?,?)";
	}

	public List<ProductDTO> ProductSelect() {
		String query="select * from product order by pseq desc";
		
		List<ProductDTO> list = new ArrayList<ProductDTO>();
		System.out.println("연결 성공");
		try {
			
			this.pstmt=this.conn.prepareStatement(query);
			this.rs = this.pstmt.executeQuery();
			ProductDTO dto= null;
			while(rs.next()) {
				dto= new ProductDTO();
				dto.setPseq(rs.getInt("pseq"));
				dto.setName(rs.getString("name"));
				dto.setPrice(rs.getInt("price"));
				dto.setContent(rs.getString("content"));
				dto.setIndate(rs.getString("indate"));
				list.add(dto);				
			}
			System.out.println(list);
		}catch(SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"select err");
		} 
		return list;
	}
	public void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"close err");
		}
	}
	public static void close(Connection conn, Statement stmt) {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"close err");
		}
	}
}
