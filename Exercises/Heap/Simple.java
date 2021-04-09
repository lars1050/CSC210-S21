import java.util.Comparator;
import java.util.*;

/** A very simple class for testing data structures that use comparable objects.
*/
public class Simple implements Comparable<Simple> {
	/** One alpha and one numeric*/
	private String alpha = "a";
	private Integer numeric = 0;

	/** Constructor with user input.
	@param a The alpha (String)
	@param n The numeric (Integer)
	*/
	public Simple(String a, Integer n) {
		alpha = a;
		numeric = n;
	}

	/** Default Constructor. Always a good idea to include one. */
	public Simple() {
		this("a",0);
	}

	/** For pretty printing the pair of values
	@return String version of the object
	*/
	@Override
	public String toString() {
		return "("+alpha+","+numeric+")";
	}
	
	// setters 
	public void numeric(Integer val) { numeric = val; }
	public void alpha(String val) { alpha = val; }

	/** Overriding Java's Object equals method. Alpha is case-sensitive.
	@param other Object compared to this.
	@return true if alpha is same
	*/
	@Override
	public boolean equals(Object other) {
		// The parameter must be of type Object to Override the equals method
		// of Java's Object class (which all things derive from)

		// if the same object in memory, definitely equal (i.e. == would be true)
		if (this==other) {
			return true;
		}
		// if other is not a Simple object, no way can they be equal
		if (!(other instanceof Simple)) {
			return false;
		}
		// Have to cast
		Simple s = (Simple) other;
		return (alpha().equals(s.alpha()));
	}

	/** The reason for this class -- to use with data structures that store comparable items. It is case-sensitive.
	@param other Simple object to compare to this.
	@return typical <0 0 >0 to signify this<other, this==other, this>other
	*/
	@Override
	public int compareTo(Simple other) {
		return numeric().compareTo(other.numeric());
	}

	// The Getters -- no setters here.
	public String alpha() { return alpha; }
	public Integer numeric() { return numeric; }

	/** Comparator object for ordering based on the alpha variable.
	A declaration and definition all in one.
	To use: Simple.orderByAlpha.compare( , );
	*/
	public static Comparator<Simple> orderByAlpha = new Comparator<Simple>() {
		@Override
		public int compare(Simple s1, Simple s2) {
			return s1.alpha().compareTo(s2.alpha());
		}
	}; // end orderByAlpha

	/** Comparator object for ordering based on the numeric variable.
	A declaration and definition all in one.
	To use: Simple.orderByNumeric.compare( , );
	*/
	public static Comparator<Simple> orderByNumeric = new Comparator<Simple>() {
		@Override
		public int compare(Simple s1, Simple s2) {
			return s1.numeric().compareTo(s2.numeric());
		}
	}; // end orderByNumeric

	/** Comparator object for querying based on alpha variable (case-senstive).
	A declaration and definition all in one.
	To use: Simple.queryByAlpha.compare( , );
	*/
	public static Comparator<Object> queryByAlpha = new Comparator<Object>() {
		@Override
		public int compare(Object obj, Object key) {
			// classCastException will be thrown if obj not Simple.
			Simple simple = (Simple) obj;
			// classCastException will be thrown if key is not String
			String alpha = (String) key;
			// this is case-sensitive
			return simple.alpha().compareTo(alpha);
		}
	}; // end queryByAlpha

	/** Comparator object for querying based on alpha variable (case-senstive).
	A declaration and definition all in one.
	To use: Simple.queryByNumeric.compare( , );
	*/
	public static Comparator<Object> queryByNumeric = new Comparator<Object>() {
		@Override
		public int compare(Object obj, Object key) {
			// classCastException will be thrown if obj not Simple.
			Simple simple = (Simple) obj;
			// classCastException will be thrown if key not Integer.
			Integer numeric = (Integer) key;
			// Using defualt compareTo for Integers.
			return simple.numeric().compareTo(numeric);
		}
	}; // end queryByAlpha
}
