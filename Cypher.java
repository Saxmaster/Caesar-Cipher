import java.util.Scanner; 
import java.util.Arrays;

/*********************************
*This is my attempt at writing a*
*program to make a Caesar cipher *
*TODO: Reduce to single method
*TODO: repeatable
*
*********************************/

public class Cypher
{
	private static final char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	private static final char[] alphCap = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	
	//Convert the lower alphabet to the shifted key
	private static char convertLower(char ch, int shift)
	{
		int index = Arrays.binarySearch(alphabet, ch); //returns #>0 if true, <0 if false
		
		if (index < 0)//Should character not be in alphabet
		{
			return ch;
		} 
		else //if it is
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
		/*
		 * For previous testing
		 * System.out.println(index);
		*/
		return alphabet[index];
	}
	
	//Same as convertLower
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
		String confirm;
		confirm = "no";
		//Just in case of a fail
		try(Scanner input = new Scanner(System.in))
			{
				do
				{	
				int shift;
				String message;
				
				System.out.print("Enter your shift key:");
				shift = input.nextInt();
		        System.out.print("Input the message to be converted: ");
		        message = input.nextLine(); //to skip the Enter ^
				message = input.nextLine();
				
				StringBuilder builder = new StringBuilder(); //allow the characters to change 1 at a time
				
				char c;
				for(int i=0; i < message.length(); i++)//move through every char in message
				{
					c = message.charAt(i);
					c = convertLower(c, shift);//order doesn't
					c = convertUpper(c, shift);//matter for these two
					builder.append(c); //add shifted to the new builder
				}
				System.out.println(builder.toString()); //output the final change
				
				System.out.print("Would you like to exit?: ");
				confirm = input.nextLine().toLowerCase();
				
			}while(confirm.equals("no"));
		}
    }
}
