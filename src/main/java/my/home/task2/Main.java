package my.home.task2;

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
		
		System.out.println("~Всего доброго! Завершаю работу...~");
		notebook.close();
		
	}

}
