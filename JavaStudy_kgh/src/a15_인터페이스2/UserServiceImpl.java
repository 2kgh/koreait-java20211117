package a15_인터페이스2;

import java.util.Scanner;

public class UserServiceImpl implements UserService{
	private User[] users;
	private Scanner in;//전역변수로 설정했기때문에 일일이 적을 필요없음
	
	public UserServiceImpl(int userCount) {
		in = new Scanner(System.in);
		users = new User[userCount];
	}
	
	public boolean nextOn() {
		do {
			System.out.println("계속 정보를 등록하시겠습니까?(y/n)");
			String continueFlag = in.nextLine();
			if(continueFlag.equals("n") || continueFlag.equals("N")) {
				return false;//return을 만나면 함수를 완전히 빠져나오게 됨
			}else if(continueFlag.equals("y") || continueFlag.equals("Y")) {
				return true;
			}else {
				System.out.println("잘못된 명령입니다.");
			}
			}while(true);
		
	}
	
	
	@Override
	public void createUser() {
		boolean loopFlag = true;
		
		while(loopFlag) {
			
			System.out.println("아이디: ");
			String id = in.nextLine();
			System.out.println("비밀번호: ");
			String password = in.nextLine();
			System.out.println("이름: ");
			String name = in.nextLine();
			System.out.println("이메일: ");
			String email = in.nextLine();
			
			loopFlag = nextOn();
			
			User user = new User();
			
			user.setId(id);
			user.setPassword(password);
			user.setName(name);
			user.setEmail(email);
			
			insertUser(user);
		}
	}
	
	@Override
	public void insertUser(User user) {
		int index = 0;
		for(int i=0;i< users.length;i++) {
			if(users[i]==null) {
				index = i;
				break;
			}
		}
		users[index] = user;//비어있는 index에 넣어줌 그리고 다시 while(loopFlag)로 돌아가서 실행
	}

	@Override
	public User getUser(String id) {
		
		for(int i = 0;i<users.length;i++) {
			if(users[i]==null || !users[i].getId().equals(id)) {
				continue;
			}
			return users[i];
		}
		
		return null;
	}

	@Override
	public void printUsers() {
		for(User user : users) {
			if(user == null) {
				continue;
			}
			System.out.println(user);
		}
		
	}

	@Override
	public void searchUser() {
		System.out.println("사용자 정보 검색");
		System.out.print("찾고자하는 아이디 입력: ");
		String searchId=in.nextLine();
		
		User user = getUser(searchId);
		
		if(user==null) {
			System.out.println("해당 아이디의 사용자를 찾을 수 없습니다.");
		}else {
			System.out.println("찾은 사용자 정보");
			System.out.println(user);
		}
		
	}
	
}
