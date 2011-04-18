import java.util.*;
import java.io.*;

public class Decode
{
	public static int[] ascii = new int[256];
	
	public static void main (String[] args)
	{
		try
		{
			File filename = new File(args[0]);
			Scanner reader = new Scanner(filename);
			
			int tempint;
			String output = "";
			
			// Create a ASCII character array.
			for (int i = 0; i <256;i++)
			{
				ascii[i] = i;
			}
			
			// Read the next int into a temporary integer variable.
			while(reader.hasNext())
			{
				tempint = reader.nextInt();
				output += (char)moveToFront(tempint);
			}
			
			System.out.println(output);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("You entered an invalid file name!");
		}
	}
	
	public static int moveToFront(int positionOfChar)
	{
		int temporaryA = 0;
		int temporaryB = ascii[positionOfChar];
		
		for (int i = positionOfChar;i > 0;i--)
		{
			temporaryA = ascii[i];
			ascii[i] = ascii[i - 1];
		}
		
		ascii[0] = temporaryB;
		return temporaryB;
	}
}