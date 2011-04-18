//WeightedEdge
//MGJ7. CS1501.

public class WeightedEdge
{
	private int destination;
	private int weight;
	
	public WeightedEdge(int dest, int w)
	{
		destination = dest;
		weight = w;
	}
	
	public int getDest()
	{
		return destination;
	}
	
	public int getWeight()
	{
		return weight;
	}
	
	public void setWeight(int w)
	{
		weight = w;
	}
	
	public String toString()
	{
		String tempString = "<" + destination + ":" + weight + ">";
		
		return tempString;
	}
	
}