package programming;

import java.util.Scanner;

public class PrimeNumberOrNot {
	static boolean isprime(int n) {
		for(int i=2;i<=n/2;i++) {      
			if(n%i==0)
		return false;
	}
		return true;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.err.println("enter the number");
		int n=s.nextInt();
		boolean res=isprime(n);
		if(res)
			System.out.println("Prime number");
		else {
			System.out.println("Not a prime number");
		}
	}
}
