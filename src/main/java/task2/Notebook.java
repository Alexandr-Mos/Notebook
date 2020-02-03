package task2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Notebook {
	private List<Note> notes;
	private Console console;
	private FileManager fileManager;
	private String catalog;
	public static String FILE_NAME = "notes.txt";
	
	
	public Notebook(String catalog) {
		this.catalog = catalog;
	}
	
	public void initialize() {
		console = Console.getInstance();
		
		fileManager = new FileManager(catalog, Notebook.FILE_NAME);
		while (!fileManager.initialize()) {
			System.out.println("~Неверный путь или нет прав на работу в данном каталоге!~");
			System.out.print("Введите новый путь ");
			catalog = console.nextCommand();
			fileManager = new FileManager(catalog, Notebook.FILE_NAME);
		}
		notes = fileManager.readFile();
		
		
	}
	
	public void print() {
		System.out.println("~Список всех заметок~");
		for(Note n : notes) {
			System.out.println(n);
		}
	}
	
	public void findByHeader() {
		System.out.print("Запрос ");
		String keyword = console.nextCommand();
		System.out.println("~Результат поиска по заголовкам...~");
		
		for (Note n : notes) {
			if(n.getHead().contains(keyword)) {
				System.out.println(n);
			}
		}
	}
	
	public void findByDate() {
		System.out.print("Запрос ");
		String date = console.nextCommand();
		System.out.println("~Результат поиска по дате~");
		
		for (Note n : notes) {
			if(n.getDate().contains(date)) {
				System.out.println(n);
			}
		}
	}
	
	public void findByEmail() {
		System.out.print("Запрос ");
		String email = console.nextCommand();
		System.out.println("~Результат поиска по e-mail~");
	
		for (Note n : notes) {
			if(n.getEmail().contains(email)) {
				System.out.println(n);
			}
		}
	}
	
	public void findByText() {
		System.out.print("Запрос ");
		String keyword = console.nextCommand();
		System.out.println("~Результат поиска по тексту заметок~");

		for (Note n : notes) {
			if(n.getText().contains(keyword)) {
				System.out.println(n);
			}
		}
	}
	
	
	public void addNote() {
		Note note = new Note();
		System.out.print("Введите тему");
		note.setHead(console.nextCommand());
		System.out.print("Введите e-mail");
		note.setEmail(console.nextEmail());
		System.out.print("Введите текст заметки");
		note.setText(console.nextCommand());
		note.setDate(new Date(System.currentTimeMillis()).toString());
		System.out.println("Время заметки: " + note.getDate());
		notes.add(note);
		System.out.println("~Заметка добавлена~");
	}
	
	public void close() {
		fileManager.writeFile(notes);
	}
	
	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	@Override
	public String toString() {
		return "Notebook [notes=" + notes + "]";
	}
	
	
}
