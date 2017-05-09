package tree;

import java.util.*;

public class Miscellaneous {
	
		static boolean printAncesstor(Tree root, int item,List<Integer> list){
		if(root == null)
				return false;
		if(root.data==item){
			list.add(root.data);
			return true;
		}
		else{
			if(printAncesstor(root.left,item,list)){
				list.add(root.data);
				return true;
			}
			if(printAncesstor(root.right,item,list)){
				list.add(root.data);
				return true;
			}
		}
		return false;
	}
	

	static Tree buildTree(int[] inorder, List<Integer> preorder,int start, int end){
		if(start>end)
			return null;

		int rootEle = preorder.get(0); 
		int eleIndex = findIndex(inorder,rootEle);
		preorder.remove(0);
		Tree tree = new Tree(rootEle);
		tree.data = rootEle;
		tree.left = buildTree(inorder,preorder,start,eleIndex-1);
		tree.right = buildTree(inorder,preorder,eleIndex+1,end);
		return tree;

	}

	static int findIndex(int[] inorder, int rootEle){
		for(int i =0; i<inorder.length;i++){
			if(inorder[i]==rootEle)
				return i;
		}
		return -1;
	}
	static void reverseTree(Tree root){
		if(root==null)
			return;
		if(root.left!=null && root.right!=null){
			reverseTree(root.left);
			reverseTree(root.right);
			Tree temp;
			temp = root.left;
			root.left = root.right;
			root.right = temp;
		}
	}
		static boolean hasSum(Tree root, int sum){
		if(root==null)
		return false;
		else{
			int remainingSum = sum-root.data;
			if(remainingSum==0)
				return true;
			return(hasSum(root.left, remainingSum)|| hasSum(root.right, remainingSum));
		}
	}
	static void printPath(Tree root,List<Integer> list){
		if(root == null)
			return;
		list.add(root.data);
		if(root.left==null && root.right == null){
			printList(list);
			list.remove(list.size()-1);
		}else{
			printPath(root.left,list);
			printPath(root.right,list);
			list.remove(list.size()-1);
		}
		
	}

	private static void printList(List<Integer> list) {
		// TODO Auto-generated method stub
		for(Integer i: list){
			System.out.print(i+" ");
		}
		System.out.println();
	}
}
