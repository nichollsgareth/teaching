import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HR_SolutionFibRecursive {

	/*The difference in this challenge is that each test case will consist of many inputs instead 
	 * of just one. Furthermore, we're allowing larger values of n. You'll need to use dynamic 
	 * programming to solve all the inputs without running out of time.*/
	
	//Use a hash table to determine if the number has been used.  Key is the number, value is the result
	private static Map<Integer, BigInteger> numbers = new HashMap<Integer, BigInteger>();
	
	public static BigInteger calculate(int n) {
	    if (n == 1 || n == 2) {
	        return BigInteger.ONE;
	    }
	    if (numbers.containsKey(n)) {
	        return numbers.get(n);
	    }
	    BigInteger v = calculate(n - 1).add(calculate(n - 2));
	    numbers.put(n, v);
	    return v;
	}	
	
    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	try {
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    	String posStr = null;
	    	BigInteger result = new BigInteger("0");
	    	while ((posStr = br.readLine()) != null) {

		    	int pos = (int) Integer.parseInt(posStr);
			        	
			    for (int i=1 ; i <= pos;i++) {
			    	result = calculate(i);
			    }
			    System.out.println(result);
			    
	    	}
    	} 
    	catch (Exception e) {
    		throw e;
    	}    	
    }
}