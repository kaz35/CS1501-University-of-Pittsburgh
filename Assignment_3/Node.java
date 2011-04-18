public class Node
{
    private Node parent;
    private int position;
    private int weight;
    private int label;
    private int character;
	
	// Begin constructors ****************************
    public Node()
	{
        this.parent = null;
        position = 0;
        weight = 0;
        label = 0;
		character = -1;
    }
	
	public Node(int pos, Node par, int w, int l)
	{
		position = pos;
		parent = par;
		weight = w;
		label = l;
	}
	
	public Node(int pos, Node par, int w, int l, int c)
	{
		position = pos;
		parent = par;
		weight = w;
		label = l;
		character = c;
	}
	// End constructors ******************************
	
	// Begin accessor methods ************************
	public void setPosition(int pos){
		position = pos;
	}
	public void setWeight(int w){
		weight = w;
	}
	public void setLabel(int l){
		label = l;
	}
	public void setCharacter(int c){
		character = c;
	}
	public void setParent(Node par){
		parent = par;
	}
	// End accessor methods **************************
	
	// Begin mutator methods *************************
	public int getPosition(){
		return position;
	}
	public int getWeight(){
		return weight;
	}
	public int getLabel(){
		return label;
	}
	public int getCharacter(){
		return character;
	}
	public Node getParent(){
		return parent;
	}
	// End mutator methods ***************************
	
	// Methods for future use or debugging purposes.
	public String toString()
	{
		String output = "<" + position + "," + parent.getPosition() + "," + weight + "," + label + "," + character + ">";
		return output;
	}
}