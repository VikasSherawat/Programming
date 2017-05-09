package main;

import java.util.*;
public class TwoPlus {

public static void main(String[] args) {
		// TODO Auto-generated method stub
	Scanner in = new Scanner(System.in);
	int row = in.nextInt(),col=in.nextInt();
	char[][] arr = new char[row][col];
	for (int i = 0; i < row; i++) {
		String inp= in.next();
		arr[i]=inp.toCharArray();
	}
	

	boolean flag = true;
	int index=0,length=0;
	TreeMap<Integer,Integer> map = new TreeMap<Integer, Integer>();
	//List<Integer> list1 = new ArrayList<Integer>();
	for (int i = 1; i < row-1; i++) {
		for (int j = 1; j < col-1; j++) {
			flag = true;
			length=0;
			length = index = Math.min(Math.min(Math.abs(i-0),Math.abs(row-1-i)),Math.min(Math.abs(j-0),Math.abs(col-1-j)));
			//System.out.println("Maximum length of plus possible is--"+index);
			while(index>0){
				if(arr[i][j]!='G' || arr[i][j+index]!='G'||arr[i][j-index]!='G'||arr[i+index][j]!='G'||arr[i-index][j]!='G'){
					flag=false;
					length--;
				}else{
				flag=true;	
				}
				index--;
			}//while  loop ends here
			if(flag){
				map.put(10*i+j, length);
			//	list1.add(length);
			}
		}//inner for loop closed here
	}//outer  for loop closed here
	
	
	//Integer[] arr1 = (Integer[])list1.toArray();
	//Arrays.sort(arr1);
	if(map.size()==1){
		TreeMap<Integer,List<Integer>> map1 = new TreeMap<Integer, List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		for(Map.Entry<Integer, Integer> e1: map.entrySet()){
			//System.out.println("Key :"+e1.getKey()+"\tValue : "+e1.getValue());
			Integer key=e1.getKey();
			Integer val = e1.getValue();
			
			list.add(e1.getKey());
			while(val>0){
				list.add(10*val+key);
				list.add(key-10*val);
				list.add(val+key);
				list.add(key-val);
				val--;
			}
		}//for loop ends here
		 flag=false;
		for (int i = 1; i < row-1; i++) {
			for (int j = 1; j < col-1; j++) {
				if(arr[i][j]=='G' && !list.contains(10*i+j)){
					flag=true;
				}
	
			}
		}
		if(flag)
		System.out.println(4*map.get(map.firstKey())+1);
		else
			System.out.println(0);
	}else if(map.size()==0){
		int count =0;
		for (int i = 1; i < row-1; i++) {
			for (int j = 1; j < col-1; j++) {
				if(arr[i][j]=='G')
					count++;
			}
		}
		if(count<=1){
			System.out.println(0);
		}else
			System.out.println(1);
			
	}
		else{
		TreeMap<Integer,List<Integer>> map1 = new TreeMap<Integer, List<Integer>>();
		for(Map.Entry<Integer, Integer> e1: map.entrySet()){
			//System.out.println("Key :"+e1.getKey()+"\tValue : "+e1.getValue());
			Integer key=e1.getKey();
			Integer val = e1.getValue();
			List<Integer> list = new ArrayList<Integer>();
			list.add(e1.getKey());
			while(val>0){
				list.add(10*val+key);
				list.add(key-10*val);
				list.add(val+key);
				list.add(key-val);
				val--;
			}
			map1.put(key, list);
		}//for loop ends here
		
		Object[] keyArr = map1.keySet().toArray(); 
		Object[] keyArr1 = map1.keySet().toArray(); 
		TreeMap<String,Integer> tree1 = new TreeMap<String, Integer>();
		List<Integer> fList = new ArrayList<Integer>();
		for (int i = 0; i < keyArr.length-1; i++) {
			for (int j = i+1; j < keyArr1.length; j++) {
				boolean result = checkOverlap(map1.get(keyArr[i]),map1.get(keyArr1[j]));
				if(result){
					Integer num1 = (Integer)keyArr[i];
					Integer num2 = (Integer)keyArr1[j];
					fList.add(num1);
					fList.add(num2);
				}
			}
		}//outer for loop ends here
		int maxArea = 0;
		for(int i=0;i<fList.size();i=i+2){
			int lArea = (4*map.get(fList.get(i))+1)*(4*map.get(fList.get(i+1))+1);
			if(lArea>maxArea)
				maxArea=lArea;
		}
	System.out.println(maxArea);
	}
}// main function ends here

private static boolean checkOverlap(List<Integer> list, List<Integer> list2) {
	// TODO Auto-generated method stub
	int size = list.size(), size2=list2.size();
	for (int i = 0; i < size; i++) {
		for (int j = 0; j < size2; j++) {
			if(list.get(i)==list2.get(j))
				return false;
		}
	}
	return true;
}



}
