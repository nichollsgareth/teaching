import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HR_SolutionMth {

	/*For this question, you will write a program that, given a positive integer M 
	 * and a list of integers L, outputs the list element M links away from the end 
	 * of the list. For this program, we will use 1-indexing. That means mth_to_last(1) 
	 * is the "1st-to-last" element, or simply the last element in the list.*/
	
    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	try {
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String posStr = br.readLine();
	        String listStr = br.readLine();
	        List<String> items = Arrays.asList(listStr.split(" "));
	        int pos = (int) Integer.parseInt(posStr);
	        
	        if ((pos < 1) || (pos > items.size())) {
	        	System.out.println("NIL");
	        	return;
	        }
	        else {
	        	int offset = items.size() - pos;
	        	System.out.println(items.get(offset));
	        }
    	} 
    	catch (Exception e) {
    		throw e;
    	}
        
    }
}