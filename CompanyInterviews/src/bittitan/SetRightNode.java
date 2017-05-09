package bittitan;

import java.util.*;
import java.util.Queue;

class Node
{
    public Node[] Children;
    public Node Right;
    public int data;
}


public class SetRightNode {

public static void main(String[] args) {
	//Node root = new Node();
	Node root = createTree();
	root = setRight(root);
	printTree(root);
}

private static void printTree(Node root) {
	// TODO Auto-generated method stub
	
	Queue<Node> queue = new ArrayDeque<Node>();
	queue.add(root);
	
	while(!queue.isEmpty()){
		Node n = queue.remove();
		if(n.Right!=null)
			System.out.println("Node:"+n.data+" its right siblinig is:"+n.Right.data);
		else
			System.out.println("Node:"+n.data+" its right siblinig is null ");
		if(n.Children==null)
			continue;
		for(int i = 0;i<n.Children.length;i++){
			queue.add(n.Children[i]);
		}
	}
	
}

private static Node createTree() {
	// TODO Auto-generated method stub
	Node root = new Node();
	root.data = 1;
	Node[] children = new Node[3];
	int count = 0;
	for(int i = 2;i<=4;i++){
		Node n = new Node();
		n.data = i;
		children[count++] = n;
	}
	root.Children = children;
	
	children = new Node[2];
	count = 0;
	for(int i = 5;i<=6;i++){
		Node n = new Node();
		n.data = i;
		children[count++] = n;
	}
	root.Children[0].Children = children;
	
	
	
	
	children = new Node[1];
	count = 0;
	for(int i = 10;i<=10;i++){
		Node n = new Node();
		n.data = i;
		children[count++] = n;
	}
	root.Children[2].Children = children;
	
	return root;
}

private static Node setRight(Node root) {
	// TODO Auto-generated method stub
	if(root == null)
		return null;
	
	Queue<Node> queue = new ArrayDeque<Node>();
	queue.add(root);
	
	Node orgRoot = root; 
	Node prevSibling = orgRoot;
	
	while(queue.size()>0){
		Node node = queue.remove();
		Node[] children = node.Children;
		if(children == null)
			continue;
		//
		
		for (int i = 0; i < children.length-1; i++) {
			Node curr = children[i]; 
			curr.Right = children[i+1];
			if(prevSibling.Right==null && depth(root,prevSibling,0)==depth(root,curr,0)){
				prevSibling.Right = curr;
			}
			prevSibling = curr;
			queue.add(curr);
		}
		node = children[children.length-1];
		if(prevSibling.Right==null && depth(root,prevSibling,0)==depth(root,node,0)){
			prevSibling.Right = node;
		}
		queue.add(node);
		prevSibling = node;
		
	}
	
	return orgRoot;
}

private static int depth(Node root, Node curr, int depth) {
	// TODO Auto-generated method stub
	if(root.equals(curr))
		return depth;
	else{
	if(root.Children==null)
		return -1;
	int cDepth = depth;
	int d = -1;
	Node[] children = root.Children;
	for(int i =0;cDepth == depth && i< children.length;i++ )
	{
		d = depth(children[i],curr,depth+1);
		if(d !=-1)
			cDepth = d;
	}

		
	return d;
	}
}


}
