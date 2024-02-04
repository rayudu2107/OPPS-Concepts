package programming.strings;

import java.util.Scanner;

public class ReverseWard {
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
    for(int i=0;i<ch.length;i++)
    {
    	int f=i;
    	while(i<ch.length&&ch[i]!=' ')
    	{
    		i++;
    	}
    	int l=i-1;
    	while(l>=f)
    	{
    		res=res+ch[l];
    		l--;
    	}
    	if(i<ch.length)
    		res=res+ch[i];
    }
	return res;
}
}
