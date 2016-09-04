import java.util.Scanner; 
import java.util.Arrays;

/*********************************
*This is my attempt at writing a*
*program to make a Caesar cipher *
*TODO: Reduce to single method
*TODO: Add numbers
*TODO: Add punctuation/ASCII
*TODO: repeatable
*
*********************************/

public class Cypher
{
	private static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	private static final char[] alphCap = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	
	private static char convertLower(char ch, int shift)
	{
		int index = Arrays.binarySearch(alphabet, ch);
		
		if (index < 0)
		{
			return ch;
		} 
		else 
		{
			index += shift;
			while (index >= alphabet.length)
			{
				index -= alphabet.length;
			}
			while (index < 0)
			{
				index += alphabet.length;
			}	
		}
		//System.out.println(index);
		return alphabet[index];
	}
	
	private static char convertUpper(char ch, int shift)
	{
		int index = Arrays.binarySearch(alphCap, ch);
		
		if (index < 0)
		{
			return ch;
		} 
		else 
		{
			index += shift;
			while (index >= alphCap.length)
			{
				index -= alphCap.length;
			}
			while (index < 0)
			{
				index += alphCap.length;
			}	
		}
		return alphCap[index];
	}
	
	public static void main(String[] args)
	{
		try(Scanner input = new Scanner(System.in))
		{
			int shift;
			String message;
			
			System.out.print("Enter your shift key:");
			shift = input.nextInt();
	        System.out.print("Input the message to be converted: ");
	        message = input.nextLine();
			message = input.nextLine();
			
			StringBuilder builder = new StringBuilder();
			
			char c;
			for(int i=0; i < message.length(); i++)
			{
				c = message.charAt(i);
				c = convertLower(c, shift);
				c = convertUpper(c, shift);
				builder.append(c);
			}
			System.out.println(builder.toString());
		}
    }
}
