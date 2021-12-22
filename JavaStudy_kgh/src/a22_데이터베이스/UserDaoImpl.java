package a22_�����ͺ��̽�;

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
			pstmt.setString(1, user.getUsername());//ù��° ����ǥ���ٰ� ���� �ְڴ�.
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getName());
			pstmt.setString(4, user.getEmail());
			result = pstmt.executeUpdate(); //select�� ������ ����������� ���๮�̱⶧���� executeUpdate�� ����Ѵ�,result���� ����� �Ǽ��� �Էµ�
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt);
		}
		
		return result; //�ߵ����� 1�� ��µ� ����
	}
	
}
