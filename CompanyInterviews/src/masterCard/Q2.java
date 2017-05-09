package masterCard;

import java.util.*;

public class Q2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		Node _root;
		int root_i = 0, root_cnt = 0, root_num = 0;
		root_cnt = in.nextInt();
		_root = null;
		for (root_i = 0; root_i < root_cnt; root_i++) {
			root_num = in.nextInt();
			if (root_i == 0)
				_root = new Node(root_num);
			else
				insert(_root, root_num);
		}

		int _x = in.nextInt();
		System.out.println(isPresent(_root, _x));
		return;
	}

	private static int isPresent(Node root, int val) {
		// TODO Auto-generated method stub
		if (root == null) {
			return 0;
		}
		if (root.data == val)
			return 1;
		else if (isPresent(root.left, val) == 1
				|| isPresent(root.right, val) == 1)
			return 1;
		else
			return 0;
	}

	private static Node insert(Node node, int data) {
		if (node == null) {
			node = new Node(data);
		} else {
			if (data <= node.data) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}
		return (node);
	}

}
