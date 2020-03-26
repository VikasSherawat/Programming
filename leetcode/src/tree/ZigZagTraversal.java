package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ZigZagTraversal {
    List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode rightSub = new TreeNode(20);
        rightSub.left = new TreeNode(15);
        rightSub.right = new TreeNode(7);
        root.left = new TreeNode(9);
        root.right = rightSub;
        List<List<Integer>> ans = new ZigZagTraversal().zigzagLevelOrder(root);
        for(List<Integer> a : ans){
            System.out.println(Arrays.toString(a.toArray()));
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null)
            return ans;

        LinkedList<TreeNode> q = new LinkedList<>();
        TreeNode temp = null;
        q.addLast(root);
        q.addLast(temp);
        int level = 0;
        List<Integer> ls = new LinkedList<>();
        while(q.size()>1){
            TreeNode node = q.removeFirst();


            if(node==null){
                ans.add(ls);
                level++;
                ls = new ArrayList<>();
                q.addLast(temp);
            }else{
                if(level%2==0)
                    ls.add(node.val);
                else
                    ls.add(0,node.val);

                if(node.left!=null)
                    q.addLast(node.left);

                if(node.right!=null)
                    q.addLast(node.right);

            }
        }
        return ans;
    }
}
