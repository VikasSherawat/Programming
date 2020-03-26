package tree;

public class MaxPathSum {
    int sum;
    public int maxPathSum(TreeNode root) {
        dfs(root, 0);
        return this.sum;
    }

    private int dfs(TreeNode root, int curr){
        if(root == null){
            return curr;
        }

        int lsum = Math.max(dfs(root.left, curr),0);
        int rsum = Math.max(dfs(root.right, curr),0);

        int csum = lsum + rsum + root.val;
        if(csum > this.sum){
            this.sum = csum;
        }
        return root.val + Math.max(csum, curr);
    }
}
