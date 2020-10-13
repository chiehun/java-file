package com.hun.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.hun.dto.GoodsDTO;

public class OracleDAO {

	public Connection conn = null;
	public PreparedStatement pstmt = null;
	public Statement stmt = null;
	public ResultSet rs = null;
	public int r = 0;

	public OracleDAO() {
		// TODO Auto-generated constructor stub
	}

	/** 각 서블릿들이 기본 호출 (접속) **/
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");

			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
			this.conn = DriverManager.getConnection(url, "naver_store", "1234");
			System.out.println("접속 성공");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + "드라이버 로딩 실패");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + "연결 실패");
		}
	}// connect end

	/** GoodsListServlet (조회)에서 호출 **/
	public List<GoodsDTO> selectAll() {		
		List<GoodsDTO> array = new ArrayList<GoodsDTO>();
		GoodsDTO dto1 = new GoodsDTO();//넣어져와된
		String qurey = "select * from store2";
		try {
			this.stmt = conn.createStatement();
			this.rs = this.stmt.executeQuery(qurey);
			while(rs.next()) {					
				dto1 = new GoodsDTO();
				dto1.setCode(rs.getInt("code"));
				dto1.setProduct(rs.getString("product"));
				dto1.setContent(rs.getString("content"));
				dto1.setQuantity(rs.getInt("quantity"));
				dto1.setDiscount(rs.getInt("discount"));
				dto1.setDelivery_change(rs.getInt("delivery_change"));
				dto1.setPrice(rs.getInt("price"));
				dto1.setName(rs.getString("name"));
				array.add(dto1);
				dto1 = null;
				}
			System.out.println("성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"select query err");
		}		
		return array;
		
	}// selectAll end

	/** GoodsDetailServlet (1개 조회 -> Detail.jsp)에서 호출 **/
	public void selectOne(int code) {

	}// selectOne() end

	/** GoodsEntryServlet -> ListServlet 에서 호출 ( 삽입) **/
	public void insert(GoodsDTO goods) {
		String query = "insert into store2 (code , product, content, quantity, discount, delivery_change, price, name)"
				+ " values (?, ?, ?, ?, ?, ?, ?, ?)";
		System.out.println("==> goods.toString() "+goods.toString());
		
		try {
			this.pstmt = conn.prepareStatement(query);
			this.pstmt.setInt(1, goods.getCode());//goods.getCode()
			this.pstmt.setString(2, goods.getProduct());//goods.getProduct()
			this.pstmt.setString(3, goods.getContent());//goods.getContent()
			this.pstmt.setInt(4, goods.getQuantity());//goods.getQuantity()
			this.pstmt.setInt(5, goods.getDiscount()); //goods.getDiscount()
			this.pstmt.setInt(6, goods.getDelivery_change());//goods.getDelivery_change()
			this.pstmt.setInt(7,goods.getPrice());// goods.getPrice()
			this.pstmt.setString(8, goods.getName());//goods.getName()

			this.r = this.pstmt.executeUpdate();

			if (r > 0) {
				System.out.println("==> INSERT 성공");
			} else {
				System.out.println("==> INSERT 실패");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage() + "insert err");
		}

	}

	/** GoodsUpdateServlet 에서 호출 (삭제) **/
	public void update(GoodsDTO goods) {

	}

	/** GoodsDeleteServlet 에서 호출 (삭제) **/
	public void delete(int code) {

	}// delete() end

	/** 각 서블릿들이 데이터베이스 작업 완료 후, 호출 **/
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
			System.out.println("종료 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("close err =>" + e.getMessage());
		}
	}// close() End
}
