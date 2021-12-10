package a16_기본클래스;

import java.util.Objects;

public class Car { 
	private int carNumber; //일련번호
	private String model;
	
	public Car(int carNumber, String model) {
		this.carNumber = carNumber;
		this.model = model;			
		
	}
	
	
	public String getModel() {
		return model;
	}
	
	
	
	
	/*
	@Override
	//hashCode는 주소값(주소값만 가지고 있음) hashCode를 일련번호로 지정하고 싶을때 활용하는 방법
	public int hashCode() {
		return this.carNumber;
	}


	@Override
	public boolean equals(Object obj) { 
		Car car = (Car)obj;
		if(this.model.equals(car.getModel()) && this.hashCode() == car.hashCode()) {
			return true;
		}else {
			return false;
		}
	}
	
	*/

	@Override
	public int hashCode() {
		return Objects.hash(carNumber, model);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return carNumber == other.carNumber && Objects.equals(model, other.model);
	}


	@Override
	public String toString() {
		return "Car [carNumber=" + carNumber + ", model=" + model + "]";
	}
	

}
