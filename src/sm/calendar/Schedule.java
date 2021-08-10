package sm.calendar;

import java.util.Scanner;

public class Schedule {
	
	public static void main(String[] args) {	
		Scanner scan = new Scanner(System.in);

		Prompt p = new Prompt();
			
		while(true) {
			p.Menu();
			switch( scan.nextInt() ) {
			case 1 :
				p.cmdRegister();
				break;
			case 2 :
				p.cmdSearch();
				break;
			case 3 :
				p.cmdCal();
				break;
			case 4 :
				System.out.println("종료.");
				System.exit(0);
			
			}
			
		}
		
	}
	
		
}
