import java.util.*;

public class MaxHeap<T extends Comparable> {

	static final int DEFAULT_CAPACITY = 20;

	/** number of elements in the heap */
	int size = 0;

	/* Storing of the heap -- initialized with constructor */
	T[] heap = null;

	/** The order used to build the heap. Use T compareTo as default. */
	private Comparator<T> sortOrder;

	// if user does not specify sort order, then use compareTo of class T
	class DefaultOrder implements Comparator<T> {
		@Override
		public int compare(T obj1, T obj2) {
			return obj1.compareTo(obj2);
		}
	};

	// determine the indes of the left, right, and parent of a given index.
	private int indexOfLeft(int index) {
		return -1;
	}
	private int indexOfRight(int index) {
		return -1;
	}
	private int indexOfParent(int index) {
		return -1;
	}

	/** Constructor in which user specifies sorting order.
	@param orderBy comparator to establish heap ordering.
	*/
	public MaxHeap(Comparator<T> orderBy) {
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Comparable[DEFAULT_CAPACITY];
		heap = temp;
		if (orderBy==null) {
			sortOrder = new DefaultOrder();
		} else {
			sortOrder = orderBy;
		}
	}

	/** Default constructor using default compareTo method of type T */
	public MaxHeap() {
		this(null);
	}

	/** Setter of sortOrder which necessitates a reordering (i.e. rebuild heap)
	@param orderBy determines ordering within the tree.
	*/
	public void sortOrder(Comparator<T> orderBy) {
		sortOrder = orderBy;
		buildHeap();
	}

	/** Reorganize the heap. This is necessary if sortOrder changes. */
  private void buildHeap() {
    for (int i=heap.length/2+1;i>=0;i--) {
      maxHeapify(i);
    }
  }

	// this should be private, but made it public for testing.
	/** Sink the element at index i down to its proper place (meaning the heap property is maintained). The heap property ordering uses sortOrder.
	@param index Position in the heap that needs to be ordered
	*/
  public void maxHeapify(int index) {

  }

	/** Remove the maximum element from the heap -- leaving it in heap order.
	@return maximum element in the tree (the root)
	*/
	public T extractMax() {
		return null;
	}

	/** Change the key of a given element. */
	public void keyChanged(T item) {
		// find the item.
		// reorganize
	}

	/** Add an element to the heap. It is added to the end, then floats up
	to its final position in which the heap property is maintained.
	@param item of type T to be added to the heap (maintaining heap order)
	*/
	public void insert(T item) {
			// add this new item to the heap
			heap[size] = item;
			++size;
			// item is at the bottom.
			// float it up the tree as long as it is greater than its parent
			// and it is not the root.
			int currentIndex = size-1;
			int parentIndex = indexOfParent(currentIndex);
			while(parentIndex>=0 && sortOrder.compare(heap[parentIndex],item) < 0) {
				heap[currentIndex] = heap[parentIndex];
				heap[parentIndex] = item;
				currentIndex = parentIndex;
				parentIndex = indexOfParent(currentIndex);
			}
	} // end insert

	/** To see the array (note that this will not print in order!!) */
	public void print() {
		for (int i=0; i<size; i++) {
			System.out.print(heap[i]);
		}
		System.out.println();
	}
} // end MaxHeap
