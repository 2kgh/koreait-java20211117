package a08_반복;

import java.util.Scanner;

public class DoubleFor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int gugudanStart = 0;
		int gugudanEnd = 0;
		
		System.out.print("시작 단수: ");
		gugudanStart = in.nextInt();//숫자를 입력받고 gugudanStart에 대입하는 것
		System.out.print("마지막 단수: ");
		gugudanEnd = in.nextInt();
		
	
		for(int i=gugudanStart;i<gugudanEnd+1;i++) {
			System.out.println(i + "단");
			for(int j=1;j<10;j++) {
			System.out.println(i + " X " + j + " = " + i*j);
			}
		}
		
	}
	
}
