package sm.calendar;

import java.util.Scanner;

public class Prompt {


	public void runPrompt() {

		Scanner scan = new Scanner(System.in);

		Calendar cal = new Calendar();

		// 숫자를 입력받아 해당하는 숫자의 달력을 출력하는 프로그램
		int month = 0;
		int year = 0;
		while (true) {
			System.out.println("년도를 입력하세요.");
			System.out.print("YEAR> ");
			year = scan.nextInt();
			System.out.println("달을 입력하세요.");
			System.out.print("MONTH> ");
			month = scan.nextInt();
			
			if (month == -1) {
				break;
			} else if (month >= 13) {
				continue;
			}
			cal.printCalendar(year, month);
		}

		System.out.println("----끝!----");
		scan.close();
	}

	// main 
	public static void main(String[] args) {
		// 셀 실행
		Prompt prompt = new Prompt();
		prompt.runPrompt();

	}

}
