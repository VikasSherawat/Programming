package tree;

import java.util.*;

import tree.Tree;

class Node {
    int data;
    Node left;
    Node right;
 }

public class IsBST {
	 boolean checkBST(Node root) {
	        List<Integer> list = new ArrayList<Integer>();
	        inOrder(root,list);
	        for(int i =1;i<list.size();i++){
	            if(list.get(i)<=list.get(i-1))
	                return false;
	        }
	        return true;
	    }

	    public void inOrder(Node root,List<Integer> list) {
			// TODO Auto-generated method stub
			if (root != null) {
				inOrder(root.left,list);
				//System.out.print(root.item + " ");
	            list.add(root.data);
				inOrder(root.right,list);
			}
			

		}
}
