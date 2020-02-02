package task2;

import java.util.Scanner;

public class Console {
	private static Console instance;
	private static Scanner scanner;
	public static String HELP = "";
	
	private Console() {
		scanner = new Scanner(System.in);
	}
	
	public static Console getInstance() {
		if (instance == null) {
			instance = new Console();
		}
		return instance;
	}
	
	public String nextCommand() {
		System.out.print(">> ");
		return scanner.nextLine();
	}
	
	public int nextInt() {
		int number = 0;
		System.out.print(">> ");
		while (!scanner.hasNextInt()) {
			scanner.nextLine();
			System.out.print(">> ");
		}
		number = scanner.nextInt();
		scanner.nextLine();                // сьедает перевод на новую строку. Иначе следующее чтение строки забагует
		return number;
	}
	

}