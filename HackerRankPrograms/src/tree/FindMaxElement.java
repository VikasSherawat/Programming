package tree;

public class FindMaxElement {

	static int maxElement(Tree root){
		if(root==null)
			return -1;
		int rootData = root.data;
		int left = maxElement(root.left);
		int right = maxElement(root.right);
		
		return left>right?left>rootData?left:rootData:right>rootData?right:rootData;
	}
}
