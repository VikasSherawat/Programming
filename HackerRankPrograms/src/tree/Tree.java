package tree;

import java.util.*;

public class Tree {

	int data;
	Tree left;
	Tree right;

	public Tree() {
	}

	public Tree(int data) {
		this.data = data;
		left = right = null;
	}

	/*
	 * //input 6 3 5 4 7 2 1
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 23, 16, 15, 9, 6, 17, 10, 13, 8, 26, 18, 2, 22, 24, 12, 5, 20, 25, 21, 4, 19, 1, 3, 14, 7 };
		Tree root = null;
		List<Tree> list = new ArrayList<Tree>();
		for (int i = 1; i < 16; i++) {
			list = insert1(i, list);
		}
		root = list.get(0);
		
		List<Integer> list1 = new ArrayList<Integer>();
		Miscellaneous.printAncesstor(root, 6, list1);
		Collections.reverse(list1);
		if (list1.size() > 0) {
			for (Integer i : list1)
				System.out.print(i + " ");
		} else
			System.out.println(-1);
	}

	private static List<Tree> insert1(int i, List<Tree> list) {
		// TODO Auto-generated method stub
		if (list.size() == 0) {
			list.add(new Tree(i));
			return list;
		}
		int size = list.size();
		int pIndex = size % 2 == 0 ? size / 2 - 1 : size / 2;
		Tree tree = list.get(pIndex);
		if (tree.left == null) {
			tree.left = new Tree(i);
			list.add(tree.left);
			return list;
		}
		if (tree.right == null) {
			tree.right = new Tree(i);
			list.add(tree.right);
			return list;
		}
		return list;
	}

	private static int findNodeDepth(int i, Tree root) {
		// TODO Auto-generated method stub
		if (root == null)
			return -1;
		int depth = 0;
		boolean present = false;
		while (root.left != null || root.right != null) {
			if (root.data == i) {
				present = true;
				return depth;
			}
			if (i <= root.data) {
				root = root.left;
				depth++;
			} else {
				root = root.right;
				depth++;
			}
		}
		if (!present)
			return -1;
		return depth;
	}

	private static int findHeight(Tree root) {
		// TODO Auto-generated method stub
		if (root == null)
			return 0;
		else {
			int depth = 0;
			while (root != null) {
				depth = 1 + Math.max(findHeight(root.left), findHeight(root.right));
				return depth;
			}
			return 0;
		}
	}

	public static void PostOrder(Tree root) {
		// TODO Auto-generated method stub
		if (root != null) {
			PostOrder(root.left);
			PostOrder(root.right);
			System.out.print(root.data + " ");
		}
	}

	public static void inOrder(Tree root) {
		// TODO Auto-generated method stub
		if (root != null) {
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}

	}

	public static void preOrder(Tree root) {
		// TODO Auto-generated method stub
		if (root != null) {
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}

	}

	public static Tree insert(int data, Tree root) {
		// TODO Auto-generated method stub
		if (root == null) {
			return new Tree(data);
		} else {
			Tree tree;
			if (data <= root.data) {
				tree = insert(data, root.left);
				root.left = tree;
			} else {
				tree = insert(data, root.right);
				root.right = tree;
			}
		}
		return root;
	}

}
