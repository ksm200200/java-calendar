package sm.calendar;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class Calendar {

	private static final int[] MAX_DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	HashMap<Date, String> planMap = new HashMap<Date, String>();

	// 일정 등록 메소드
	public void registerPlan(String strDate, String plan) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
			planMap.put(date, plan);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
 
	// 일정 검색 메소드
	public String searchPlan(String strDate) {
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		String plan = planMap.get(date);
		return plan;
	}

	public boolean isLeapYear(int year) {
		if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
			return true;
		} else {
			return false;
		}
	}

	// 달의 최대 날짜를 돌려주는 함수
	public int getMaxDaysOfMonth(int year, int month) {
		if (isLeapYear(year)) {
			return LEAP_MAX_DAYS[month];
		} else {
			return MAX_DAYS[month];

		}
	}

	// 예시 달력 함수
	public void printCalendar(int year, int month) {
		System.out.printf("        <<%4d년%2d월>> \n", year, month);
		System.out.println("  SUN MON TUE WED THU FRI SAT");
		System.out.println("----------------------------");

		// get weekday automatically
		int weekday = getWeekday(year, month, 1);
		// print blank space
		for (int i = 0; i < weekday; i++) {
			System.out.print("    ");
		}

		int maxDay = getMaxDaysOfMonth(year, month);
		int count = 7 - weekday;
		int delim = (count < 7) ? count : 0;
		/*
		 * 위와 같다. if (count < 7) { delim = count; } else { delim = 0; }
		 */

		// print first line
		for (int i = 1; i <= count; i++) {
			System.out.printf("%4d", i);
		}
		System.out.println();

		// print from second line to last
		count++;
		for (int i = count; i <= maxDay; i++) {
			System.out.printf("%4d", i);
			if (i % 7 == delim) {
				System.out.println();
			}
		}
		System.out.println();
		System.out.println();
	}

	private int getWeekday(int year, int month, int day) {
		int syear = 1970;
		final int STANDARD_WEKKDAY = 4; // 1970/Jan/1st = Thursday

		int count = 0;

		for (int i = syear; i < year; i++) {
			int delta = isLeapYear(i) ? 366 : 365;
			count += delta;
		}

		// System.out.println(count);
		for (int i = 1; i < month; i++) {
			int delta = getMaxDaysOfMonth(year, i);
			count += delta;
		}

		count += day - 1;

		int weekday = (count + STANDARD_WEKKDAY) % 7;
		return weekday;
	}

	public static void main(String[] args) {

		Calendar c = new Calendar();
		System.out.println(c.getWeekday(1970, 1, 1) == 4);
		System.out.println(c.getWeekday(1971, 1, 1) == 5);
		System.out.println(c.getWeekday(1972, 1, 1) == 6);
		System.out.println(c.getWeekday(1973, 1, 1) == 1);
		System.out.println(c.getWeekday(1974, 1, 1) == 2);

	}
}
