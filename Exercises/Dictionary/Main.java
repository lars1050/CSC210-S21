import java.util.function.Function;
import java.util.Random;
import java.util.ArrayList;

// >>>>>>>>>>>>>>>>   ANSWER QUESTIONS IN THE GOOGLE FORM
// https://forms.gle/8KRRh52DgNCQzCqR9

public class Main {

	static Function<String, Integer> hashFirstChar = word -> Character.getNumericValue(word.charAt(0));

	// >>>>>>>>>>>>>>>>>>>>>>>>
	// MODIFY THIS SO IT ADDS THE VALUES OF THE FIRST & LAST CHAR
	static Function<String, Integer> hashTwoChar;

	/* Array of students put into each dictionary to test get function */
	static ArrayList<Student> students = new ArrayList<Student>();

	public static void main(String[] args) {

		System.out.println("\n---------- PUT ONE LINKED LIST");
		Dictionary<String, Student> linkedList = new Dictionary<>();
		dictionaryFiller(linkedList);
		System.out.println("*** Total comparisons LL "+linkedList.comparisons());

		System.out.println("\n---------- PUT HASH FIRST CHARACTER");
		Dictionary<String, Student> firstCharHash = new Dictionary<>(hashFirstChar);
		dictionaryFiller(firstCharHash);
		System.out.println("*** Total comparisons firstChar "+firstCharHash.comparisons());

		// >>>>>>>>>>>> UNCOMMENT WHEN DONE WITH FUNCTION ABOVE
		/*
		System.out.println("\n---------- PUT HASH FIRST & LAST CHARACTER");
		Dictionary<String, Student> twoCharHash = new Dictionary<>(hashTwoChar);
		dictionaryFiller(twoCharHash);
		System.out.println("Total comparisons twoChar "+twoCharHash.comparisons());
		*/

		// >>>>>>>>>>>>>> ADD 2 MORE TO GET EACH OF OTHER DICTIONARIES
		/*
		System.out.println(("\n---------- GET ONE LINKED LIST");
		for (Student s : students) {
			Student found = linkedList.get(s.firstName()+s.lastName());
		}
		System.out.println("*** Total comparisons LL "+linkedList.comparisons());
		*/
	} // end main()


	/** First Names to randomly choose from. Feel free to add your own. */
	private static String[] firsts = {"Amy", "Erik", "Nimanthi", "Mia", "Mohamed", "Adam", "Scott", "Julio","Eva", "Bonsa", "Chris", "Vivek", "Alyssa", "Luna", "Elvira", "Bryce", "X Æ A-12", "Temu", "Nina", "Fatuma","Penelope", "Dagi", "Ilhan", "Long", "Khalid", "Jiro", "Collin", "An", "Matt", "Quinn", "Su", "Jared", "Maria","Kourtnie", "Amina", "Edgar" };

	/** Last Names to randomly choose from. Feel free to add your own. */
	private static String[] lasts = { "Larson", "Smith", "Ali", "Omar", "Nguyen", "Xie", "Turing", "Cruz", "Qing", "Cortez", "Pen", "Wozniak", "Stein", "Obama", "Weiwei", "Ng", "Liebovitz","Arora", "Jobs" };

	/** Possible years of graduation */
	private static Integer[] years = { 2020, 2021, 2022, 2023, 2024, 2025 };

	public static void dictionaryFiller(Dictionary<String, Student> dict) {

		// seeding random number generator so results are replicated
		// feel free to seed with any value (or no value so it doesn't repeat)
		Random rand = new Random(55);

		// Randomly choose values for a new Student and add to DB
		for (int i = 0; i < 50; i++) {
			String first = firsts[rand.nextInt(firsts.length)];
			String last = lasts[rand.nextInt(lasts.length)];
			Integer year = years[rand.nextInt(years.length)];
			Student S = new Student(last, first, year);
			dict.put(first + last, S);
			students.add(S);
		}
	}
}
