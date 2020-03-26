package tree;

public class RangeSum {
    int sum =0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        dfs(root, L, R);
        return sum;
    }

    private void dfs(TreeNode node, int l, int r){
        if(node == null)
            return;

        if(node.val >=l && node.val <=r){
            sum += node.val;
        }

        if(node.val > l){
            dfs(node.left, l, r);
        }

        if(node.val < r){
            dfs(node.right, l, r);
        }

    }
}
