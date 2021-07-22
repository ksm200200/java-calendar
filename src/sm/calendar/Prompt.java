package sm.calendar;

import java.util.Scanner;

public class Prompt {

	private final static String PROMPT = "cal> ";

	public void runPrompt() {

		Scanner scan = new Scanner(System.in);

		Calendar cal = new Calendar();

		// 숫자를 입력받아 해당하는 숫자의 달력을 출력하는 프로그램
		int month = 0;
		while (true) {
			System.out.println("달을 입력하세요");
			System.out.print(PROMPT);
			month = scan.nextInt();
			
			if (month == -1) {
				break;
			} else if (month >= 13) {
				continue;
			}
			cal.printCalendar(2021, month);
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
