import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HR_SolutionFibLite {

	/*For this question, you will write a program that generates values from the 
	 * Fibonacci sequence. The Fibonnaci sequence is recursively defined by:*/
	
	public static int calculate(int number) {
		if (number == 1 || number == 2) {
			return 1;
		}
		
		return calculate(number -1) + calculate(number-2);
	}
	
    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	try {
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String posStr = br.readLine();
	        int pos = (int) Integer.parseInt(posStr);
	        int result = 0;
	        for (int i=1 ; i <= pos;i++) {
	        	result = calculate(i);
	        }
	        
	        System.out.println(result);
    	} 
    	catch (Exception e) {
    		throw e;
    	}    	
    }
}