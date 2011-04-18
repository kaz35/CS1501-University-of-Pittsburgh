//WeightedGraph
//MGJ7. CS1501.

import java.util.LinkedList;
import java.util.ArrayList;

public class WeightedGraph
{
	private LinkedList<WeightedEdge>[] vertices;
	private int numVertices;
	private int numEdges;
	private int[] dada;
	
	public WeightedGraph(int INTIAL_CAPACITY)
	{
		vertices = new LinkedList[INTIAL_CAPACITY];
		numVertices = 0;
		numEdges = 0;
	}
	
	public WeightedGraph()
	{
		vertices = new LinkedList[10];
		numVertices = 0;
		numEdges = 0;
	}
	
	public int getNumVertex()
	{
		return numVertices;
	}
	
	public int getNumEdges()
	{
		return numEdges;
	}
	
	private LinkedList<WeightedEdge>[] doubleArray()
	{
		LinkedList<WeightedEdge>[] Newvertices = new LinkedList[2 * vertices.length];
		System.arraycopy(vertices, 0, Newvertices, 0, vertices.length);
		//System.out.println("Old size: " + vertices.length);
		return Newvertices;
	}
	
	public LinkedList<WeightedEdge> getAdjacent(int vertex)
	{
		return vertices[vertex];
	}
	
	public void addVertex(int vert)
	{
		if (vert >= vertices.length)
		{
			vertices = doubleArray();
			vertices[vert] = new LinkedList();
			numVertices++;
		}
		else if (vertices[vert] == null)
		{
			vertices[vert] = new LinkedList();
			numVertices++;
		}
	}
			
	
	public void addEdge(int source, int dest, int w)
	{
		if ((source >= vertices.length) || (vertices[source] == null))
			addVertex(source);
		if ((dest >= vertices.length) || (vertices[dest] == null))
			addVertex(dest);
		
		vertices[source].addFirst(new WeightedEdge(dest,w));
		numEdges++;
	}
	
	public String toString()
	{
		String tempString = "\n";
		
		tempString += "V = " + numVertices;
		tempString += "\nE = " + numEdges + "\nEdges:";
		
		
		for (int i = 0; i < numVertices;i++)
		{
			tempString += "\n" + i + ": ";
			for (int j = 0; j < vertices[i].size();j++)
			{
				tempString += vertices[i].get(j);
			}
			//Debug
			//if (i >= 653)
				//System.out.println(i);
		}
		return tempString;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int[] Dijkstra(WeightedGraph G, int start)
	{
		TaggedBinaryHeap PQ = new TaggedBinaryHeap(G.getNumVertex());
		LinkedList<WeightedEdge> tempAdjList = new LinkedList();
		
		int[] val = new int[G.getNumVertex()];
		boolean[] unseen = new boolean[G.getNumVertex()];
		int[] dad = new int[G.getNumVertex()];
		
		WeightedEdge tempEdge;
		WeightedEdge tempEdgeB;
		
		int v;
		int priority;
		int x;
		int weightVtoX;
		
		// STEP ONE ------------
		PQ.insert(start,0);
		// ---------------------
		
		
		// STEP TWO ------------
		for (int i = 0; i < G.getNumVertex();i++)
		{
			val[i] = 0;
			unseen[i] = true;
		}
		dad[start] = start;
		// ---------------------
		
		
		while(!PQ.isEmpty())
		{
			
			
			tempEdge = PQ.remove();
			v = tempEdge.getDest();
			
			priority = tempEdge.getWeight();
			
			// Mark v as seen
			unseen[v] = false;
			
			val[v] = priority;
			
			tempAdjList = getAdjacent(v);
			
			//for each unseen neighbor x of v
			while(tempAdjList.peekFirst() != null)
			{
				tempEdgeB = tempAdjList.pollFirst();
				
				x = tempEdgeB.getDest();
				weightVtoX = tempEdgeB.getWeight();
				
				if (unseen[x])
				{
					if (!PQ.contains(x))
					{
						PQ.insert(x,val[v] + weightVtoX);
						
						//PQ.insert(x, val[v] + tempAdjList.get(x).getWeight());
						
						val[x] = -(val[v] + weightVtoX);
						dad[x] = v;
					}
					else
					{
						//System.out.println("Got to ELSE = val[v] + weightVtoX) = " + (val[v] + weightVtoX) + " ..and.. -(val[PQ.getPlace(x)]) = " + (-(val[PQ.getPlace(x)])));
						if ((val[v] + weightVtoX) < -(val[x]))
						{
							
							val[x] = -(val[x]);
							//System.out.println("x is = " + x + " and val[x] = " + val[x]);
							
							PQ.change(x, (val[v] + weightVtoX));
							dad[x] = v;
							//System.out.println("dad[x] is = " + dad[x]);
						}
					}
				}
			}
		
		}
	dada = dad;
	return val;
	
	}
	
	public ArrayList getPath (int s, int e)
	{
		final ArrayList path = new ArrayList();
		int x = e;
		while (x!=s)
		{
			path.add (0, x);
			x = dada[x];
		}
		path.add (0, s);
		return path;
	}
	
	
	
	
	
	
	
}