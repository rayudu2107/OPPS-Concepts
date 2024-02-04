package programming.strings;

import java.util.Scanner;

public class PalindromeOrNot {
	public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the sentence:");
        String str = s.nextLine();
        boolean res = isPalindrome(str);
        if (res) {
            System.out.println("String is a palindrome.");
        } else {
            System.out.println("String is not a palindrome.");
        }
    }
    static boolean isPalindrome(String str) {
        String rev = new StringBuffer(str).reverse().toString();
        return str.equals(rev);
    }
}