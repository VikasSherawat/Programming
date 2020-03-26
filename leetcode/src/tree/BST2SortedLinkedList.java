package tree;

public class BST2SortedLinkedList {
    private Node head, prev;
    public Node treeToDoublyList(Node root) {
        if(root==null)
            return root;
        recurse(root);
        prev.right = head;
        head.left = prev;
        return head;
    }

    private void recurse(Node root){
        if(root==null){
            return;
        }
        recurse(root.left);

        if(prev==null){
            prev = head = root;
        }else{
            prev.right = root;
            root.left = prev;
            prev = root;
        }
        recurse(root.right);
    }

    private class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
