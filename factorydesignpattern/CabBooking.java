package factorydesignpattern;

import java.util.Scanner;
class Cab{
}
class Uber extends Cab{
}
class Ola extends Cab{
}
class Rapido extends Cab{ 
}
class Mobile{
	public static Cab select(int choice) {
		if(choice==1) {
			Uber u=new Uber();
			return u;
		}
		else if(choice==2) {
			Ola o=new Ola();
			return o;
		}
		else if(choice==3) {
			Rapido r=new Rapido();
		}
		return null;
	}
}
public class CabBooking {
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	Mobile m=new Mobile();//
	System.out.println("1.Uber\n2.Ola\n3.Rapido");
	System.out.println("Enter the choice:");
	int ch=s.nextInt();
	Cab cab=Mobile.select(ch);
	if(cab instanceof Uber) {
		System.out.println("Booked Uber cab");
	}
	else if(cab instanceof Ola) {
		System.out.println("Booked Ola cab");
	}
	else if(cab instanceof Rapido) {
		System.out.println("Booked Rapido cab");
	}
	else {
		System.out.println("Invalid choices");
	}
}
}

