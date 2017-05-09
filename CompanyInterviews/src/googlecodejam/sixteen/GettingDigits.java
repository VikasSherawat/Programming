package googlecodejam.sixteen;

import java.io.*;
import java.util.*;


public class GettingDigits {
		List<Integer> list ;
		static final String FILENAME = "practice";
		static final String  QUESTION = "A-";
		static final String  SIZE = "large-";
		static final String FILEPATH = "C:\\Users\\Vikas Kumar\\Downloads\\";
		static final String IN       = FILEPATH + QUESTION+SIZE + FILENAME + ".in";
		static final String OUT      = FILEPATH + QUESTION+SIZE + FILENAME + "-answer.in";
		String FORMAT = "Case #";
		String SEMICOLON  = ": ";
		Scanner  			in       ;
		PrintWriter        out      ;
		
		private void solve(int TURN) {
			list = new ArrayList();
			int ans = 0;
			String inp = in.next();
			char[] arr = inp.toCharArray();
			Map<Character, Integer> map = new TreeMap<Character, Integer>();
			for (int i = 0; i < arr.length; i++) {
				char key = arr[i];
				if(map.containsKey(key)){
					map.put(key, map.get(key)+1);
				}else{
					map.put(key,1);
				}
			}
			removeZero(map);
			removeTwo(map);
			removeFour(map);
			removeSix(map);
			removeEight(map);
			checkOne(map);
			checkThree(map);
			checkFive(map);
			checkSeven(map);
			checkNine(map);
			
			Collections.sort(list);			
			StringBuilder sb = new StringBuilder();
			
			for (int i = 0; i < list.size(); i++) {
				sb.append(list.get(i));
			}
			
			fpl(FORMAT+TURN+SEMICOLON+sb.toString());
			/*pl(inp);
			for(Map.Entry<Character,Integer> m: map.entrySet()){
				char key = m.getKey();
				int value = m.getValue();
				if(value!=0){
					p(key+" ");
				}
			}
			pl("\n");*/
		}
		
		private void checkThree(Map<Character, Integer> map) {
			// TODO Auto-generated method stub
			int t =0,h=0,r=0,e=0;
			
			if(map.containsKey('E')){
				e = map.get('E');
			}
			if(map.containsKey('T')){
				t = map.get('T');
			}
			if(map.containsKey('H')){
				h = map.get('H');
			}
			if(map.containsKey('R')){
				r = map.get('R');
			}
			
			int min = Math.min(Math.min(t, h), r);
			if(min == 0)
				return;
			if(min*2<=e){
				removeChar(map, 'T', min);
				removeChar(map, 'H', min);
				removeChar(map, 'R', min);
				removeChar(map, 'E', 2*min);
				addToList(3, min);
			}
		}

		private void checkNine(Map<Character, Integer> map) {
			// TODO Auto-generated method stub
			int i=0,n=0,e=0;
			if(map.containsKey('I')){
				i = map.get('I');
			}
			if(map.containsKey('N')){
				n = map.get('N');
			}
			if(map.containsKey('E')){
				e = map.get('E');
			}
			int min = Math.min(i, e);
			if(min == 0)
				return;
			if(min*2 <= n){
				removeChar(map,'N',2*min);
				removeChar(map,'E',min);
				removeChar(map,'I',min);
				addToList(9, min);
			}
		}

		private void checkSeven(Map<Character, Integer> map) {
			// TODO Auto-generated method stub
			int s=0,n=0,e=0,v=0;
			if(map.containsKey('S')){
				s = map.get('S');
			}
			if(map.containsKey('N')){
				n = map.get('N');
			}
			if(map.containsKey('E')){
				e = map.get('E');
			}
			if(map.containsKey('V')){
				v = map.get('V');
			}
			int min = Math.min(Math.min(s, n),v);
			if(min==0)
				return;
			if(min*2 <= e){
				removeChar(map,'S',min);
				removeChar(map,'V',min);
				removeChar(map,'E',2*min);
				removeChar(map,'N',min);
				addToList(7, min);
			}
		}

