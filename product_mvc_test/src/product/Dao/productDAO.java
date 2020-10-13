package product.Dao;

import java.util.List;

import product.DTO.productVO;

public class productDAO {
	private static productDAO instance = new productDAO();

	public productDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static productDAO getInstance() {
		return instance;
		
	}
	
	public List<productVO> selectALL(){
		return null;
		//전체 검색 리스트를 만들어주는 역할 (역순으로 정렬)

	}
	public void insertproduct(productVO bVO) {
		//등록(데이터를 삽입해주는 역할) ->writeAction

	}
	
	//조회수
	public void updateReadCount(String num) {
		
	}

	public productVO selectOneproductByNum(String num) {
		//조회수 만들어주는 역할

		return null;
		
	}
	//비밀번호 확인 하는 메서드
	public productVO checkPassWord(String pass, String num) {
		return null;
		
	}
	//데이터삭제해주는 역할

	public void deleteproduct(String num) {
		
	}

}
