import java.util.Comparator;

/** The idea of a database, but not really a database.
It is a context for practicing comparators. */
public class Database <T extends Comparable<T>> {

	/** Array to store elements of database. */
	T[] items;

	/** The maximum size of the array for all queues */
	protected static final int DEFAULT_CAPACITY = 500;

	/** The number of items stored in the database. */
	private int count=0;

	// ============== 2 Overloaded Constructors ============== //

	/**
	Constructor
	@param size The capacity of the list (i.e. max number of elements)
	*/
	public Database(int size) {
		@SuppressWarnings("unchecked")
		T[] temp = (T[]) new Comparable[size];
		items = temp;
	}

	/**
	Default Constructor
	*/
	public Database() {
		this(DEFAULT_CAPACITY);
	}

	// ************   SETTERS, GETTERS, toPrint ******************* //

	public int length() { return count; }

	public int capacity() { return items.length; }

	public boolean isFull(){
		return (count==capacity());
	}

	public boolean isEmpty() {
		return (0==count);
	}

	/** Pretty print the database.  */
	@Override
	public String toString() {
		String printedList = "";
		for (int i=0; i<count; i++) {
			printedList += items[i].toString() + "\n";
		}
		return printedList;
	} // end toString()

	private boolean indexValid(int index) {
		return (index >= 0 && index < count );
	}

	// *******************   ADD  ******************* //

	/**
	*/
	public void add(T item) {
		if (isFull()) {
			return;
		}
		items[count] = item;
		count++;
	} // end add(song)

	// *******************   SEARCH  ******************* //

	  /**
	  */
	  public T peek(int index) {
	    if (indexValid(index)) {
				return items[index];
			}
			return null;
	  } // end peek(int)

	  /** Linear search to locate item. USE EQUALS.
	  */
	  public int find(T item) {
	    return -1;
	  } // end find(item)

		/** Linear to find the first element that is less than the item (given the comparator).
		*/
		public T findLessThan(T item, Comparator<T> orderBy) {
			return null;
		}

		/** Linear search to locate first item with Key value.
		Use the Comparator to comare the key against the item.
		It is assumed that the key is the first parameter of byKey and
		the item in the database is the second parameter.
		*/
		public T findKey(Object key, Comparator<Object> byKey) {
			return null;
		}


		/** Linear search to locate first item with key values that match BOTH.
		Use the Comparators to comare each key against the item.
		It is assumed that the key is the first parameter of byKey and
		the item in the database is the second parameter.
		*/
		public T findKeyAnd(Object key1, Comparator<Object> byKey1,
												Object key2, Comparator<Object> byKey2) {
			return null;
		}

		/** Linear search to locate first item with key values that match BOTH.
		Use the Comparators to comare each key against the item.
		It is assumed that the key is the first parameter of byKey and
		the item in the database is the second parameter.
		*/
		public T findKeyOr(Object key1, Comparator<Object> byKey1,
												Object key2, Comparator<Object> byKey2) {
			return null;
		}

		/** Linear search to locate ALL items that match the key value.
		Use the Comparators to comare each key against the item.
		It is assumed that the key is the first parameter of byKey and
		the item in the database is the second parameter.
		*/
		public T[] findAll(Object key, Comparator<Object> byKey) {
			@SuppressWarnings("unchecked")
			T[] array = (T[]) new Comparable[count];

			return array;
		}


} // end class List
