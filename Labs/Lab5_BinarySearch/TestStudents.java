/** README.md
- Create find that is an iterative binary search.
- Create findRecursive that is a recursive binary search.
- Test your implementation with persons test file.
- Finish your in-class work on Person
- Test your implementation with Person test file.
*/

public class TestStudents {

	public static void main(String[] args) {
		testOrderLast();
		testOrderYear();
		testOrderMajor();
		testFind();
		testFindRecursive();
	}

	// Create students for tests Student(last,first,credits,major,year);
	static Student joS = new Student("smith","jo",50,Major.CSC,2022);
	static Student joA = new Student("ali","jo",30,Major.CSC,2021);
	static Student su = new Student("lui","su",40,Major.CSC,2024);
	static Student mia = new Student("nunes","mia",25,Major.MIS,2024);
	static Student isa = new Student("nunes","isa",12,Major.ART,2021);
	static Student matt = new Student("johnson","matt",80,Major.MAT,2023);

	/** ----------------------------------------------------------------- **/
	public static void testOrderLast() {

		System.out.println("\nTesting order by last name, first name ...");

		Student.orderBy(Student.Order.LAST);
		OrderedList<Student> students = new OrderedList<>();
		students.add(joS);
		students.add(joA);
		students.add(su);
		students.add(mia);
		students.add(isa);

		// Testing order maintained by last name, then first when adding students.
		// VISUAL INSPECTION
		System.out.println("ORDER BY LAST Expect: joA, su, isa, mia, joS");
		System.out.println("\n"+students);
	} // end testOrderLast

	/** ----------------------------------------------------------------- **/
	public static void testOrderYear() {

		System.out.println("\nTesting order by year, credits ...");

		Student.orderBy(Student.Order.YEAR);
		OrderedList<Student> students = new OrderedList<>();
		students.add(joS);
		students.add(joA);
		students.add(su);
		students.add(mia);
		students.add(isa);
		students.add(matt);

		// Testing order maintained by year, then credits when adding students.
		// NOTE: ordering incorrect originally. 
		// Also, I have years in ascending and credits in descending. I will accept either order.
		// VISUAL INSPECTION
		System.out.println("ORDER BY YEAR Expect: joA, isa, joS, matt, mia, su");
		System.out.println("\n"+students);

	} // end testOrderAge

	/** ----------------------------------------------------------------- **/
	public static void testOrderMajor() {

		System.out.println("\nTesting order by Major, year ...");

		Student.orderBy(Student.Order.MAJOR);
		OrderedList<Student> students = new OrderedList<>();
		students.add(mia);
		students.add(joS);
		students.add(su);
		students.add(joA);
		students.add(isa);
		students.add(matt);

		// Testing order maintained by year, then credits when adding students.
		// VISUAL INSPECTION
		System.out.println("ORDER BY Major Expect: joA, joS, su, mia, matt, isa  ");
		System.out.println("\n"+students);
	}

	/** ----------------------------------------------------------------- **/
	public static void testFind() {

		System.out.println("\nTesting find (non-recursive) ...");

		// Testing Find last name (non-recursive)
		Student.orderBy(Student.Order.LAST);
		OrderedList<Student> students = new OrderedList<>();
		students.add(joS);
		students.add(joA);
		students.add(su);
		students.add(mia);
		students.add(isa);

		Student noStudent = new Student("x","y");
		if (-1 != students.find(noStudent)) {
			System.out.println("findIterative(noStudent) not null");
		}
		int index = -1;
		// in first position
		index = students.findIterative(joA);
		assertEquals(joA.firstName(),students.peek(index).firstName(),"find joA");
		// in last position
		index = students.findIterative(joS);
		assertEquals(joS.firstName(),students.peek(index).firstName(),"find joS");
		// in the middle with odd count
		index = students.findIterative(isa);
		assertEquals(isa.firstName(),students.peek(index).firstName(),"find middle (odd count)");
		// in middle with even count
		students.add(matt);
		index = students.findIterative(mia);
		assertEquals(mia.firstName(),students.peek(index).firstName(),"find in middle (even count)");
	}

	/** ----------------------------------------------------------------- **/
	public static void testFindRecursive() {

		System.out.println("\nTesting find (recursive) ...");

		// Testing Find last name (recursive)
		Student.orderBy(Student.Order.LAST);
		OrderedList<Student> students = new OrderedList<>();
		students.add(joS);
		students.add(joA);
		students.add(su);
		students.add(mia);
		students.add(isa);

		Student noStudent = new Student("x","y");
		if (-1 != students.find(noStudent)) {
			System.out.println("find(noStudent) not null");
		}
		int index = -1;
		// in first position
		index = students.find(joA);
		assertEquals(joA.firstName(),students.peek(index).firstName(),"find joA");
		// in last position
		index = students.find(joS);
		assertEquals(joS.firstName(),students.peek(index).firstName(),"find joS");
		// in the middle with odd count
		index = students.find(isa);
		assertEquals(isa.firstName(),students.peek(index).firstName(),"find middle (odd count)");
		// in middle with even count
		students.add(matt);
		index = students.find(mia);
		assertEquals(mia.firstName(),students.peek(index).firstName(),"find in middle (even count)");
	}

	/** ----------------------------------------------------------------- **/
	/** ----------------------------------------------------------------- **/
	public static void assertEquals(Object expect, Object result, String msg) {
		if (null==expect && null==result) {
			return;
		} else if ((null==expect && null!=result) || !expect.equals(result)) {
			System.out.println("ERROR:"+msg+". Expected "+expect+". Result "+result);
		}
	} // end assertEquals
}
