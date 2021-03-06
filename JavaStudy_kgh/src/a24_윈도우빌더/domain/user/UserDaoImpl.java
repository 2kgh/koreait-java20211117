package a24_윈도우빌더.domain.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

	@Override
	public int checkUsernameByUsername(String username) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql=null;
		int result = 0;
		
		try {
			con = pool.getConnection();
			sql = "select count(username) from user_mst where username = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			
			rs.next();
			result = rs.getInt(1);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return result;
	}

	@Override
	public int signinByUsernameAndPassword(User user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int result = 0;
		
		try {
			con = pool.getConnection();
			sql = "select count(um.username) + count(um2.password) "
				+"from user_mst um left outer join user_mst um2 "
				+"on(um2.id = um.id and um2.password = ?)"
				+"where um.username = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setNString(1, user.getPassword());
			pstmt.setNString(2, user.getUsername());
			rs = pstmt.executeQuery();
			
			rs.next();
			result = rs.getInt(1);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return result;
	}
	
	@Override
	public User getUserByUsername(String username) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		User user = null;
		
			
		try {
			con = pool.getConnection();
			sql = "select * from user_mst wehre username = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,username);
			rs = pstmt.executeQuery();
				
			rs.next();
			user = new User();
			user.setId(rs.getInt(1));
			user.setUsername(rs.getString(2));
			user.setUsername(rs.getString(3));
			user.setName(rs.getString(4));
			user.setEmail(rs.getNString(5));
			user.setCreate_date(rs.getDate(6));
			user.setUpdate_date(rs.getDate(7));
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				pool.freeConnection(con, pstmt, rs);
			}
			return user;
	}

	@Override
	public int updateProfileById(User user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int result = 0;
		
		try {
			con = pool.getConnection();
			sql = "update user_mst set name = ?, email = ?, update_date = now() where id =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getName());
			pstmt.setString(2, user.getEmail());
			pstmt.setInt(3, user.getId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updatePasswordById(User user) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int result = 0;
		
		try {
			con = pool.getConnection();
			sql = "update user_mst set password = ? where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getPassword());
			pstmt.setInt(2, user.getId());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con,pstmt);
		}
		return result;
	}

	
	public int deleteUserById(int id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = null;
		int result = 0;
		
		try {
			con = pool.getConnection();
			sql = "delete from user_mst where = ? where id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con,pstmt);
		}
		return result;
	}
}
