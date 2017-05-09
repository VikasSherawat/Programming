package string;

public class AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "100";
		String b = "1000";

		System.out.println(new AddBinary().addB(a, b));
	}

	public String addB(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int al = a.length();
		int bl = b.length();
		int car = 0;
		for (int i = 0; i < Math.min(al, bl); i++) {
			int ac = a.charAt(a.length() - 1 - i) - '0';
			int bc = b.charAt(b.length() - 1 - i) - '0';
			int r = 0;
			if (ac == 1 && bc == 1) {
				if (car == 1) {
					r = 1;
				} else {
					r = 0;
				}
				car = 1;
			} else if ((ac == 1 && bc == 0) || (ac == 0 && bc == 1)) {
				if (car == 0)
					r = 1;
				else{
					r = 0;
					car = 1;
				}
			} else {
				if (car != 0)
					r = 1;
				else
					r = 0;
				car = 0;
			}
			sb.append(r);
		}
		int r = Math.max(al, bl) - Math.min(al, bl) - 1;
		String s = null;
		if (al > bl)
			s = a;
		else
			s = b;

		for (int i = r; i >= 0; i--) {
			int c = s.charAt(i) - '0';
			int rs = 0;
			if (car == 1) {
				if (c == 0) {
					car = 0;
					rs =1;
				}else{
					rs = 0;
					car = 1;
				}
				sb.append(rs);

			} else {
				sb.append(c);
			}
		}
		if(car==1)
			sb.append(1);
		return sb.reverse().toString();
	}

}