		private void checkOne(Map<Character, Integer> map) {
			// TODO Auto-generated method stub
			int o=0,n=0,e=0;
			if(map.containsKey('O')){
				o = map.get('O');
			}
			if(map.containsKey('N')){
				n = map.get('N');
			}
			if(map.containsKey('E')){
				e = map.get('E');
			}			
			int min = Math.min(Math.min(o, n), e);
			if(min==0)
				return;
			removeChar(map,'O',min);
			removeChar(map,'E',min);
			removeChar(map,'N',min);
			addToList(1, min);
			
		}
		
		
		
		private void removeChar(Map<Character, Integer> map, char c, int min) {
			// TODO Auto-generated method stub
			if(map.containsKey(c)){
				map.put(c, map.get(c)-min);
			}
			
		}

		private void checkFive(Map<Character, Integer> map) {
			// TODO Auto-generated method stub
			int f=0,i=0,v=0,e=0;
			if(map.containsKey('F')){
				f = map.get('F');
			}
			if(map.containsKey('I')){
				i = map.get('I');
			}
			
			if(map.containsKey('V')){
				v = map.get('V');
			}
			
			if(map.containsKey('E')){
				e = map.get('E');
			}
			int min = Math.min(Math.min(f,i), Math.min(v,e));
			if(min==0)
				return;
			removeChar(map,'F',min);
			removeChar(map,'I',min);
			removeChar(map,'V',min);
			removeChar(map,'E',min);
			addToList(5, min);
			
		}
		private void addToList(int num, int times){
			for (int i = 0; i < times; i++) {
				list.add(num);
			}
		}
		
		private void removeFour(Map<Character, Integer> map){
			if(map.containsKey('U')){
				int N = map.get('U');
				map.put('F', map.get('F')-N);
				map.put('O', map.get('O')-N);
				map.put('R', map.get('R')-N);
				map.remove('U');
				addToList(4, N);
			}
		}
		
		private void removeSix(Map<Character, Integer> map){
			if(map.containsKey('X')){
				int N = map.get('X');
				map.put('I', map.get('I')-N);
				map.put('S', map.get('S')-N);
				map.remove('X');
				addToList(6, N);
			}
		}
		
		private void removeEight(Map<Character, Integer> map){
			if(map.containsKey('G')){
				int N = map.get('G');
				map.put('I', map.get('I')-N);
				map.put('E', map.get('E')-N);
				map.put('H', map.get('H')-N);
				map.put('T', map.get('T')-N);
				map.remove('G');
				addToList(8, N);
			}
		}
		
		private void removeZero(Map<Character, Integer> map){
			if(map.containsKey('Z')){
				int N = map.get('Z');
				map.put('E', map.get('E')-N);
				map.put('R', map.get('R')-N);
				map.put('O', map.get('O')-N);
				map.remove('Z');
				addToList(0, N);
			}
		}
		
		private void removeTwo(Map<Character, Integer> map){
			if(map.containsKey('W')){
				int N = map.get('W');
				map.put('T', map.get('T')-N);
				map.put('O', map.get('O')-N);
				map.remove('W');
				addToList(2, N);
			}
		}
		
		private void configOutput() {
			File file = new File(OUT);
			if (file.exists()) {
				file.delete();
			}
			try {
				out = new PrintWriter(new File(OUT));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		private void configInput() {
			// TODO Auto-generated method stub
			File file = new File(IN);
			try {
				in = new Scanner(file);
				//in = new Scanner(System.in);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		private void run() throws Exception {
			configInput();
			configOutput();
			int t = in.nextInt();
			for (int i = 1; i <= t; i++) {
				//out.print("Case #" + i + ": ");
				solve(i);
			}
			in.close();
			out.close();
		}
		
		
		public static void main(String args[]) throws Exception {
			new GettingDigits().run();
		}
		
		public void pl(Object inp){
			System.out.println(inp);
		}
		
		public void p(Object inp){
			System.out.print(inp);
		}
		
		public void fpl(Object inp){
			out.println(inp);
		}
		
		public void fp(Object inp){
			out.print(inp);
		}
}
