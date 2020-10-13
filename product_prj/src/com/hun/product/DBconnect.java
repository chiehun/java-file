package com.hun.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBconnect {
	public Connection conn = null;
	public PreparedStatement pstmt = null;
	public Statement stmt = null;
	public ResultSet rs = null;

	private final String ORACLE_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String ORACLE_URL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";

	public DBconnect() {
		// TODO Auto-generated constructor stub
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

	public List<ProductDTO> productList() {
		List<ProductDTO> productlist = new ArrayList<ProductDTO>();

		// String query= "select code, name, price from product order by code desc";
		String query = "select * from product order by code desc";
		try {
			this.connect();
			this.pstmt = this.conn.prepareStatement(query);
			this.rs = this.pstmt.executeQuery();
			while (rs.next()) {
				ProductDTO dto = new ProductDTO();
				dto.setCode(this.rs.getInt("code"));
				dto.setName(this.rs.getString("name"));
				dto.setPrice(this.rs.getInt("price"));
				productlist.add(dto);

			}
			// System.out.println(productlist);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + "select err");
		}

		return productlist;
	}

	public boolean productInsert(ProductDTO dto) {
		boolean flag = false;
		String query = "insert into product (code, name, price, description) values( product_seq.nextval,?,?,?)";
		int count = 0;
		this.connect();
		try {
			this.pstmt = this.conn.prepareStatement(query);
			this.pstmt.setString(1, dto.getName());
			this.pstmt.setInt(2, dto.getPrice());
			this.pstmt.setString(3, dto.getDescription());
			count = this.pstmt.executeUpdate();
			if (count > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + "insert err");
		}
		System.out.println(dto.toString());
		return flag;

	}

	public boolean productDelete(int code) {
		boolean flag = false;
		String query = "delete from product where code=?";
		int count=0;
		System.out.println(code);
		try {
			this.connect();
			this.pstmt=this.conn.prepareStatement(query);
			this.pstmt.setInt(1, code);
			count = this.pstmt.executeUpdate();
		
			System.out.println(code);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"delete문 err");
		}
		return flag;		
	}

	public boolean productUpdate(ProductDTO dto) {
		String query = "update product set name=?, price=?, description=? where code=?";
		boolean flag = false;
		this.connect();
		int count =0;
		try {
			this.pstmt=this.conn.prepareStatement(query);
			this.pstmt.setString(1, dto.getName());
			this.pstmt.setInt(2, dto.getPrice());
			this.pstmt.setString(3, dto.getDescription());
			count = this.pstmt.executeUpdate();
			if (count > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"update err");
		}
		
		return flag;
	}

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
