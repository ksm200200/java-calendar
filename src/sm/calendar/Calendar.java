package sm.calendar;

import java.util.Scanner;

public class Calendar {

	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	private static final int[] LEAP_MAX_DAYS = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public boolean isLeapYear(int year) {
		if(year % 4 == 0 && (year % 100 != 0 || year % 400 == 0))
			return true;
			
		return false;
	}
	// 달의 최대 날짜를 돌려주는 함수
	public int getMaxDaysOfMonth(int month) {
		return MAX_DAYS[month - 1];
	}

	
	/*
	 * 월을 입력하면 해당월의 달력을 출력한다
	 * 달력의 모양은 1단계에서 작성한 모양으로 한다
	 * 1일은 일요일로 정해도 무방하다
	 * 프롬포트를 출력한다
	 * 
	 */
	// 예시 달력 함수
	public void printCalendar(int year ,int month) {
		System.out.printf("        <<%d %d>> \n",year,  month);
		System.out.println("  SUN MON TUE WED THU FRI SAT");
		System.out.println("----------------------------");
		
		int maxDay = getMaxDaysOfMonth(month);
		for(int i = 1; i <= maxDay; i++) {
			System.out.printf("%4d", i);
			if(i % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println();
	}

	//main
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		Calendar cal = new Calendar();
		
		// 예시달력 출력
		//숫자를 입력받아 해당하는 달의 최대 일수를 출력하고 -1이면 종료하는 프로그램
		int month = 0;
		while(true) {
			System.out.println("달을 입력하세요");
			System.out.print(">");
			month = scan.nextInt();
			if(month == -1) {
				break;
			} else if(month >= 13) {
				continue;
				
			}
			System.out.printf("%d월은 %d일까지 있습니다.\n", month, cal.getMaxDaysOfMonth(month));
			
		}
		System.out.println("----끝!----");
		scan.close();

	}

}
