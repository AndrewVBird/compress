package compress;

import java.util.*;

public class Huffman{

    public static void main(String[] args)
    {
       Scanner scan = new Scanner(System.in);
       
       System.out.print("Please enter your text ");
       String in = scan.nextLine();
       String ASCII="";
       double size=in.length()*7;
       double newSize=0;
       String newCode="";
       int[] freq = new int[256];
       PriorityQueue < Tree >  PQ = new PriorityQueue < Tree >();
       
       for(int i=0; i < in.length(); i++)
       {
           String binaryValue = Integer.toBinaryString((int)in.charAt(i));
           for(int j=7;j>binaryValue.length();j--)
           {
               ASCII+="0";
           }
           ASCII += binaryValue+" ";
       }
       System.out.println(ASCII);
       
       for(int i=0; i < in.length(); i++)
       {
           freq[(int)in.charAt(i)]++;  
       }
       
       for(int i=0; i<freq.length; i++)
       {
           if(freq[i]>0)
           {
                System.out.println("'"+(char)i+"' appeared "+freq[i]+((freq[i] == 1) ? " time" : " times"));
                Node newletter=new Node((char)i,freq[i]);
                Tree newTree=new Tree(newletter,freq[i]);
                insertTree(newTree,PQ);
            }
        }
       
        while(PQ.size()>1)
        {
        	Tree tempTree = new Tree();
        	tempTree.combine(PQ.poll(), PQ.poll());
        	insertTree(tempTree,PQ);
        }
        
        Tree HuffmanTree = PQ.poll();
        
        for(int i=0; i<freq.length; i++)
        {
            if(freq[i]>0)
            {
                System.out.println("'"+(char)i+"' is code "+HuffmanTree.getCode((char)i));
            }
        }
        
        for(int i=0; i < in.length(); i++)
        {
            String codeValue = HuffmanTree.getCode(in.charAt(i));
            newCode += codeValue+" ";
            newSize+=codeValue.length();
        }
        System.out.println(newCode);
        System.out.println("The new file is %" +(int)((newSize/size)*100) +" the size of the original file.");
        scan.close();
    }
    
    public static void insertTree(Tree tree,PriorityQueue < Tree > PQ)
	{
		if(PQ.size()==0)
		{
			PQ.add(tree);
		}
		else
		{
			Boolean done = true;
			PriorityQueue < Tree >  tempPQ = PQ;
			PriorityQueue < Tree >  storePQ = new PriorityQueue < Tree >() ;
			Tree current = new Tree();
			
			while(done)
			{
				current=tempPQ.peek();
				if(current==null)
				{
					tempPQ.add(tree);
					done=false;
				}
				else if(tree.frequency>current.frequency)
				{
					storePQ.add(tempPQ.poll());
				}
				else
				{
					tempPQ.add(tree);
					done=false;
				}
			}
			
			while(storePQ.size()!=0)
			{
				tempPQ.add(storePQ.poll());
			}
			PQ=tempPQ;
		}
	}
}