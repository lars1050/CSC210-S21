import java.util.Comparator;
import java.util.*;

/** A simple class for testing orderings, sorting, finding, etc.*/
public class Simple implements Comparable<Simple>, Copyable<Simple> {
	private String alpha = "a";
	private Integer numeric = 0;

	/** Only constructor -- must provide data to fill in object */
	public Simple(String a, Integer n) {
		alpha = a;
		numeric = n;
	}

	/** COPY CONSTRUCTOR */
	public Simple(Simple toCopy) {
		this(toCopy.alpha(),toCopy.numeric());
	}

	@Override
	public String toString() {
		return "("+alpha+","+numeric+")";
	}
	@Override
	public boolean equals(Object other) {
		if (this==other) return true;
		Simple s = (Simple) other;
		return (alpha().equals(s.alpha()) && numeric()==s.numeric());
	}

	@Override
	public int compareTo(Simple other) {
		return alpha().compareTo(other.alpha());
	}

	/** This is implementing the Copyable interface */
	@Override
	public Simple copyThis() {
		return new Simple(alpha,numeric);
	}

	/** Getter and Setters */

	public String alpha() { return alpha; }
	public Integer numeric() { return numeric; }
	public void alpha(String s) { alpha=s; }
	public void numeric(Integer n) { numeric=n; }

	/** Comparators for ordering */
	public static Comparator<Simple> orderByAlpha = new Comparator<Simple>() {
		@Override
		public int compare(Simple s1, Simple s2) {
			//System.out.println(s1+" "+s2);
			return s1.alpha().compareTo(s2.alpha());
		}
	}; // end orderByAlpha

	public static Comparator<Simple> orderByNumeric = new Comparator<Simple>() {
		@Override
		public int compare(Simple s1, Simple s2) {
			return s1.numeric().compareTo(s2.numeric());
		}
	}; // end orderByNumeric

	/** KEY Comparators for querying the list (our faux database) */
	public static Comparator<Object> queryByAlpha = new Comparator<Object>() {
		@Override
		public int compare(Object key, Object obj) {
			Simple simple = (Simple) obj;
			String alpha = (String) key;
			return simple.alpha().compareTo(alpha);
		}
	}; // end queryByAlpha

	public static Comparator<Object> queryByNumeric = new Comparator<Object>() {
		@Override
		public int compare(Object key, Object obj) {
			Simple simple = (Simple) obj;
			Integer numeric = (Integer) key;
			return simple.numeric().compareTo(numeric);
		}
	}; // end queryByNumeric
}
