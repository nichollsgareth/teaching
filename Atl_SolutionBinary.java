import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Atl_SolutionBinary {

	private static final Hashtable<Integer, String> VALUEHASH = new Hashtable<Integer, String>() {{
		put(0, "0");
		put(1, "a");
		put(2, "t");
		put(3, "l");
		put(4, "s");
		put(5, "i");
		put(6, "n");
	 }};
	
 
		public static void convert(long input) {

			String output = "";
			long quotent; 
			long remainder;
			do {
				quotent = input / 7;
				remainder = input % 7;
				input = quotent;
				output = VALUEHASH.get((int)remainder) + "" + output;
			}while (quotent!=0);

			System.out.println(output);
		}	 
	 
    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	convert(610);
    }
}