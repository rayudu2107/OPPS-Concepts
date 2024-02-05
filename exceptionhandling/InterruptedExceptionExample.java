package exceptionhandling;

import java.util.Scanner;
//Checked exception
public class InterruptedExceptionExample {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number");
		int n = s.nextInt();
		try {
			printNumbers(n);
		} catch (InterruptedException e) {
			System.out.println("handleed");
		}
	}
	static void printNumbers(int n) throws InterruptedException {
		for (int i = 1; i <= n; i++)
			System.out.println(i);
		Thread.sleep(20000);
	}
}
