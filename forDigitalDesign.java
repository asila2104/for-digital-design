import java.util.Scanner;

public class Main
{
    static int i = 0; // main counter for string indexes
    static char[] startString; // array for unpacked string
    
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		startString = scanner.nextLine().toCharArray();
		
		
		String newString = "";// <----- here will be the result
		
    	if (stringValidation(startString)) { // <----- validation
    	    while(i < startString.length) { 
    		    if (Character.isLetter(startString[i])) // <----- find and add letter in newString
    		        newString += startString[i];
    		        
    		    else if (Character.isDigit(startString[i])) // <----- repeat parts
                    newString += stringRepeat(); // <----- recursiive function
                    
                i++;
    		    }
		System.out.print("Final string is " + newString); // <----- result
    	}	
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
	
	public static boolean stringValidation(char[] str)
	{
	    int numOpen = 0; 
	    int numClose = 0;
	    for (int j = 0; j < str.length; j++)
	    {
	        if (str[j] == '[') // <----- for different number of brackets
	            numOpen++;
	        else if (str[j] == ']')
	            numClose++;
	            
	        if (Character.isDigit(str[j]) || Character.isLetter(str[j]) 
	            || str[j] == '[' || str[j] == ']') // <----- incorrect symbols
	            continue;
	        else {
	            System.out.println("Invalid character(s)");
	            return false;
	        }
 	    }
 	    if (numClose != numOpen)
 	    {
 	        System.out.println("The number of opening and closing brackets is NOT equal!");
 	        return false;
 	    }
 	    
 	    for (int j = 0; j < str.length-1; j++){ 
 	        if (str[j] == '[' && str[j+1] == ']') {
 	            System.out.println("Empty brackets!"); // <----- for empty brackets
 	            return false;
 	        }
 	        
 	        if (Character.isDigit(str[j]) && Character.isLetter(str[j+1]) || 
 	            Character.isDigit(str[str.length-1]) || 
 	            Character.isLetter(str[j]) && str[j+1] == '[') // <----- for missing numbers or brackets
 	        {
 	            System.out.println("NO number of repeats or missing brackets!");
 	            return false;
 	        }
 	    }
 	    
 	    return true; 
	}
}

