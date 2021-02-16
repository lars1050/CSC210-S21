/** General person class with basic information.*/
public class Student implements Comparable<Student> {

	/** static variable for creating a unique id */
	private static Integer nextID = 21000;
	private static Integer idGenerator() {
		// Every time a student is created, this method is called to
		// generate new, unique id.
		// notice the post-fix ++, returns current value, then increments.
		return nextID++;
	}

	/* Fields that can be used to order Student */
	public static enum Order { ID, LAST, YEAR, MAJOR };
	private static Order orderBy = Order.ID; // default order value

	private final Integer id=idGenerator();		// unique identifier

	String lastName;
	String firstName;
	int credits = 0;	// total credits earned
	Major major = Major.UNDECLARED;
	int yearOfGrad;

	public Student(String last, String first, int credits, Major major, int year) {
		lastName(last);
		firstName(first);
		credits(credits);
		major(major);
		yearOfGrad(year);
		//id = idGenerator();
	}

	/** Constructor with the basics */
	public Student(String last, String first) {
		this(last,first,0,Major.UNDECLARED,2024);
	}

	/** "Default" constructor. */
	public Student() {
		// first and last will be null.
	}

	@Override
	public String toString() {
		return (id+": ("+yearOfGrad+") "+lastName+" "+firstName+". "+major+" "+credits+" credits");
	}

	// @TODO Implement compareTo with options for ordering.
	@Override
	public int compareTo(Student other) {
		// the user can change the method of comparison by setting the orderBy var.
		// check the value of orderBy to determine how to order students
		// acceptable values are specified in enum Order.
		// see requirements (readme) for more info.
		// NOTE: this is not how you should do this, but I have not yet shown
		// you the correct (more complicated) way to do this,
		// so we are doing it this way until I teach you the other way

		// placeholder until this is implemented.
		return 0;
	} // end compareTo()

	// @TODO Implement equals (based on ID)
	@Override
	public boolean equals(Object other) {
		// Check if it is the same object, the same type of object.
		// Then check if the id's are the same (and only the id's)
		// Look at the Song.equals method for an example.

		// placeholder until ths is implemented.
		return true;
	} // end equals()

	// All the setters and getters
	public void lastName(String n) { lastName = n; }
	public String lastName() { return lastName; }

	public void firstName(String n) { firstName = n; }
	public String firstName() { return firstName; }

	// for ID, getter only. This should never be changed.
	public int id() { return id; }

	public void credits(int c) { credits = c;}
	public int credits() { return credits; }

	public void yearOfGrad(int y) { yearOfGrad = y; }
	public int yearOfGrad() { return yearOfGrad; }

	public void major(Major m) { major = m; }
	public Major major() { return major; }

	// for orderBy, setter only (you can add getter if you want to)
	public static void orderBy(Order o) { orderBy = o; }
}
