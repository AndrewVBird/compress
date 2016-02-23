package compress;

public class Node
{

	public char letter;
	int freq;
	
	public Node leftChild;
	public Node rightChild;
	public Node parent;
	public Node()
	{
		this.letter=0;
		this.freq=0;
		this.leftChild=null;
		this.rightChild=null;
		this.parent=null;
	}
	
	public Node(char letter,int freq)
	{
		this.letter=letter;
		this.freq=freq;
		this.leftChild=null;
		this.rightChild=null;
		this.parent=null;
	}
}

