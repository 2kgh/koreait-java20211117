package a08_�ݺ�;

import java.util.Scanner;

public class DoubleFor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int gugudanStart = 0;
		int gugudanEnd = 0;
		
		System.out.print("���� �ܼ�: ");
		gugudanStart = in.nextInt();//���ڸ� �Է¹ް� gugudanStart�� �����ϴ� ��
		System.out.print("������ �ܼ�: ");
		gugudanEnd = in.nextInt();
		
	
		for(int i=gugudanStart;i<gugudanEnd+1;i++) {
			System.out.println(i + "��");
			for(int j=1;j<10;j++) {
			System.out.println(i + " X " + j + " = " + i*j);
			}
		}
		
	}
	
}
