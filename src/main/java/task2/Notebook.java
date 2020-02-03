package task2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Notebook {
	private List<Note> notes;
	private Console console;
	private FileManager fileManager;
	private String catalog;
	public static String FILE_NAME = "notes.csv";
	
	
	public Notebook(String catalog) {
		this.catalog = catalog;
	}
	
	public void initialize() {
		fileManager = new FileManager(catalog, Notebook.FILE_NAME);
		while (!fileManager.initialize()) {
			System.out.println("Неверный путь или нет прав на работу в данном каталоге!");
			System.out.println("Введите новый путь ");
			catalog = console.nextCommand();
			fileManager = new FileManager(catalog, Notebook.FILE_NAME);
		}
		notes = fileManager.readFile();
		
		console = Console.getInstance();
	}
	
	public void addNote() {
		Note note = new Note();
		System.out.println("Введите тему");
		note.setHead(console.nextCommand());
		System.out.println("Введите e-mail");
		note.setEmail(console.nextEmail());
		System.out.println("Введите текст заметки");
		note.setText(console.nextCommand());
		note.setDate(new Date(System.currentTimeMillis()).toString());
		System.out.println("Время заметки: " + note.getDate());
		notes.add(note);
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
