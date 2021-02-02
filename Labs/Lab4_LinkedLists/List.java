// REMEMBER: using Java Collections is not permitted.

public interface List<T> {

	/**
	 * This defines the methods of an abstract data type List.
	 */

	// ************ SETTERS, GETTERS, toPrint ******************* //

	public Integer length();

	public Integer capacity();

	public boolean isFull();

	public boolean isEmpty();

	// ******************* ADD ******************* //

	public void add(T item);

	public void add(T item, Integer index);

	public void addUnique(T[] array);

	public void set(T item, Integer index);

	// ******************* FIND ******************* //

	public T peek(Integer index);

	public Integer location(T item);

	public Integer lastLocation(T item);

	public boolean contains(T item);

	// ******************* REMOVE ******************* //

	public T remove(Integer index);

	public void remove(T item);

	public void removeAll();

	public void removeDuplicates();

	// ******************* CONVERT ******************* //

	public T[] toArray();

	public void toArray(T[] array);

} // end class List
