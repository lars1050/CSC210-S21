import java.util.Random;

public class DatabaseMaker {

  /** First Names to randomly choose from. Feel free to add your own. */
  private static String[] firsts = {
    "Amy","Erik","Nimanthi","Kelly","Mia","Mohamed","Adam","Scott","Julio", "Eva","Bonsa","Chris","Vivek","Alyssa","Luna","Elvira","Bryce","X Æ A-12",
    "Temu","Nina","Fatuma","Penelope","Dagi","Ilhan","Long","Khalid","Jiro",
    "Collin","An","Matt","Quinn","Su","Jared","Maria","Kourtnie","Amina","Edgar"
  };

  /** Last Names to randomly choose from. Feel free to add your own. */
  private static String[] lasts = {
    "Larson","Smith","Ali","Omar","Nguyen","Xie","Turing","Cruz","Qing", "Cortez","Pen","Wozniak","Stein","Obama","Weiwei","Ng",
    "Liebovitz","Arora","Jobs"
  };

  /** Save the values from enum Major to choose from randomly */
  private static Major[] majors = Major.values();

  /** Possible years of graduation */
  private static Integer[] years = {2020,2021,2022,2023,2024,2025};

  /** A random database of Students. DB created a little bigger so more can be added later.
  @param size Number of elements to put in DB
  @return a database with random data for testing.
  */
  public static Database<Student> makeDB(int size) {
    // seeding random number generator so results are replicated
    // feel free to seed with any value (or no value so it doesn't repeat)
    Random rand = new Random(100);

    // Making DB a little bigger in case user wants to add more later.
    Database<Student> db = new Database<>(size+100);

    // Randomly choose values for a new Student and add to DB
    for (int i=0; i<size; i++) {
      String first = firsts[rand.nextInt(firsts.length)];
      String last = lasts[rand.nextInt(lasts.length)];
      Integer year = years[rand.nextInt(years.length)];
      Integer credits = rand.nextInt(150);
      Major major = majors[rand.nextInt(majors.length)];
      db.add(new Student(last,first,credits,major,year));
    }
    return db;
  }
}

// enum random select from https://stackoverflow.com/questions/1972392/pick-a-random-value-from-an-enum/30641206
