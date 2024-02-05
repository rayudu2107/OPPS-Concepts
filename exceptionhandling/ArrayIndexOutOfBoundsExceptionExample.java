package exceptionhandling;

public class ArrayIndexOutOfBoundsExceptionExample {
	public static void main(String[] args) {
		int a[]= {10,20,30,40};
		System.out.println("start");
		try {
		System.out.println(a[9]);
		}
		catch(ArithmeticException e){
			System.out.println("do not divisable by zero");
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Invalid index");
		}
		System.out.println("end");
	}
}
