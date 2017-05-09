package googlecodejam;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class TrainTime implements Comparable<TrainTime> {
	int atime;
	int dtime;

	public TrainTime(int dtime, int atime) {
		super();
		this.atime = atime;
		this.dtime = dtime;
	}

	@Override
	public int compareTo(TrainTime b) {
		// TODO Auto-generated method stub
		return Integer.valueOf(this.dtime).compareTo(b.dtime);
	}

}

public class TrainTimetable {
	static final String FILENAME = "practice";
	static final String QUESTION = "B-";
	static final String SIZE = "small-";
	static final String FILEPATH = "C:\\Users\\Vikas Kumar\\Downloads\\";
	static final String IN = FILEPATH + QUESTION + SIZE + FILENAME + ".in";
	static final String OUT = FILEPATH + QUESTION + SIZE + FILENAME
			+ "-answer.in";
	String FORMAT = "Case #";
	String SEMICOLON = ": ";
	Scanner in;
	PrintWriter out;

	private void solve(int TURN) {
		int ans = 0;
		int T = in.nextInt();
		int na = in.nextInt();
		int nb = in.nextInt();
		in.nextLine();

		String[] arr = new String[na];
		TrainTime[] tarr = new TrainTime[na];
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i < na; i++) {
			String[] s = in.nextLine().split("\\s+");
			String hour = s[0].split(":")[0];
			String min = s[0].split(":")[1];
			String time = hour + min;
			int dtime = Integer.parseInt(time);

			hour = s[1].split(":")[0];
			min = s[1].split(":")[1];
			time = hour + min;
			int atime = Integer.parseInt(time);
			map.put(dtime, atime);
			tarr[i] = new TrainTime(dtime, atime);
		}
		Arrays.sort(tarr);

		String[] brr = new String[nb];
		TrainTime[] barr = new TrainTime[nb];
		Map<Integer, Integer> bmap = new TreeMap<Integer, Integer>();
		for (int i = 0; i < nb; i++) {
			String[] s = in.nextLine().split("\\s+");
			String hour = s[0].split(":")[0];
			String min = s[0].split(":")[1];
			String time = hour + min;
			int dtime = Integer.parseInt(time);

			hour = s[1].split(":")[0];
			min = s[1].split(":")[1];
			time = hour + min;
			int atime = Integer.parseInt(time);

			bmap.put(dtime, atime);
			barr[i] = new TrainTime(dtime, atime);
		}

		Arrays.sort(barr);
		int aAns = na - findans(map, barr, T);
		int bAns = nb - findans(bmap, tarr, T);
		if (aAns < 0)
			aAns = 0;
		if (bAns < 0)
			bAns = 0;

		fpl(FORMAT + TURN + SEMICOLON + aAns + " " + bAns);
	}

	private int findans(Map<Integer, Integer> map, TrainTime[] barr, int t) {
		// TODO Auto-generated method stub
		int ans = 0;
		for (int i = 0; i < barr.length; i++) {
			int dtime = barr[i].atime;
			int min = dtime % 100;
			dtime = min + t > 59 ? dtime + 40 + t : dtime + t;
			for (Map.Entry<Integer, Integer> m : map.entrySet()) {
				int departure = m.getKey();
				int arrival = m.getValue();
				if (departure >= dtime) {
					map.remove(departure);
					ans++;
					break;
				}
			}
		}
		return ans;
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
			// out.print("Case #" + i + ": ");
			solve(i);
		}
		in.close();
		out.close();
	}

	public static void main(String args[]) throws Exception {
		new TrainTimetable().run();
	}

	public void pl(Object inp) {
		System.out.println(inp);
	}

	public void p(Object inp) {
		System.out.print(inp);
	}

	public void fpl(Object inp) {
		out.println(inp);
	}

	public void fp(Object inp) {
		out.print(inp);
	}
}
