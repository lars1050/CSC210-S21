/** A collection of items that might be a set.
*/
public class Items {

	/** Fixed sized array of doubles */
	private double[] A = new double[10];

	/** Number of elements stored in the array */
	private int count = 0;

	/** Default constructor -- nothing to do */
	public Items() {
	}

	/** Constructor that initializes the array with the provided numbers.
	@param numbers elements to add to array.
	*/
	public Items(double[] numbers) {
		add(numbers);
	}

	/** Getter for ocunt */
	public int count() { return count; }

	/** add all numbers from the input to the array A.
	IF, more numbers than capacity, add up to capacity of array A.
	@param numbers elements to add to array (up to capacity of A)
	*/
	public void add(double[] numbers) {
		// determine how many of the numbers to add to A.
		int max = 0;
		if (numbers.length <= A.length) {
			max = numbers.length;
		} else {
			max = A.length;
		}
		// add that many numbers to items.
		for (int i=0; i<max; i++) {
			A[i] = numbers[i];
		}
		// set count to reflect number of elements stored in A.
		count = max;
	}

	/** Determine if more than one element of given value is in A.
	@param n value to check for duplicates in A
	@return true: if more than one of n
	*/
	public boolean duplicate(double n) {
		// initialize frequency of n in A
		int frequency = 0;
		// iterate looking for n
		for (int i=0; i<count; i++) {
			if (A[i]==n) {
				++frequency;
				// if we found more than 1, then there is a duplicate
				if (frequency==2) {
					return true;
				}
			}
		}
		// if we are here, there is 0 or 1 of n -- no duplicates
		return false;
	}

	/** Peek at the middle element of A.
	@return middle element (based on position not value)
	*/
	public double middle() {
		return A[count/2];
	}

	/** Determine if A is a set.
	@return true if A is a Set
	*/
	public boolean set() {
		// for evey element in A, check every element to the right
		// to see if there is a match. as soon as there is 1 match, not a set.
		for (int i=0; i<count-1; i++) {
			for (int j=i+1; j<count; j++) {
				if (A[i]==A[j]) {
					return false;
				}
			}
		}
		// if here, it means no duplicates in A. it's a set!
		return true;
	}

	/** Find and remove all elements in A with a duplicate
	*/
	public void removeDuplicates() {
		// create a new array for unique elements
		// "last" is the count of elements stored in set.
		double[] set = new double[A.length];
		int last = 0;
		for (int i=0; i<count; i++) {
			// determine if element A[i] is in set.
			boolean match = false;
			for (int j=0; j<last; j++) {
				if (A[i]==set[j]) {
					match = true;
					break;
				}
			} // end for j
			// if the element is not in set, add it
			if (!match) {
				set[last] = A[i];
				last++;
			}
		} // end for i
		// have A reference the new array "set" with unique elements
		A = set;
		count = last;
	} // end makeSet

	@Override
	public String toString() {
		String result = "";
		for (int i=0; i<count; i++) {
			if (i==0) {
				result = "{ "+A[i];
			} else {
				result += ", "+A[i];
			}
		}
		result += " }";
		return result;
	}
}
