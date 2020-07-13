package my.home.task2;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

public class FileManager {
	private File directory;
	private File notesFile;

	public FileManager(String directory, String file) {
		this.directory = new File(directory);
		this.notesFile = new File(directory + "\\" + file);
	}

	public boolean initialize() {
		if (!directory.exists()) {
			directory.mkdirs();
		}
		if (!notesFile.exists()) {
			try {
				notesFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return directory.exists() && notesFile.exists();
	}

	public List<Note> readFile() {
		List<Note> data = new ArrayList<Note>();
		try (FileReader fileReader = new FileReader(notesFile)) {
			CsvToBeanBuilder<Note> builder = new CsvToBeanBuilder<Note>(fileReader);
			data = builder.withSeparator(',').withType(Note.class).build().parse();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data;
	}

	public void writeFile(List<Note> notesList) {
		try (FileWriter fileWriter = new FileWriter(notesFile, false)) {
			StatefulBeanToCsv<Note> beanToCsv = new StatefulBeanToCsvBuilder<Note>(fileWriter).build();
			beanToCsv.write(notesList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
