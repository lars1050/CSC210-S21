import java.util.function.Function;
import java.util.LinkedList;

/** Homegrown dictionary (hashmap) for efficient storage
 * and retrieval of a collection of items within an array.
 * It uses a hash function to map the key value to an array index.
 * KEYS must be unique (but the hashed key might not be)
*/
public class Dictionary<K,T> {

  class ListNode {
    K key;
    T object;
    ListNode(K k, T obj) {
      key = k;
      object = obj;
    }
  }

	/** Max number of elements that can be stored.*/
  private static final Integer DEFAULT_CAPACITY = 100;

  @SuppressWarnings("unchecked")
  private LinkedList<ListNode>[] hashTable =  (LinkedList<ListNode>[]) new LinkedList[DEFAULT_CAPACITY];

	// Hash Function that maps the key to an index.
  // Default is to put everything into the linked list at index 0
  private Function<K,Integer> hashFunction = key -> 0;

	/** Count total comparisons for both put and get */
	int comparisons = 0;

	public int comparisons() { return comparisons; }

	/** Constructor.
   * @param hash Function mapping key value to array index.
  */
  public Dictionary(Function<K,Integer> hash) {

    // Set the hash function
    if (null != hash) {
      hashFunction = hash;
    }
    // else using the default definition above.
  }

  public Dictionary() {
    this(null);
  }

	/** Add an element to the hashTable. The key MUST be unique.
	@param key to be hashed
  @param value to be stored at hashed key
	*/
  public void put(K key, T object) {
    // Hash the key to get the index for the tables.
    Integer index = hashFunction.apply(key) % hashTable.length;

		// Count the number of comparisons to evaluate efficiency
		int putComparisons = 0;
    // Determine if key is unique
    if (null == hashTable[index]) {
      // If nothing currently at that hashed entry, create the linkedlist
      hashTable[index] = new LinkedList<ListNode>();
    } else {
      // See if another entry at that index has same key value

      for (ListNode el : hashTable[index]) {
        ++putComparisons;
        //ListNode el = (ListNode) obj;
        if (el.key.equals(key)) {
          System.out.println("Cannot add: "+key+" already used.");
          return;
        }
      }
    }
    // Add the object at that index, storing with the key to ensure
    // keys are unique.
    hashTable[index].add(new ListNode(key,object));
    System.out.println(putComparisons+" PUT "+key);
		comparisons += putComparisons;
  }

  /** Get the value associated with the key
  @param key to be hashed to lookup entry in hashtable
  @return object at hashed(key) with that unique key value
	*/
  public T get(K key) {
    // Hash the key
    Integer index = hashFunction.apply(key) % hashTable.length;

    // If nothing at that hashed index, it is not in the dictionary
    if (null == hashTable[index]) {
      // If nothing currently at that hashed entry
      return null;
    }

    // Search through linked list to find object with that unique key
    // Count the number of comparisons to evaluate efficiency
    int getComparisons = 0;
    LinkedList<ListNode> listAtIndex = hashTable[index];
    for (ListNode el : listAtIndex) {
      ++getComparisons;
      if (el.key.equals(key)) {
				System.out.println(getComparisons+" GET "+key);
				comparisons += getComparisons;
        return el.object;
      }
    } // end for
    System.out.println(getComparisons+"GET "+key);
		comparisons += getComparisons;
    // Not in the dictionary
    return null;
  } // end get()
} // end class Dictionary
