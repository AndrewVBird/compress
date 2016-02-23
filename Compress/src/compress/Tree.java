package compress;

import java.io.*;
import java.util.*;

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
	   Node newRoot = new Node();
	   newRoot.freq=treeOne.frequency+treeTwo.frequency;
	   newRoot.leftChild=treeOne.root;
	   newRoot.rightChild=treeTwo.root;
	   newRoot.leftChild.parent=newRoot;
	   newRoot.rightChild.parent=newRoot;
	   this.root=newRoot;
	   this.frequency=treeOne.frequency+treeTwo.frequency;
   }
   
   public int compareTo(Tree object){
       if(frequency-object.frequency>0){
           return 1;
        }else if(frequency-object.frequency<0){
           return -1;
        }else{
            return 0;
        }
   }

   public String getCode(char letter){
	    path="";
		inOrder(letter,this.root);
		return path;
	}
   
	public String inOrder(char letter,Node root)
	{
		if(root.letter==0)
		{
			path+="0";
			inOrder(letter,root.leftChild);
		}
		else if(root.letter!=letter)
		{
			path=path.substring(0,path.length()-1)+"1";
			inOrderRight(letter,root.parent.rightChild);
		}
		return path;
	}
	
	public String inOrderRight(char letter,Node root)
	{
		if(root.letter==0)
		{
			path+="0";
			inOrder(letter,root.leftChild);
		}
		else if(root.letter!=letter)
		{
			path=path.substring(0,path.length()-2)+"1";
			inOrderRight(letter,root.parent.parent.rightChild);
		}
		return path;
	}

}