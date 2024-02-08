package factorydesignpattern;

import java.util.Scanner;

class Food {
}

class Idly extends Food {
}

class Poori extends Food {
}

class Biryani extends Food {
}

class Hotel {
	public static Food orderFood(int choice) {
		if (choice == 1) {
			Idly i = new Idly();
			return i; // return new Idly();
		} else if (choice == 2) {
			Poori p = new Poori();
			return p; // return new Poori();
		} else if (choice == 3) {
			Biryani b = new Biryani();
			return b; // return new Biryani();
		} else {
			return null;
		}
	}
}

public class FoodOrder {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("1.Idly\n" + "2.Poori\n" + "3.Biryani\n" + "Enter the choice:");
		int ch = s.nextInt();
		Food obj = Hotel.orderFood(ch);
		if (obj instanceof Idly) {
			System.out.println("Eating Idly");
		} else if (obj instanceof Poori) {
			System.out.println("Eating Poori");
		} else if (obj instanceof Biryani)
			System.out.println("Eating Biryani");
		else {
			System.out.println("Inavlid choices");
		}
	}
}

//If choice is 1->Food obj Food=new Idly();
//If choice is 2->Food obj Food=new Poori();
//If choice is 3->Food obj Food=new Biryani();
//If choice is 4,5,6 ,....->Food obj=null;
