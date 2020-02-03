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
		Console console = Console.getInstance();
		System.out.println("Введите путь к каталогу ");
		String command = console.nextCommand();
		Notebook notebook = new Notebook(command);
		notebook.initialize();
		
		//http://proglang.su/java/date-and-time
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
		System.out.println(notebook.getNotes());
		
		
		
		notebook.close();
	}

}
