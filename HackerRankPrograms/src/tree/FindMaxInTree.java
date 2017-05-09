package tree;

import java.util.*;
import tree.Tree;
public class FindMaxInTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {6,3,4,8,2,7,9};
		Tree root =null;
		for (int i = 0; i < arr.length; i++) {
			root = Tree.insert(arr[i],root);
		}
		int max=findMaxEle(root);
	}

	public static int findMaxEle(Tree root) {
		// TODO Auto-generated method stub
		int max=-1;
		while(true){
			break;
		}
		return max;
	}

}
