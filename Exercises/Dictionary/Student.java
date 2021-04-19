/** General student class with basic information.*/
public class Student implements Comparable<Student> {


	String lastName;
	String firstName;
	Integer yearOfGrad;

	public Student(String last, String first, Integer year) {
		lastName(last);
		firstName(first);
		yearOfGrad(year);
	}

  public Student(String last, String first) {
    this(last,first,-1);
  }

	@Override
	public String toString() {
		return ("("+yearOfGrad+") "+lastName+", "+firstName);
	}

	// @TODO Implement compareTo with options for ordering.
	@Override
	public int compareTo(Student other) {
		return lastName.compareTo(other.lastName);
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
    Student student = (Student) other;
		return (
      lastName.equals(student.lastName) && firstName.equals(student.firstName));
	} // end equals()

	// All the setters and getters
	public void lastName(String n) { lastName = n; }
	public String lastName() { return lastName; }

	public void firstName(String n) { firstName = n; }
	public String firstName() { return firstName; }

	public void yearOfGrad(Integer y) { yearOfGrad = y; }
	public Integer yearOfGrad() { return yearOfGrad; }
}
