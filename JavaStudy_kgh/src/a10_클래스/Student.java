package a10_Ŭ����;

public class Student {
	public int studentYear;
	public int studentGroup;
	private int studentNumber;
	String name;
	
	//�����ǰ��� ���� �ִ� ���, *�ذ� ���� �Ű������� ��������� public(�⺻ ������)�� ���� �����ؾ���
	public Student() {
		//System.out.println("���ο� �л� ����");
	}
	
	//�����ʰ� ���ÿ� ���� �ִ� ���
	public Student(int studentYear,int studentGroup,int studentNumber,String name) {
		this.studentYear=studentYear;
		this.studentGroup=studentGroup;
		this.studentNumber=studentNumber;
		this.name = name;		
	}
	
	public void showInfo() {
		System.out.println("�г�:" + studentYear);
		System.out.println("��:" + studentGroup);
		System.out.println("��ȣ:" + studentNumber);
		System.out.println("�̸�:" + name);
		System.out.println();
		
	}

}
