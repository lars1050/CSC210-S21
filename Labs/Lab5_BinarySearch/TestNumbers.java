
public class TestNumbers {
	public static void main(String[] args) {
		testAdd();
		testFind();
		testFindRecursive();
		System.out.println("\nNumbers Tests Complete ----\n");
	}
	
	/** ----------------------------------------------------------------- **/
	public static void testAdd() {

		System.out.println("\ntesting order for add ...");

		// Create a new list
		OrderedList<Integer> numbers = new OrderedList<Integer>();

		// Add some numbers
		numbers.add(60);
		numbers.add(30);
		numbers.add(10);
		numbers.add(40);
		numbers.add(20);
		numbers.add(50);

		// Testing order maintained by last name, then first when adding students.
		// VISUAL INSPECTION
		System.out.println("ORDER Expect: 10, 20, ..., 60");
		System.out.println("\n"+numbers);
	}

	/** ----------------------------------------------------------------- **/
	public static void testFind() {

		System.out.println("\ntesting find (non-recursive) ...");

		OrderedList<Integer> numbers = new OrderedList<Integer>();
		numbers.add(30);
		numbers.add(10);
		numbers.add(40);
		numbers.add(20);

		// list should be { 10, 20, 30, 40 }
		assertEquals(-1,numbers.findIterative(2),"find something not there");
		assertEquals(0,numbers.findIterative(10),"findIt first");
		assertEquals(3,numbers.findIterative(40),"findIt last");
		assertEquals(1,numbers.findIterative(20),"findIt in middle (even)");
		numbers.add(25);
		// now { 10, 20, 25, 30, 40 }
		assertEquals(3,numbers.findIterative(30),"findIt in middle (odd)");
	}

	/** ----------------------------------------------------------------- **/
	public static void testFindRecursive() {

		System.out.println("\ntesting find (recursive) ...");

		OrderedList<Integer> numbers = new OrderedList<Integer>();
		numbers.add(30);
		numbers.add(10);
		numbers.add(40);
		numbers.add(20);

		// list should be { 10, 20, 30, 40 }
		assertEquals(-1,numbers.find(2),"find something not there");
		assertEquals(0,numbers.find(10),"findRec first");
		assertEquals(3,numbers.find(40),"findRec last");
		assertEquals(1,numbers.find(20),"findRec in middle (even)");
		numbers.add(25);
		// now { 10, 20, 25, 30, 40 }
		assertEquals(3,numbers.find(30),"findRec in middle (odd)");
	}

	/** ----------------------------------------------------------------- **/
	public static void assertEquals(Object expect, Object result, String msg) {
		if (null==expect && null==result) {
			return;
		} else if ((null==expect && null!=result) || !expect.equals(result)) {
			System.out.println("ERROR:"+msg+". Expected "+expect+". Result "+result);
		}
	} // end assertEquals
}
