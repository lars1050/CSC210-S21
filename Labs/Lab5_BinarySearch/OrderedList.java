/**
*/
public class OrderedList<T extends Comparable<T>> {

	/** An array of elements of type T (Comparable) */
	private T[] items;
	private int count = 0;
	private static final int DEFAULT = 10;

	/** Constructor to establish array (capacity of 10) */
	public OrderedList(int size) {
		// Compiler does not like casts like this.
		// Tell it not to generate warning when compiling
		// Note the array type Comparable being cast to T[]
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Comparable[size];
		items = temp;
	}

	public OrderedList() {
		this(DEFAULT);
	}

	@Override
	public String toString() {
		String output = "";
		for (int i=0; i<count; i++) {
			output += items[i].toString()+"\n";
		}
		return output;
	} // end toString()

	public T peek(int index) {
		// check for error condition ...
		// if requesting an element out of range of list
		// 0-based indexing -- cannot be equal to count!!
		if (index < 0 || index >= count) {
			return null;
		}
		return items[index];
	} // end peek()

	// this is a helper function for adding to an ordered list
	// shift everything from index to the end, 1 position to the right
	private void shiftRight(int index) {
		for (int i = count; i>index; i--) {
			items[i] = items[i-1];
		}
	} // end shiftRight()


	public void add(T element) {
		// Add an element, while maintaining order of list.
		// Not the most efficient way because requires a look at every element.
		// Iterate from end to location of add to be more efficient.
		// You do not have to change this -- just making note of it.

		// If full up, no can do
		if (count >= items.length) {
			return;
		}
		// determine where to add in the list based on ordering defined in T.
		// does not enter loop if list is empty (after you fix it!)
		// @TODO THIS WILL NOT COMPILE UNTIL YOU FIX IT!
		int i=0;
		while (items[i] < element) {
			++i;
		}
		// upon exit, i is the location where the element should be added.
		// if i not at the end, need to shift things to make room
		if (i<count) {
			shiftRight(i);
		}
		// place it and maintain count
		items[i] = element;
		++count;
	} // end add()


	// @TODO Implement the iterative version of binary search
	public int findIterative(T element) {
		// find the element provided and return the index
		// This is the iterative version of binary search!

		// indicate element not found
		return -1;
	} // end findIterative()


	// @TODO Implement the recursive version of binary search
	public int find(T element) {
		// find the element and return the index.
		// this is the recursive version of binary search

		// start the recursion, operating on entire list
		return findRec(element,0,count-1);
	} // end find()

	// this is the supplement to (helper function) for binary search
	// notice how helper functions are private
	private int findRec(T element, int start, int end ) {

		// indicate element not found
		return -1;
	} // end findRec

} // end orderedArray
