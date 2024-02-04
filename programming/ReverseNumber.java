package programming;

import java.util.Scanner;

public class ReverseNumber {
	static int reverse(int n) {
		int rev=0;
		while(n!=0)
		{
			int d=n%10;
			rev=rev*10+d;
			n=n/10;
		}
		return rev;
		
	}
	static int reversedo(int n) {
		int rev1=0;
		do{
			int d=n%10;
			rev1=rev1*10+d;
			n=n/10;
		}while(n!=0);
		return rev1;
	}
	
public static void main(String[] args) {
	Scanner  s=new Scanner(System.in);
	System.out.println("enter  the number");
	int  n=s.nextInt();
	int rev=reverse(n);
	int rev1=reversedo(n);
	System.out.println(n+"reverse of given nuber is "+rev);
	System.out.println(n+"reverse of given nuber is "+rev1);
}
}

