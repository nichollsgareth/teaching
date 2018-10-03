import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	Scanner sc = new Scanner(System.in);
        int numberCount = sc.nextInt();
        
    	int[] arr = new  int[numberCount];
        for (int n = 0; n < numberCount; n++) {
        	int number = sc.nextInt();
        	int count = arr[number] + 1;
        	arr[number] = count;
        }

        for (int i: arr) {
        	System.out.print(i + " ");
        }
    }
}