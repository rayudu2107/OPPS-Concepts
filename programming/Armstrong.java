package programming;

import java.util.Scanner;

public class Armstrong {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number");
		int n = s.nextInt();
		boolean res = isArmStrong(n);
		if (res)
			System.out.println(n + " is an armstrong");
		else
			System.out.println(n + " not an armstrong");
	}
	static boolean isArmStrong(int n) {
		int sum=0,temp=n;
		int dc=countDigits(n);
		do {
			int d=n%10;
			sum=sum+pow(d,dc);
			n=n/10;
		}while(n!=0);
		return sum==temp;
	}
	static int countDigits(int n) {
		int count=0;
		do {
			n=n/10;
			count++;
		}while(n!=0);
		return count;
	}
	static int pow(int n,int p) {
		int prod=1;
		while(p>0) {
			prod=prod*n;
			p--;
		}
		return prod;
	}
	}
	/*
	 * Input : 153
	Output : Yes
	153 is an Armstrong number.
	1*1*1 + 5*5*5 + 3*3*3 = 153

	Input : 120
	Output : No
	120 is not a Armstrong number.
	1*1*1 + 2*2*2 + 0*0*0 = 9

	Input : 1253
	Output : No
	1253 is not a Armstrong Number
	1*1*1*1 + 2*2*2*2 + 5*5*5*5 + 3*3*3*3 = 723

	Input : 1634
	Output : Yes
	1*1*1*1 + 6*6*6*6 + 3*3*3*3 + 4*4*4*4 = 1634
	 */
