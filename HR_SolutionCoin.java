import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class HR_SolutionCoin {

	/*
	 * How many different ways can you make change for an amount, given a 
	 * list of coins? In this problem, your code will need to efficiently 
	 * compute the answer.
	 */
	
	public static int minChange(String[] denom, int targetAmount) {
		int[][] solution = new int[denom.length + 1][targetAmount + 1];

		// if target = 0 then just return empty set
		for (int i = 0; i <= denom.length; i++) {
			solution[i][0] = 1;
		}

		// if no coins given no way to make the change
		for (int i = 1; i <= targetAmount; i++) {
			solution[0][i] = 0;
		}

		for (int i = 1; i <= denom.length; i++) {
			for (int j = 1; j <= targetAmount; j++) {
				// check if the coin value is less than the amount needed
				int temp = Integer.parseInt(denom[i - 1]);
				if (temp <= j) {
					// reduce the amount by coin value and
					// use the subproblem solution (amount-v[i]) and
					// add the solution from the top to it
					solution[i][j] = solution[i - 1][j]
							+ solution[i][j - temp];
				} else {
					// just copy the value from the top
					solution[i][j] = solution[i - 1][j];
				}
			}
		}
		return solution[denom.length][targetAmount];
	}	
	
    public static void main(String[] args) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	try {
	    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String moneyList = br.readLine();
	        String changeList = br.readLine();
	        
	                
	        List<String> values = Arrays.asList(moneyList.split(" "));
	        List<String> change = Arrays.asList(changeList.split(" "));

	        int value = Integer.parseInt(values.get(0));
	        int offset = Integer.parseInt(values.get(1));
	        if ((offset == 0)||(value ==0)) {
	        	System.out.println(0);
	        	return;
	        }
	        int amount = minChange((String[])change.toArray(), value);
	        
	        System.out.println(amount);
	        
    	} 
    	catch (Exception e) {
    		throw e;
    	}
        
    }
}