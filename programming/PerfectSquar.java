package programming;

import java.util.Scanner;

public class PerfectSquar {
	static boolean isperfect(int n) {
		int sum=0;
		for(int i=1;i<=n/2;i++) {
			if(n%i==0)
				sum=sum+i;
		}
		return sum==n;
	}
public static void main(String[] args) {
	Scanner s=new Scanner(System.in);
	System.out.println("enter the nuber");
	int n=s.nextInt();
	boolean res=isperfect(n);
}
}
/*
Example 1:

n = 9
Proper Divisors of 9 are 1 and 3.
Sum = 1+3 = 4 ≠ 9
⇒ 9 is not a perfect number.

Example 2:

n = 6
Proper Divisors of 6 are 1, 2 and 3.
Sum = 1+2+3 = 6 = 6
⇒ 6 is a perfect number.

Example 3:

n = 28
Proper Divisors of 28 are 1, 2, 4, 7 and 14.
Sum = 1+2+4+7+14 = 28 = 28
⇒ 28 is a perfect number.

Example 4:

n = 15
Proper Divisors of 15 are 1,3 and 5.
Sum = 1+3+5 = 9 ≠ 15
⇒ 15 is not a perfect number.
*/

