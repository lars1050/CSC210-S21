/** A super, simple class perfect for experimenting with. */
public class Simple implements Comparable<Simple> {

	// Alpha and numeric fields can be used for ordering
	private String alpha = null;
	private Integer numeric = null;

	public Simple(String a, Integer n) {
		alpha = a;
		numeric = n;
	}

	public Simple() {
	}

	@Override
	public String toString() {
		return "("+alpha+","+numeric+")";
	}
	@Override
	public boolean equals(Object object) {
		if (this==object) {
			return true;
		}
		if (! (object instanceof Simple)) {
			return false;
		}
		Simple other = (Simple) object;
		if (alpha.equals(other.alpha) && numeric.equals(other.numeric)) {
			return true;
		}
		return false;
	} // end equals()

	@Override
	public int compareTo(Simple other) {
	  return alpha.compareTo(other.alpha);		// OPTION 1
		// return other.alpha.compareTo(alpha);	 // OPTION 2
		// return numeric.compareTo(other.numeric); // OPTION 3
		// return other.numeric.compareTo(numeric); // OPTION 4
	}
}
