package hired;

public class Solution1 {
	public static void main(String[] args) {
		int a = 0;
		int b = 100;
		System.out.println(new Solution1().solution(a, b));
	}

	public int solution(int a, int b) {
		a = a < 0 ? 0 : a;
		b = b < 0 ? 0 : b;
		int flag = a == 0 ? 0 : 1;
		return (int) (Math.floor(Math.sqrt(b)) - Math.ceil(Math.sqrt(a)) + flag);
	}
}
