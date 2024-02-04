package programming.strings;

import java.util.Scanner;

public class AnagramOrNot {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter a two Strngs:\n ");
		String str1 = scan.nextLine();
		String str2 = scan.nextLine();
		boolean res = isAnagram(str1, str2);
		if (res)
			System.out.println("String is anagram");
		else
			System.out.println("String is not anagram");
	}

	static boolean isAnagram(String str1, String str2) {
		int[] ct1 = new int[26];
		for (int i = 0; i < str1.length(); i++) {
			char ch = str1.charAt(i);
			if (ch >= 'A' && ch <= 'Z')
				ct1[ch - 65]++;
			else if (ch >= 'a' && ch <= 'z')
				ct1[ch - 97]++;
		}
		int[] ct2 = new int[26];
		for (int i = 0; i < str2.length(); i++) {
			char ch = str2.charAt(i);
			if (ch >= 'A' && ch <= 'Z')
				ct2[ch - 65]++;
			else if (ch >= 'a' && ch <= 'z')
				ct2[ch - 97]++;
		}
		for (int i = 0; i < 26; i++) {
			if (ct1[i] != ct2[i])
				return false;
		}
		return true;
	}
}

