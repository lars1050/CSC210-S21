public class BinarySearchTree<T extends Comparable<T>> {

	private Node root = null;

	class Node {
		T data;
		Node left = null;
		Node right = null;
		Node parent = null;
		Node(T d) {
			data = d;
		}
	}

	/** Constructor  */
	public BinarySearchTree() {
	}


	/** pretty print string for this list. Use recursion! */
	public String toString() {
		String output = "";
		// >>>> COMPLETE THIS
		return output;
	}

	// Insert an element into the tree at its proper place
	public void add(T element) {
		Node node = new Node(element);
		if (null==root) {
      root = node;
			return;
   }
	 Node current = root;
	 // Once a node has been added, it returns.
	 // This while condition should never be false
	 while (null != current) {
		 // go left
		 if (node.data.compareTo(current.data)>0) {
			 if (null == current.left) {
				 node.left = current;
				 node.parent = current.left;
				 return;
			 }
			 else {
				 current = current.left;
			 }
		 }
		 else {
			 if (null == current.right) {
				 current.right = node;
				 node.parent = current.right;
				 return;
			 }
			 else {
				 current = current.right;
			 }
		 }
	 }
 } // end add

	/** find the element provided and return that object (not the index) */
	public T find(T element) {
		return null;
	} // end find

} // end orderedArray
