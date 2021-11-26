package a12_배열;

public class ClassArray {
	public static void main(String[] args) {
		Student[] students = new Student[10];
		
		for(int i=0;i<students.length;i++) {
			students[i] = new Student("김준일"+i,i);
		}
		
		//students값의 주소값을 student배열안에 넣는다.
		for(Student student : students) {
			System.out.println("학생이름: "+student.getName());
			System.out.println("학생학년: "+student.getYear());
			
		}
		
		for(int i=0;i<students.length;i++) {
			System.out.println("학생이름: " +students[i].getName());
			System.out.println("학생학년: " +students[i].getYear());
		}
		
	}

}
