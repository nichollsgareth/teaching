import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HR_SolutionFactoral {

	/*
	 * n factorial (written as n!) is the number we get when we multiply every 
	 * positive number from 1 up to n together. In this problem, your code will do 
	 * the grunt work of computing the factorial.
	 */
	public static int fact(int i, int pivot) {
		if (i == 0)
			return pivot;
		else 
			return fact( i -1, pivot * i);
	}
	
	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		else {
			return fact(n, 1);
		}
	}
	
	public static BigInteger fact(BigInteger i, BigInteger pivot) {
		if (i.equals(BigInteger.ZERO))
			return pivot;
		else 
			return fact( i.subtract(BigInteger.ONE) , pivot.multiply(i));
	}
	
	public static BigInteger factorial(BigInteger n) {
		if (n.equals(BigInteger.ZERO)) {
			return BigInteger.ONE;
		}
		else {
			return fact(n, BigInteger.ONE);
		}
	} 	
	
    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	try {
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String numStr = br.readLine();
	        int num = (int) Integer.parseInt(numStr);
	        	        	        
	        System.out.println(factorial(num));
    	} 
    	catch (Exception e) {
    		throw e;
    	}
        
    }
}