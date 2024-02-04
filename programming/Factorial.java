package programming;

import java.util.Scanner;

public class Factorial {
	public static void main(String []args) {
		Scanner s=new Scanner(System.in);
		System.out.println("enter the number");
		long n=s.nextInt();
		long fac=1;
		for (int i = 1; i <=n; i++) {
			fac=fac*i;
		}
		System.out.println(fac);
		long res=fact(n);
		System.out.println(res);
	}
	static long fact(long n) {
		long fact=1;
		while(n!=0) {
			fact=fact*n;
			n--;
		}
		return fact;
	}
	}
