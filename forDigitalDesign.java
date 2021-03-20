import java.util.Scanner;

public class Main
{
    static int i = 0; // main counter for string indexes
    static char[] startString; // array for unpacked string
    
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		startString = scanner.nextLine().toCharArray();
		
		
		String newString = "";// <----- here will be the result
		
		while(i < startString.length) { 
		    if (Character.isLetter(startString[i])) // <----- find and add letter in newString
		        newString += startString[i];
		        
		    else if (Character.isDigit(startString[i])) // <----- repeat parts
                newString += stringRepeat(); // <----- recursiive function
                
            i++;
		    }
		
		System.out.print("Final string is " + newString); // <----- result
	}
	public static String stringRepeat() {
	    String repeat = "";
	    String result = "";// <----- strings for inner repeats, result and number of repeats
	    String number = "";
	    
	    while (Character.isDigit(startString[i])) // <----- find number
		{
		    number += startString[i];
		    i++;
		}
		
		i++; 
		
	    while (startString[i] != ']') 
	    {
	        if (Character.isLetter(startString[i])) // <----- repeat partts
    	        repeat += startString[i];
    	        
	        else if (Character.isDigit(startString[i])) // <----- inner repeat (recursion)
	            repeat += stringRepeat();
    
    	    i++;
	    }
	    
	    for (int j = 0; j < Integer.parseInt(number); j++) // <----- we need repeats
	        result += repeat;
	        
	    return result;
	}
}

