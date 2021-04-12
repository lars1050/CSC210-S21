/** Binary node class for use with any type of binary tree.
*/
public class BinaryNode<T> {

	/** Data to be stored in node. */
	private T data = null;

	/** Height of node within tree. Height is longest simple path to leaf. */
	private Integer height = null;

	/** Depth of node within tree. Depth is length of path from root to node. */
	private Integer depth = null;

	/** Balance factor (difference in node count of left and right subtrees) */
	private Integer balance = 0;

	/** Right child of Node. */
	private BinaryNode<T> right = null;

	/** Left child of Node. */
	private BinaryNode<T> left = null;

	/** Constructor
	@param val Data to be stored in node.
	*/
	public BinaryNode(T val) {
		data = val;
		// use default for all other values
	}

	/** Default constructor -- creating null data.
	*/
	public BinaryNode() {
		this(null);
	}

	// Getters and setters are named such that they do not need Javadocs

	// Getters for "pointers"
	public BinaryNode<T> right() { return right; }
	public BinaryNode<T> left() { return left; }
	// Setters for "pointers"
	public void right(BinaryNode<T> n) { right = n; }
	public void left(BinaryNode<T> n) { left = n; }

	// Getters and Setters for data, height, depth.
	public T data() { return data; }
	public void data(T d) { data = d; }
	public Integer height() { return height; }
	public void height(Integer h) { height = h; }
	public Integer depth() { return depth; }
	public void depth(Integer d) { depth = d; }

} // end class Node
