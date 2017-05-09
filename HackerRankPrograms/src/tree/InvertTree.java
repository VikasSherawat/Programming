package tree;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class InvertTree {
	public static void main(String[] args) {
		int[] a = { 4, 2, 1, 3, 7, 6, 9 };
		Tree root = null;
		for (int i = 0; i < a.length; i++) {
			root = Tree.insert(a[i], root);
		}
		Tree.inOrder(root);
		invertTree(root);
		System.out.println();
		Tree.inOrder(root);
	}

	private static void invertTree(Tree root) {
		// TODO Auto-generated method stub

		if (root == null) {
			return;
		}

		if (root.left != null)
			invertTree(root.left);
		
		if (root.right != null)
			invertTree(root.right);
		
		Tree temp = root.left;
		root.left = root.right;
		root.right = temp;
		
	}
}
