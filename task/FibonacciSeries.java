package task;
import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        int n, f1 = 0, f2 = 1;
        Scanner s = new Scanner(System.in);
        System.out.print("Enter value of n: ");
        n = s.nextInt();
        System.out.print("Fibonacci Series: ");
        for (int i = 1; i <= n; i++) {
            System.out.print(f1 + " ");
            int sum = f1 + f2;
            f1 = f2;
            f2 = sum;
        }
    }
}
