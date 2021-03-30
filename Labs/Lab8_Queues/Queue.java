/**
* Classic First-In-First-Out Queue (FIFO)
* push to add, pop to remove
* use a "circular" array to create the most efficient implementation
*/
public class Queue <T> {

	/** Maximum size of stack (if user does not specify) */
	private static final Integer DEFAULT_CAPACITY = 100;

	/** Primary structure to hold all the items */
	private T[] queue;

	/** Primary entry point of the list. */
	private int head;

	/** Last element in the list. */
	private int tail;

	private int size;

	/** Default constructor. Creating queue of default size */
	public Queue() {
		// Initialize an array of T with DEFAULT_CAPACITY
		// Include a "dummy node" to simplify code.
		@SuppressWarnings

	}

	/** Determine if empty.
	@return True if nothing in queue, else false
	*/
	public boolean empty() {

	}

	/** Remove first-in element (i.e. oldest in the queue)
	@return element removed from the queue -- ignore if empty.
	*/
	public T pop() {

		return null;
	}

	/** Add to the end of the list.
	@param el object to be added to queue.
	*/
	public void push(T el) {

	}
}
