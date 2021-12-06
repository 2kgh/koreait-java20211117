package a14_추상;

/**
 * 
 * 오버라이딩(@Override)
 * 재정의를 하기 위함.
 * @ -> 어노테이션
 *
 */

class Human extends Animal{
	@Override//추상클래스 Animal을 상속받았으면 꼭 override를 해주어야 한다.
	public void move() {
		System.out.println("사람이 움직입니다.");
	}
}

class Tiger extends Animal{
	@Override
	public void move() {
		System.out.println("호랑이가 움직입니다.");
	}
}

public class AbstractText {

	public static void main(String[] args) {
		Animal[] animals=new Animal[2];
		animals[0]=new Human();
		animals[1]=new Tiger();
		
		for(Animal animal:animals) {
			animal.move();
		}
	}

}
