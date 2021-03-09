import java.util.Comparator;

public class TestOrderedList {

	public static OrderedList<Olympian> athletes;

	public static void main(String[] args) {
		athletes = new OrderedList<>();
		try {
			LoadOlympians.load(athletes,"test.csv");
		} catch(Exception e) {
			System.out.println("Error loading Olympians");
			e.printStackTrace();
			return;
		}
		System.out.println(athletes);

		testComparator(Orderings.orderById,"Testing ID Comparator");
		testKeyComparator(Orderings.queryByCountry,"Chile","Testing Key Field Country Comparator");
		testExceptions();
		testFinds();
		testRanges();
		testMinMax();
	}


	public static void testComparator(Comparator<Olympian> orderBy, String msg) {
		System.out.println("___________________________________________");
		System.out.println(msg);

		// Test your comparator using a visual inspection of the results.
		// Create a small subset (of subset) to test with.
		// Declare a list
		// Set the Comparator in OrderedList with this comparator.
		// Load the file with the small test set
		// print to confirm in order
	}

	public static void testKeyComparator(
	Comparator<Object> queryBy, Object key, String msg) {
		System.out.println("___________________________________________");
		System.out.println(msg);

		// Test key comparator using a visual inspection of the results.
		// Create a small subset (of subset) to test with.
		// Declare a list
		// Load the file with the small test set
		// call one of the methods that use key comparators
		// visual inspection or test return value to confirm it is working.
	}

	public static void testExceptions() {
		// test that the Comparator<Objects> are catching bad input parameters.
	}


	public static void testFinds() {
		System.out.println("\n----------  Testing Finds");
	}

	public static void testRanges() {
		System.out.println("\n----------  Testing Ranges");
		/*
		athletes.getRange("Austria","Bolivia",new QueryByCountry());

		athletes.retainRange("Austria","Ireland",new QueryByCountry());

		athletes.removeRange("Bolivia","Chile",new QueryByCountry());
		*/
	}

	public static void testMinMax() {
		System.out.println("\n----------  Testing Min and Max");
		/*
		athletes.min();
		athletes.max();
		athletes.min(new OrderById());
		athleste.max(new OrderById());
		*/
	}

}
