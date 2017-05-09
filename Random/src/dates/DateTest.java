package dates;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		
		
		Calendar cal = Calendar.getInstance();
		Date now = cal.getTime();
		System.out.println(cal.getFirstDayOfWeek());
		System.out.println(cal.YEAR);
	}
}
