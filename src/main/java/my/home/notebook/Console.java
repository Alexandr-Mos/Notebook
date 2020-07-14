package my.home.notebook;

import java.util.Scanner;
import java.util.regex.Pattern;

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
	
	public String nextEmail() {
		System.out.print(">> ");
		String email = scanner.nextLine();
		Pattern pattern = Pattern.compile("[^@]+@[^@]+\\.[^@]+"); //данная проверка не 100%. Нужно отсылать подтверждение на почту
		while (!pattern.matcher(email).matches()) {
			System.out.println("Некорректный e-mail. Введите другой.");
			System.out.print(">> ");
			email = scanner.nextLine();
		}
		return email;
	}
	

}