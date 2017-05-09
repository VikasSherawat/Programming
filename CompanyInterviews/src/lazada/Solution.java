package lazada;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


class Tree {
    public int x;
    public Tree l;
    public Tree r;

    public Tree(int x) {
        this.x = x;
    }
}

public class Solution {
    public static void main(String[] args) {
        int[] a = {2, 2, 3, 2};
        Tree root = null;
        for (int i = 0; i < a.length; i++) {
            root = insert(a[i], root);
        }
        //inOrder(root);
        //System.out.println();
        int ans = new Solution().solution(root);
        System.out.println(ans);

    }

    public static Tree insert1(int[] a) {
        Queue<Tree> q = new LinkedList<>();
        q.add(new Tree(a[0]));
        int idx = 1;
        return null;
    }

    public static Tree insert(int data, Tree root) {
        if (root == null) {
            return new Tree(data);
        } else {
            Tree tree;
            if (data <= root.x) {
                tree = insert(data, root.l);
                root.l = tree;
            } else {
                tree = insert(data, root.r);
                root.r = tree;
            }
        }
        return root;
    }

    public int solution(Tree T) {
        int ans = 0;
        Set<Integer> set = new HashSet<Integer>();
        ans = distinctNode(T, set);
        return ans;
    }

    public static void inOrder(Tree root) {
        // TODO Auto-generated method stub
        if (root != null) {
            inOrder(root.l);
            System.out.print(root.x + " ");
            inOrder(root.r);
        }

    }

    public static void preOrder(Tree root) {
        // TODO Auto-generated method stub
        if (root != null) {
            System.out.print(root.x + " ");
            preOrder(root.l);
            preOrder(root.r);
        }

    }

    private int distinctNode(Tree t, Set<Integer> cset) {
        // TODO Auto-generated method stub
        if (t == null) {
            return cset.size();
        }
        Set<Integer> set = new HashSet<>(cset);
        set.add(t.x);
        return Math.max(distinctNode(t.l, set), distinctNode(t.r, set));
    }
}
