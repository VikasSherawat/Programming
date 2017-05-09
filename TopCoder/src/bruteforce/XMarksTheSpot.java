package bruteforce;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class XMarksTheSpot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] board = { "?.", ".O" };
		int ans = new XMarksTheSpot().countArea(board);
		System.out.println(ans);
	}

	public int countArea(String[] board) {
		int ans = 0;
		char[][] a = new char[board.length][board[0].length()];
		for (int i = 0; i < a.length; i++) {
			a[i] = board[i].toCharArray();
		}

		int minX = 100, minY = 100, maxX = -1, maxY = -1;
		ArrayList<Point> list = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				char c = a[i][j];
				if (c == 'O') {
					if (i < minX)
						minX = i;
					if (i > maxX)
						maxX = i;
					if (j > maxY)
						maxY = j;
					if (j < minY)
						minY = j;
				}else if(c=='?'){
					list.add(new Point(i,j));
				}
			}	
		}
		
	
	    for(int mask=0;mask< 1 << list.size();mask++) {
	      int minX2 = minX, maxX2 = maxX, minY2 = minY, maxY2 = maxY;
	      for(int i=0;i<list.size();i++) {
	        if((mask & (1 << i)) != 0) {
	          minX2 = Math.min(minX2, list.get(i).x);
	          maxX2 = Math.max(maxX2, list.get(i).x);
	          minY2 = Math.min(minY2, list.get(i).y);
	          maxY2 = Math.max(maxY2, list.get(i).y);
	        }
	      }
	      ans += (maxX2 - minX2+1) * (maxY2 - minY2+1);
	    }
		return ans;
	}
	
	class Point{
		int x ;
		int y;
		
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}

}
