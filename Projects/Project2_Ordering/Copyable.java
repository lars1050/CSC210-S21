/** A made-up interface to illuminate the difference between copying a reference, a shallow copy, and a deep copy. Other options for creating copies of objects include a COPY CONSTRUCTOR and implementing Clonable.
*/
public interface Copyable <T> {
	/** Create a new object of type T with a copy of "this" variable data.
	@return new object of type T with same data as "this"
	*/
  public Object copyThis();
}
