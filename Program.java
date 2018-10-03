
public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello World");
	}
	
	public static String getDecentNumber(int number) {

		String output = null;
		int max_div, num5s, num3s;
		
		//Remove edge cases
		if ((number == 0) || (number < 3)) {
			return writeOut(0, 0);
		}
		else if (number == 3) {
			return writeOut(1,0);
		}
		else if (number == 5) {
			return writeOut(0,1);
		}
		
		num5s = number / 5;
		int remainder = number - (num5s * 3);
		num3s = remainder / 3;
		remainder = number - (num5s * 3) - (num3s * 5);
		if (remainder > 0 ) {
			return "-1";
		}
		else {
			  return writeOut(num5s, num3s);
		}
	}	
	
    private static String writeOut(int fives, int threes) {
    	String fStr = "555";
    	String tStr = "33333";
    	String output = "";
    	
    	if ((fives == 0) && (threes == 0)) {
    		return "-1";
    	}
    	
    	for (int i = 0; i < fives; i++) {
    		output = output + fStr;
    	}
    	for (int i = 0; i < threes; i++) {
    		output = output + tStr;
    	}
    	
    	return output;
    }	

}
