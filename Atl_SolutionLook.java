import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Atl_SolutionLook {
	/*
	 * Complete the function below.
	 */
	  
	  public static String lookAndSay(String number){
	  	StringBuilder result= new StringBuilder();
 
	  	char repeat= number.charAt(0);
	  	number= number.substring(1) + " ";
	  	int times= 1;
 
	  	for(char actual: number.toCharArray()){
	  		if(actual != repeat){
	  			result.append(times + "" + repeat);
	  			times= 1;
	  			repeat= actual;
	  		}else{
	  			times+= 1;
	  		}
	  	}
	  	return result.toString();
	  }

	

	    public static void main(String[] args) throws IOException{
			String num = "11";
			for (int i = 0; i < 2; i++) {
			 	num =  lookAndSay(num);
			}
	    }
	}