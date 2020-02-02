package task2;

import java.util.ArrayList;
import java.util.List;

public class Notebook {
	private List<Note> notes;
	public static String FILE_NAME = "notes.csv";
	
	public Notebook() {
		notes = new ArrayList<Note>();
	}
	
	public void addNote(Note note) {
		notes.add(note);
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
