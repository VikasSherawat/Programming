package tree;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ConstructBinaryTree {
    Set<Integer> set = new HashSet<>();

    public static void main(String[] args) {
        int[] pre= {1,2,4,5,3,6,7};
        int[] post = {4,5,2,6,7,3,1};
        TreeNode node = new ConstructBinaryTree().constructFromPrePost(pre,post);
        inOrder(node);
    }

    private static void inOrder(TreeNode node) {
        if(node==null){
            return;
        }
        inOrder(node.left);
        System.out.println(node.val);
        inOrder(node.right);
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        TreeNode root = new TreeNode(pre[0]);
        if(pre.length>1) {
            root.left = new TreeNode(pre[1]);
            root.right = new TreeNode(post[post.length-2]);
        }
        set.add(root.val);
        construct(pre,post,root.left);
        construct(pre,post,root.right);

        return root;
    }

    private void construct(int[] pre, int[] post, TreeNode root){
        int preIndex = indexOf(pre, root.val);
        int postIndex = indexOf(post, root.val);
        int leftChild = preIndex==pre.length-1?-1:pre[preIndex+1];
        if(!set.contains(leftChild)){
            root.left = new TreeNode(leftChild);
            set.add(leftChild);
        }
        if(postIndex>=2 && post[postIndex-2] == leftChild){
            root.right = new TreeNode(post[postIndex-1]);set.add(leftChild);

        }
        construct(pre,post,root.left);
        construct(pre,post,root.right);
    }

    private int indexOf(int[] arr, int n){
        for(int i = 0;i<arr.length;i++){
            if(arr[i]==n)
                return i;
        }

        return -1;
    }
}
