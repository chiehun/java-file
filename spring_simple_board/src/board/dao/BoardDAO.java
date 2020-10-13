package board.dao;

/** Connection, prepardStatement, 쿼리 실행관련**/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/** Context(Interface이다), InitialContext 객체**/
// lookup(찾고자 하는 이름(JNDI명)) -> 탐색기에서 검색하는 것 과 같은 느낌
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
//*추가 (JNDI 방식)**/
//DataSource 객체 -> getConnection()
import javax.sql.DataSource;
import board.command.BoardCommand;
import board.dto.BoardDTO;

public class BoardDAO {
	DataSource ds;
	
	// 생성자 : DataSource 얻기 : InitialContext와 JNDI명
	public BoardDAO() {
		try {
			// InitialContext ctx= new InitialContext(); 이것도 가능,
			Context ctx = new InitialContext();

			// lookup("java:comp/env/찾고자하는 Jndi이름")
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/orcl");
			System.out.println("ds:" + ds);
		} catch (NamingException e) {
			System.out.println(e.getMessage() + "연결 오류");
		}
		
	}//BoardDAO() {
	
	public ArrayList<BoardDTO> list(){
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		
		try {
			String sql ="SELECT * FROM springboard order by num desc";
			Connection con = ds.getConnection();
			
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				BoardDTO data = new BoardDTO();				
				data.setNum(rs.getInt("num"));
				data.setAuthor(rs.getString("author"));
				data.setTitle(rs.getString("title"));
				data.setContent(rs.getString("content"));
				data.setDate(rs.getString("date"));
				data.setReadcnt(rs.getInt("readcnt"));
				
				list.add(data);
			}//while
			
			rs.close();
			stmt.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"list err");
		}
		
		return null;
		
	}
}//class END
