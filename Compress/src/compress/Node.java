package compress;

public class Node
{

	public char letter;
	
	public Node leftChild;
	public Node rightChild;
	public Node()
	{
		this.letter=0;
		this.leftChild=null;
		this.rightChild=null;
	}
	
	public Node(char letter)
	{
		this.letter=letter;
		this.leftChild=null;
		this.rightChild=null;
	}
}

