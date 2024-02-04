package programming.arrays;

import java.util.Scanner;

public class MergeTwoArray {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Size two arrays");
		int n=s.nextInt();
		int m=s.nextInt();
		 int a[]=new int[n];
		 int b[]=new int[n];
		System.out.println("enter the elements first array ");
		for(int i=0;i<a.length;i++) {
			a[i]=s.nextInt();
		}
		System.out.println("enter the elements secand array");
		for(int i=0;i<a.length;i++) {
			b[i]=s.nextInt();
		}
		int[] y=merge(a,b);
		printArr(y);
		
	}
		static int[] merge(int[] a,int[] b) {
			int[] c = new int[a.length+b.length];
			for(int i=0;i<a.length;i++)
				c[i]=a[i];
			for(int j=0;j<b.length;j++)
				c[a.length+j]=b[j];
			return c;
		}
		static void printArr(int a[]) {
			for(int i=0;i<a.length;i++) 
				System.out.println(a[i]+"");
		}
	}

