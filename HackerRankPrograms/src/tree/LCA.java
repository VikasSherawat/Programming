package tree;

import java.util.*;

public class LCA {
static Tree findLCA(Tree root, int v1,int v2){
	List<Tree> list1,list2 ;
	if((v1<=root.data && v2<=root.data) || (v1>root.data && v2>root.data)){
		list1 = findParent(root,v1);
		list2 = findParent(root,v2);
	}else{
		return root;
	}
	for(int i1=list1.size()-1;i1>=0;i1--){
		for(int i=list2.size()-1;i>=0;i--){
			if(list1.get(i1).equals(list2.get(i)))
				return list1.get(i1);
		}
	}
	return null;
}

private static List<Tree> findParent(Tree root, int v1) {
	// TODO Auto-generated method stub
	if(root==null)
		return null;
	List<Tree> list = new ArrayList<Tree>();
	while(root!=null){
		list.add(root);
		if(root.data==v1){
			return list;
		}
		if(v1<=root.data)
		root = root.left;
		else
			root = root.right;
	}
	return list;
}
}
