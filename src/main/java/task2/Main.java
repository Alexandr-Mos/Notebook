package task2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*Задание 2. Блокнот. Разработать консольное приложение, работающее с Заметками
в Блокноте. Каждая Заметка это: Заметка (тема, дата создания, e-mail, сообщение).
Общие пояснения к практическому заданию.
	• В начале работы приложения данные должны считываться из файла, в конце
работы – сохраняться в файл.
	• У пользователя должна быть возможность найти запись по любому параметру
или по группе параметров (группу параметров можно определить
самостоятельно), получить требуемые записи в отсортированном виде, найти
записи, текстовое поле которой содержит определенное слово, а также
добавить новую запись.
	• Особое условие: поиск, сравнение и валидацию вводимой информации
осуществлять с использованием регулярных выражений.
	• Особое условие: проверку введенной информации на валидность должен
осуществлять код, непосредственно добавляющий информацию.*/
public class Main {

	public static void main(String[] args) {
		System.out.println("~ЗАМЕТКИ~");
		Console console = Console.getInstance();
		System.out.print("Введите путь к каталогу ");
		String command = console.nextCommand();
		Notebook notebook = new Notebook(command);
		notebook.initialize();
		
		System.out.println("~Добро пожаловать!~");
		System.out.println("~Введите [help] для получения полного списка комманд~");
		
		while(!command.equals("exit")) {
			System.out.print("Введите команду ");
			command = console.nextCommand().toLowerCase();
			switch (command) {
			    case "help":
			    	notebook.printHelp();
			    	break;
				case "print":
					notebook.print();
					break;
				case "add":
					notebook.addNote();
					break;
				case "findbyheader":
					notebook.findByHeader();
					break;
				case "findbydate":
					notebook.findByDate();
					break;
				case "findbyemail":
					notebook.findByEmail();
					break;
				case "findbytext":
					notebook.findByText();
					break;
				case "exit":
					continue;
				default:
					System.out.println("~Такой команды не существует~");
					break;
			}
		}
		
		notebook.close();
		
		/*// http://proglang.su/java/date-and-time
		Date date = new Date(System.currentTimeMillis());
		System.out.println(date);
		SimpleDateFormat df = new SimpleDateFormat("E kk:mm:ss z dd.MM.yyyy");
		System.out.println(df.format(date));

		try {
			System.out.println(df.parse("Пн 11:28:57 MSK 03.02.2020"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		notebook.addNote();
		System.out.println(notebook.getNotes());*/

		
		
	}

}
