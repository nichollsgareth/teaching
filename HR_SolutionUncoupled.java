import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HR_SolutionUncoupled {

	/*Find the only uncoupled integer in an array.*/
    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	try {
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        //String listStr = br.readLine();
	    	String listStr = "1, 2, 3, 4, 5, 3, 1, 2, 3, 3, 4, 5";
	        List<String> items = Arrays.asList(listStr.split(", "));
	        int result = 0;
	        for (String value: items) {
	        	int number = (int) Integer.parseInt(value);
	        	result ^= number;
	        }
	        
	        System.out.println(result);
    	} 
    	catch (Exception e) {
    		throw e;
    	}
    }
}