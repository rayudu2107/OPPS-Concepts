package programming.arrays;

import java.util.Scanner;

public class NumberOfOddEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of array:");
        int n = scanner.nextInt();
        int[] ar = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < ar.length; i++) {
            ar[i] = scanner.nextInt();
        }
        int[] count = countEvenOdd(ar);
        System.out.println("Count of even numbers: " + count[0]);
        System.out.println("Count of odd numbers: " + count[1]);
    }

    static int[] countEvenOdd(int[] arr) {
        int evenCount = 0, oddCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        int[] count = {evenCount, oddCount};
        return count;
    }
}
