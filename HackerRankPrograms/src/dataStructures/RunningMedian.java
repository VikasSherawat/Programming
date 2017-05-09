package dataStructures;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class RunningMedian {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		int sum = 0;
		Set<Integer> set = new HashSet<Integer>();
		MTree root =null;
		float median = 0.0f;
		for (int i = 1; i <= T; i++) {
			int a = in.nextInt();
			sum += a;
			MTree.insert(root, a);
			if (i % 2 == 0) {// odd
				median = sum / i;
			}else{
				//median = MTree.inorder(root,i/2);
			}

			

		}
	}

}

class MTree {
	MTree left;
	MTree right;
	int value;

	public static MTree insert(MTree root, int a) {
		// TODO Auto-generated method stub
		if (root == null) {
			root = new MTree(null, null, a);
		} else {
			if (root.value > a) {
				insert(root.right, a);
			} else {
				insert(root.left, a);
			}
		}
		
		return root;
	}



	public MTree(MTree left, MTree right, int value) {
		super();
		this.left = left;
		this.right = right;
		this.value = value;
	}

}
