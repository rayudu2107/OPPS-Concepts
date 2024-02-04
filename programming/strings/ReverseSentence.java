package programming.strings;

import java.util.Scanner;

public class ReverseSentence {
	 public static void main(String args[]) {
	        Scanner scan = new Scanner(System.in);
	        System.out.print("Enter a sentence:\n");
	        String str = scan.nextLine();
	        String res = reverseWord(str);
	        System.out.println("Modified sentence: " + res);
	    }

	 static String reverseWord(String str) {
		 char[]ch=str.toCharArray();
	        String res="";
	        for(int i=ch.length-1;i>=0;i--)
	        {
	        	int l=i;
	        	while(i>=0&&ch[i]!=' ')
	        	{
	        		i--;
	        	}
	        	int f=i+1;
	        	while(f<=l)
	        	{
	        		res=res+ch[f];
	        		f++;
	        	}
	        	if(i>=0)
	        		res=res+ch[i];
	        }
			return res;
	}
}


