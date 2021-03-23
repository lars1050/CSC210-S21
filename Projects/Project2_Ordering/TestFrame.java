import java.util.Comparator;
import java.util.*;

/** General framework for organizing tests for the OrderedList class.
Be mindful that there are no tests here for the required comparators and copyable interface of Olympian. You will want to test those too.
This file will not be assessed or even viewed during assessment. It is YOUR file to modify and use as you deem necessary.
*/
public class TestFrame {

	/** Class level variable to use as a test case in all tests. */
	public static OrderedList<Simple> simples;

	/** Populate the "simples" list with Simple elements for testing.
	@param count Number of elements to add to simples
	@param comp Instantiate simples with this comparator.
	@return Simple[] in case user wants to view created objects.
	*/
	public static Simple[] buildSimples(int count, Comparator<Simple> comp) {

		// Instantiate objects
		simples = new OrderedList<Simple>(comp);
		Simple[] array = new Simple[count];

		// if user provided comparator, set the ordering based on this.
		if (null != comp) {
			simples.reorder(comp);
		}

		// Create a collection of Simple objects and add to structs.
		for (int i=0; i<count; i++) {
			Simple s = new Simple(String.valueOf((char)((int)'z'-i)),i);
			simples.add(s);
			array[i] = s;
		}
		return array;
	}

	/** Print all elements in the array on a single line.
	@param array Simple elements to be printed.
	*/
	public static void print(Simple[] array) {
		for (Simple el : array) {
			System.out.print(el+" ");
		}
		System.out.println();
	}


	public static void main(String[] args) {

		// All methods defined? Can add and peek?
		Simple[] array = buildSimples(3,Simple.orderByAlpha);
		System.out.println("\n--- SANITY CHECK ---");
		try {
			testCallAll();
		} catch(Exception e) {
			System.out.println("****** MISSING METHODS. ABORT *******");
			e.printStackTrace();
			return;
		}
		System.out.print("ADDED ");
		print(array);
		System.out.print(simples.peek(0)+" ");
		System.out.print(simples.peek(1)+" ");
		System.out.println(simples.peek(2)+" ");
		System.out.println("^^^^^ HOW DOES THIS LOOK? ^^^^^^^");
		System.out.println("^^^ if not good, fix or tests are meaningless ^^^");


		// -------------- Once sanity check is passing, move on to these ...
		try {
			testSortingOrder();
		} catch(Exception e) {
			System.out.println("testSortOrder Exception "+e.getMessage());
		}
		try {
			testArraySort();
		} catch(Exception e) {
			System.out.println("testArraySort Exception "+e.getMessage());
		}
		try {
			testFinds();
		} catch(Exception e) {
			System.out.println("testFinds Exception "+e.getMessage());
		}
		try {
			testFindsKeys();
		} catch(Exception e) {
			System.out.println("testFindsKeys Exception "+e.getMessage());
		}
		try {
			testRanges();
		} catch(Exception e) {
			System.out.println("testRanges Exception "+e.getMessage());
		}
		try {
			testDynamic();
		} catch(Exception e) {
			System.out.println("testDynamic Exception "+e.getMessage());
		}

	}

	/** Series of calls to each public method in OrderedList.
	Confirms everything is defined (but nothing more). */
	public static void testCallAll() {
		// Constructors
		OrderedList<Simple> simples = new OrderedList<>();
		simples = new OrderedList<>(Simple.orderByAlpha);

		// Add, Locate, Reorder
		simples.add(new Simple("a",1));
		Simple s = simples.peek(0);
		int x = simples.find(new Simple("a",1));
		simples.reorder(Simple.orderByNumeric);

		// toArray
		Comparable[] array1 = simples.toArray();
		Comparable[] array2 = simples.toArray(Simple.orderByAlpha);

		// Find with Keys
		ArrayList<Simple> list = simples.findAll("a",Simple.queryByAlpha);
		list = simples.findAllOr("a",Simple.queryByAlpha,"b",Simple.queryByAlpha);
		list = simples.findInRangeInclusive("a","m",Simple.queryByAlpha);

		// Ranges retain and remove
		simples.retainInRangeInclusive("a","m",Simple.queryByAlpha);
		simples.removeInRangeInclusive("a","m",Simple.queryByAlpha);

		// max and mins
		Simple m = simples.max();
		m = simples.min();
		m = simples.max(Simple.orderByAlpha);
		m = simples.min(Simple.orderByAlpha);
	}

	public static void testSortingOrder() {

		System.out.println("\n___________________________________________");
		System.out.println("Testing add and sorting order");
	}

	public static void testArraySort() {

		System.out.println("\n___________________________________________");
		System.out.println("Testing toArray (both)");

		buildSimples(5,null);

	}

	public static void testFinds() {
		System.out.println("\n___________________________________________");
		System.out.println("Testing Finds");

		Simple s = null;

		buildSimples(5,Simple.orderByAlpha);
	}

	public static void testFindsKeys() {
		System.out.println("\n___________________________________________");
		System.out.println("Testing Finds with Key Values");

		buildSimples(5,Simple.orderByAlpha);
		ArrayList<Simple> result = null;
	}

	public static void testRanges() {

		System.out.println("\n___________________________________________");
		System.out.println("Testing Ranges");

		buildSimples(5,Simple.orderByAlpha);

	}

	public static void testDynamic() {
		System.out.println("\n___________________________________________");
		System.out.println("Testing Dynamic Array");

	}

	/**-----------------------------------------------------------------*/
	/**-------------------------   ASSERTS if you want them ------------*/
	/**-----------------------------------------------------------------*/
	public static void assertEquals(Object exp, Object res, String msg) {
		if ( null==exp) {
			if (null!=res) {
				System.out.println("ERROR "+msg+": expected "+exp+", results "+res);
				return;
			} else {
				return;
			}
		} // end if exp null
		if (!exp.equals(res)) {
			System.out.println("ERROR "+msg+": expected "+exp+", results "+res);
		}
	} // end assertEquals

	public static void assertEquals(int exp, int res, String msg) {
			if (exp!=res) {
				System.out.println("ERROR "+msg+": expected "+exp+", results "+res);
			}
		}
}
