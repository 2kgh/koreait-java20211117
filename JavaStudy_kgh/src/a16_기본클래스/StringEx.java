package a16_�⺻Ŭ����;

import java.util.Scanner;

//�ּҰ��� ������ ���ͷ����� ������, �ᱹ ���ͷ����� ���ƾ� true��� ����� ����

public class StringEx {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("�̸� �Է� : ");
		String name = in.nextLine(); //>>name3
		
		String name1 = "������";
		String name2 = "������";//�������̶�� ������� ����� �ּҸ� name2�� ������
		
		String name3 = new String("������");//���� String��ü�� ������� String�� �ּҰ� name3�� �������
		
		System.out.println(name1==name2);
		System.out.println(name == "������");
		System.out.println(name.equals("������"));//equals�� �ּҰ��� ���ϴ� ��
		
	}

}
