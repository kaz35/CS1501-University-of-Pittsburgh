//LGDriver
//MGJ7. CS1501.

import java.util.Scanner;
import java.io.*;
import java.math.*;

public class LGDriver
{
	public static void main (String[] args) throws FileNotFoundException
	{
		String temps,tempd;
		int tempw;
		LabeledGraph G = new LabeledGraph();
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the file name: ");
		String filename = input.nextLine();
		
		
		File inputfile = new File(filename);
		Scanner inputfilescan = new Scanner(inputfile);
		
		while(inputfilescan.hasNext())
		{
			temps = inputfilescan.next();
			tempd = inputfilescan.next();
			tempw = inputfilescan.nextInt();
			
			
			G.addVertex(temps);
			G.addEdge(temps,tempd,tempw);
					
					
		}
		
		System.out.println(G);
		
		System.out.print("\nDijkstras Shortest Path algorithm requires a start vertex: ");
		tempw = input.nextInt();
		
		System.out.println(G.Dijkstra(tempw));
		
		
	}
}