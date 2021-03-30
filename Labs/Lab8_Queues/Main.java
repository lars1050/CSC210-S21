public class Main {

	public static void main(String[] args) {

		// values = {20, 10, 25, 5, 8, 3, 6, 22, 24};
		// Hand building a binary search tree.
		BinaryNode<Integer> n20 = new BinaryNode<Integer>(20);
		BinaryNode<Integer> n10 = new BinaryNode<Integer>(10);
		BinaryNode<Integer> n25 = new BinaryNode<Integer>(25);
		BinaryNode<Integer> n5 = new BinaryNode<Integer>(5);
		BinaryNode<Integer> n8 = new BinaryNode<Integer>(8);
		BinaryNode<Integer> n3 = new BinaryNode<Integer>(3);
		BinaryNode<Integer> n6 = new BinaryNode<Integer>(6);
		BinaryNode<Integer> n22 = new BinaryNode<Integer>(22);
		BinaryNode<Integer> n24 = new BinaryNode<Integer>(24);

		n20.left(n10); // 20 -> 10, 25
		n20.right(n25);
		n10.left(n5); // 10 -> 5
		n25.left(n22); // 25 -> 22
		n5.left(n3); // 5 -> 3, 8
		n5.right(n8);
		n8.left(n6); // 8 -> 6
		// 3 is a leaf node
		// 6 is a leaf node
		n22.right(n24); // 22 -> 24
		// 24 is a leaf node

		BinaryNode<Integer> root = n20;

		// Keep in mind that you can put a breakpoint after the tree is built
		// to get a sense of its structure.
		dfs(root);
		bfs(root);
	} // end main()

	/** In order traversal is a dfs.
	@param The root of the binary search tree
	*/
	public static void dfs(BinaryNode<Integer> root) {
		// Print nodes as you pop them from the stack.

	}

	/** BFS is useful to find node depth - distance from root
	@param Root of the binary search tree.
	*/
	public static void bfs(BinaryNode<Integer> root) {
		// Print nodes as you pop them from the queue.

	}

}
