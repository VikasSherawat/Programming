package tree;


import java.util.HashMap;
import java.util.Map;

class BTreeUsingInorder {

    public static void main(String[] args) {
        int[] a = {1,2,3};
        int[] b = {2,3,1};
        TreeNode node = new BTreeUsingInorder().buildTree(a,b);

    }
    int[] preorder;
    int[] inorder;
    Map<Integer, Integer> map = new HashMap<>();
    int count =0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder==null || preorder.length==0){
            return null;
        }

        this.preorder = preorder;
        this.inorder = inorder;

        buildIndex();
        TreeNode node = new TreeNode(preorder[0]);
        int index = this.map.get(preorder[0]);
        this.count++;
        node.left = buildTree(0, index-1);
        node.right = buildTree(index+1, preorder.length-1);
        return node;
    }

    private void buildIndex(){
        for(int i =0;i<this.inorder.length;i++){
            map.put(this.inorder[i],i);
        }
    }


    private TreeNode buildTree(int start, int end){
        if(start>end || start<0 || end<0 || start==preorder.length || end==preorder.length || this.count==preorder.length)
            return null;

        if(start==end){
            return new TreeNode(this.preorder[this.count++]);
        }

        TreeNode node = new TreeNode(this.preorder[this.count]);
        int index = this.map.get(this.count++);

        node.left = buildTree(start, index-1);
        if(index<end)
            node.right = buildTree(index+1, end);
        return node;

    }
}
