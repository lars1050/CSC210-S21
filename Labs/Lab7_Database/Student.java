/** General student class with basic information.*/
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
	Integer credits = 0;	// total credits earned
	Major major = Major.UNDECLARED;
	Integer yearOfGrad;

	public Student(String last, String first,
  Integer credits, Major major, Integer year) {
		lastName(last);
		firstName(first);
		credits(credits);
		major(major);
		yearOfGrad(year);
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
		return (id+": ("+yearOfGrad+") "+lastName+", "+firstName+". "+major+" "+credits+" credits");
	}

	// @TODO Implement compareTo with options for ordering.
	@Override
	public int compareTo(Student other) {
		return id.compareTo(other.id);
	} // end compareTo()

	// @TODO Implement equals (based on ID)
	@Override
	public boolean equals(Object other) {
		if (other == this) {
			return true;
		}
		if (!(other instanceof Student)) {
			return false;
		}
		return (id == ((Student) other).id);
	} // end equals()

	// All the setters and getters
	public void lastName(String n) { lastName = n; }
	public String lastName() { return lastName; }

	public void firstName(String n) { firstName = n; }
	public String firstName() { return firstName; }

	// for ID, getter only. This should never be changed.
	public Integer id() { return id; }

	public void credits(Integer c) { credits = c;}
	public Integer credits() { return credits; }

	public void yearOfGrad(Integer y) { yearOfGrad = y; }
	public Integer yearOfGrad() { return yearOfGrad; }

	public void major(Major m) { major = m; }
	public Major major() { return major; }

	// for orderBy, setter only (you can add getter if you want to)
	public static void orderBy(Order o) { orderBy = o; }
}
