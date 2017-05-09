package search;

import java.util.*;


public class MissingNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		   Scanner in = new Scanner(System.in);
		   	int index=0;
	        int n = in.nextInt();
	       Map<Integer, Integer> hm = new TreeMap<Integer, Integer>();
	       // int[] ar = new int[n];
	        for (int i = 0; i < n; i++) {
				index = in.nextInt();
				if(hm.containsKey(index))
				hm.put(index, hm.get(index)+1);
				else
					hm.put(index, 1);
			}
	        

	        //second array
	        int b = in.nextInt();
	        Map<Integer, Integer> hm1 = new TreeMap<Integer, Integer>();
	        for (int i = 0; i < b; i++) {
	        	index = in.nextInt();
				if(hm1.containsKey(index))
				hm1.put(index, hm1.get(index)+1);
				else
					hm1.put(index, 1);
			}
	        
	   
	        Integer key,value;
	        ArrayList<Integer> list = new ArrayList<Integer>();
	        for(Map.Entry iter: hm1.entrySet()){
	     
	        	key = (Integer)iter.getKey();
	        	//System.out.println("Key value is----"+key);
	        	value = (Integer)iter.getValue();
	    
	        	
	        	
	        if(hm.containsKey(key)){
	        	if(value.equals(hm.get(key))){
	        		continue;
	        		}
	        	else{
		       // 	System.out.println("Value against Key in Map one is--"+hm.get(key));
	        	//	System.out.println(key+","+value);
	        		list.add(key);
	        	}
	        	}else
	        		list.add(key);
	        	
	        }
	        
	       //System.out.println("Final Result is");
	        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				Integer integer = (Integer) iterator.next();
				System.out.print(integer+" ");
				
			}
	        
	        
	}
}
