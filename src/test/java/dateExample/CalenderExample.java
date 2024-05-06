package dateExample;

import java.util.Calendar;

public class CalenderExample {

	public CalenderExample() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		calendarMethod();
	}

	public static void calendarMethod() {
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.getTime());
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK_IN_MONTH));
	}
}
