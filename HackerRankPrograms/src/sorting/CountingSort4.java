package sorting;

import java.util.*;

public class CountingSort4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Object[][] arr = new Object[N][2];
        Map<Integer,List<String>> map = new TreeMap<Integer, List<String>>();
        for (int i = 0; i < N; i++) {
			int key=in.nextInt();
			String val =in.next();
			if(i<N/2){
				if(map.containsKey(key)){
					List<String> list = map.get(key);
					list.add("-"+val);
				}else{
					List<String> list = new ArrayList<String>();
					list.add("-"+val);
					map.put(key, list);
				}
			}else{
				if(map.containsKey(key)){
					List<String> list = map.get(key);
					list.add(val);
				}else{
					List<String> list = new ArrayList<String>();
					list.add(val);
					map.put(key, list);
				}
			}
		}
        StringBuilder sb = new StringBuilder("");
        for(Map.Entry<Integer, List<String>> m1: map.entrySet()){
        	List<String> list = m1.getValue();
        	for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				String string = (String) iterator.next();
				if(string.charAt(0)=='-'){
					sb.append("- ");
				}else{
					sb.append(string+" ");
				}
				
			}
        }
        System.out.println(sb);
	
        in.close();
	}

}
