package a22_데이터베이스;

import java.sql.Connection;
import java.sql.PreparedStatement;

import db.DBConnectionMgr;

public class UserDaoImpl implements UserDao{ 
	private DBConnectionMgr pool;
	
	public UserDaoImpl() {
		pool = DBConnectionMgr.getInstance();
	}
	
	@Override
	public int insertUser(User user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int result = 0;
		try {
			con = pool.getConnection();
			sql = "insert into user_mst values(0,?,?,?,?,now(),now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());//첫번째 물음표에다가 값을 넣겠다.
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			result = pstmt.executeUpdate(); //select를 제외한 모든쿼리들은 실행문이기때문에 executeUpdate를 사용한다,result에는 실행된 건수가 입력됨
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt);
		}
		
		return result; //잘들어갔으면 1이 출력될 것임
	}
	
}
