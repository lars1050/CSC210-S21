import java.util.Comparator;
import java.util.*;

/* It isn't necessary to use this to work on the BST code. But if you want to try some different types, this one is, well, simple. */

public class Simple implements Comparable<Simple> {
	private String alpha = "a";
	private Integer numeric = 0;
	public Simple(String a, Integer n) {
		alpha = a;
		numeric = n;
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
		// EXCHANGE THESE TO CHANGE THE ORDERING
		return numeric().compareTo(other.numeric());
		//return alpha().compareTo(other.alpha());

	}

	public String alpha() { return alpha; }
	public Integer numeric() { return numeric; }
	public void alpha(String s) { alpha=s; }
	public void numeric(Integer n) { numeric=n; }

}
