package programming.strings;

import java.util.Scanner;

public class FrequencyEachApla {
	public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a Sentence :\n ");
        String str = scan.nextLine();
        printFreuencyAlpa(str);
}
	 static void printFreuencyAlpa(String str) {
		
		int[]ct=new int[26];
		for(int i=0;i<str.length();i++) {
			char ch=str.charAt(i);
			if(ch>='A'&&ch<='Z')
				ct[ch-65]++;
			else if (ch>='a'&&ch<='z')
				ct[ch-97]++;
			}
			for(int i1=0;i1<26;i1++) {
				if(ct[i1]!=0)
					System.out.println((char)(i1+97)+"--->"+ct[i1]);
			}
		}
	}
