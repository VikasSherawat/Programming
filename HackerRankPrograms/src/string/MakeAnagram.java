package string;

import java.util.*;
public class MakeAnagram {
	 public static void main(String[] args){
	        
	       Scanner in = new Scanner(System.in);
		   String inp1 = in.next(), inp2 = in.next();
		   TreeMap<Character,Integer> map1 = new TreeMap<Character,Integer>();
		   TreeMap<Character,Integer> map2 = new TreeMap<Character,Integer>();
		   int len1 = inp1.length();
		   int len2 = inp2.length();
		   for(int i=0;i<len1;i++){
			   if(map1.containsKey(inp1.charAt(i))){
				   map1.put(inp1.charAt(i),map1.get(inp1.charAt(i))+1);
			   }
			   else
				    map1.put(inp1.charAt(i),1);
		   }
		   
		   for(int i=0;i<len2;i++){
			   if(map2.containsKey(inp2.charAt(i))){
				   map2.put(inp2.charAt(i),map2.get(inp2.charAt(i))+1);
			   } else
				    map2.put(inp2.charAt(i),1);
		   }
		   int count =0;
		   
		   for(Map.Entry<Character, Integer> entry: map1.entrySet()){
			   char key = (char)entry.getKey();
			   int value = (int)entry.getValue();
			   if(map2.containsKey(key) ){
				   if(value != map2.get(key))
				   count+=Math.abs(value-map2.get(key));
			   }else{
				   count+=value;
			   }			   
		   }
		   
		   for(Map.Entry<Character, Integer> entry: map2.entrySet()){
			   char key = (char)entry.getKey();
			   if(!map1.containsKey(key) ){
				   count+=map2.get(key);
			   }			   
		   }
		   
		   System.out.println(count);
	    }
}
