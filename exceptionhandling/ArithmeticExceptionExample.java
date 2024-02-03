package exceptionhandling;

import java.util.Scanner;
//Checked exception
public class ArithmeticExceptionExample {
	public static void main(String[] args) {
		System.out.println("start");
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the first number");
		int a=s.nextInt();
		System.out.println("Enterthe second number");
		int b=s.nextInt();
		try {
		System.out.println(a/b);
		}
		catch(Exception e){
			System.out.println("do not divisable by zero");
		}
		System.out.println("end");
	}
}
