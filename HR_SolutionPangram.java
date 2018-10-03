import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HR_SolutionPangram {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	try {
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        //String sentence = br.readLine();
	    	String sentence = "We promptly judged antique ivory buckles for the next prize";
	    	char[] caSentence = (sentence.toLowerCase()).toCharArray();
	    	Arrays.sort(caSentence);
	    	sentence = String.valueOf(caSentence).trim();
	    	System.out.println(sentence);
	    	boolean isPangram = false;
	        for (int i = 97; i < 123; i++) {
	        	char letter = (char)i;
	        	if (sentence.contains(letter+"")) {
	        		isPangram = true;
	        	}
	        	else {
	        		isPangram = false;
	        		break;
	        	}
	        }
	        if (isPangram) {
	        	System.out.println("pangram");
	        }
	        else {
	        	System.out.println("not pangram");
	        }
    	} 
    	catch (Exception e) {

    	}
    }
}