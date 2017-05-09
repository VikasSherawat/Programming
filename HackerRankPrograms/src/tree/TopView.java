package tree;

import java.util.*;


public class TopView {
public static void topView(Tree root){
	List<Integer> list = new ArrayList<Integer>();
	Tree orgRoot = root;
	while(root!=null){
		list.add(root.data);
		root=root.left;
	}
	for(int i=list.size()-1;i>-1;i--){
		System.out.print(list.get(i)+" ");
	}
	if(orgRoot.right!=null)
	root = orgRoot.right;
	list.clear();
	while(root!=null){
		list.add(root.data);
		root=root.right;
	}
	for(Integer i: list){
		System.out.print(i+" ");
	}
	
}
}
