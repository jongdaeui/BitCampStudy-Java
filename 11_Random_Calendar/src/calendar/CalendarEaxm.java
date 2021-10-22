package calendar;

import java.util.Calendar;
import java.util.Date;

public class CalendarEaxm {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println("new date() : " + date);
		
		date = new Date(2021 - 1900, 7 - 1, 29);
		System.out.println(date);
		
		System.out.println("---------- Calendar ----------");
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		
		System.out.println("년도 : " + cal.get(Calendar.YEAR));
		System.out.println("월 : " + (cal.get(Calendar.MONTH) + 1));
		System.out.println("일 : " + cal.get(Calendar.DATE));
		System.out.println("일 : " + cal.get(Calendar.DATE));
		
		cal.add(Calendar.HOUR, -5);
		System.out.println("오전오후 : " + cal.get(Calendar.AM_PM));
		System.out.println("시(12시간) : " + cal.get(Calendar.HOUR));
		System.out.println("시(24시간) : " + cal.get(Calendar.HOUR_OF_DAY));
		System.out.println("분 : " + cal.get(Calendar.MINUTE));
		System.out.println("초 : " + cal.get(Calendar.SECOND));
		
		System.out.println("---------------");

	}
}
