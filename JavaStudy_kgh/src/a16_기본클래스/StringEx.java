package a16_기본클래스;

import java.util.Scanner;

//주소값이 같은지 리터럴값이 같은지, 결국 리터럴값이 같아야 true라고 결과가 나옴

public class StringEx {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("이름 입력 : ");
		String name = in.nextLine(); //>>name3
		
		String name1 = "김준일";
		String name2 = "김준일";//김준일이라는 상수값이 저장된 주소를 name2에 넣은것
		
		String name3 = new String("김준일");//새로 String객체를 만들고나서 String의 주소가 name3에 들어있음
		
		System.out.println(name1==name2);
		System.out.println(name == "김준일");
		System.out.println(name.equals("김준일"));//equals는 주소값을 비교하는 것
		
	}

}
