import java.io.*;
import java.util.Random;

public class LoadOlympians {
	public static void load(OrderedList<Olympian> list, String filename) {

		// FROM seas.upenn.edu/~cis1xx/resources/java/fileIO/introToFileIO.html

		Random rand = new Random();

		// Open the file and put contents in bufferReader
		FileReader inputStream = null;
		BufferedReader bufferReader;
		try {
			inputStream = new FileReader(filename);
			bufferReader = new BufferedReader(inputStream);
		} catch (Exception e) {
			System.out.println("Cannot open "+filename);
			e.printStackTrace();
			return;
		}

		// Ignore first row containing column headings
		// Read in rest -- each row/line corresponds to new athlete
		try {
			String line = bufferReader.readLine();	// column headings
			// While there is more to read ...
			line = bufferReader.readLine();
			while (null != line) {
				list.add(new Olympian(line));
				line = bufferReader.readLine();
			}
		} catch (Exception e) {
			System.out.println("ERROR: throw in the while");
			e.printStackTrace();
			return;
		}
	} // end load()
} // end LoadOlympians
