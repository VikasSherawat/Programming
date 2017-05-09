package tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

import tree.Tree;

public class SwapNode {
	static BTree root;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		root = new BTree();
		root.item = 1;
		root.height=1;
		for (int i = 1; i <= N; i++) {
			int left = in.nextInt();
			int right = in.nextInt();
			if (!BTree.insert(root, i, left, right))
				break;
		}
		//System.out.println("\nPrinting");
		int height = findHeight(root);
		// printTree(root);
		int T = in.nextInt();
		for (int i = 0; i < T; i++) {
			int depth = in.nextInt();
			for (int j = 1; j <= 10; j++) {
				if (j * depth > height)
					break;
				swapNodes(j*depth);
				
			}
			BTree.inOrder(root);
			System.out.println();
		}
		
		//System.out.println("Done");
	}

	private static int findHeight(BTree root) {
		// TODO Auto-generated method stub
		if (root == null)
			return 0;
		else {
			int depth = 0;
			while (root != null) {
				depth = 1 + Math.max(findHeight(root.left),
						findHeight(root.right));
				return depth;
			}
			return depth;
		}
	}

	private static void swapNodes(int depth) {
		// TODO Auto-generated method stub
		Queue<BTree> q = new ArrayDeque<BTree>();
		q.add(root);
		while (!q.isEmpty()) {
			BTree node = q.remove();
			if (node.height == depth) {
				BTree temp = node.left;
				node.left = node.right;
				node.right = temp;
			}else{
				if (node.left != null)
					q.add(node.left);
				if (node.right != null)
					q.add(node.right);
			}
			if (node.height > depth)
				return;
		}

	}

	private static void printTree(BTree root) {
		// TODO Auto-generated method stub
		BTree node = root;
		Queue<BTree> q = new ArrayDeque<BTree>();
		q.add(node);
		while (!q.isEmpty()) {
			node = q.remove();
			System.out.print(node.item + " ");
			if (node.left != null)
				q.add(node.left);
			if (node.right != null)
				q.add(node.right);
		}
		System.out.println();
	}

}

class BTree {
	BTree left;
	BTree right;
	int height;
	int item;

	public static void inOrder(BTree root) {
		// TODO Auto-generated method stub
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.item + " ");
			inOrder(root.right);
		}
		

	}

	public static boolean insert(BTree root, int index, int left, int right) {
		if (left == -1 && right == -1)
			return true;

		BTree node = search(root, index);
		if (node == null) {
			return false;
		} else {
			if (left != -1) {
				BTree btree = new BTree();
				btree.item = left;
				btree.height = node.height+1;
				node.left = btree;
			}
			if (right != -1) {
				BTree rtree = new BTree();
				rtree.item = right;
				rtree.height = node.height+1;
				node.right = rtree;
			}
			return true;
		}
	}

	public static BTree search(BTree root, int index) {
		// TODO Auto-generated method stub
		BTree node = root;
		Queue<BTree> q = new ArrayDeque<BTree>();
		q.add(node);
		while (node.item != index && !q.isEmpty()) {
			node = q.remove();
			if (node.left != null)
				q.add(node.left);
			if (node.right != null)
				q.add(node.right);

		}
		if (node.item == index)
			return node;
		else
			return null;
	}

}
