package a22_데이터베이스;

public class Display {
	public void mainDisplay() {
		System.out.println("[프로그램 시작]");
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("q. 프로그램 종료");
		System.out.println();
	}
	
	public void signupDisplay() {
		System.out.println("[회원가입]");
	}
	
	public void signupMessage(boolean result) {
		if(result == true) {
			System.out.println("회원가입 성공.");
		}else {
			System.out.println("회원가입 실패.");
		}
	}

}
