package weekofcode19;

import java.util.*;

public class ScalarProductEdit {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	int a=0;
	int b= in.nextInt(),mod = in.nextInt(),n=in.nextInt();
	Map<Long,Long> map = new TreeMap<Long, Long>();
	b%=mod;
	Long mult = (long)b;
	int bd = 4 * n;
	for(int i=2;i<bd;++i)
    {
		int res = a + b;
		if (res >= mod)
			res -= mod;
		a = b;
			b = res;
        if (i % 2 == 1 && i > 6)
            map.put((b * mult) % mod,(b * mult) % mod);
    }
	System.out.println(map.size());
}
}
