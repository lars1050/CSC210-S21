/**
* Classic Last-In-First-Out Queue (LIFO) or STACK
* push to add, pop to remove
*/
public class Stack<T> {

	// Using an array for easy implementation of adding and removing at end.

	/** Maximum size of stack */
	private static final Integer DEFAULT_CAPACITY = 100;

	/** Primary structure to hold all the items */
	private T[] stack;

	/** Number of elements currently in the list. */
	private int size;

	/** Default constructor using default capacity */
	public Stack() {
	}

	/** Determine if empty.
	@return true if nothing in stack, else false. */
	public boolean empty() {
		return false;
	}

	/** Remove last-in element (i.e. newest in the stack)
	@return element removed from the stack -- ignore if empty.
	*/
	public T pop() {

		return null;
	}

	/** Add to the end of the list.
	@param el object to be added to stack.
	*/
	public void push(T el) {

	}
}
