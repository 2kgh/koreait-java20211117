package a24_���������.domain.user;

public interface UserDao {
	public int insertUser(User user);
	public int checkUsernameByUsername(String username);
	public int signinByUsernameAndPassword(User user);
	public User getUserByUsername(String username);
	public int updateProfileById(User user);
	public int updatePasswordById(User user);
}
