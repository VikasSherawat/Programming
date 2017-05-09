package tree;

public class BST<E extends Comparable<E>> {

	@SuppressWarnings("hiding")
	private class Tree<E> {
		Tree<E> left;
		Tree<E> right;
		Tree<E> parent;
		int depth;
		E data;

		public Tree(E data, Tree<E> parent) {
			this.data = data;
			this.parent = parent;
		}
	}

	Tree<E> root;

	public void insert(E data) {
		if (root == null) {
			root = new Tree<E>(data, null);
			root.depth =1;
			root.parent = null;
		} else {
			if (data.compareTo(root.data) <= 0) {
				insert(root.left, data, root, false);
			} else
				insert(root.right, data, root, true);
		}
	}

	public void insert(Tree<E> node, E data, Tree<E> parent, boolean right) {
		if (node == null) {
			Tree<E> child = new Tree<E>(data, parent);
			child.depth = parent.depth+1;
			child.parent = parent;
			if (right) {
				parent.right = child;
			} else {
				parent.left = child;
			}
		} else {
			if (data.compareTo(node.data) <= 0) {
				insert(node.left, data, node, false);
			} else
				insert(node.right, data, node, true);
		}
	}
	public boolean delete(E data){
		if(root == null)
			return false;
		else if(search(data)){
			delete(root,data);
			return true;
		}else{
			return false;
		}
	}
	private void delete(Tree<E> root, E data) {
		// TODO Auto-generated method stub
		Tree<E> node = root;
		//searching for the node to be deleted
		while(node!=null){
			if(data.compareTo(node.data)<0)
				node  = node.left;
			else if(data.compareTo(node.data)>0)
				node  = node.right;
			else
				break;
		}
		//deleting node here
		if(node!=null){
			if(node.left==null && node.right==null){
				if(node.parent.left.data==node.data){ //node has no children
					node.parent.left=null;
				}else
					node.parent.right=null;
			}else if(node.left == null || node.right==null){ // node has one children
				if(node.left == null){ // node has only right child
					node.data = node.right.data;
					node.right = null;
				}else{
					node.data = node.left.data;
					node.left = null;
				}
			}else{ // node has two children
				Tree<E> minNode = findMinNode(node.right);
				node.data = minNode.data;
				if(minNode.parent.left.data==minNode.data){ 
					minNode.parent.left=null;
				}else
					minNode.parent.right=null;
			}
		}
	}

	private Tree<E> findMinNode(Tree<E> node) {
		// TODO Auto-generated method stub
			return node.left == null ? node : findMinNode(node.left);
	}

	public E getMinimum(){
		return getMinimum(root);
	}
	
	private E getMinimum(Tree<E> root) {

		if (root == null)
			return null;
		else {
			return root.left == null ? root.data : getMinimum(root.left);
		}
	}
	public E getMaximum(){
		return getMaximum(root);
	}

	private E getMaximum(Tree<E> root) {

		if (root == null)
			return null;
		else {
			return root.right == null ? root.data : getMaximum(root.right);
		}
	}

	public boolean search(E data) {
		if (root == null)
			return false;
		else
			return search(root, data);
	}

	private boolean search(Tree<E> node, E data) {
		// TODO Auto-generated method stub
		if (node == null)
			return false;
		
		if (data.compareTo(node.data) < 0)
			return search(node.left, data);
		else if (data.compareTo(node.data) > 0)
			return search(node.right, data);
		else
			return true;
	}

	public void inOrder() {
		// TODO Auto-generated method stub
		if (root == null) {
			System.out.println(-1);
		} else {
			inOrder(root);
		}

	}

	private void inOrder(Tree<E> root) {
		// TODO Auto-generated method stub
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
	}

	public void postOrder() {
		// TODO Auto-generated method stub
		if (root == null) {
			System.out.println(-1);
		} else {
			postOrder(root);
		}

	}

	public void postOrder(Tree<E> root) {
		// TODO Auto-generated method stub
		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + " ");
		}
	}

	public void preOrder() {
		// TODO Auto-generated method stub
		if (root == null) {
			System.out.println(-1);
		} else {
			preOrder(root);
		}

	}

	public void preOrder(Tree<E> root) {
		// TODO Auto-generated method stub
		if (root != null) {
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}

	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	public int height(){
		if(root==null){
			return 0;
		}else{
			return getHeight(root);
		}
	}

	private int getHeight(Tree<E> root) {
		// TODO Auto-generated method stub
		if(root==null)
			return 0;
		else
		return 1+Math.max(getHeight(root.left),getHeight(root.right));
	}
	
	public void printTree(){
		if(root==null)
		System.out.println("Tree is empty");
		else
			printTree(root);
		
	}

	private void printTree(Tree<E> root) {
		// TODO Auto-generated method stub
		if(root!=null){
			//String left = "Left children empty";
		
			String left = "Left children ";
			System.out.println("Parent Data:"+root.data);
			System.out.println(root.left==null?left+" empty":left+root.left.data);
			String right = "Right children ";
			System.out.println(root.right==null?right+" empty":right+root.right.data);
			if(root.left!=null)
				printTree(root.left);
			if(root.right!=null)
				printTree(root.right);
		}
	}
}
