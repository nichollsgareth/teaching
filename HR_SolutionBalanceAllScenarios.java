import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;
class HR_SolutionBalanceAllScenarios{

	/*
	 * A balanced delimiter starts with an opening character ((, [, {), 
	 * ends with a matching closing character (), ], } respectively), 
	 * and has only other matching delimiters in between. A balanced delimiter 
	 * may contain any number of balanced delimiters.
	 */	
    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);
        String input = "{}({()})";
        Stack stack = new Stack();
        boolean isValid = true;
        for (int i = 0; i < input.length(); i++) {
        	try {
	        	String chr = input.charAt(i)+"";
	        	String cpr = "";
	        	switch (chr) {
		        	case "(": 
		        	case "{": 
		        	case "[": 
		        		stack.push(chr);
		        		break;
		        	case ")": 
		        		cpr = (String)stack.pop();
		        		if (!cpr.equals("(")) {
		        			isValid = false;
		        		}
		        		break;
		        	case "}":
		        		cpr = (String)stack.pop();
		        		if (!cpr.equals("{")) {
		        			isValid = false;
		        		}	        		
		        		break;
		        	case "]":
		        		cpr = (String)stack.pop();
		        		if (!cpr.equals("[")) {
		        			isValid = false;
		        		}	        		
		        		break;
		        	default:
		        		isValid = false;
	        	}
        	}
        	catch(Exception e) {
        		isValid =false;
        	}        	
        	if (isValid == false) {
        		break;
        	}
        }
        
        if (!stack.isEmpty()) {
        	isValid = false;
        }
        
        System.out.println(isValid);

    }


}
