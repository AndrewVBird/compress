package compress;

public class Tree implements Comparable<Tree>
{
   public Node root;
   public int frequency=0;
   String path="";

   public Tree()
   {   
	   root = null; 
   }
   
   public Tree(Node root,int frequency)
   {
	   this.root=root;
	   this.frequency=frequency;
   }
   
   public void combine(Tree treeOne,Tree treeTwo)
   {
	   this.root = new Node();
	   this.root.leftChild=treeOne.root;
	   this.root.rightChild=treeTwo.root;
	   this.frequency=treeOne.frequency+treeTwo.frequency;
   }
   
   public int compareTo(Tree object)
   {
       if(frequency-object.frequency>0)
       {
           return 1;
       }
       else if(frequency-object.frequency<0)
       {
           return -1;
       }
       else
       {
            return 0;
       }
   }
   
   public String getCode(char letter){
	    String temp="";
		inOrder(letter,this.root,temp);
		return path;
	}
   
    public void inOrder(char letter,Node localRoot,String temp)
    {
    	if(localRoot != null)
	   	{
    		if(localRoot.letter==letter)
        	{
        		path=temp;
        	}
    		temp+=0;
		   	inOrder(letter,localRoot.leftChild,temp);
		   	temp=temp.substring(0,temp.length()-1)+1;
		   	inOrder(letter,localRoot.rightChild,temp);
	   	}
    }

}