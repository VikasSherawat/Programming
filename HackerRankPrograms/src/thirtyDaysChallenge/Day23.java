package thirtyDaysChallenge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}
public class Day23 {
	static void levelOrder(Node root){
	      //Write your code here
		List<Node> list = new ArrayList<Node>();
	      if(root!=null){
	    	  list.add(root);
	      }
	    	  //findOrder(list);
	      while(list.size()>0){
				Node node = list.get(0);
				if(node.left!=null)
					list.add(node.left);
				if(node.right!=null)
					list.add(node.right);
				System.out.print(node.data+" ");
				list.remove(0);
			}
	    }
	/*//input 6
	3
	5
	4
	7
	2
	1*/


	public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
            Scanner sc=new Scanner(System.in);
            int T=sc.nextInt();
            Node root=null;
            while(T-->0){
                int data=sc.nextInt();
                root=insert(root,data);
            }
           levelOrder(root);
            //System.out.println(root.data);
        }	
}
