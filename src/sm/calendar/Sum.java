package sm.calendar;

import java.util.Scanner;

public class Sum {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("두 수를 입력하세요.");
		int a = scan.nextInt();
		int b = scan.nextInt();
		
		System.out.println("두 수의합은 " + (a + b) + " 입니다");
		scan.close();
	}
}
