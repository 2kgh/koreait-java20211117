package a09_메소드;

public class Bingsu {
	
	static String toMake(String material) {
		return material + "빙수";
	}

	public static void/*void는 반환할게 없는 실행만 시키겠다는 뜻*/ main(String[] args) {
		String m = toMake("딸기");
		System.out.println(m);
	}

}
