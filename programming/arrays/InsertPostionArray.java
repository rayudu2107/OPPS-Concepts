package programming.arrays;

import java.util.Scanner;

public class InsertPostionArray {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Size");
		int n=s.nextInt();
		 int a[]=new int[n];
		System.out.println("enter the elements");
		for(int i=0;i<a.length;i++) {
			a[i]=s.nextInt();
		}
		System.out.println("enter the element to be insert");
		int ele=s.nextInt();
		System.out.println("enter the postion to be insert element");
		int p=s.nextInt();
		 int[]x=insertEle(a,ele,p);
		 printArr(x);
		 
	}
		static int[] insertEle(int[] a, int ele, int in) {
		    if (in < 0 || in > a.length) {
		        System.out.println("Index not in the range");
		        return a;
		    }
		    int[] x = new int[a.length + 1];
		    x[in]=ele;
		    for (int i = 0; i < a.length; i++) {
		        if (i < in) 
		            x[i] = a[i];
		            else 
		            x[i+1] = a[i];
		        }
		    return x;
		}
		static void printArr(int a[]) {
			for(int i=0;i<a.length;i++) {
				System.out.println(a[i]+"");
		}
	}
	}
