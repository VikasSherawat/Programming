package visa.second;

public class A {
	public static void main(String[] args) {
		int[] a = { 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 0 };
		System.out.println(minMoves(a));
	}

	static int minMoves(int[] arg) {
		int ans = 0;
		int[] cpArray = copyArray(arg);
		boolean flag = true;
		int end = arg.length;
		while (flag) {
			flag = false;
			int last = 0;
			for (int i = 0; i < end - 1; i++) {
				if (arg[i] != arg[i + 1] && arg[i] == 0) {
					swap(arg, i, i + 1);
					flag = true;
					ans++;
					last = i + 1;
				}
			}

			end = last;
		}

		arg = cpArray;
		int min = ans;
		ans = 0;
		flag = true;
		end = arg.length;
		while (flag && ans < min) {
			flag = false;
			int last = 0;
			for (int i = 0; i < arg.length - 1; i++) {
				if (arg[i] != arg[i + 1] && arg[i] == 1) {
					swap(arg, i, i + 1);
					flag = true;
					ans++;
					if (ans >= min)
						break;
				}
			}

			
		}

		return Math.min(ans, min);
	}

	private static int[] copyArray(int[] arg) {
		// TODO Auto-generated method stub
		int[] a = new int[arg.length];
		for (int i = 0; i < arg.length; i++) {
			a[i] = arg[i];
		}
		return a;
	}

	private static void swap(int[] arg, int i, int j) {
		// TODO Auto-generated method stub
		int temp = arg[j];
		arg[j] = arg[i];
		arg[i] = temp;

	}
}
