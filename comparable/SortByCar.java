package comparable;

import java.util.TreeSet;

class Car implements Comparable<Car>{
	String brand;
	int price;
	public Car(String brand, int price) {
		super();
		this.brand = brand;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Brand Name: "+brand+" Cast "+price;
	}
	@Override
	public int compareTo(Car c) {
		return this.price-c.price;
	}
}

public class SortByCar {
	public static void main(String[] args) {

		Car c1=new Car("RANGE ROWER",87599);
		Car c2=new Car("MARUTHI",55599);
		Car c3=new Car("BMW",999999);
		Car c4=new Car("INAVA",6999);
		TreeSet<Car> list=new TreeSet<Car>();
		list.add(c4);
		list.add(c3);
		list.add(c2);
		list.add(c1);
		for(Car c:list) {
			System.out.println(c);
		}
	}
}
