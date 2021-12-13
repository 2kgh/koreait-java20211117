package a18_lombok;

public class LombokTest {

	public static void main(String[] args) {
		User user = new User();
		User user2 = new User("junil","1234","김준일","asdfas@gmail.com");
		
		user.setUser("rkgus");
		
		user.equals(user2);
		System.out.println("해쉬코드: "+user.hashCode());
		
		System.out.println(user.getUser());
		
		System.out.println(user);
		System.out.println(user2);
	}

}
