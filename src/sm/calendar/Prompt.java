package sm.calendar;

import java.util.Scanner;

public class Prompt {

	Calendar cal = new Calendar();
	Scanner scan = new Scanner(System.in);
	
	//메뉴
	public void Menu() {
		System.out.println("+------------+");
		System.out.println("| 1. 일정 등록");
		System.out.println("| 2. 일정 검색");
		System.out.println("| 3. 달력 보기");
		System.out.println("| 4. 종료");
		System.out.println("+------------+");
		System.out.println("명령 (1, 2, 3, 4)");
		System.out.print(">");
		
	}
	
	
	//일정등록
	public void cmdRegister() {
		System.out.println("[새 일정 등록]");
		System.out.println("날짜를 입력해 주세요.(yyyy-MM-dd)");
		String date = scan.next();
		scan.nextLine();
		System.out.println("일정을 입력해 주세요.");
		String text = scan.nextLine();
		cal.registerPlan(date, text);
		System.out.println();
	}
	
	//일정검색
	public void cmdSearch() {
		System.out.println("[일정 검색]");
		System.out.println("날짜를 입력해 주세요.(yyyy-MM-dd)");
		String date = scan.next();
		String plan = cal.searchPlan(date);
		System.out.println(plan);
		System.out.println();
	}

	// 달력보기
	public void cmdCal() {

		int month = 1;
		int year = 1997;
		System.out.println("년도를 입력하세요.");
		System.out.print("YEAR> ");
		year = scan.nextInt();

		System.out.println("달을 입력하세요.");
		System.out.print("MONTH> ");
		month = scan.nextInt();

		if (month > 12 || month < 1) {
			System.out.println("잘못된 입력입니다.");
			return;
		}

		cal.printCalendar(year, month);
	}

}
