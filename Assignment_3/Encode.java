import java.util.*;
import java.io.*;

public class Encode
{
	public static int[] ascii = new int[256];
	
	public static void main (String[] args)
	{
		try
		{
			File inputfilename = new File(args[0]);
			FileReader reader = new FileReader(inputfilename);
			
			File outputfilename = new File(args[1]);
			FileWriter output = new FileWriter(outputfilename);
			
			int tempint;
			
			// Create a ASCII character array.
			for (int i = 0; i <256;i++)
			{
				ascii[i] = i;
			}
			
			// Read the next int into a temporary integer variable.
			tempint = reader.read();
			while(tempint != -1)
			{
				output.write(moveToFront(tempint) + " ");
				tempint = reader.read();
			}
			
			output.close();
			reader.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("You entered an invalid file name!");
		}
		catch (IOException e)
		{
			System.out.println("An IOException occured...uh oh.");
		}
	}
	
	public static int moveToFront(int charToMove)
	{
		int temporaryA;
		int temporaryB;
		int x = 0;
		
		temporaryA = ascii[0];
		// This loop only happens if the character is not already in the first position!
		while(temporaryA != charToMove)
		{
				temporaryB = ascii[x + 1];
				ascii[x + 1] = temporaryA;
				temporaryA = temporaryB;
				x++;
		}
		ascii[0] = charToMove;
		
		return x;
	}
}