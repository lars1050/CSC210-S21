// REMEMBER: using Java Collections is not permitted.

public class SongList {

	/**
	This is a list of Song objects implemented with an array. The list may have duplicates. It is not in sorted order. Add and remove operate at the end of the list by default, but positional information can be provided to operate in the middle of the list.
	*/

	/** Array to store songs in queue */
	protected Song[] songs;

	/** The maximum size of the array for all queues */
	protected static final int DEFAULT_CAPACITY = 500;

	/** The capacity of the instance array (set to default). "capacity" is the equivalent to songs.length() and can be used interchangably. */
	private int capacity = DEFAULT_CAPACITY;

	/** The number of songs stored in the array. */
	private int count=0;


	// ============== 2 Overloaded Constructors ============== //

	/**
	Constructor
	@param size The capacity of the list (i.e. max number of elements)
	*/
	public SongList(int size) {
		capacity = size;
		songs = new Song[capacity];
	}

	/**
	Default Constructor
	*/
	public SongList() {
		this(DEFAULT_CAPACITY);
	}

	// ************   SETTERS, GETTERS, toPrint ******************* //

	public int length() { return count; }

	public int capacity() { return capacity; }

	public boolean isFull(){
		return true;
	}

	public boolean isEmpty() {
		return true;
	}

	/** Prints numbered list of songs.  */
	@Override
	public String toString() {
		String printedList = "";
		for (int i=0; i<count; i++) {
			printedList += (i+1) + ". " + songs[i].toString() + "\n";
		}
		return printedList;
	} // end toString()

	// *******************   ADD  ******************* //

	/**
	*/
	public void add(Song song) {

	} // end add(song)

	/**
	*/
	public void add(Song song, int index) {

	} // end add(Song, int)

	/**
	*/
	// overwrite the element
	public void set(Song song, int index) {

} // end set(Song, int)


	// *******************   SEARCH  ******************* //

	  /**
	  */
	  public Song peek(int index) {
	    return null;
	  } // end peek(int)

	  /**
	  */
	  public int location(Song song) {
	    return -1;
	  } // end location(Song)

		/**
		*/
		// make use of the location method!
		public boolean contains(Song song) {
			return false;
		}

		/**
		*/
		// return the first song that matches the given title
		public Song findTitle(String title) {
			return null;
		} // end findTitle


	// *******************   REMOVE  ******************* //

  /**
  */
  public Song remove(int index) {
    return null;
  } // end remove(int)

  /**
  */
	// can you make use of your remove method above?
  public void remove(Song song) {

  } // end remove(Song)

  /**
  */
	// no need to iterate.
  public void removeAll() {

  } // end removeAll()


  // *******************   CONVERT  ******************* //
  /**
  */
	// make a COPY of the song array and return it.
	// it should be the size of "count"
  public Song[] toArray() {
    return null;
  } // end toArray(song)


} // end class List
