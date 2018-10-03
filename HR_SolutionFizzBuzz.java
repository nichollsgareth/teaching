import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HR_SolutionFizzBuzz {

	/*
	 * Write a program that, given a number n from STDIN, prints out all numbers from 1 to n (inclusive) 
	 * to STDOUT, each on their own line. But there's a catch:

		For numbers divisible by 3, instead of n, print Fizz
		For numbers divisible by 5, instead of n, print Buzz
		For numbers divisible by 3 and 5, just print FizzBuzz
		For example, given the input 1, your program should output:
	 */
    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	try {
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        //String numberStr = br.readLine();
	    	String numberStr = "15";
	        int num = (int) Integer.parseInt(numberStr);
	        for (int i = 1; i <= num; i++) {
	        	if ((i % 3 == 0) && (i % 5 == 0)) {
	        		System.out.println("FizzBuzz");
	        	}
	        	else if ((i % 3 == 0))
	        	{
	        		System.out.println("Fizz");
	        	}
	        	else if (i % 5 == 0) {
	        		System.out.println("Buzz");
	        	}
	        	else {
	        		System.out.println(i);
	        	}
	        }
    	} 
    	catch (Exception e) {
    		throw e;
    	}
        
    }
}