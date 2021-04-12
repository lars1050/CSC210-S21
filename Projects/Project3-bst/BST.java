import java.util.*;

/** Binary Search Tree storing type T */
public class BST <T extends Comparable> {

	/** Root of binary search tree */
	private BinaryNode<T> root = null;

	/** Number of nodes in the tree */
	private int numberOfNodes = 0;

	/** The order used to build the tree. Use T compareTo as default. */
	private Comparator<T> orderBy = new Comparator<T>() {
		@Override
		public int compare(T obj1, T obj2) {
			return obj1.compareTo(obj2);
		}
	};

	/** Root getter */
	public BinaryNode root() { return root; }

	// -------------------------------------------------------------
	// ------------------------------   PRIMARY OP add()
	// -------------------------------------------------------------
	public void add(T object) {
		// use orderBy to maintain BST property
		// a buggy add was provided in the in-class exercise
		// include your fixed code here
	}

	// -------------------------------------------------------------
	// --------------  FIND(el) a specific element, the min, the max
	// -------------------------------------------------------------

	// Finding the node corresponding to the given data.
	public BinaryNode<T> find(T object) {
		// recursive or iterative search through the tree, searching for object
		return null;
	}

	// do not iterate over the entire tree looking for minimum!
	public T min() {
		return null;
	}

	// do not iterate over the entire tree looking for maximum!
	public T max() {
		return null;
	}

	// -------------------------------------------------------------
	// --------------  RESTRUCTURE with balance() or reorder()
	// -------------------------------------------------------------

	public void balance() {
		// reorganize tree to ensure it is in balance.
		// probably use recursion -- looks a lot like binary search
		// When complete, the height of the tree should be O(lg n)
		// Process: convert to a sorted array, then rebuild the tree
	}

	public void reorder(Comparator<T> order){
		orderBy = order;
		// Use the comparator to rebuild the tree according to this given comp.
		// it does not have to be balanced!
	}

	// -------------------------------------------------------------
	// -------  CHARACTERIZE nodes/tree: depth, height, balance factor
	// -------------------------------------------------------------

	// calculate the depth of every node of the tree.
	public void calculateDepth() {
		// perform a bfs and fill in the depth
	}

	// calculate the height of every node of the tree.
	// return the height of the tree.
	// The height of any node is the max(right.height,left.height)+1
	// imho, recursion is your best option (similar to dfs).
	public int calculateHeight() {
		return 0;
	}


	// determine balance factor for every node.
	public void calculateBalanceFactor() {

	}

	// Determine if tree is balanced. (zyBook 9.1)
	// true: left and right balance factor of every node differs by at most 1
	public boolean isBalanced() {
		// IS THE HEIGHT UP-TO-DATE?
		return false;
	}

	// -------------------------------------------------------------
	// ------------  INSPECTING CONTENTS toString, toArrayList, Visualize
	// -------------------------------------------------------------

	public String toString() {
		// return a string with elements in order.
		// recursion is probably the easiest, but
		// you can also use a DFS with a stack
		return null;
	}

	public ArrayList<T> toArrayList() {
		// convert tree to SORTED array. use recursion (like print) or your dfs.
		// do not put into an array and then sort -- it is not efficient.
		ArrayList<T> array = new ArrayList<>();

		return array;
	}

	// Use the height of the tree to set the height of the visualization.
	// AND
	// use the height of the tree to set the width (maybe +16 for each level)
	/** Simple visualization of the tree.
	*/
	public void visualize() {
		// copied from web -- citation provided later

		// Now that you can determine the height of the tree,
		// you can use that to guestimate good width and height values.

		// establish total width of tree
		// if elements too crowded, increase this -- use powers of 2.
		final int width = 32;

		// will not visualize greater than this height.
		// use tree height when you have that complete.
		int height = numberOfNodes;
		//int height = root.height();

		// length of entire string holding tree -- including return characters \n
		int len = width * height * 2 + 2;
		StringBuilder sb = new StringBuilder(len);
		// put placeholders in for every char of every line of the tree string.
		for (int i = 1; i <= len; i++) {
			sb.append( ((i < len - 2) && (i % width == 0)) ? "\n" : ' ');
		}
		// build from the root
		visualizeRec(sb, width / 2, 1, width / 4, width, root, " ");
		System.out.println(sb);
	} // end visualize

	// string, center, right, depth, width, node, space or "branch" character.
	private void visualizeRec(StringBuilder sb, int c, int r, int d, int w, BinaryNode n, String edge) {
		if (n == null) {
			return;
		}
		// build left subtree
		visualizeRec(sb, c - d, r + 2, d / 2, w, n.left(), " /");
		// place node value in string
		String s = n.data().toString();
		int idx1 = r * w + c - (s.length() + 1) / 2;
		int idx2 = idx1 + s.length();
		int idx3 = idx1 - w;
		if (idx2 < sb.length()) {
			sb.replace(idx1, idx2, s).replace(idx3, idx3 + 2, edge);
		}
		// build right subtree
		visualizeRec(sb, c + d, r + 2, d / 2, w, n.right(), "\\ ");
	} // end visualizeRec

} // end class Tree
