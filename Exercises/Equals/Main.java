
import java.lang.reflect.*;
import java.util.Scanner;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        Student[] roster = null;
        Student[] college = null;
        try {
            roster = loadFromFile("roster.csv");
        } catch (Exception e) {

        }
        try {
            college = loadFromFile("students.csv");
        } catch (Exception e) {

        }
        if (null == roster) {
            System.out.println("oops");
            return;
        }
        int rosterCount;
        System.out.println("\nCLASS ROSTER_________________");
        int i;
        for (i = 0; i < roster.length; i++) {
            if (null == roster[i]) {
                break;
            }
            System.out.println(roster[i]);
        }
        rosterCount = i;
        int studentCount = 0;
        System.out.println("\nALL STUDENTS_________________");
        for (i = 0; i < college.length; i++) {
            if (null == college[i]) {
                break;
            }
            System.out.println(college[i]);
        }
        studentCount = i;

        System.out.println("\n___ MATCH TO ITSELF");
        for (int j = 0; j < rosterCount; j++) {
            if (roster[j] == roster[j]) {
                System.out.println("EQUALS: " + roster[j]);
            }
        }

        System.out.println("\n___ CLASS ROSTER MATCHING STUDENT LIST __");

        // NOTICE nothing is matching!
        // Can you fix this?
        for (int j = 0; j < rosterCount; j++) {
            for (int k = 0; k < studentCount; k++) {
                if (roster[j] == college[k]) {
                    System.out.println(roster[j] + " EQUALS " + college[k]);
                } else {
                    System.out.println(roster[j] + " NOT EQUALS " + college[k]);

                }
            }
        }

    }

    public static Student[] loadFromFile(String filename) throws Exception {
        // FROM seas.upenn.edu/~cis1xx/resources/java/fileIO/introToFileIO.html

        // Open the file and put contents in bufferReader
        FileReader inputStream = null;
        BufferedReader bufferReader;
        try {
            inputStream = new FileReader(filename);
            bufferReader = new BufferedReader(inputStream);
        } catch (Exception e) {
            System.out.println("Cannot open " + filename);
            return null;
        }

        Student[] list = new Student[20];
        int count = 0;

        // Read the file. Each row is a new student
        String[] entry;
        String line;
        Student student;
        try {
            // While there is more to read ...
            while ((line = bufferReader.readLine()) != null) {
                // Instantiate an "empty" student
                student = new Student();
                // read one line, parsing using comma
                entry = line.split(",");
                // Populate the student with information from row
                student.last(entry[0]);
                student.first(entry[1]);
                student.major(entry[2]);
                student.credits(Integer.parseInt(entry[3]));
                list[count] = student;
                count++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return list;
    } // end loadFromFile(String)
}
