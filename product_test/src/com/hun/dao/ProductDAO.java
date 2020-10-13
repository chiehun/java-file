package com.hun.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hun.dto.ProductVO;
import com.hun.util.DBManager;

public class ProductDAO {

	public ProductDAO() {
		// TODO Auto-generated constructor stub
	}
	private static ProductDAO instance = null;
	
	public static ProductDAO getInstance() {
		instance = new ProductDAO();
		return instance;
		
	}
	// c Read u d
	public List<ProductVO> selectAllProducts(){
		// 최근 등록한 상품 먼저 출력하기
		String sql ="select * from product order by code desc";
		List<ProductVO> list = new ArrayList<ProductVO>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn= DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ProductVO pVO = new ProductVO();
				pVO.setCode(rs.getInt("code"));
				pVO.setName(rs.getString("name"));
				pVO.setPrice(rs.getInt("price"));
				pVO.setPictureUrl(rs.getString("pictureurl"));
				pVO.setDescription(rs.getString("description"));
				list.add(pVO);
			}// while문 끝
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"select err");
		}finally {
			DBManager.close(conn, pstmt, rs);
		}		
		return list;		
	}
	//craete r u d
	public void insertProduct(ProductVO pVO) {
		String sql ="insert into product values (product_seq.nextval, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn= DBManager.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pVO.getName());
			pstmt.setInt(2, pVO.getPrice());
			pstmt.setString(3, pVO.getPictureUrl());
			pstmt.setString(4, pVO.getDescription());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"insert err");
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
	public ProductVO selectProductByCode(String code) {
		String sql ="select * from product where code=?";
		
		ProductVO pVO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;		
		
		try {
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, code);
			
			if(rs.next()) {
				pVO = new ProductVO();
				pVO.setCode(rs.getInt("code"));
				pVO.setName(rs.getString("name"));
				pVO.setPrice(rs.getInt("price"));
				pVO.setPictureUrl(rs.getString("pictureUrl"));
				pVO.setDescription(rs.getString("description"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			
		}finally {
			//DBManager.close(conn, pstmt, rs);
		}
		return pVO;
		
	}
	public void updateProduct(ProductVO pVO) {
		String sql ="update product set name=?, price=?, pictureurl=?, description=?, where code=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;	
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pVO.getName());
			pstmt.setInt(2, pVO.getPrice());
			pstmt.setString(3, pVO.getPictureUrl());
			pstmt.setString(4, pVO.getDescription());
			pstmt.setInt(5, pVO.getCode());
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"update err");
		}finally {
			DBManager.close(conn, pstmt);
		}
		
	}
	public void deleteProduct(String code) {
		String sql ="delete product where code=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try {
			conn= DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, code);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"err");
		}finally {
			DBManager.close(conn, pstmt);
		}
	}
}
