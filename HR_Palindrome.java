import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HR_Palindrome {

	public static boolean isPalindrome(String input) {

		int left = 0;
		int right = input.length() -1;

		while (right > left) {
			if (input.charAt(left) != input.charAt(right)) {
				return false;
			}
			++left;
			--right;
		}
		return true;
	}

	public static boolean isPalindromeSentence(String sentence) {

			if ((sentence == null) || (sentence.length() == 0)) {
				return false;
			}
			sentence = sentence.toLowerCase();
	        String reverseSentence = "";

	        Stack<Character> stack = new Stack<Character>();

	        for (int i = 0; i < sentence.length(); i++) {
	            stack.push(sentence.charAt(i));
	        }

	        while (!stack.isEmpty()) {
	            reverseSentence += stack.pop();
	        }

	        if (sentence.equals(reverseSentence))
	            return true;
	        else
	            return false;
	}

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();
        //int testCases = 1;
        sc.nextLine();
        for (int t = 0; t < testCases; t++) {
        	String str = sc.nextLine();
        	//String str = "abba";
        	boolean isPal = false;
        	int position = -1;
        	while (isPal == false) {
        		if (position == str.length()) {
        			position = -1;
        			break;
        		}
        		if (position >= 0) {
        			StringBuilder sb = new StringBuilder(str);
        			sb.deleteCharAt(position);
        			isPal = isPalindrome(sb.toString());
        		}
        		else {
        			isPal = isPalindrome(str);
        		}

    			if (isPal) {
    				//position = position -1;
        			if (position < 0) {
        				position = -1;
        			}
    				break;
    			}
        		position++;
        	}

        	System.out.println(position);
        }
    }
}