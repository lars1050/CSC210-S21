import java.util.ArrayList;
import java.io.FileReader;
import java.io.File;
import java.io.BufferedReader;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class ConvertCVS {
	public static void main(String[] args) throws Exception {

		// FROM seas.upenn.edu/~cis1xx/resources/java/fileIO/introToFileIO.html
		String filename = "athlete_events.csv";

		ArrayList<String> entries = new ArrayList<String>();
		Random rand = new Random();

		// Open the file and put contents in bufferReader
		FileReader inputStream = null;
		BufferedReader bufferReader;
		try {
			inputStream = new FileReader(filename);
			bufferReader = new BufferedReader(inputStream);
		} catch (Exception e) {
			System.out.println("Cannot open "+filename);
			return;
		}

		// Save first row of column headings
		String columns = null;
		try {
			// Read first row to get column headings
			columns = bufferReader.readLine();
		} catch (Exception e) {
			System.out.println(e+" Fail to read first row.");
			throw e;
		}

		// Read in the rest of the file. Each row is a new athlete
		String[] entry;
		String line;
		int chance = 0;
		try {
			// While there is more to read ...
			line = bufferReader.readLine();
			while (null != line && entries.size() < 50000) {

				// name, age, country, year, season, city, sport, medal
				String[] tokens = line.split(",");
				if (tokens[1].equals("NA")) {
					tokens[1] = String.valueOf(rand.nextInt(20)+15);
					String updated = tokens[0]+",";
					for (String t : tokens) {
						updated+=t+",";
					}
					line = updated;
				}
				chance = rand.nextInt(200);
				if (10==chance) {
					entries.add(line);
				}
				line = bufferReader.readLine();
			}
		} catch (Exception e) {
			throw e;
		}
		System.out.println("saved "+entries.size());

		try {
			File fileObject = new File("subset.csv");
			if (fileObject.createNewFile()) {
				System.out.println("File created.");
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		FileWriter writer = new FileWriter("subset.csv");
		writer.write(columns);
		writer.write("\n");
		for (String e : entries) {
			writer.write(e);
			writer.write("\n");
		}
		writer.close();
	} // end main
} // end loadFromFile(String)
