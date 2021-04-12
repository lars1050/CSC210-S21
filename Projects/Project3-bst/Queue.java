/** Classic FIFO queue using a CIRCULAR ARRAY with a "dummy" item!!
Queues only have 2 operators: push/add and pop/remove.
The user can check if the Queue is empty or full.
There is not tracking of the number of items in the queue.
*/
public class Queue<T> {

	/** Max number of elements that can be stored.
	Used if user does not provide a capacity.
	*/
  private static final Integer DEFAULT_CAPACITY = 100;

	/** Where everything is happening */
  private T[] queue;

	// Index into the array to indicate the first element.
  private int head;

	/*
	Index into the array to indicate the next-to-last element.
	The tail marks where the next element should be added (it does not point to the last element.)
	*/
  private int tail;

	/** Constructor with user-specified capacity.
	*/
  public Queue(Integer capacity) {
		// Note capacity+1 to accommodate the "dummy" slot
    @SuppressWarnings("unchecked")
    T[] temp = (T[]) new Object[capacity+1];
    queue = temp;
		// empty queue places head and tail at first element
    head = 0;
    tail = 0;
  }

	/** Constructor using default capacity */
  public Queue() {
    this(DEFAULT_CAPACITY);
  }

	/** Use to determine if full. push will be ignored if full.
	@return true if full.
	*/
  public boolean full() {
    return (next(tail) == head);
  }

	/** use to determine if empty. Pop will return null if empty.
	@return true if empty
	*/
  public boolean empty() {
    return (head == tail);
  }

	// Private internal method to calculate next modulo capacity+1
	// Internal methods do not need Javadocs
  private int next(int value) {
    return (value+1) % queue.length;
  }

	/** Remove the oldest element in the queue (at the front)
	@return front of the list, or null if empty.
	*/
  public T pop() {

  }

  /* Add the element to the end of the queue.
	@param data to be added. IGNORE if queue is full.
	*/
  public void push(T data) {

  }
}
