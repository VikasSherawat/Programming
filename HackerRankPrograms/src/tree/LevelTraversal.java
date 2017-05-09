package tree;
import java.util.*;

public class LevelTraversal {
static void levelOrderTraversal(Tree root){
	if(root!=null){
		Queue<Tree> queue = new LinkedList<Tree>();
		queue.add(root);
		while(queue.size()>0){
			Tree node = queue.remove();
			System.out.print(node.data+" ");
			if(node.left!=null){
				queue.add(node.left);
			}
			if(node.right!=null){
				queue.add(node.right);
			}
		}
	}
}

static  void levelReverseTraversal(Tree root){
	if(root!=null){
		List<Integer> list = new ArrayList<Integer>();
		Queue<Tree> queue = new LinkedList<Tree>();
		queue.add(root);
		while(queue.size()>0){
			Tree tree = queue.remove();
			list.add(tree.data);
			if(tree.right!=null)
				queue.add(tree.right);
			if(tree.left!=null)
				queue.add(tree.left);
		}
		
		for(int i=list.size()-1;i>-1;i--){
			System.out.print(list.get(i)+" ");
		}
	}
}
}
