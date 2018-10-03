import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HR_SolutionBalanceNotAllScenarios {

	/*
	 * A balanced delimiter starts with an opening character ((, [, {), 
	 * ends with a matching closing character (), ], } respectively), 
	 * and has only other matching delimiters in between. A balanced delimiter 
	 * may contain any number of balanced delimiters.
	 */
    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	try {
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    	Map<String, String> combo = new HashMap<String, String>();
	    	//Hardcoded values, not too  great, but time wise lets just do it
	    	combo.put("(", ")");
	    	combo.put("[", "]");
	    	combo.put("{", "}");
	        String listStr = br.readLine();
	        	        
	        if (listStr.length() % 2 != 0) {
	        	System.out.println("False");
	        	return;
	        }
	        
	        int length = listStr.length();
	        for (int i = 0; i < (length / 2); i++) {
	        	String key = (listStr.charAt(i))+"";
	        	String value = combo.get(key);
	        	if (value != null) {
		        	if (!(value.equals( listStr.charAt((length - 1) - i)+"" ))) {
		        		System.out.println("False");
		        		return;
		        	}
	        	}
	        }
	        
	        System.out.println("True");
	        
    	} 
    	catch (Exception e) {
    		throw e;
    	}    	
    }
}