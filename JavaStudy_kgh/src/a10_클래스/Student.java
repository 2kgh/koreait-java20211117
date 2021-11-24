package a10_클래스;

public class Student {
	public int studentYear;
	public int studentGroup;
	private int studentNumber;
	String name;
	
	//생성되고나서 값을 넣는 방법, *밑과 같이 매개변수를 만들었으면 public(기본 생성자)도 같이 존재해야함
	public Student() {
		//System.out.println("새로운 학생 생성");
	}
	
	//생성됨과 동시에 값을 넣는 방법
	public Student(int studentYear,int studentGroup,int studentNumber,String name) {
		this.studentYear=studentYear;
		this.studentGroup=studentGroup;
		this.studentNumber=studentNumber;
		this.name = name;		
	}
	
	public void showInfo() {
		System.out.println("학년:" + studentYear);
		System.out.println("반:" + studentGroup);
		System.out.println("번호:" + studentNumber);
		System.out.println("이름:" + name);
		System.out.println();
		
	}

}
