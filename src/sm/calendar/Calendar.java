package sm.calendar;

import java.util.Scanner;

public class Calendar {

	private static final int[] MAX_DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	// 달의 최대 날짜를 돌려주는 함수
	public int getMaxDaysOfMonth(int month) {
		return MAX_DAYS[month - 1];
	}

	// 예시 달력 함수
	public void printSampleCalendar() {
		System.out.println(" 일   월   화   수   목   금   토");
		System.out.println("----------------------------");
		System.out.println(" 1   2   3    4   5   6   7");
		System.out.println(" 8   9  10   11  12  13  14");
		System.out.println("15  16  17   18  19  20  21");
		System.out.println("22  23  24   25  26  27  28 ");
		System.out.println("-------------------------------");
	}

	//main
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		Calendar cal = new Calendar();
		// 예시달력 출력
		cal.printSampleCalendar();
		
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
