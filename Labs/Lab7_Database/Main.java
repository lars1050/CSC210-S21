import java.util.Comparator;
import java.lang.Exception;

public class Main {

  public static void main(String[] args) {
    Database<Student> db = DatabaseMaker.makeDB(20);
    System.out.println(db);

		Student s = db.peek(0);

		// Testing Equality
		boolean answer = keyLast.compare("Larson",s)==0;
		System.out.println(s.lastName+" ?==? Larson ("+answer+")");
		answer = keyLast.compare("Ali",s)==0;
		System.out.println(s.lastName+" ?==? Ali ("+answer+")");

		// Testing Order
		int value = keyLast.compare("Larson",s);
		System.out.print("Comparison value is "+value+", which means ");
		if (value < 0) {
			System.out.println("Larson < "+s.lastName);
		} else {
			System.out.println("Larson > "+s.lastName);
		}

		try {
			// Example of throwing exception because parameters not correct.
			answer = keyLast.compare(s,"Ali")==0;
		} catch (Exception e) {
			System.out.println("\n*** ERROR ***");
			e.printStackTrace();
		}

		// Make sure this is all compiling (YOU have to test it though)
		System.out.println("\nIS IT ALL COMPILING? .... ");
		db.find(s);
		//db.findLessThan(s, byDefault); // define byDefault, then uncomment.
		db.findKey("Larson", keyLast);
		db.findAll("Larson", keyLast);
		db.findKeyOr("Larson", keyLast, "Ali", keyLast);

		// obviously, this will never find anything.
		// choose another field to match with a different comparator.
		db.findKeyAnd("Larson", keyLast, "Ali", keyLast);

	} // end main

	/** Example of a comparator (a slight abuse of the construct) that
	is comparing a String to a Student */
	public static Comparator<Object> keyLast = new Comparator<Object>() {
		@Override
		public int compare(Object keyObj, Object studentObj) {
			if (!(keyObj instanceof String) || (!(studentObj instanceof Student))) {
				throw new IllegalArgumentException("Not instance of.");
			}
			String key = (String) keyObj;
			Student student = (Student) studentObj;
			return key.compareTo(student.lastName());
		}
	}; // end keyLast
} // end class Main
