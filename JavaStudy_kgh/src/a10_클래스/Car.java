package a10_클래스;

public class Car {
	String company; //제조사
	String model; //차량 모델명
	String color; //차량 색상
	int year; //연식
	
	void carInfo() {
		System.out.println(company + ", " + model + ", " + color + ", " + year);
	}

}
